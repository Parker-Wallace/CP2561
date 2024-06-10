package Assignments.A3RegEx.SensitiviyRedacter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Redacter {
    public static void main(String[] args) {
        Path readPath = Paths.get("src/main/java/Assignments/A3RegEx/SensitiviyRedacter/sampleInfo.txt");
        String writePath = "logs/sampleInfoRedacted.txt";
        try {
            List<String> allLines = Files.readAllLines(readPath);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(writePath))) {
                for (String line :allLines) {
                    if (line.matches(".*\\d{2}-\\d{2}-\\d{2,4}.*")) {
                        line = line.replaceAll("\\d{2}-\\d{2}-\\d{2,4}", "##-##-####");
                    }
                    if (line.matches(".*\\s(\\d{4}-?){4}\\s.*")) {
                        line = line.replaceAll("(\\d{4}-?){4}", "####-####-####-####");
                    }
                    if (line.matches(".*[$].*")) {
                        line = line.replaceAll("[$]\\d+([.]\\d+)?", "\\$##.##");
                    }
                    if (line.matches(".*[CODE]\\d+.*")) {
                        line = line.replaceAll("[CODE]\\d+", "################");
                    }
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

}
