package by.academy.it.task12.validator;

import by.academy.it.task12.entity.Student;

public class ValidatorProvider {
    private static final ValidatorProvider INSTANCE = new ValidatorProvider();

    private ValidatorProvider() {
    }

    public static ValidatorProvider getInstance() {
        return INSTANCE;
    }

    public Validator<Student> getStudentValidator() {
        return new StudentValidatorImpl();
    }
}
