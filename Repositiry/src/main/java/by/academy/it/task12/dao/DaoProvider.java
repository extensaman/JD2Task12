package by.academy.it.task12.dao;

import by.academy.it.task12.dao.impl.StudentDaoImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoProvider {
    public static final String PERSISTENCE_UNIT_NAME = "task12";
    private final static DaoProvider INSTANCE =
            new DaoProvider();
    private final EntityManagerFactory factory;

    private static class SingletonHolder {
        private final static DaoProvider INSTANCE =
                new DaoProvider();
    }

    private DaoProvider() {
        factory = Persistence
                .createEntityManagerFactory(
                        PERSISTENCE_UNIT_NAME);
    }

    /**
     * @return -
     */
    public static DaoProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public StudentDao getStudentDao() {
        return new StudentDaoImpl(factory.createEntityManager());
    }
}
