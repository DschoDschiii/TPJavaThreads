package net.tfobz.concurrency.prime.net.tfobz.minmaxavg;

import javax.swing.*;

public class FindMax extends Thread {

    private int[] arr;
    private JTextField tx;
    private JProgressBar pb;

    public FindMax(JTextField tx, JProgressBar pb, int[] arr){
        this.arr = arr;//new int[100000000];
        this.pb = pb;
        this.tx = tx;
    }


    @Override
    public synchronized void run() {
        int max = 0;
        int pbInt = 0;
        for(int i: arr){
            pb.setValue(++pbInt);
            if(i>max){
                tx.setText(String.valueOf(i));
                max=i;
            }
        }
    }
}
