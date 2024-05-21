package ClassWork.FunWithIOandFiles;

import java.io.FileNotFoundException;
import java.util.Random;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.file.Paths;

public class NumberguesserGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);
        String currentDirectory = System.getProperty("user.dir");

        String logFilePath = Paths.get(currentDirectory,"hello" ).toString();
        try (Formatter output = new Formatter("./logs/Gamelog.txt")) {
            output.format("%d", randomNumber);
            Scanner input = new Scanner(System.in);
            System.out.println("im Thinking of a number between one and one-hundred, can you guess it?");
            int guess = 0;
            while (guess != randomNumber) {
                guess = input.nextInt();
                if (guess > randomNumber) {
                    System.out.println("my number is Lower than that! Try again...");
                    output.format("hello world");
                } else if (guess < randomNumber) {
                    System.out.println("my number is higher than that! try again...");
                    output.format("bye world");
                } else {
                    System.out.println("holy moly you got it! good job");
                    output.format("hola world");
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    }
