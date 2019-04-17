package net.tfobz.rss;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class RssThread extends Thread {

    private URL url;
    private JTextArea textarea;

    public RssThread(JTextArea textarea, URL url){
        this.textarea = textarea;
        this.url = url;
    }

    @Override
    public void run() {
        RSSFeedParser parser = new RSSFeedParser(url);
        Feed f = parser.readFeed();
        for(FeedMessage message: f.getMessages()){
            EventQueue.invokeLater(()->textarea.append(message.getTitle()+":  "+message.getDescription()+"\n"));
        }
    }
}
