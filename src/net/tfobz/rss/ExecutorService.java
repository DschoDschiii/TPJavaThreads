package net.tfobz.rss;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExecutorService extends Thread {

    private JTextArea area;
    private List<URL> urls;


    public ExecutorService(JTextArea area, List<URL> urls) {
        this.area = area;
        this.urls = Objects.requireNonNullElseGet(urls, ArrayList::new);

    }

    public void addURL(URL url){
        urls.add(url);
    }

    @Override
    public void run() {
        updateRssFeeds();
    }

    public void updateRssFeeds() {
        for (URL url : urls) {
            new RssThread(area, url).start();
        }
    }
}
