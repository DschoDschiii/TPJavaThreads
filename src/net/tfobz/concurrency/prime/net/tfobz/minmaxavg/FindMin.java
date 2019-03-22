package net.tfobz.concurrency.prime.net.tfobz.minmaxavg;

import javax.swing.*;

public class FindMin extends Thread {

    private int[] arr;
    private JTextField tx;
    private JProgressBar pb;

    public FindMin(JTextField tx, JProgressBar pb, int[] arr){
        this.arr = arr;//new int[100000000];
        this.pb = pb;
        this.tx = tx;
    }


    @Override
    public synchronized void run() {
        int min = Integer.MAX_VALUE;
        int pbInt = 0;
        for(int i: arr){
            pb.setValue(++pbInt);
            if(i<min){
                tx.setText(String.valueOf(i));
                min=i;
            }
        }
    }
}
