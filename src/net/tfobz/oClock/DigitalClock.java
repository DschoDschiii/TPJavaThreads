package net.tfobz.oClock;

import javax.swing.*;
import java.util.Date;

public class DigitalClock extends Thread {
    private JLabel outputLabel = null;
    private boolean stopped = false;

    public DigitalClock(JLabel outputLabel) {
        this.outputLabel = outputLabel;
        this.start();
    }

    public boolean getStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public void run() {
        while (true) {
            if (!this.stopped) {
                outputLabel.setText(
                        new Date().toString().substring(11, 19));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
            }
        }
    }
}

