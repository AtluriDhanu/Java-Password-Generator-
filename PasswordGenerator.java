import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    public static String generatePassword(int length, boolean useUpper, boolean useLower, boolean useDigits, boolean useSpecial) {
        StringBuilder characterPool = new StringBuilder();
        SecureRandom random = new SecureRandom();

        if (useUpper) characterPool.append(UPPER);
        if (useLower) characterPool.append(LOWER);
        if (useDigits) characterPool.append(DIGITS);
        if (useSpecial) characterPool.append(SPECIAL);

        if (characterPool.length() == 0) {
            throw new IllegalArgumentException("No character set selected!");
        }

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(randomIndex));
        }

        return password.toString();
    }
}
