package br.com.helpet.dao;

import java.util.List;

import br.com.helpet.dao.jinq.IWhere;
import br.com.helpet.entities.BaseEntity;

public interface IDao<T extends BaseEntity> {

	void insert(T t);
	void update(T t);
	boolean delete(int id);
	List<T> list();
	List<T> list(IWhere<T> predicate);
	T find(int id);
}
