package Assignments.A2Serialization.PhishingScanner;

import java.nio.file.*;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;


public class PhishingScanner {
    public static void main(String[] args) {
        // create a map of keywords and thier point value
        Map<String, Integer> phisingKeyWords = new HashMap<>();

        // the path to the file containing keywords and thier point values seperated by " " 
        Path PhisingTerms = Paths.get("src/main/java/Assignments/A2Serialization/PhishingScanner/PhishingTerms.txt");

        // try with resources to create the file reader to write the security summary
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/Assignments/A2Serialization/logs/emailSecuritylog.txt"))) {
            // write the header and initialize the total security risk score
            writer.write("Keyword\tOccurences\tSecurity Score\n");
            int emailSecurityScore = 0;

            /**
             * reads all the lines from the phishinKeywords Files then seperates them into key value pairs delimmited by " "
             */
            List<String> allLines = Files.readAllLines(PhisingTerms);
            for (String line : allLines) {
                String[] parts = line.split("\\s+");
                phisingKeyWords.put(parts[0], Integer.valueOf(parts[1]));
            }

            // read the content of the email and get a list of strings for each word in the email
            List<String> emailContent = readEmail();
            
            /**
             * for each key value pair in the phising keywords map check loop through the email content to see how many times the keyword appears
             * then write the number of occurences and the keyyword point total to the summary file
             */
            for (Entry<String, Integer> keyword : phisingKeyWords.entrySet()) {
                int occurrences = countOccurences(emailContent, keyword);
                if (occurrences != 0) {
                    int riskFactorPoints = occurrences * keyword.getValue();
                    emailSecurityScore += riskFactorPoints;
                        String formattedString = String.format("%s\t%d\t\t\t%d%n", keyword.getKey(), occurrences, riskFactorPoints);
                        writer.write(formattedString);
                    }
                }
            String formattedString = String.format("total risk factor:\t%d", emailSecurityScore);
            writer.write(formattedString);
        }             
        
         catch (Exception e) {
            System.out.println(e);
        }}

    /**
     * gets the occurences and point total of this content given a keyword-point value pairing.
     * @param content a list of strings to check the occurences of this keyword
     * @param keyword a map entry of a keyword and assigned point value
     * @return an int array containing the occurrences of the keyword in this content and the total point value
     */
    private static int countOccurences(List<String> content, Map.Entry<String, Integer> keyword) {
        int occurrences = 0;
        for (String word: content) {
            if (word.equals(keyword.getKey())) {
                occurrences ++;
            }
        }
        return occurrences;
    } 
    

    private static List<String> readEmail() {
        List<String> words = new ArrayList<>();
        Path path = Paths.get("src/main/java/Assignments/A2Serialization/PhishingScanner/FakeEmail2.txt");
        try {
            List<String> allLines = Files.readAllLines(path);
            for (String line : allLines) {
                String[] parts = line.split("[^a-zA-z']|\n");
                for (String part : parts) {
                    if (!part.isEmpty()) {
                        words.add(part);
                    }}}
                    return words;

        } catch (Exception e) {
            System.out.println(e);
        }
        return words;
    
    
    }

}

