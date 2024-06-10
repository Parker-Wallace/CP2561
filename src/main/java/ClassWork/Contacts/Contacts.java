package ClassWork.Contacts;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacts {
    public static void main(String[] args) {
        try (
            FileWriter invalidWriter = new FileWriter("logs/invalid_Contacts.txt");
            FileWriter validWriter = new FileWriter("logs/valid_Contacts.txt");
             )
        {
            Pattern phoneNumber = Pattern.compile("(709|613)-\\d{3}-\\d{4}");
            List<String> allLines = Files.readAllLines(Path.of("src/main/java/ClassWork/Contacts/contacts.txt"));
            for (String line: allLines) {
                Matcher matcher = phoneNumber.matcher(line);
                if (matcher.find()) {
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
}
