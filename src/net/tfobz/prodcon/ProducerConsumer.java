package net.tfobz.prodcon;

class ProducerConsumer {
	
	public static void main(String[] args) {
		final Lager lager = new Lager(100);
		final ProducerThread pt = new ProducerThread(lager);
		final ConsumerThread kt = new ConsumerThread(lager);
		
		
		pt.start();
		kt.start();
	}
}
