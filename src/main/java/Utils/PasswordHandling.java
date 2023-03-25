package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author bbkx2
 */
public class PasswordHandling {
    private static final String ALGO = "MD5";
    
    public static String encrypt(String pass){
        String encryptedPassword = "";
        
        StringBuilder buffer = new StringBuilder();
        try{
            /* MessageDigest instance for MD5. */  
            MessageDigest m = MessageDigest.getInstance(ALGO);  
            /* Add plain-text password bytes to digest using MD5 update() method. */  
            m.update(pass.getBytes());
            /* Convert the hash value into bytes */   
            byte[] bytes = m.digest();
            for(int i=0; i< bytes.length ;i++){  
                buffer.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
            encryptedPassword = buffer.toString();  
        } catch(NoSuchAlgorithmException e){
            System.err.println(e + " Something went wrong... Encryption Failed(404)");
        }
        
        return encryptedPassword;
    }
    
    public static boolean checkPassword(String passOne, String passTwo){
        return passOne.equals(passTwo);
    }
    
    public static String decrypt(String pass){
        return encrypt(pass);
    }
    
    public static String getPasswordStrength(String password) {
        // Minimum length requirement
        int minLength = 8;
        if (password.length() < minLength) {
            return "Weak";
        }

        // Initialize score
        int score = 0;

        // Check for at least one uppercase letter
        if (password.matches(".*[A-Z].*")) {
            score += 2;
        }

        // Check for at least one lowercase letter
        if (password.matches(".*[a-z].*")) {
            score += 2;
        }

        // Check for at least one digit
        if (password.matches(".*\\d.*")) {
            score += 2;
        }

        // Check for at least one special character
        if (password.matches(".*[@$!%*?&].*")) {
            score += 2;
        }

        // Add bonus points for length and complexity
        score += Math.min(2, password.length() / 8);
        score += Math.min(2, (password.matches(".*[a-z].*") ? 1 : 0)
                            + (password.matches(".*[A-Z].*") ? 1 : 0)
                            + (password.matches(".*\\d.*") ? 1 : 0)
                            + (password.matches(".*[@$!%*?&].*") ? 1 : 0));

        // Determine strength based on score
        if (score <= 4) {
            return "Weak";
        } else if (score <= 8) {
            return "Moderate";
        } else {
            return "Strong";
        }
    }

}
