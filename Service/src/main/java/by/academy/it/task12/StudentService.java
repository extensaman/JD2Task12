package by.academy.it.task12;

import by.academy.it.task12.validator.ValidatorException;
import by.academy.it.task12.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    /**
     * @param id
     * @return -
     */
    Optional<Student> findById(Integer id) throws ServiceException;

    List<Student> findAll() throws ServiceException;

    /**
     * @param entity
     */
    void save(Student entity) throws ServiceException, ValidatorException;

    /**
     * @param list
     */
    void save(List<Student> list) throws ServiceException, ValidatorException;

    /**
     * @param entity
     */
    void update(Student entity) throws ServiceException, ValidatorException;

    /**
     * @param id
     */
    void deleteById(final Integer id) throws ServiceException;

    /**
     * @param entity
     */
    void delete(final Student entity) throws ServiceException;
}
