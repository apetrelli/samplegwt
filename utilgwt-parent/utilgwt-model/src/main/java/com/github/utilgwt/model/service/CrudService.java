package com.github.utilgwt.model.service;

public interface CrudService<T, I> {

	T findOne(I id);
	
	T save(T entity);
	
	void delete(I id);
}
