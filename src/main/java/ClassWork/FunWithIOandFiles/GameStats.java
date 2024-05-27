package ClassWork.FunWithIOandFiles;// Fig. 15.2: FileAndDirectoryInfo.java
// File class used to obtain file and directory information.
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameStats
{
    public static void main(String[] args) throws IOException
    {


        // create Path object based on user input
        Path path = Paths.get("src/main/java/ClassWork/FunWithIOandFiles/logs");

        if (Files.exists(path)) // if path exists, output info about it
        {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                List<Integer> totalGuesses = new ArrayList<Integer>();
                for (Path filePath : stream) {
                    // Check if the current Path is a regular file and not a directory
                    if (Files.isRegularFile(filePath)) {
                        // Read all lines from the file
                        List<String> lines = Files.readAllLines(filePath);
                        System.out.println((lines).toArray().length);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            }
        }
    }