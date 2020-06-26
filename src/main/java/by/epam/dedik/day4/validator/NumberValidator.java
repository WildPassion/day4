package by.epam.dedik.day4.validator;

public class NumberValidator {
    public static final StringBuilder REGEX_INTEGER = new StringBuilder("^(-?([1-9][0-9]{0,8}")
            .append("|1[0-9]{9}")
            .append("|20[0-9]{8}")
            .append("|21[0-3][0-9]{7}")
            .append("|214[0-6][0-9]{6}")
            .append("|2147[0-3][0-9]{5}")
            .append("|21474[0-7][0-9]{4}")
            .append("|214748[0-2][0-9]{3}")
            .append("|2147483[0-5][0-9]{2}")
            .append("|21474836[0-3][0-9]{1}")
            .append("|214748364[0-7])")
            .append("|-2147483648|0)$");

    public boolean isInteger(String number) {
        return number.matches(REGEX_INTEGER.toString());
    }
}
