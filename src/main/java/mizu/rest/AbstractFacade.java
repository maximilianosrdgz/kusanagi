package mizu.rest;

import mizu.util.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by ms.rodriguez on 20/4/2017.
 */
public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity){
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public T find(Object id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        T entity = null;
        try {
            em.getTransaction().begin();
            entity = em.find(entityClass, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return entity;
    }

    public List<T> findAll() {
        CriteriaQuery<T> critQuery = EntityManagerUtil.getEntityManager()
                .getCriteriaBuilder()
                .createQuery(this.entityClass);
        critQuery.select(critQuery.from(this.entityClass));
        return EntityManagerUtil.getEntityManager()
                .createQuery(critQuery)
                .getResultList();
    }

    public void update(T entity) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void delete(T entity) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public int count(List<T> list) {
        return list.size();
    }

}
