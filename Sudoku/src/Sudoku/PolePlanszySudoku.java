package Sudoku;

// Podstawowa struktura czesci modelowej programu

public class PolePlanszySudoku implements Comparable<PolePlanszySudoku> {
	
	private int wartoscPola;
	private int nrWiersza;
	private int nrKolumny;
	private int nrKwadratu;

	public PolePlanszySudoku() {

	}

//metoda compare ponizej bedzie umozliwiala sprawdzanie, czy pola na planszy nie zawieraja dwoch takich samych cyfr w tym samym wierszu/kolumnie/kwadracie czastkowym (9x9) 	
	
	public int compareTo(PolePlanszySudoku innePole) {

		int wartosc = Double.compare(this.wartoscPola, innePole.wartoscPola);
		int wiersz = Double.compare(this.nrWiersza, innePole.nrWiersza);
		int kolumna = Double.compare(this.nrKolumny, innePole.nrKolumny);
		int kwadrat = Double.compare(this.nrKwadratu, innePole.nrKwadratu);


		if (((wartosc == 0) && (wiersz == 0)) || ((wartosc == 0) && (kolumna == 0)) || ((wartosc == 0) && (kwadrat == 0)) ) {
			return 0;
		} 
		else if ((kolumna == 0) && (wiersz == 0)) {
			return 1;
		}
		
		else {
			return 1;
		}

	}
	

	public int getNrKwadratu() {
		return nrKwadratu;
	}

	public void setNrKwadratu(int nrKwadratu) {
		this.nrKwadratu = nrKwadratu;
	}

	public int getWartoscPola() {
		return wartoscPola;
	}

	public void setWartoscPola(int wartoscPola) {
		this.wartoscPola = wartoscPola;
	}

	public int getNrWiersza() {
		return nrWiersza;
	}

	public void setNrWiersza(int nrWiersza) {
		this.nrWiersza = nrWiersza;
	}

	public int getNrKolumny() {
		return nrKolumny;
	}

	public void setNrKolumny(int nrKolumny) {
		this.nrKolumny = nrKolumny;
	}

}
