package com.example.XML_WS_backend.custom_utils.validator;

public class DataValidator {
    private static final String SUR_NAME_REGEX = "^[a-zA-Z'][a-zA-Z' ]*";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+$";
    private static final String REG_PASSWORD = "^[a-zA-Z0-9!@#$%^&*()_+=]{6,30}$";
    public static boolean valNameOrSurname(String toValidate) {
        return toValidate.matches(SUR_NAME_REGEX);
    }

    public static boolean valEmail(String toValidate) {
        return toValidate.matches(EMAIL_REGEX);
    }

    public static boolean valPassword(String toValidate) {
        return toValidate.matches(REG_PASSWORD);
    }
}
