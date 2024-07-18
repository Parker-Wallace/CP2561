package Assignments.A5;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Represents a tool to check RSS feeds intended to be executed by a thread
 */
public class RSSFeedChecker implements Runnable{
    private String feedUrl;
    private RSSFeedWriter FeedWriter;

    /**
     * Class constructor specifying the URL which provides the XML
     * 
     * @param feedUrl the url of the RSS feed which is provided in XML
     */
    public RSSFeedChecker(String feedUrl, RSSFeedWriter rssFeedWriter) {
        this.feedUrl = feedUrl;
        this.FeedWriter = rssFeedWriter;
    }
    
    

    @Override
    public void run() {
        while (true) {
        try {
            checkFeed();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            break;
        }
    }}

    public void checkFeed() {
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL(feedUrl);
            //XML Document building
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            //This is how you work with XML - you do not need to modify this!
            NodeList itemList = doc.getElementsByTagName("item");


            for (int i = 0; i < 3; i++) {
                Node itemNode = itemList.item(i);
                if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element itemElement = (Element) itemNode;
                    String title = itemElement.getElementsByTagName("title").item(0).getTextContent();
                    String link = itemElement.getElementsByTagName("link").item(0).getTextContent();
                    String pubDate = itemElement.getElementsByTagName("pubDate").item(0).getTextContent();
                    RSSItem item = new RSSItem(title, link, pubDate);
                    FeedWriter.addRSSItem(item);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }




}