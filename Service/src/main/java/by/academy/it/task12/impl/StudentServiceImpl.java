package by.academy.it.task12.impl;

import by.academy.it.task12.ServiceException;
import by.academy.it.task12.StudentService;
import by.academy.it.task12.dao.DaoException;
import by.academy.it.task12.dao.DaoProvider;
import by.academy.it.task12.dao.StudentDao;
import by.academy.it.task12.entity.Student;
import by.academy.it.task12.validator.Validator;
import by.academy.it.task12.validator.ValidatorException;
import by.academy.it.task12.validator.ValidatorProvider;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    @Override
    public Optional<Student> findById(Integer id) throws ServiceException {
        Optional<Student> optionalHorse;
        try (StudentDao studentDao = DaoProvider.getInstance().getStudentDao()) {
            optionalHorse = studentDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return optionalHorse;
    }

    @Override
    public List<Student> findAll() throws ServiceException {
        List<Student> all;
        try (StudentDao studentDao = DaoProvider.getInstance().getStudentDao()) {
            all = studentDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return all;
    }

    @Override
    public void save(Student entity) throws ServiceException, ValidatorException {

        ValidatorProvider.getInstance()
                .getStudentValidator()
                .validate(entity);

        try (StudentDao studentDao = DaoProvider.getInstance().getStudentDao()) {
            studentDao.save(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(List<Student> list)
            throws ServiceException, ValidatorException {
        Validator<Student> horseValidator = ValidatorProvider
                .getInstance()
                .getStudentValidator();
        for (Student student : list) {
            horseValidator.validate(student);
        }
        try (StudentDao studentDao = DaoProvider.getInstance().getStudentDao()) {
            studentDao.save(list);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Student entity) throws ServiceException, ValidatorException {

        ValidatorProvider.getInstance()
                .getStudentValidator()
                .validate(entity);

        try (StudentDao studentDao = DaoProvider.getInstance().getStudentDao()) {
            studentDao.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteById(Integer id) throws ServiceException {

    }

    @Override
    public void delete(Student entity) throws ServiceException {

    }
}
