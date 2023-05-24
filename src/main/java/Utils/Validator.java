// @author Brandon Ban Kai Xian TP067094
// @co-author They Kai Zhe TP062802
package Utils;

import Models.Payment;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Calendar;
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

    private static final String PHONEREGEX = "^(\\+?6?01)[02-46-9]-*[0-9]{7}$|^(\\+?6?01)[1]-*[0-9]{8}$";
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
    
    /**
     * Validates an input date string using the specified format and returns a
     * LocalDateTime object with a time of 12:00 PM on the input date if the
     * date is valid and not in the past.
     *
     * @param dateString A string representing the input date to be validated
     * @param format A string representing the format of the input date string
     * (e.g. "dd-MM-yyyy")
     * @return A LocalDateTime object with a time of 12:00 PM on the input date
     * if the date is valid and not in the past. Returns null if the input date
     * string is not in the correct format or if the parsed date is in the past.
     */
    public static LocalDate validateApplicationInputDate(String dateString, String format) {
        // Define a DateTimeFormatter object to parse the input date string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        // Declare a LocalDate object to hold the parsed date
        LocalDate date;
        String[] dateSplit = dateString.split("-");
        boolean checkDate = isInvalidDay(Integer.parseInt(dateSplit[2]),Integer.parseInt(dateSplit[1]),Integer.parseInt(dateSplit[0]));
        if(!checkDate) return null;
        date = LocalDate.parse(dateString, formatter);

        // Check that the parsed date is not in the past
        if (date.isBefore(LocalDate.now())) {
            // Return null if the input date is in the past
            return null;
        }

        // Return a LocalDateTime object with a time of 12:00 PM on the input date
        return date;
    }
    
    public static boolean isInvalidDay(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false); // Ensure strict date validation
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Calendar.MONTH is zero-based
        int maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return day < 1 || day <= maxDayOfMonth;
    }
}