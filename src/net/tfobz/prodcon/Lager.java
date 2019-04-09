package net.tfobz.prodcon;

class Lager {
	private static final int MANZ = 20;
	private int bilanz;
	private int anz;

	
	Lager(int start) {
		bilanz = start;
		System.out.println("Das Lager ist offen (Bestand = " + bilanz + ")\n");
	}
	
	boolean offen() {
		if (anz < MANZ)
			return true;
		else {
			System.out.println("\nLieber " + Thread.currentThread().getName() + ", es ist Feierabend!");
			return false;
		}
	}
	
	private String formZeit() {
		return java.text.DateFormat.getTimeInstance().format(new java.util.Date());
	}
	
	void ergaenze(int add) {
		bilanz += add;
		anz++;
		System.out.println("Nr. " + anz + ":\t" + Thread.currentThread().getName() + " ergänzt\t" + add + "\tum " + formZeit() + " Uhr. Stand: " + bilanz);
	}
	
	void liefere(int sub) {
		bilanz -= sub;
		anz++;
		System.out.println("Nr. " + anz + ":\t" + Thread.currentThread().getName() + " entnimmt\t" + sub + "\tum " + formZeit() + " Uhr. Stand: " + bilanz);
	}
}