package Assignments.A5;

import java.util.LinkedList;
import java.util.Queue;

public class RSSFeedWriter {
    private Queue<RSSItem> RSSItems = new LinkedList<>();


    public synchronized void addRSSItem(RSSItem item) throws InterruptedException {
        RSSItems.add(item);
        notifyAll();
        System.out.println("notified");
        WriteRSSFeed();
    }

    public synchronized void helloworld() {
        System.out.println("hello, world");
    }

    public synchronized void WriteRSSFeed() throws InterruptedException {
        while (RSSItems.isEmpty()) {
            wait();
            System.out.println("waiting");
        }
        System.out.println("im ht, just broken");
        RSSItem item = RSSItems.poll();
        System.out.println("Title: " + item.getTitle());
        System.out.println("Link: " + item.getLink());
        System.out.println("Published Date: " + item.getPubDate());
        System.out.println();
        }

    }

