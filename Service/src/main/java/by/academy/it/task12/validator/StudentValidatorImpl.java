package by.academy.it.task12.validator;

import by.academy.it.task12.entity.Student;

import java.util.Optional;

public class StudentValidatorImpl implements Validator<Student> {

    @Override
    public void validate(Student entity) throws ValidatorException {
        Student student = Optional.ofNullable(entity)
                .orElseThrow(ValidatorException::new);
        boolean validationFail = false;
        StringBuilder builder = new StringBuilder();
/*        if (horse.getNickname().length() >
                Horse.HORSE_NICKNAME_LENGTH_LIMIT) {
            validationFail = true;
            builder.append(HORSE_S_NICKNAME)
                    .append(ValidatorConstant.LENGTH_MUST_BE_LESS_THEN)
                    .append(Horse.HORSE_NICKNAME_LENGTH_LIMIT)
                    .append(ValidatorConstant.SYMBOLS);
        }*/
        if (validationFail) {
            throw new ValidatorException(builder.toString());
        }
    }
}
