package net.tfobz.rss;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MainGUI extends JFrame {
    private JTextArea rssarea;

    private JButton urladdbutton;
    private JButton scheduleswitchbutton;
    private JButton updatebutton;

    ScheduledExecutorService executor;

    public MainGUI() {
        super("Simple RSSReader");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(50, 50, 975, 600);
        setLayout(null);

        Font font = new Font("Verdana", Font.BOLD, 12);

        Container cpane = getContentPane();
        rssarea = new JTextArea();
        rssarea.setEditable(false);

        JScrollPane scrollpane = new JScrollPane(rssarea);
        scrollpane.setBounds(5, 5, 965, 510);
        cpane.add(scrollpane);

        urladdbutton = new JButton("Add Url...");
        urladdbutton.setBounds(550, 525, 100, 35);
        urladdbutton.setMnemonic('U');
        urladdbutton.setFont(font);
        urladdbutton.addActionListener(e -> {
            try{
                String urlstring = JOptionPane.showInputDialog("Neue URL eingeben");
                if(urlstring != null){
                    URL url = new URL(urlstring);
                    executor.addURL(url);
                }
            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(this, "Keine gültige URL!");
            }
        });
        cpane.add(urladdbutton);

        scheduleswitchbutton = new JButton("Activate Scheduler");
        scheduleswitchbutton.setBounds(655, 525, 200, 35);
        scheduleswitchbutton.setMnemonic('e');
        scheduleswitchbutton.setFont(font);
        scheduleswitchbutton.addActionListener(e -> {
            executor.switchActive();
            if(executor.isActive())
                scheduleswitchbutton.setText("Deavtivate Scheduler");
            else
                scheduleswitchbutton.setText("Activate Scheduler");
        });
        cpane.add(scheduleswitchbutton);

        updatebutton = new JButton("Update");
        updatebutton.setBounds(860, 525, 100, 35);
        updatebutton.setMnemonic('a');
        updatebutton.setFont(font);
        updatebutton.addActionListener(e -> executor.updateRssFeeds());
        cpane.add(updatebutton);

        executor = new ScheduledExecutorService(rssarea, null, 10000);
        executor.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
