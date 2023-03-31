package Utils;

import java.util.regex.Pattern;

public class Validator {

    private static final String EMAILREGEX = "^(.+)@(.+)$";
    private static final Pattern EMAILPATTERN = Pattern.compile(EMAILREGEX);

    private static final String PHONEREGEX = "^(01)[0-46-9]*[0-9]{7,8}$";
    private static final Pattern PHONEPATTERN = Pattern.compile(PHONEREGEX);

    // This code checks whether a given string matches the format of an email address.
    // It is used to check the validity of the email address entered by the user in a registration form.
    // The function name is isValidEmail, the parameter name is email, and the return value is a boolean.
    public static boolean isValidEmail(String email) {
        return EMAILPATTERN.matcher(email).matches();
    }

    // This code checks whether a given string matches the format of a phone number.
    // It is used to check the validity of the phone number entered by the user in a registration form.
    // The function name is isValidPhone, the parameter name is phoneNumber, and the return value is a boolean.
    public static boolean isValidPhone(String phoneNumber) {
        return PHONEPATTERN.matcher(phoneNumber).matches();
    }
}