package net.tfobz.prodcon;

class ProducerThread extends Thread {
	private Lager pl;
	
	ProducerThread(Lager pl) {
		super("Produzent");
		this.pl = pl;
	}
	
	public void run() {
		while (pl.offen()) {
			pl.ergaenze((int) (5 + Math.random()*100));
			
			try {
				Thread.sleep((int) (1000 + Math.random()*3000));
			} catch(InterruptedException ie) {interrupt();}
		}
	}
}
