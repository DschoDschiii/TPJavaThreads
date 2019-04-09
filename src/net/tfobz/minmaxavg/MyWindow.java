package net.tfobz.minmaxavg;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    private boolean untouched = true;
    private Thread thmin;
    private Thread thmax;
    private Thread thavg;
    private int[] arr;
    private JButton btn;
    private JLabel lmin;
    private JLabel lmax;
    private JLabel lavg;
    private JTextField tmin;
    private JTextField tmax;
    private JTextField tavg;
    private JProgressBar pmin;
    private JProgressBar pmax;
    private JProgressBar pavg;
    private final int WIDTH = 700;
    private final int HEIGHT = 400;
    private final int ABSTAND = 5;
    private final int HOEHE = 20;
    private final int MIN = 0;
    private final int MAX = 10000000;

    public MyWindow(String title){
        super(title);
        initGUI();
    }

    private int[] generateNums() {
        int[] ret = new int[MAX];
        for(int i=0;i< ret.length; i++){
            ret[i] = (int)(Math.random()*Integer.MAX_VALUE);
        }
        return ret;
    }

    private void initGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        this.setSize(new Dimension(WIDTH, HEIGHT));

        btn = initBtn("Start searching", WIDTH /3, ABSTAND, WIDTH /3, HOEHE);
        lmin = initLabel(tmin,"Min: ", ABSTAND, 2* ABSTAND + HOEHE, WIDTH /15, HOEHE);
        lmax = initLabel(tmax,"Max: ", ABSTAND, 3* ABSTAND +2* HOEHE, WIDTH /15, HOEHE);
        lavg = initLabel(tavg,"Avg: ", ABSTAND, 4* ABSTAND +3* HOEHE, WIDTH /15, HOEHE);
        tmin = initTextfield(2* ABSTAND + WIDTH /15, 2* ABSTAND + HOEHE, 4* WIDTH /15, HOEHE);
        tmax = initTextfield(2* ABSTAND + WIDTH /15, 3* ABSTAND +2* HOEHE, 4* WIDTH /15, HOEHE);
        tavg = initTextfield(2* ABSTAND + WIDTH /15, 4* ABSTAND +3* HOEHE, 4* WIDTH /15, HOEHE);
        pmin = initProgressbar(3* ABSTAND +5* WIDTH /15, 2* ABSTAND + HOEHE,9* WIDTH /15, HOEHE);
        pmax = initProgressbar(3* ABSTAND +5* WIDTH /15, 3* ABSTAND +2* HOEHE,9* WIDTH /15, HOEHE);
        pavg = initProgressbar(3* ABSTAND +5* WIDTH /15, 4* ABSTAND +3* HOEHE,9* WIDTH /15, HOEHE);


        Container c = this.getContentPane();
        c.add(btn);
        c.add(lmin);
        c.add(lmax);
        c.add(lavg);
        c.add(tmin);
        c.add(tmax);
        c.add(tavg);
        c.add(pmin);
        c.add(pmax);
        c.add(pavg);

        this.setVisible(true);
    }

    private JProgressBar initProgressbar(int x,int y,int w,int h) {
        JProgressBar ret = new JProgressBar(MIN,MAX);
        ret.setBounds(x,y,w,h);
        ret.setStringPainted(true);
        ret.setVisible(true);
        return ret;
    }

    private JTextField initTextfield(int x, int y, int w, int h) {
        JTextField ret = new JTextField();
        ret.setBounds(x,y,w,h);
        ret.setVisible(true);
        return ret;
    }

    private JLabel initLabel(JTextField t, String name, int x, int y, int width, int height) {
        JLabel ret = new JLabel(name);
        ret.setBounds(x,y,width,height);
        ret.setLabelFor(t);
        ret.setDisplayedMnemonic(name.charAt(1));
        ret.setVisible(true);
        return ret;
    }

    private JButton initBtn(String name, int x, int y, int width, int height) {
        btn = new JButton(name);
        btn.setBounds(x,y,width,height);
        btn.setVisible(true);
        btn.addActionListener(l -> {
            if(untouched || thmin != null && thmax != null && thavg != null){
                if(untouched || !thmin.isAlive() && !thmax.isAlive() && !thavg.isAlive()){
                    thmin = null;
                    thmax = null;
                    thavg = null;
                    arr=generateNums();
                    thmin = new FindMin(tmin,pmin,arr);
                    thmin.start();
                    thmax = new FindMax(tmax,pmax,arr);
                    thmax.start();
                    thavg = new FindAvg(tavg,pavg,arr);
                    thavg.start();
                    untouched = false;
                }
            }
        });
        return btn;
    }

    public static void main(String[] args){
        MyWindow w = new MyWindow("MinMaxAvgSearch");
    }
}
