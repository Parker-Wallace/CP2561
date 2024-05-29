package Assignments.A2Serialization;

import java.util.*;

public class TelephonicWordGen {

    public static void getWord(String phoneNumber) {}



    public static void main(String[] args) {

        Map<Integer, List<String>> correspondence = new HashMap<>();
        // Add entries to the dictionary
        correspondence.put(2, List.of("A","B","C"));
        correspondence.put(3, List.of("D","E","F"));
        correspondence.put(4, List.of("G","H","I"));
        correspondence.put(5, List.of("J","K","L"));
        correspondence.put(6, List.of("M","N","O"));
        correspondence.put(7, List.of("P","R","S"));
        correspondence.put(8, List.of("T","U","V"));
        correspondence.put(9, List.of("W","X","Y"));

         String filePath = "src/main/java/Assignments/A2Serialization/logs/phonicword.txt";

        try (Formatter output = new Formatter(filePath)){
            String number = "6392277";
            for (int j = 0; j < 7; j++) {
            for (int i = number.length()-1;  i >= 0;  i--) {
                char c = number.charAt(i);
                System.out.print(c);
        }}
    }catch (Exception e) {
            System.out.println(e);
        }
    }
}
