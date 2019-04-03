package net.geozen.lhc3.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import net.geozen.lhc3.constant.SystemConfigKeys;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.domain.SystemConfig;
import net.geozen.lhc3.jpa.Lhc3TmRepository;
import net.geozen.lhc3.jpa.SystemConfigRepository;

@Service
public class NumImporter {
	@Autowired
	private SystemConfigRepository configRepository;

	@Autowired
	private Lhc3TmRepository tmRepository;

	@Autowired
	private RestTemplate client;

	public List<Lhc3Tm> importTm() throws Exception {
		Optional<SystemConfig> configOp = configRepository.findByKey(SystemConfigKeys.LOTTERY_SITE);
		String domain = null;
		if (configOp.isPresent()) {
			domain = configOp.get().getValue();
		} else {
			domain = "xlwap.playgamings.com";
		}
		String host = "https://" + domain + "/";
		int index = 1;
		ObjectMapper mapper = new ObjectMapper();
		ResponseObject response = null;
		List<Lhc3Tm> list = new ArrayList<>();
		out: do {
			String result = client.getForObject(host + "Lott/GetLotteryData?ac=1023&gid=50&pageIndex=" + index, String.class);
			if (result.indexOf("\"data\":\"\"") == -1) {
				response = mapper.readValue(result, ResponseObject.class);
				if (response.getData() != null) {
					if (response.getData().getPr() != null && !response.getData().getPr().isEmpty()) {
						for (PrObject pobj : response.getData().getPr()) {
							Optional<Lhc3Tm> tmOp = tmRepository.findByPhase(pobj.getPhase().toString());
							if (tmOp.isPresent()) {
								break out;
							}
							Lhc3Tm tm = new Lhc3Tm();
							tm.setPhase(pobj.getPhase().toString());
							Integer num = Integer.valueOf(pobj.getNums().split("\\|")[0].split(",")[5]);
							tm.setNum(num);
							list.add(tm);
						}
					}
				}
			} else {
				response = new ResponseObject();
				response.setCode(-1);
			}
			index++;
		} while (response.getCode() == 0);
		list.sort(new Comparator<Lhc3Tm>() {

			@Override
			public int compare(Lhc3Tm o1, Lhc3Tm o2) {
				return o1.getPhase().compareTo(o2.getPhase());
			}

		});
		if (!list.isEmpty()) {
			tmRepository.saveAll(list);
		}
		return list;
	}
}

@Data
class ResponseObject {
	private String message;
	private String result;
	private int code;
	private DataObject data;
}

@Data
class DataObject {
	@JsonProperty(value = "GID")
	private int gid;
	@JsonProperty(value = "GN")
	private String gn;
	@JsonProperty(value = "PR")
	private List<PrObject> pr;
}

@Data
class PrObject {
	@JsonProperty(value = "OPD")
	private String opd;
	@JsonProperty(value = "P")
	private Long phase;
	@JsonProperty(value = "R")
	private String nums;
}
