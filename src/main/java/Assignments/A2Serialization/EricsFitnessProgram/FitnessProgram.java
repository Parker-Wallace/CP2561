package Assignments.A2Serialization.EricsFitnessProgram;

import java.io.BufferedReader;
import java.nio.file.*;
import java.util.Scanner;

public class FitnessProgram {
    public static void main(String[] args) {
        Path path = Paths.get("src/main/java/Assignments/A2Serialization/EricsFitnessProgram/Settings.xml");
        Scanner input = new Scanner(System.in);
        Integer userChoice = 0;
        while (userChoice != 3) {
            System.out.println("Press 1 to View Settings...");
            System.out.println("Press 2 to Update Settings...");
            System.out.println("Press 3 to Exit...");
            userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    if (Files.exists(path)) {
                        BufferedReader reader = Files.newBufferedReader(path);
                        
                    }       
                default:
                    System.out.println("invalid input please try again...");
            }
        }
        input.close();
    
    } 
}
