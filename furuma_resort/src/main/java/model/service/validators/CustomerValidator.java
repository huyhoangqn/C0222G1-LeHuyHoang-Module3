package model.service.validators;

import model.bean.Customer;
import model.service.exception.ValidateException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerValidator {
    static Pattern pattern;
    static Matcher matcher;

    private final String PHONE_REGEX = "^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$";
    private final String ID_CARD_REGEX = "^(\\d{9})$|^(\\d{12})$";
    private final String EMAIL_REGEX = "^[a-z]\\S+@\\S+\\.\\S+$";

    public List<String> validateCustomer(Customer customer) {
        List<String> errors = new ArrayList<>();
        try {
            validateIdCard(customer);
        } catch (ValidateException e) {
            errors.add(e.getMessage());
        }
        try {
            validatePhone(customer);
        } catch (ValidateException e) {
            errors.add(e.getMessage());
        }
        try {
            validateEmail(customer);
        } catch (ValidateException e) {
            errors.add(e.getMessage());
        }
        try {
            validateBirthday(customer);
        } catch (ValidateException e) {
            errors.add(e.getMessage());
        }
        return errors;
    }

    private void validatePhone(Customer customer) throws ValidateException {
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(customer.getPhoneCustomer());
        boolean flag = matcher.matches();
        if (!flag) {
            throw new ValidateException("Phone is not valid");
        }

    }

    private void validateIdCard(Customer customer) throws ValidateException {
        pattern = Pattern.compile(ID_CARD_REGEX);
        matcher = pattern.matcher(customer.getIdCardCustomer());
        boolean flag = matcher.matches();
        if (!flag) {
            throw new ValidateException("Id card is not valid");
        }

    }

    private void validateEmail(Customer customer) throws ValidateException {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(customer.getEmailCustomer());
        boolean flag = matcher.matches();
        if (!flag) {
            throw new ValidateException("Email is not valid");
        }

    }

    private void validateBirthday(Customer customer) throws ValidateException {
        if (customer.getBirthdayCustomer().isEmpty()) {
            throw new ValidateException("Birthday is not valid");
        }
    }

}
