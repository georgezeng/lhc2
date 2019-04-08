package net.geozen.lhc3.controller;

import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;

import net.geozen.lhc2.dto.PageResult;
import net.geozen.lhc2.dto.QueryInfo;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.base.PosBaseEntity;
import net.geozen.lhc3.domain.base.SwBaseEntity;

public abstract class Lhc3BaseController<Y extends PosBaseEntity, Z extends PosBaseEntity, S extends SwBaseEntity> {

	protected abstract BaseRepository<Y> getYzRepository();

	protected abstract BaseRepository<Z> getZfRepository();

	protected abstract BaseRepository<S> getSwRepository();

	protected Class<Y> yzClass;

	protected Class<Z> zfClass;

	protected Class<S> swClass;

	@SuppressWarnings("unchecked")
	public Lhc3BaseController() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		yzClass = (Class<Y>) type.getActualTypeArguments()[0];
		zfClass = (Class<Z>) type.getActualTypeArguments()[1];
		swClass = (Class<S>) type.getActualTypeArguments()[2];
	}

	public Result<PageResult<Y>> yzList(QueryInfo<String> queryInfo) throws Exception {
		Page<Y> result = getYzRepository().findAll(queryInfo.getPage().pageable());
		if (queryInfo.getPage().getNum() == 1 && result.hasContent()) {
			List<Y> list = new LinkedList<>(result.getContent());
			Y first = list.get(0);

			Y topForTotal = yzClass.newInstance();
			topForTotal.setPhase("遗值和(无限制)");
			topForTotal.setW1(first.getT1());
			topForTotal.setW2(first.getT2());
			topForTotal.setW3(first.getT3());
			topForTotal.setW4(first.getT4());
			topForTotal.setW5(first.getT5());
			topForTotal.setW6(first.getT6());
			topForTotal.setW7(first.getT7());
			topForTotal.setW8(first.getT8());
			topForTotal.setW9(first.getT9());
			topForTotal.setW10(first.getT10());
			topForTotal.setW11(first.getT11());
			topForTotal.setW12(first.getT12());
			list.add(0, topForTotal);

			Y topForLimitedTotal = yzClass.newInstance();
			topForLimitedTotal.setPhase("遗值和(有限制)");
			topForLimitedTotal.setW1(first.getLt1());
			topForLimitedTotal.setW2(first.getLt2());
			topForLimitedTotal.setW3(first.getLt3());
			topForLimitedTotal.setW4(first.getLt4());
			topForLimitedTotal.setW5(first.getLt5());
			topForLimitedTotal.setW6(first.getLt6());
			topForLimitedTotal.setW7(first.getLt7());
			topForLimitedTotal.setW8(first.getLt8());
			topForLimitedTotal.setW9(first.getLt9());
			topForLimitedTotal.setW10(first.getLt10());
			topForLimitedTotal.setW11(first.getLt11());
			topForLimitedTotal.setW12(first.getLt12());
			list.add(0, topForLimitedTotal);
			return Result.genSuccessResult(new PageResult<>(list, result.getTotalElements()));
		}
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	public Result<PageResult<Z>> zfList(QueryInfo<String> queryInfo) throws Exception {
		Page<Z> result = getZfRepository().findAll(queryInfo.getPage().pageable());
		if (queryInfo.getPage().getNum() == 1 && result.hasContent()) {
			List<Z> list = new LinkedList<>(result.getContent());
			Z first = list.get(0);

			Z topForTotal = zfClass.newInstance();
			topForTotal.setPhase("遗值和(无限制)");
			topForTotal.setW1(first.getT1());
			topForTotal.setW2(first.getT2());
			topForTotal.setW3(first.getT3());
			topForTotal.setW4(first.getT4());
			topForTotal.setW5(first.getT5());
			topForTotal.setW6(first.getT6());
			topForTotal.setW7(first.getT7());
			topForTotal.setW8(first.getT8());
			topForTotal.setW9(first.getT9());
			topForTotal.setW10(first.getT10());
			topForTotal.setW11(first.getT11());
			topForTotal.setW12(first.getT12());
			list.add(0, topForTotal);

			Z topForLimitedTotal = zfClass.newInstance();
			topForLimitedTotal.setPhase("遗值和(有限制)");
			topForLimitedTotal.setW1(first.getLt1());
			topForLimitedTotal.setW2(first.getLt2());
			topForLimitedTotal.setW3(first.getLt3());
			topForLimitedTotal.setW4(first.getLt4());
			topForLimitedTotal.setW5(first.getLt5());
			topForLimitedTotal.setW6(first.getLt6());
			topForLimitedTotal.setW7(first.getLt7());
			topForLimitedTotal.setW8(first.getLt8());
			topForLimitedTotal.setW9(first.getLt9());
			topForLimitedTotal.setW10(first.getLt10());
			topForLimitedTotal.setW11(first.getLt11());
			topForLimitedTotal.setW12(first.getLt12());
			list.add(0, topForLimitedTotal);
			return Result.genSuccessResult(new PageResult<>(list, result.getTotalElements()));
		}
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	public Result<PageResult<S>> swList(QueryInfo<String> queryInfo) throws Exception {
		Page<S> result = getSwRepository().findAll(queryInfo.getPage().pageable());
		if (queryInfo.getPage().getNum() == 1 && result.hasContent()) {
			List<S> list = new LinkedList<>(result.getContent());
			S first = list.get(0);

			S topForTotal = swClass.newInstance();
			topForTotal.setPhase("遗值和(无限制)");
			topForTotal.setW1(first.getT1());
			topForTotal.setW2(first.getT2());
			topForTotal.setW3(first.getT3());
			topForTotal.setW4(first.getT4());
			topForTotal.setW5(first.getT5());
			topForTotal.setW6(first.getT6());
			topForTotal.setW7(first.getT7());
			topForTotal.setW8(first.getT8());
			topForTotal.setW9(first.getT9());
			topForTotal.setW10(first.getT10());
			topForTotal.setW11(first.getT11());
			topForTotal.setW12(first.getT12());
			list.add(0, topForTotal);

			S topForLimitedTotal = swClass.newInstance();
			topForLimitedTotal.setPhase("遗值和(有限制)");
			topForLimitedTotal.setW1(first.getLt1());
			topForLimitedTotal.setW2(first.getLt2());
			topForLimitedTotal.setW3(first.getLt3());
			topForLimitedTotal.setW4(first.getLt4());
			topForLimitedTotal.setW5(first.getLt5());
			topForLimitedTotal.setW6(first.getLt6());
			topForLimitedTotal.setW7(first.getLt7());
			topForLimitedTotal.setW8(first.getLt8());
			topForLimitedTotal.setW9(first.getLt9());
			topForLimitedTotal.setW10(first.getLt10());
			topForLimitedTotal.setW11(first.getLt11());
			topForLimitedTotal.setW12(first.getLt12());
			list.add(0, topForLimitedTotal);
			return Result.genSuccessResult(new PageResult<>(list, result.getTotalElements()));
		}
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
