package br.com.furb.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Repository<T> {
    protected final EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    protected final EntityManager entityManager;
    
    public Repository() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("licencas-server");

        this.entityManager = this.entityManagerFactory.createEntityManager();
    }
    

    public void persist(T transientInstance) {
        try {
        	entityManager.getTransaction().begin();
            entityManager.persist(transientInstance);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public void remove(T persistentInstance) {
        try {
        	entityManager.getTransaction().begin();
            entityManager.remove(persistentInstance);
            entityManager.getTransaction().commit();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public T merge(T detachedInstance) {        
        try {
        	entityManager.getTransaction().begin();
            T result = entityManager.merge(detachedInstance);
            entityManager.getTransaction().commit();
            return result;
        } catch (RuntimeException re) {
            throw re;
        }
    }
}
