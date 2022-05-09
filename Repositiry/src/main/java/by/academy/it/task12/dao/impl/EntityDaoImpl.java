package by.academy.it.task12.dao.impl;

import by.academy.it.task12.dao.DaoException;
import by.academy.it.task12.dao.EntityDao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class EntityDaoImpl<T> implements EntityDao<T> {
    /**
     *
     */
    protected final EntityManager entityManager;
    /**
     *
     */
    private final Class<T> aClass;

    /**
     * @param em
     * @param a
     */
    public EntityDaoImpl(final EntityManager em,
                         final Class<T> a) {
        this.entityManager = em;
        this.aClass = a;
    }

    @Override
    public Optional<T> findById(final Integer id) throws DaoException {
        T entity = null;
        try {
            entity = entityManager.find(aClass, id);
        } catch (IllegalArgumentException e) {
            throw new DaoException(e);
        }
        return Optional.ofNullable(entity);
    }

    /**
     * @return -
     */
    @Override
    public List<T> findAll() throws DaoException {
        List<T> result;
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
            Root<T> rootEntry = criteriaQuery.from(aClass);
            CriteriaQuery<T> all = criteriaQuery.select(rootEntry);
            TypedQuery<T> allQuery = entityManager.createQuery(all);
            result = allQuery.getResultList();
        } catch (RuntimeException e) {
            throw new DaoException(e);
        }
        return result;
    }

    /**
     * @param t
     */
    @Override
    public void save(final T t) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new DaoException(e);
        }
    }

    /**
     * @param list
     */
    @Override
    public void save(final List<T> list) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            list.forEach(entityManager::persist);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new DaoException(e);
        }
    }

    /**
     * @param t
     */
    @Override
    public void update(final T t) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new DaoException(e);
        }
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(final Integer id) throws DaoException {
        Optional<T> optionalEntity = findById(id);
        if (optionalEntity.isPresent()) {
            delete(optionalEntity.get());
        }
    }

    @Override
    public void delete(final T entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw new DaoException(e);
        }
    }

    @Override
    public void close() {
        entityManager.close();
    }
}
