package net.geozen.lhc3.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.geozen.lhc3.constant.SystemConfigKeys;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.domain.SystemConfig;
import net.geozen.lhc3.jpa.Lhc3TmRepository;
import net.geozen.lhc3.jpa.SystemConfigRepository;

@Service
public class NumImporter {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
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
		int size = 20000;
		ObjectMapper mapper = new ObjectMapper();
		ResponseObject response = null;
		List<Lhc3Tm> list = new ArrayList<>();
		out: do {
			String result = client.getForObject(host + "Lott/GetLotteryData?ac=1023&gid=50&pageIndex=" + index,
					String.class);
//			logger.info(result);
			if (result.indexOf("\"data\":\"\"") == -1) {
				response = mapper.readValue(result, ResponseObject.class);
				if (response.getData() != null) {
					if (response.getData().getPr() != null && !response.getData().getPr().isEmpty()) {
						for (PrObject pobj : response.getData().getPr()) {
							Optional<Lhc3Tm> tmOp = tmRepository.findByPhase(pobj.getPhase().toString());
							if (tmOp.isPresent()) {
								break out;
							}
							String phase = pobj.getPhase().toString();
							if (phase.length() == 11) {
								Lhc3Tm tm = new Lhc3Tm();
								tm.setPhase(phase);
								String[] nums = pobj.getNums().split("\\|")[0].split(",");
								if (nums.length == 7) {
									Integer num = Integer.valueOf(nums[6]);
									tm.setNum(num);
									list.add(tm);
									if (list.size() == size) {
										break out;
									}
								}
							}
						}
					}
				}
			} else {
				response = new ResponseObject();
				response.setCode(-1);
			}
			index++;
		} while (list.size() < size);
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

class ResponseObject {
	private String message;
	private String result;
	private int code;
	private DataObject data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public DataObject getData() {
		return data;
	}

	public void setData(DataObject data) {
		this.data = data;
	}
}

class DataObject {
	@JsonProperty(value = "GID")
	private int gid;
	@JsonProperty(value = "GN")
	private String gn;
	@JsonProperty(value = "PR")
	private List<PrObject> pr;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGn() {
		return gn;
	}

	public void setGn(String gn) {
		this.gn = gn;
	}

	public List<PrObject> getPr() {
		return pr;
	}

	public void setPr(List<PrObject> pr) {
		this.pr = pr;
	}
}

class PrObject {
	@JsonProperty(value = "OPD")
	private String opd;
	@JsonProperty(value = "P")
	private Long phase;
	@JsonProperty(value = "R")
	private String nums;

	public String getOpd() {
		return opd;
	}

	public void setOpd(String opd) {
		this.opd = opd;
	}

	public Long getPhase() {
		return phase;
	}

	public void setPhase(Long phase) {
		this.phase = phase;
	}

	public String getNums() {
		return nums;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}
}
