package com.smatechnologies.opcon.restapiclient.util;

import com.smatechnologies.opcon.restapiclient.model.ServerOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class PasswordPolicyUtil {

    private static final String REGEX_CHARS_REPEAT_PREFIX = ".*(.)\\1{";
    private static final String REGEX_CHARS_REPEAT_SUFFIX = "}.*";
    private static final String REGEX_CHARS_REQUIRED_NUMERIC = ".*\\d.*";
    private static final String REGEX_CHARS_REQUIRED_ALPHA = ".*[a-zA-Z].*";
    private static final String REGEX_CHARS_REQUIRED_SPECIAL = ".*\\W.*";

    private PasswordPolicyUtil() {
    }

    public static void validate(String loginName, String password, ServerOptions.PasswordPolicy passwordPolicy) throws PasswordPolicyUtilException {
        Objects.requireNonNull(loginName, "LoginName cannot be null");
        Objects.requireNonNull(password, "Password cannot be null");
        Objects.requireNonNull(passwordPolicy, "PasswordPolicy cannot be null");

        PasswordPolicyUtilException exception = new PasswordPolicyUtilException();

        if (loginName.equals(password)) {
            exception.addCode(PasswordPolicyUtilException.ERROR_EQUALS);
        }

        if (passwordPolicy.getMinimumCharacters() != null && password.length() < passwordPolicy.getMinimumCharacters()) {
            exception.addCode(PasswordPolicyUtilException.ERROR_CHARS_MIN);
        }

        if (passwordPolicy.getRepeatedCharacterOccurrencesAllowed() != null && passwordPolicy.getRepeatedCharacterOccurrencesAllowed() > 0 && password.matches(REGEX_CHARS_REPEAT_PREFIX + String.valueOf(passwordPolicy.getRepeatedCharacterOccurrencesAllowed()) + REGEX_CHARS_REPEAT_SUFFIX)) {
            exception.addCode(PasswordPolicyUtilException.ERROR_CHARS_REPEAT);
        }

        if (passwordPolicy.getAlphaRequired() != null && passwordPolicy.getAlphaRequired() && !password.matches(REGEX_CHARS_REQUIRED_ALPHA)) {
            exception.addCode(PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_ALPHA);
        }

        if (passwordPolicy.getNumericRequired() != null && passwordPolicy.getNumericRequired() && !password.matches(REGEX_CHARS_REQUIRED_NUMERIC)) {
            exception.addCode(PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_NUMERIC);
        }

        if (passwordPolicy.getSpecialCharacterRequired() != null && passwordPolicy.getSpecialCharacterRequired() && !password.matches(REGEX_CHARS_REQUIRED_SPECIAL)) {
            exception.addCode(PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_SPECIAL);
        }

        if (!exception.getCodes().isEmpty()) {
            throw exception;
        }
    }

    public static class PasswordPolicyUtilException extends Exception {

        public final static int ERROR_EQUALS = 0;
        public final static int ERROR_CHARS_MIN = 1;
        public final static int ERROR_CHARS_REPEAT = 2;
        public final static int ERROR_CHARS_REQUIRED_ALPHA = 3;
        public final static int ERROR_CHARS_REQUIRED_NUMERIC = 4;
        public final static int ERROR_CHARS_REQUIRED_SPECIAL = 5;

        private final List<Integer> codes = new ArrayList<>();

        public void addCode(int code) {
            codes.add(code);
        }

        public List<Integer> getCodes() {
            return Collections.unmodifiableList(codes);
        }
    }
}
