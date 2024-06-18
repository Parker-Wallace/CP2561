package Tests.T01;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCyclistID {
    public static void main(String[] args) {


        try (Scanner sc = new Scanner(System.in)) {
            boolean registered = false;
            Pattern pattern = Pattern.compile("[A-Z]{3}\\d{4}(D1|D2|D3|D4)_\\d{5}");
            while (!registered) {
            System.out.println("enter the cyclist ID");
            String cyclistID = sc.next();

            Matcher matcher = pattern.matcher(cyclistID);
            if (matcher.find()) {
                System.out.println("you are registered for the cyclist race");
                registered = true;
            } else {
                System.out.println("invalid liscence, please try again");
            }
        }
        }
    }
}
