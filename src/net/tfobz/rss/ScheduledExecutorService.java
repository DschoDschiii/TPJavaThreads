package net.tfobz.rss;

import javax.swing.*;
import java.net.URL;
import java.util.List;

public class ScheduledExecutorService extends ExecutorService{

    private boolean active;
    private int interval;


    public ScheduledExecutorService(JTextArea area, List<URL> urls, int interval){
        super(area, urls);
        this.interval = interval;
        active = true;
    }

    public void switchActive(){
        active = !active;
    }

    public boolean isActive(){
        return active;
    }

    public void run(){

        while (true){
            if(active){
                updateRssFeeds();
                System.out.println("Updated!");
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }

        }
    }

}
