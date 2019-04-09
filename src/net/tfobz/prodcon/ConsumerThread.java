package net.tfobz.prodcon;

class ConsumerThread extends Thread {
	private Lager pl;
	
	ConsumerThread(Lager pl) {
		super("Konsument");
		this.pl = pl;
	}
	
	public void run() {
		while (pl.offen()) {
			pl.liefere((int) (5 + Math.random()*100));
			
			try {
				Thread.sleep((int) (1000 + Math.random()*3000));
			} catch(InterruptedException ie) {interrupt();}
		}
	}
}
