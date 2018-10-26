package net.geozen.lhc2.def.jpa.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Repository;

import net.geozen.lhc2.domain.base.BaseEntity;

@Repository
public class CommonDAO {
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public <T extends BaseEntity> List<T> findAllByOffsetAndSize(Class<T> clazz, int offset, int size) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from " + AnnotationUtils.findAnnotation(clazz, Table.class).name()).append("\n");
		sql.append("order by phase desc").append("\n");
		sql.append("limit ?, ?").append("\n");
		Query query = em.createNativeQuery(sql.toString(), clazz);
		query.setParameter(1, offset);
		query.setParameter(2, size);
		return (List<T>) query.getResultList();
	}
}
