package Sudoku;

// Skladowa czesci modelowej programu. W takiej strukturze beda przechowywane miedzy innymi dane o stanie gry (ilosc poprawnie zapisanych pol)

public class PlanszaSudoku {

	private PolePlanszySudoku[] pola = new PolePlanszySudoku[81];
	
	public PlanszaSudoku(boolean pusta) {
		
	}

	public PlanszaSudoku() {

		inicjalizacjaPol();

	}
	
	public PlanszaSudoku(String zPliku) {
		
		for (int i = 0; i < 81; i++) {
			pola[i] = new PolePlanszySudoku();//Tworze 81 pol
			this.pola[i].setNrWiersza(i/9);
			this.pola[i].setNrKolumny(i%9);
			this.pola[i].setNrKwadratu(3*(i/27) + ((i/3)%3));

		}
		
	}

	private void inicjalizacjaPol() {

		PolePlanszySudoku poleOperacyjne = new PolePlanszySudoku(); //Obiekt Pomocniczy

		for (int i = 0; i < 81; i++) {
			pola[i] = new PolePlanszySudoku();//Tworze 81 pol
		}

//		for (int i = 0; i < 18; i++) {
		for (int i = 0; i < 30; i++) {

			boolean kontynuuj = true;
			int moznaZapisac = 1;

			int wartoscPolaO = (int) (Math.random() * 9) + 1;
			poleOperacyjne.setWartoscPola(wartoscPolaO);
			do {
				
				moznaZapisac = 1;
				int poleOnr = (int) (Math.random() * 80) + 1;// zmienna pomocnicza
				int nrWierszaO = poleOnr/9;
				int nrKolumnyO = poleOnr%9;
				int nrKwadratuO = 3*(poleOnr/27) + ((poleOnr/3)%3);

				poleOperacyjne.setNrWiersza(nrWierszaO);
				poleOperacyjne.setNrKolumny(nrKolumnyO);
				poleOperacyjne.setNrKwadratu(nrKwadratuO);

				if (this.pola[poleOnr].getWartoscPola() == 0) { // sprawdzam, czy temu polu nie zostala juz przypisana
																// wartosc z
																// zakresu 1...9
					for (PolePlanszySudoku kolejnePole : pola) {
						if (kolejnePole.compareTo(poleOperacyjne) == 0) {
							moznaZapisac = 0;
							
							
						}																				
					}
					
					if (moznaZapisac == 1) {
						this.pola[poleOnr].setWartoscPola(wartoscPolaO);
						this.pola[poleOnr].setNrWiersza(nrWierszaO);
						this.pola[poleOnr].setNrKolumny(nrKolumnyO);
						this.pola[poleOnr].setNrKwadratu(nrKwadratuO);

						kontynuuj = false;
				}
							
				}
				
			} while ((kontynuuj == true) );
		}

	}

	public PolePlanszySudoku[] getPola() {
		return pola;
	}

	public void setPola(PolePlanszySudoku[] pola) {
		this.pola = pola;
	}

	public int pobierzWartoscPola(int i) {

		return this.pola[i].getWartoscPola();

	}

	public void zmienWartoscPola(int i, int j) {

		this.pola[i].setWartoscPola(j);

	}

}
