package net.tfobz.oClock;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    private DigitalClock digitalClock;
    private JLabel time;
    private JButton bstop;
    private JButton bcont;
    private final int WIDTH = 300;
    private final int HEIGTH = 300;
    private final int ABST = 5;

    public GUI(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(new Rectangle(WIDTH,HEIGTH));
        setLayout(null);
        time = new JLabel();
        time.setBounds(6*ABST,ABST,5*WIDTH/6,2*HEIGTH/4);
        time.setFont(new Font("Verdana", Font.PLAIN, 48));
        bstop = new JButton();
        bstop.setBounds(4*ABST,2*ABST+2*HEIGTH/4,(2*WIDTH/6)-ABST,HEIGTH/4);
        bstop.setText("Stop");
        bcont = new JButton();
        bcont.setBounds(4*ABST+((2*WIDTH/6)-ABST),2*ABST+2*HEIGTH/4,3*WIDTH/6,HEIGTH/4);
        bcont.setText("Continue");

        this.digitalClock = new DigitalClock(time);
        bstop.addActionListener(e -> digitalClock.setStopped(true));
        bcont.addActionListener(e -> digitalClock.setStopped(false));

        getContentPane().add(time);
        getContentPane().add(bstop);
        getContentPane().add(bcont);
        time.setVisible(true);
        bstop.setVisible(true);
        bcont.setVisible(true);
    }

    public static void main(String[] args){
        GUI g = new GUI();
        g.setVisible(true);
    }
}
