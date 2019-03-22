package net.tfobz.concurrency.prime.net.tfobz.minmaxavg;

import javax.swing.*;

public class FindAvg extends Thread {

    private int[] arr;
    private JTextField tx;
    private JProgressBar pb;

    public FindAvg(JTextField tx, JProgressBar pb, int[] arr){
        this.arr = arr;//new int[100000000];
        this.pb = pb;
        this.tx = tx;
    }


    @Override
    public synchronized void run() {
        double avg = 0;
        int pbInt = 0;
        for(int i: arr){
            pb.setValue(++pbInt);
            avg+=i;
            if(pbInt%1000==0) {
                tx.setText(String.valueOf((int)(avg / pbInt)));
            }
        }
    }
}
