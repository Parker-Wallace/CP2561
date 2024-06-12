package Assignments.A3RegEx;

import java.util.Scanner;

public class SentenceReverser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("write a sentence to be reversed");
        String sample = scanner.nextLine();
        System.out.println(reverseSentence(sample));
    }


    public static String reverseSentence(String sentence) {
        String[] words = sentence.split("\\s");
        StringBuilder reversedSentence = new StringBuilder();
        for (int i = words.length-1 ; i >= 0; i--) {
            reversedSentence.append(words[i]).append(" ");
        }
        return String.valueOf(reversedSentence).trim();
    }
}
