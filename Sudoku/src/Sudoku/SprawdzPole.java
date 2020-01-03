package Sudoku;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// Sluchacz jako klasa zewnetrzna

public class SprawdzPole implements DocumentListener {

	JTextField tF;
	PolePlanszySudoku[] pS;
	ArrayList<JTextField> pTekstowe;

	public SprawdzPole(JTextField tF, PolePlanszySudoku[] pS, ArrayList<JTextField> pTekstowe) {
		this.tF = tF;
		this.pS = pS;
		this.pTekstowe = pTekstowe;
	}

	public void insertUpdate(DocumentEvent e) {

		int zapiszWtablicy = 1;

		PolePlanszySudoku poleBiezace = new PolePlanszySudoku();

		try {
			poleBiezace.setWartoscPola(Integer.parseInt(tF.getText()));
			poleBiezace.setNrWiersza(Integer.parseInt(tF.getName()) / 9);
			poleBiezace.setNrKolumny(Integer.parseInt(tF.getName()) % 9);
			poleBiezace.setNrKwadratu(
					3 * (Integer.parseInt(tF.getName()) / 27) + ((Integer.parseInt(tF.getName()) / 3) % 3));

			System.out.println(tF.getText());
			int zapisane = 0;
			for (PolePlanszySudoku kolejnePole : pS) {

				if (((kolejnePole.compareTo(poleBiezace) == 0))) {
					tF.setBackground(Color.RED);
//				 System.out.println(" wartosc: " + poleBiezace.getWartoscPola() + " wiersz: " + poleBiezace.getNrWiersza() + " kolumna: " + poleBiezace.getNrKolumny() + " kwadrat: " +poleBiezace.getNrKwadratu() );
					zapiszWtablicy = 0;
				}

			}
			if (zapiszWtablicy == 1) {
				pS[Integer.parseInt(tF.getName())].setWartoscPola(poleBiezace.getWartoscPola());
				for (PolePlanszySudoku kolejnePole : pS) {
					if (((kolejnePole.getWartoscPola() > 0))) {
						zapisane++;
					}
				}

//			System.out.println("zapisane: " + zapisane + "zapisz w tablicy: "+ zapiszWtablicy);
				if (zapisane > 80) {
					for (int i = 0; i < pTekstowe.size(); i++) {
						pTekstowe.get(i).setEnabled(false);
						pTekstowe.get(i).setBackground(new Color(50, 205, 50));
//				System.out.println("Congrats");
					}
				}
			}
		} catch (Exception ex) {
			tF.setBackground(Color.RED);
			ex.printStackTrace();
		}
	}

	public void removeUpdate(DocumentEvent e) {
		tF.setBackground(Color.WHITE);
		pS[Integer.parseInt(tF.getName())].setWartoscPola(0);

	}

	public void changedUpdate(DocumentEvent e) {

	}

}
