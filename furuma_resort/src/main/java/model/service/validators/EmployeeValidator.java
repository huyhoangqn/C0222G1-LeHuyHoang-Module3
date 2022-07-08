package model.service.validators;

import model.bean.Employee;
import model.service.exception.ValidateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeValidator {
    static Pattern pattern;
    static Matcher matcher;
    private final String PHONE_REGEX = "^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$";
    private final String ID_CARD_REGEX = "^(\\d{9})$|^(\\d{12})$";
    private final String EMAIL_REGEX = "^[a-z]\\S+@\\S+\\.\\S+$";
//    private final String BIRTHDAY_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";


    public List<String> validateEmployee(Employee employee)  {
        List<String> errors = new ArrayList<>();
//        try {
//            validateBirthday(employee);
//        } catch (ValidateException e) {
//            errors.add(e.getMessage());
//
//        }

        try {
            validateIdCard(employee);
        } catch (ValidateException e) {
            errors.add(e.getMessage());

        }

        try {
            validateSalary(employee);
        } catch (ValidateException e) {
            errors.add(e.getMessage());
        }

        try {
            validatePhone(employee);
        } catch (ValidateException e) {
            errors.add(e.getMessage());
        }

        try {
            validateEmail(employee);
        } catch (ValidateException e) {
            errors.add(e.getMessage());
        }




       return errors;


    }


    private void validatePhone(Employee employee) throws ValidateException {
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(employee.getPhone());
        boolean flag = matcher.matches();
        if (!flag) {
            throw new ValidateException("Phone is not valid");
        }

    }

    private void validateIdCard(Employee employee) throws ValidateException {
        pattern = Pattern.compile(ID_CARD_REGEX);
        matcher = pattern.matcher(employee.getIdCard());
        boolean flag = matcher.matches();
        if (!flag) {
            throw new ValidateException("Id card is not valid");
        }

    }

    private void validateEmail(Employee employee) throws ValidateException {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(employee.getEmail());
        boolean flag = matcher.matches();
        if (!flag) {
            throw new ValidateException("Email is not valid");
        }

    }
//
//    private void validateBirthday(Employee employee) throws ValidateException {
//        try {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            simpleDateFormat.parse(employee.getBirthday());
//
//        } catch (Exception e) {
//            throw new ValidateException("Birthday is not valid");
//        }

//        pattern = Pattern.compile(BIRTHDAY_REGEX);
//        matcher = pattern.matcher(employee.getBirthday());
//        boolean flag = matcher.matches();
//        if (!flag) {
//            throw new ValidateException("Birthday is not valid");
//        }

//    }

    private void validateSalary(Employee employee) throws ValidateException {
        if (employee.getSalary() < 0) {
            throw new ValidateException("Salary is not valid");
        }

    }


}
