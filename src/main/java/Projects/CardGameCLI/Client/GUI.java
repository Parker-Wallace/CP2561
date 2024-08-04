package Projects.CardGameCLI.Client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GUI {
    final public static void GAMEHEADER() {}

    final public static void GAMEWelcome() {
        clearConsole();
        System.out.println("****************************************");
        System.out.println("");
        System.out.println("          WELCOME TO BLACKJACK              ");
        System.out.println("");
        System.out.println("*****************************************");
    }
    final public static void PRINTBUST () {        
        String[] frames = {
        "src/main/java/Projects/CardGameCLI/Client/frame1.txt",
        "src/main/java/Projects/CardGameCLI/Client/frame2.txt",
        "src/main/java/Projects/CardGameCLI/Client/frame3.txt",
        "src/main/java/Projects/CardGameCLI/Client/frame4.txt"
        };

        try {
            playAnimation(frames, 400);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }}

    public static void playAnimation(String[] frames, int delay) throws IOException, InterruptedException {
        for (int i = 0; i < 5; i++) {  // Loop through the animation 10 times
            for (String frame : frames) {
                clearConsole();
                printFrame(frame);
                Thread.sleep(delay);
            }
        }
    }

    private static void printFrame(String framePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(framePath));
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void printHand() {}

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
