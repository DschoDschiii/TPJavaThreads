package net.tfobz.rss;

import javax.swing.*;
import java.net.URL;

public class RssThread extends Thread {

    private URL url;
    private JTextArea textarea;

    public RssThread(URL url){
        this.url = url;
    }

    @Override
    public void run() {
        super.run();
    }
}
