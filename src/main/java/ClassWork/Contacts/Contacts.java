package ClassWork.Contacts;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class Contacts {
    public static void main(String[] args) {
        try (
            FileWriter invalidWriter = new FileWriter("logs/invalid_Contacts.txt");
            FileWriter validWriter = new FileWriter("logs/valid_Contacts.txt");
             )
        {
            List<String> allLines = Files.readAllLines(Path.of("src/main/java/ClassWork/Contacts/contacts.txt"));
            for (String line: allLines) {
                if (validatePhoneNumber(line)) {
                    validWriter.write(line + System.lineSeparator());
                }
                else {
                    invalidWriter.write(line + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * validates a phone number in the format xxx-xxx-xxxx where the first 3 digits are either 709 or 613
     * @param phoneNumber a string which may or may not contain a valid phone number
     * @return {@code true} if this string contains a valid phone number otherwise {@code false}
     */
    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern validPhoneNumber = Pattern.compile("(709|613)-\\d{3}-\\d{4}");
        Matcher matcher = validPhoneNumber.matcher(phoneNumber);
        return matcher.find();
    }
}
