package Assignments.A2.EricsFitnessProgram;

import javax.xml.bind.JAXB;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.*;
import java.util.Scanner;

public class FitnessProgram {
    public static void main(String[] args) {
        Path path = Paths.get("src/main/java/Assignments/A2/EricsFitnessProgram/Settings.xml");
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
                        try (BufferedReader reader = Files.newBufferedReader(path)) {
                            Settings settings = JAXB.unmarshal(reader, Settings.class);
                            System.out.println(settings.getName());
                            System.out.println(settings.getHeight());
                            System.out.println(settings.getWeight());
                            System.out.println(settings.getBirthday());
                            System.out.println(settings.getFTP());
                        }
                        catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                    else {
                        System.out.println("Settings have not been saved yet, please update and save settings");
                    }
                    break;
                case 2:
                    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                        Settings settings = new Settings();
                        try (Scanner userInput = new Scanner(System.in)) {
                            System.out.println("please enter name");
                            settings.setName(userInput.next());
                            System.out.println("please enter height");
                            settings.setHeight(userInput.nextInt());
                            System.out.println("please enter weight");
                            settings.setWeight(userInput.nextInt());
                            System.out.println("please enter birthday");
                            settings.setBirthday(userInput.next());
                            System.out.println("please enter ftp");
                            settings.setFtp(userInput.nextInt());
                        }
                        JAXB.marshal(settings, writer);
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    
                case 3: continue;
                default:
                    System.out.println("invalid input please try again...");
            }
        }
        input.close();
    
    } 
}
