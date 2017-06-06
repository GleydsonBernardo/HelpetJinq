package br.com.helpet.dao;

import br.com.helpet.dao.jinq.GenericDao;
import br.com.helpet.entities.BaseEntity;

public class DaoFactory {

	public static <T extends BaseEntity> IDao<T> getDao(Class<T> entityClass) {
		return new GenericDao<>(entityClass);
	}
}
