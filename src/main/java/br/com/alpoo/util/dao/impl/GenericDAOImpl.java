package br.com.alpoo.util.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.alpoo.util.dao.IGenericDAO;

public class GenericDAOImpl<T, I extends Serializable> implements IGenericDAO<T, I> {
	
	@PersistenceContext
	protected EntityManager em;
	
    public T save(T entity) {
    	T saved = null;
		saved = em.merge(entity);
        return saved;
    }
	
	public void remove(T entity) {
		em.remove(entity);
	}

	public T getById(Class<T> classe, I pk) {
		return em.find(classe, pk);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> classe) {
		return em.createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
	}	

	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> classe, String ordenarCampo) {
		return em.createQuery("select o from " + classe.getSimpleName() + " o order by " + ordenarCampo).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> classe, String ordenarCampo, String ordem) {
		return em.createQuery("select o from " + classe.getSimpleName() + " o order by " + ordenarCampo + " " + ordem).getResultList();
	}	
	
	@SuppressWarnings("unchecked")
	public List<T> getAllByField(Class<T> classe, String field, String value, String ordenadoPor) {
		String sql = "";
		sql = "select o from " + classe.getSimpleName() + " o where o." + field + " = :value order by " + ordenadoPor;
		Query query = em.createQuery(sql);
		query.setParameter("value",value);
		
		return query.getResultList();
	}		

	@SuppressWarnings("unchecked")
	public List<T> getAllByField(Class<T> classe, String field, Integer value, String ordenadoPor) {
		String sql = "";
		sql = "select o from " + classe.getSimpleName() + " o where o." + field + "= :value order by " + ordenadoPor;
		Query query = em.createQuery(sql);
		query.setParameter("value",value);
		
		return query.getResultList();
	}		

	@SuppressWarnings("unchecked")
	public List<T> getAllByField(Class<T> classe, String field, Long value, String ordenadoPor) {
		String sql = "";
		sql = "select o from " + classe.getSimpleName() + " o where o." + field + " = :value order by " + ordenadoPor;
		Query query = em.createQuery(sql);
		query.setParameter("value",value);
		
		return query.getResultList();
	}		
}
