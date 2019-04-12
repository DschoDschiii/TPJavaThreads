package net.tfobz.concurrency.prime;

public class ThreadPrimeFactorTool extends PrimeFactorTool implements Runnable{

    private int num;

    public ThreadPrimeFactorTool(){
        //Do nothing
    }

    public ThreadPrimeFactorTool(int i){
        num = i;
        new Thread(this, "PrimeThread for "+i).start();
    }

    @Override
    public void run() {
        super.printPrimeFactors(num);
    }

    @Override
    public void printPrimeFactors(int num) {
        new ThreadPrimeFactorTool(num);
    }
}
