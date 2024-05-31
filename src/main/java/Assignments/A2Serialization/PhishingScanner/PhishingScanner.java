package Assignments.A2Serialization.PhishingScanner;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PhishingScanner {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        BufferedReader reader;

        Path path = Paths.get("src/main/java/Assignments/A2Serialization/PhishingScanner/PhishingTerms.txt");
        try {
            List<String> allLines = Files.readAllLines(path);
            for (String line : allLines) {
                String[] parts = line.split("\\s+");
                words.add(parts[0]);
                points.add(Integer.valueOf(parts[1]));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
