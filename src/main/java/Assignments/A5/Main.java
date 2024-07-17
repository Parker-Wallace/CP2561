package Assignments.A5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> feedUrls = new ArrayList<>();
            RSSFeedWriter writer = new RSSFeedWriter();
            final String end = "done";
            String url = "";
            writer.helloworld();
            System.out.println("Enter RSS feed URLs (type 'done' to finish):");
            while (!url.equals(end)) {
                url = scanner.nextLine();
                if (!url.equalsIgnoreCase(end)) {
                    feedUrls.add(url);
                }
            }


            for (String feedUrl : feedUrls) {
                Thread feedthread = new Thread(new RSSFeedChecker(feedUrl, writer));
                feedthread.start();
            }
            
        }
    }
}