package by.academy.it.task12.dao;

import java.util.List;
import java.util.Optional;

public interface EntityDao<T> extends AutoCloseable {
    /**
     * @param id
     * @return -
     */
    Optional<T> findById(Integer id) throws DaoException;

    /**
     * @return -
     */
    List<T> findAll() throws DaoException;

    /**
     * @param t
     */
    void save(T t) throws DaoException;

    /**
     * @param list
     */
    void save(List<T> list) throws DaoException;

    /**
     * @param entity
     */
    void update(T entity) throws DaoException;

    /**
     * @param id
     */
    void deleteById(final Integer id) throws DaoException;

    /**
     * @param entity
     */
    void delete(final T entity) throws DaoException;

    void close();
}
