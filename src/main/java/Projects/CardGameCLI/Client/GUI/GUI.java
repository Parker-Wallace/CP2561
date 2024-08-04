package Projects.CardGameCLI.Client.GUI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.simple.JSONArray;

public class GUI {
    final public static void GAMEHEADER() {}

    final public static void GAMEWelcome() {
        String[] frames = {
            "src/main/java/Projects/CardGameCLI/Client/GUI/Welcome/frame1.txt",
            "src/main/java/Projects/CardGameCLI/Client/GUI/Welcome/frame2.txt",
            "src/main/java/Projects/CardGameCLI/Client/GUI/Welcome/frame3.txt",
            "src/main/java/Projects/CardGameCLI/Client/GUI/Welcome/frame4.txt",
            "src/main/java/Projects/CardGameCLI/Client/GUI/Welcome/frame5.txt",
            "src/main/java/Projects/CardGameCLI/Client/GUI/Welcome/frame6.txt",
            "src/main/java/Projects/CardGameCLI/Client/GUI/Welcome/frame7.txt"
            };
            try {
                    playAnimation(frames, 400);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

    }
    final public static void PRINTBUST () {        
        String[] frames = {
        "src/main/java/Projects/CardGameCLI/Client/GUI/BustAnimation/frame1.txt",
        "src/main/java/Projects/CardGameCLI/Client/GUI/BustAnimation/frame2.txt",
        "src/main/java/Projects/CardGameCLI/Client/GUI/BustAnimation/frame3.txt",
        "src/main/java/Projects/CardGameCLI/Client/GUI/BustAnimation/frame4.txt"
        };

        try {
            for (int i = 0; i < 3; i++) {
                playAnimation(frames, 400);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }}

    public static void playAnimation(String[] frames, int delay) throws IOException, InterruptedException {
            for (String frame : frames) {
                clearConsole();
                printFrame(frame);
                Thread.sleep(delay);
            }
        }

    private static void printFrame(String framePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(framePath));
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void printHand() {}

    public static void printChips(int chips) {
        System.out.println("***************");
        System.out.println("chips available: " + chips);
        System.out.println("**********************");
    }

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
