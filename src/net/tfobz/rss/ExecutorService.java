package net.tfobz.rss;

import javax.swing.*;
import java.net.URL;
import java.util.List;

public class ExecutorService extends Thread{

    private JTextArea area;


    public ExecutorService(JTextArea area, List<URL> urls){

    }

    @Override
    public void run(){
        updateRssFeeds();
    }

    public void updateRssFeeds(){

    }
}
