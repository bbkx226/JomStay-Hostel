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
}
