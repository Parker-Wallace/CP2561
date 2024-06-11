package Assignments.A3RegEx;

public class ScentenceReverser {
    public static String sample = "The Quick Brown Fox Jumps Over The Lazy Dog";

    public static void main(String[] args) {
        System.out.println(    reverseScentence(sample));
    }


    public static String reverseScentence(String scentence) {
        String[] words = scentence.split("\\s");
        StringBuilder reversedScentence = new StringBuilder();
        for (int i = words.length-1 ; i >= 0; i--) {
            reversedScentence.append(words[i]).append(" ");
        }
        return String.valueOf(reversedScentence);
    }
}
