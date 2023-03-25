package Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bbkx2
 */
public class EmailValidator {
    
    private static final String REGEX = "^(.+)@(.+)$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    
    public static boolean isValidEmail(String email) {
        return PATTERN.matcher(email).matches();
    }
}
