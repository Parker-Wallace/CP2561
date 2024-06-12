package Assignments.A3RegEx.SensitiviyRedacter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Redacter {
    public static void main(String[] args) {
        Path readPath = Paths.get("src/main/java/Assignments/A3RegEx/SensitiviyRedacter/sampleInfo.txt");
        String writePath = "logs/sampleInfoRedacted.txt";
        try {
            List<String> allLines = Files.readAllLines(readPath);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(writePath))) {
                for (String line :allLines) {
                    line = searchSensitiveData(line);
                    writer.write(line + "\n");
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * searches a string for sensitive information and returns the same string with the data redacted
     * sensitive data:
     * dates in the format xx-xx-xx or xx-xx-xxxx
     * finance info: a $ followed by a int or float
     * credit card number in the format xxxx-xxxx-xxxx-xxxx
     * 14-20 digit numbers preceded by 'CODE'
     *
     * @param line  a string which will be checked for sensitive information
     * @return
     */
    public static String searchSensitiveData(String line) {

        if (line.matches(".*\\d{2}-\\d{2}-\\d{2,4}.*")) {
            line = line.replaceAll("\\d{2}-\\d{2}-\\d{2,4}", "##-##-####");
        }
        if (line.matches(".*\\s\\d*-\\d*-\\d*-\\d*.*")) {
            line = line.replaceAll("\\d*-\\d*-\\d*-\\d*", "####-####-####-####");
        }
        if (line.matches(".*\\$(\\d+(\\.\\d{0,2})?).*")) {
            line = line.replaceAll("\\$(\\d+(\\.\\d{0,2})?)", "\\$##.##");
        }
        if (line.matches(".*[CODE]\\d+.*")) {
            line = line.replaceAll("CODE\\d+", "################");
        }
        return line;
    }

}
