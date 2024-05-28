package ClassWork.WorkingWithSerialization;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.security.spec.ECField;
import java.util.Scanner;
import javax.xml.bind.JAXB;

public class AnalyzeLogs {
    public static void main(String[] args) {
        Path path = Paths.get("src/main/java/ClassWork/WorkingWithSerialization/logs");
        if (Files.exists(path)) {
            try {
                DirectoryStream<Path> directoryStream =
                        Files.newDirectoryStream(path);
                int totalFiles = 0;
                int totalGuesses = 0;
                for (Path p : directoryStream) {
                    BufferedReader input = Files.newBufferedReader(p);
                    GameLog gameLogs = JAXB.unmarshal(input, GameLog.class);
                    totalGuesses += gameLogs.getGuesses().size();
                    totalFiles ++;
                }
                System.out.println("total games played: " + totalFiles);
                System.out.println("total guesses across games: " + totalGuesses);
                System.out.println("average guesses: " + totalGuesses/totalFiles);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            System.out.println("files not found");
        }
    }}