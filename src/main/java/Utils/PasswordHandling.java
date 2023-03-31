package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHandling {
    private static final String ALGO = "MD5";
    
    // Encrypt the password
    public static String encrypt(String pass){
        
        String encryptedPassword = ""; // Create an empty string to hold the encrypted password
        StringBuilder buffer = new StringBuilder(); // Create an empty StringBuilder object
        try{ // Try to create a MessageDigest object
            MessageDigest msg = MessageDigest.getInstance(ALGO); // Create a MessageDigest object using MD5
            msg.update(pass.getBytes()); // Update the MessageDigest object with the password
            byte[] bytes = msg.digest(); // Create a byte array to hold the bytes of the password
            // Append the byte to the StringBuilder object as a hex string
            for(int i=0; i< bytes.length ;i++)buffer.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            encryptedPassword = buffer.toString(); // Set the encryptedPassword to the string value of the StringBuilder object
        } catch(NoSuchAlgorithmException e){
            PopUpWindow.showErrorMessage("Something went wrong...", "Encryption Failed(404)");
        }
        return encryptedPassword;
    }
    
    // Check if the password is correct
    public static boolean checkPassword(String firstPassword, String secondPassword){
        return firstPassword.equals(secondPassword);
    }
    
    // Decrypt the password
    public static String decrypt(String password){
        return encrypt(password);
    }
    
    // Check the strength of the password
    public static String getPasswordStrength(String password) {
        int minLength = 8; // Minimum length requirement
        if (password.length() < minLength) return "Weak";
        int score = 0; // Initialize score
        
        if (password.matches(".*[A-Z].*")) score += 2; // Check for at least one uppercase letter
        if (password.matches(".*[a-z].*")) score += 2; // Check for at least one lowercase letter
        if (password.matches(".*\\d.*")) score += 2; // Check for at least one digit
        if (password.matches(".*[@$!%*?&].*")) score += 2; // Check for at least one special character

        // Add bonus points for length and complexity
        score += Math.min(2, password.length() / 8);
        score += Math.min(2, (password.matches(".*[a-z].*") ? 1 : 0)
                            + (password.matches(".*[A-Z].*") ? 1 : 0)
                            + (password.matches(".*\\d.*") ? 1 : 0)
                            + (password.matches(".*[@$!%*?&].*") ? 1 : 0));

        // Determine strength based on score
        if (score <= 4) return "Weak";
        else if (score <= 8) return "Moderate";
        else return "Strong";
    }
}
