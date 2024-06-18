package Tests.T01;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * converts phrases from {@code English.txt} into piglatin phrases and writes them to {@code Piglatin.txt}
 */
public class PiglatinEncode {

    /**
     * main method for {@see PiglatinEncode}
     */
    public static void main(String[] args) {
        //grab files
        File unEncodedPhrases = new File("English.txt");
        File encodedPhrases = new File("Piglatin.txt");
        
        //try with resources scanner and writer
        try (Scanner sc = new Scanner(unEncodedPhrases);
             FileWriter encoder = new FileWriter(encodedPhrases);) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                //tokenize the string and also take each space
                StringTokenizer tokens = new StringTokenizer(line," ", true);
                while (tokens.hasMoreTokens()) {
                    String token = tokens.nextToken();
                    //convert to piglatin if the token isnt a space character
                    if (!token.equals(" ")){
                        token = (token.substring(1)).concat(token.substring(0,1).concat("ay")).toLowerCase();
                    }
                    encoder.write(token);
                }
                encoder.write('\n');
            }
        }

        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
