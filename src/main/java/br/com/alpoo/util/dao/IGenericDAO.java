package br.com.alpoo.util.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T, I extends Serializable> {

	public T save(T entity);
	
	public void remove(T entity);

	public T getById(Class<T> classe, I pk);
	
	public List<T> getAll(Class<T> classe);

	public List<T> getAll(Class<T> classe, String ordenarCampo);
	
	public List<T> getAll(Class<T> classe, String ordenarCampo, String ordem);
	
	public List<T> getAllByField(Class<T> classe, String field, String value, String ordenadoPor);

	public List<T> getAllByField(Class<T> classe, String field, Integer value, String ordenadoPor);

}
