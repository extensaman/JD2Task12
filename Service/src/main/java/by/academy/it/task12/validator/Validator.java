package by.academy.it.task12.validator;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}
