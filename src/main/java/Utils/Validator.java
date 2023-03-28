package Utils;

import java.util.regex.Pattern;

/**
 *
 * @author bbkx2
 */
public class Validator {
    
    private static final String EMAILREGEX = "^(.+)@(.+)$";
    private static final Pattern EMAILPATTERN = Pattern.compile(EMAILREGEX);
    
    private static final String PHONEREGEX = "^(01)[0-46-9]*[0-9]{7,8}$";
    private static final Pattern PHONEPATTERN = Pattern.compile(PHONEREGEX);
    
    // private static final String ICREGEX = "^\\d{6}\\-\\d{2}\\-\\d{4}$";
    // private static final Pattern ICPATTERN = Pattern.compile(ICREGEX);
    
    public static boolean isValidEmail(String email) {
        return EMAILPATTERN.matcher(email).matches();
    }
    
    public static boolean isValidPhone(String phoneNumber) {
        return PHONEPATTERN.matcher(phoneNumber).matches();
    }
    
    // public static boolean isValidNRIC(String nric) {
    //    return ICPATTERN.matcher(nric).matches();
    // }
    
}
