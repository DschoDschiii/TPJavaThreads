package net.tfobz.rss;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ExecutorService extends Thread {

    private JTextArea area;
    List<URL> urls;


    public ExecutorService(JTextArea area, List<URL> urls) {
        this.area = area;
        if (urls == null) {
            this.urls = new ArrayList<>();
        } else {
            this.urls = urls;
        }

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
