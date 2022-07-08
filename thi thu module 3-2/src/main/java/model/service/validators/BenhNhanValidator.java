package model.service.validators;

import model.bean.BenhNhan;
import model.exception.ValidateException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BenhNhanValidator {
    static Pattern pattern;
    static Matcher matcher;
    private final String NAME_REGEX = "([A-Z][a-zA-Z]+\\s){1,}(([A-Z0-9]{1,})|([A-Z][a-zA-Z]{1,}))$";

    public List<String> validatorBenhNhan(BenhNhan benhNhan) {
        List<String> errors = new ArrayList<>();
        try {
            validateName(benhNhan);
        } catch (ValidateException e) {
            errors.add(e.getMessage());
        }

        return errors;
    }

    private void validateName(BenhNhan benhNhan) throws ValidateException {
        pattern = Pattern.compile(NAME_REGEX);
        matcher = pattern.matcher(benhNhan.getTenBenhNham());
        boolean flag = matcher.matches();
        if (!flag) {
            throw new ValidateException("Loi dinh dang ten");
        }
    }
}
