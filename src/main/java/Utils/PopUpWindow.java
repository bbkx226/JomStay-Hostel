// @author Brandon Ban Kai Xian TP067094
package Utils;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PopUpWindow {
    
    private static ImageIcon getResizedImage(ImageIcon icon){
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(96, 96,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        return icon;
    }
    public static void showSuccessfulMessage(String message, String title){
        ImageIcon tickIcon = new ImageIcon("src/main/java/assets/tick.png");
        tickIcon = getResizedImage(tickIcon);
        JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,tickIcon);   
    }
    
    public static void showErrorMessage(String message, String title){
        ImageIcon errorIcon = new ImageIcon("src/main/java/assets/error.png");
        errorIcon = getResizedImage(errorIcon);
        JOptionPane.showMessageDialog(null,message,title,JOptionPane.ERROR_MESSAGE,errorIcon);   
    }
    
    public static void showSuggestionMessage(String message, String title){
        ImageIcon suggestionIcon = new ImageIcon("src/main/java/assets/suggestion.png");
        suggestionIcon = getResizedImage(suggestionIcon);
        JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,suggestionIcon);   
    }
    
    public static void showFormatErrorMessage(String message, String title){
        ImageIcon formatErrorIcon = new ImageIcon("src/main/java/assets/formatError.png");
        formatErrorIcon = getResizedImage(formatErrorIcon);
        JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,formatErrorIcon);   
    }    
    
    public static void showGoodByeMessage(String message, String title){
        ImageIcon goodbyeIcon = new ImageIcon("src/main/java/assets/goodbye.png");
        goodbyeIcon = getResizedImage(goodbyeIcon);
        JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,goodbyeIcon);
    }
    
    public static void showAuthenticatedMessage(String message, String title){
        ImageIcon authenticateIcon = new ImageIcon("src/main/java/assets/authentication.png");
        authenticateIcon = getResizedImage(authenticateIcon);
        JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,authenticateIcon);
    }
    
    public static boolean showRoom(String message, String title) {
        ImageIcon roomPic = new ImageIcon("src/main/java/assets/dorm_room_pic_small.png");
        roomPic = getResizedImage(roomPic);
        String[] options = { "Apply" };
        int confirm = JOptionPane.showOptionDialog(null, message, title, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, roomPic, options, title);
        return confirm == JOptionPane.OK_OPTION;
    }
}
