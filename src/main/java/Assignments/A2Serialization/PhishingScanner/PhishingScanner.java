package Assignments.A2Serialization.PhishingScanner;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class PhishingScanner {
    public static void main(String[] args) {
        BufferedReader reader;
        String path = "Assignments/A2Serialization/PhishingScanner/PhisingTerms.txt";
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
