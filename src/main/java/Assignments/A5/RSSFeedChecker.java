package Assignments.A5;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RSSFeedChecker {
    private String feedUrl;

    public RSSFeedChecker(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public void checkFeed() {
        try {
            URL url = new URL(feedUrl);
            //XML Document building
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            //This is how you work with XML - you do not need to modify this!
            NodeList itemList = doc.getElementsByTagName("item");
            List<RSSItem> items = new ArrayList<>();

            for (int i = 0; i < itemList.getLength(); i++) {
                Node itemNode = itemList.item(i);
                if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element itemElement = (Element) itemNode;
                    String title = itemElement.getElementsByTagName("title").item(0).getTextContent();
                    String link = itemElement.getElementsByTagName("link").item(0).getTextContent();
                    String pubDate = itemElement.getElementsByTagName("pubDate").item(0).getTextContent();
                    items.add(new RSSItem(title, link, pubDate));
                }
            }

            System.out.println("Feed: " + feedUrl);
            for (int i = 0; i < Math.min(3, items.size()); i++) {
                RSSItem item = items.get(i);
                System.out.println("Title: " + item.getTitle());
                System.out.println("Link: " + item.getLink());
                System.out.println("Published Date: " + item.getPubDate());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class RSSItem {
        private String title;
        private String link;
        private String pubDate;

        public RSSItem(String title, String link, String pubDate) {
            this.title = title;
            this.link = link;
            this.pubDate = pubDate;
        }

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getPubDate() {
            return pubDate;
        }
    }
}