package by.academy.it.task12;

import by.academy.it.task12.impl.StudentServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider INSTANCE = new ServiceProvider();

    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return INSTANCE;
    }

    public StudentService getStudentService() {
        return new StudentServiceImpl();
    }
}
