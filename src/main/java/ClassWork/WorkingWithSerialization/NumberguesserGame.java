package ClassWork.WorkingWithSerialization;

import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.nio.file.Paths;
import javax.xml.bind.JAXB;

/**
 * The {@code NumberguesserGame} class demonstrates writing to files.
 * The {@code main} method generates a random number within the bound of 100,
 * takes user input until the user guesses the number, and writes the guesses to a timestamped .txt file.
 */
public class NumberguesserGame {
    /**
     * The main method that runs the number guessing game.
     * A random number between 0 and 99 is generated, and the user is prompted to guess the number.
     * Each guess is logged to a timestamped file until the correct number is guessed.
     */
    public static void main(String[] args) {
        GameLog gamelog = new GameLog();
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new java.util.Date());

        // Create the file path with the timestamp
        String filePath = String.format("src/main/java/ClassWork/WorkingWithSerialization/logs/gamelog%s.xml", timeStamp);

        try (BufferedWriter output = Files.newBufferedWriter((Paths.get(filePath)))) {
            Scanner input = new Scanner(System.in);
            System.out.println("im Thinking of a number between one and one-hundred, can you guess it?");
            System.out.println(randomNumber);
            int guess = 0;
            while (guess != randomNumber) {
                guess = input.nextInt();
                if (guess > randomNumber) {
                    System.out.println("my number is Lower than that! Try again...");
                    gamelog.getGuesses().add(guess);
                } else if (guess < randomNumber) {
                    System.out.println("my number is higher than that! try again...");
                    gamelog.getGuesses().add(guess);
                } else {
                    System.out.println("holy moly you got it! good job");
                    gamelog.getGuesses().add(guess);
                }
            }
            JAXB.marshal(gamelog, output);
            input.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
    }
