package net.geozen.lhc3.service.base;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.dto.ZInfo;
import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.domain.base.PosBaseEntity;

@Service
public abstract class BaseZfZValueCalService<Y extends PosBaseEntity, Z extends PosBaseEntity> {
	private Logger log = LoggerFactory.getLogger(getClass());

	protected abstract BaseRepository<Z> getZfRepository();

	protected abstract BaseRepository<Y> getYzRepository();

	private int length = 12;

	@Async
	public Future<ZInfo> process(Lhc3Tm tm, int order) {
		ZInfo info = null;
		try {
			Optional<Z> zfOp = getZfRepository().findByPhase(tm.getPhase());
			if (zfOp.isPresent()) {
				Z zf = zfOp.get();
				BigDecimal zForP1 = new BigDecimal(zf.getTotalColsYz());
				BigDecimal z = new BigDecimal(zf.getrColsYz()).divide(new BigDecimal(zf.getMaxColYz()), 2, RoundingMode.HALF_UP);
				info = new ZInfo();
				info.setOrder(order);
				info.setZForP1(zForP1);
				info.setZ(z);

				Y yz = getYzRepository().findByPhase(tm.getPhase()).get();
				int pos = 1;
				int max = 0;
				for (int i = 1; i <= length; i++) {
					Method m = ReflectionUtils.findMethod(zf.getClass(), "getLt" + i);
					int value = (int) m.invoke(zf);
					if (value > max) {
						max = value;
						pos = i;
					}
				}
				pos = yz.getPos() + pos;
				if (pos > length) {
					pos -= length;
				}
				info.setNums(getNums(pos - 1));

				pos = 1;
				max = 0;
				for (int i = 1; i <= length; i++) {
					Method m = ReflectionUtils.findMethod(zf.getClass(), "getW" + i);
					int value = (int) m.invoke(zf);
					if (value > max) {
						max = value;
						pos = i;
					}
				}
				pos = yz.getPos() + pos;
				if (pos > length) {
					pos -= length;
				}
				info.setNumsForD1(getNums(pos - 1));

				List<TempInfo> list = new ArrayList<>();
				for (int i = 1; i <= length; i++) {
					Method m = ReflectionUtils.findMethod(zf.getClass(), "getW" + i);
					int value = (int) m.invoke(zf);
					TempInfo tmpInfo = new TempInfo();
					tmpInfo.setValue(value);
					tmpInfo.setPos(i);
					list.add(tmpInfo);
				}
				list.sort(new Comparator<TempInfo>() {

					@Override
					public int compare(TempInfo o1, TempInfo o2) {
						return o1.getValue().compareTo(o2.getValue());
					}
				});
				pos = list.get(1).getPos();
				pos = yz.getPos() + pos;
				if (pos > length) {
					pos -= length;
				}
				info.setNumsForS2(getNums(pos - 1));
				
				Collections.reverse(list);
				pos = list.get(1).getPos();
				pos = yz.getPos() + pos;
				if (pos > length) {
					pos -= length;
				}
				info.setNumsForD2(getNums(pos - 1));
				
				pos = list.get(2).getPos();
				pos = yz.getPos() + pos;
				if (pos > length) {
					pos -= length;
				}
				info.setNumsForD3(getNums(pos - 1));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return new AsyncResult<ZInfo>(info);
	}

	protected abstract List<Integer> getNums(int pos);

}
