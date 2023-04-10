// @author Brandon Ban Kai Xian TP067094
package Utils;

import Models.Payment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.JTable;

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
    
    /**
     * 
     * Checks if the given list of integers contains a complete range of numbers between the minimum and maximum values in the list.
     * @param list the list of integers to be checked
     * @return true if the list contains a complete range of numbers, false otherwise
     * @throws IllegalArgumentException if the list is empty
    */
    public static boolean isRangeComplete(ArrayList<Integer> list) {
        // Check if the list is empty
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }

        // Find the minimum and maximum numbers in the list
        int min = Collections.min(list);
        int max = Collections.max(list);

        // Create a boolean array to keep track of which numbers are present
        boolean[] present = new boolean[max - min + 1];

        // Iterate over the numbers in the list and mark each number as present in the boolean array
        for (int i : list) {
            present[i - min] = true;
        }

        // Iterate over the boolean array and return false if any number is missing
        for (boolean p : present) {
            if (!p) {
                return false;
            }
        }

        // If all the numbers are present, return true
        return true;
    }
    
    public static boolean validatePaymentTableSelection(ArrayList<Payment> payments, JTable paymentTable, ArrayList<Integer> selectedMonths, double selectedAmt) {
        List<Integer> totalMonths = IntStream.range(0, payments.size())
            .filter(i -> !payments.get(i).getStatus().equals(Payment.PaymentStatus.PAID))
            .mapToObj(i -> i + 1)
            .collect(Collectors.toList());

        List<Integer> actualSelections = IntStream.range(0, paymentTable.getRowCount())
            .filter(i -> (boolean) paymentTable.getValueAt(i, 0))
            .mapToObj(i -> i + 1)
            .collect(Collectors.toList());

        double actualSelectedAmt = IntStream.range(0, paymentTable.getRowCount())
            .filter(i -> (boolean) paymentTable.getValueAt(i, 0))
            .mapToDouble(i -> (double) paymentTable.getValueAt(i, 3))
            .sum();

        return !selectedMonths.isEmpty()
            && Objects.equals(selectedMonths.get(0), totalMonths.get(0))
            && selectedMonths.equals(actualSelections)
            && selectedMonths.size() <= totalMonths.size()
            && selectedAmt >= actualSelectedAmt
            && selectedAmt <= actualSelectedAmt
            && Validator.isRangeComplete(selectedMonths);
    }
}