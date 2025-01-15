package Java_ClassesObjectsFirstProgram.Java5HW;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {
        public static void main(String[] args) {
            String[] phoneNumbers = {
                    "+44 20 7946 0958",
                    "+91-987 654 3210",
                    "+7 800-555-3535",
                    "+1(323) 951-983",
                    "+12 345 6789"
            };

            for (String phone : phoneNumbers) {
                System.out.println(phone + " номер действителен: " + isValidPhoneNumber(phone));
            }
        }

    private static final String PHONE_REGEX = "^\\+([1-9]{1,3})\\s?-?\\(?\\d{1,4}\\)?[-\\s]?\\d{1,4}[-\\s]?\\d{1,4}$";

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

}
