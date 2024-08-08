package Projects.CardGameCLI.Client.GUI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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
    private static String[] getcards(String cards) {
            // Split the input string by commas
            String[] result = cards.split(",");
            
            // Return the array of cards
            return result;
        }
        

    public static void printCards(String cards) {
        String[] cardsList = getcards(cards);
        String[] cardLines = new String[7];

        for (int i = 0; i < 7; i++) {
            StringBuilder lineBuilder = new StringBuilder();
            for (String card : cardsList) {
                char face = card.charAt(1);
                char value = card.charAt(0);
                
                if (value == '1') {
                String tenvalue = card.substring(0, 2);
                face = card.charAt(2);
                String[] lines = new String[7];
                lines[0] = "┌─────────┐";
                lines[1] = String.format("│ %-2s      │", tenvalue);
                lines[2] = "│         │";
                lines[3] = String.format("│    %s    │", face);
                lines[4] = "│         │";
                lines[5] = String.format("│      %-2s │", tenvalue);
                lines[6] = "└─────────┘";

                lineBuilder.append(lines[i]).append("");
                cardLines[i] = lineBuilder.toString();
            }
            else {
                String[] lines = new String[7];
                lines[0] = "┌─────────┐";
                lines[1] = String.format("│ %-2s      │", value);
                lines[2] = "│         │";
                lines[3] = String.format("│    %s    │", face);
                lines[4] = "│         │";
                lines[5] = String.format("│      %-2s │", value);
                lines[6] = "└─────────┘";

                lineBuilder.append(lines[i]).append("");
                cardLines[i] = lineBuilder.toString();}
                if (cardsList.length == 1) {
                    String[] lines = new String[7];
                    lines[0] = "┌─────────┐";
                    lines[1] = String.format("│         │");
                    lines[2] = "│         │";
                    lines[3] = String.format("│         │");
                    lines[4] = "│         │";
                    lines[5] = String.format("│         │");
                    lines[6] = "└─────────┘";
                    lineBuilder.append(lines[i]).append("");
                    cardLines[i] = lineBuilder.toString();
                }
            }
        }

        // Print each line
        for (String line : cardLines) {
            System.out.println(line);
        }
    }

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
