package Level2;

public class SpainPhone implements Phone {
    private static final String PREFIX = "+34";
    private static final int EXPECTED_LENGTH = 9;
    private static final int FIRST_GROUP = 3;
    private static final int SECOND_GROUP = 5;
    private static final int THIRD_GROUP = 7;
    private static final int FINAL_LENGTH = 9;

    @Override
    public String format(String number) {
        validateNumber(number);
        String digits = extractDigits(number);
        return formatDigits(digits);
    }

    private void validateNumber(String number) {
        if (number.length() != EXPECTED_LENGTH) {
            throw new IllegalArgumentException("The Spain phone number must have 9 numbers");
        }
    }

    private String extractDigits(String number) {
        return number.replaceAll("\\D", "");
    }

    private String formatDigits(String digits) {
        return PREFIX + " "
                + digits.substring(0, FIRST_GROUP) + " "
                + digits.substring(FIRST_GROUP, SECOND_GROUP) + " "
                + digits.substring(SECOND_GROUP, THIRD_GROUP) + " "
                + digits.substring(THIRD_GROUP, FINAL_LENGTH);
    }

    @Override
    public String getPrefix() {
        return PREFIX;
    }
}