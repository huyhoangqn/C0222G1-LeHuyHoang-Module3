package model.service.validator;

import model.bean.Product;
import model.exception.ValidateException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductValidator {
    static Pattern pattern;
    static Matcher matcher;
    private final String NAME_REGEX = "^([A-Z][a-zA-Z]+\\s){1,}(([A-Z0-9]{1,})|([A-Z][a-zA-Z]{1,}))$";
    private final String PHONE_REGEX = "^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$";
    private final String ID_CARD_REGEX = "^(\\d{9})$|^(\\d{12})$";
    private final String EMAIL_REGEX = "^[a-z]\\S+@\\S+\\.\\S+$";

    public List<String> validatorStudent(Product student) {
        List<String> errors = new ArrayList<>();
        try {
            validateName(student);
        } catch (ValidateException e) {
            errors.add(e.getMessage());
        }

        return errors;
    }

    private void validateName(Product student) throws ValidateException {
        pattern = Pattern.compile(NAME_REGEX);
        matcher = pattern.matcher(student.getName());
        boolean flag = matcher.matches();
        if (!flag) {
            throw new ValidateException("Name is not valid");
        }
    }
}
