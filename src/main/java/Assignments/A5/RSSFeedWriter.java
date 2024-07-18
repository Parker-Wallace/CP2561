package Assignments.A5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RSSFeedWriter {
    private Queue<RSSItem> RSSItems = new LinkedList<>();
    private List<RSSItem> items = new ArrayList<>();


    public synchronized void addRSSItem(RSSItem item) throws InterruptedException {
        RSSItems.add(item);
        notifyAll();
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
        RSSItem item = RSSItems.poll();
        if (items.contains(item)){
        }
        else{
            items.add(item); 
            System.out.println("Title: " + item.getTitle());
            System.out.println("Link: " + item.getLink());
            System.out.println("Published Date: " + item.getPubDate());
            System.out.println();}
      
        }

    }

