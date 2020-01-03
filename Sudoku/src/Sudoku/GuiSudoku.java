package Sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;


import javax.swing.border.EmptyBorder;

import javax.swing.*;

public class GuiSudoku extends JWindow {

	private PlanszaSudoku Plansza;
	private PanelStartowy panelStartowy;
	private PanelSudoku panelSudoku;
	private JPanel ukladSudoku;
	
	private Font font;
	
	ArrayList<JTextField> polaTekstowe = new ArrayList<>();

	public GuiSudoku() {

		font = new Font("Arial", Font.BOLD, 40);

		this.panelStartowy = new PanelStartowy();
		this.panelSudoku = new PanelSudoku();
		this.ukladSudoku = new JPanel();
		
		this.panelStartowy.nowaPlanszaLosowo.addActionListener(losowoListener);
		this.panelStartowy.nowaPlanszaZpliku.addActionListener(zPlikuListener);
		this.panelStartowy.wyjscie.addActionListener(wyjscieListener);
		this.panelSudoku.zakonczGre.addActionListener(wyjscieListener);
		this.panelSudoku.noweRozdanie.addActionListener(zacznijOdNowaListener);	

	}
	
// Ponizej grupa sluchaczy jako klasy wewnetrzne
	
		ActionListener losowoListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Plansza = new PlanszaSudoku();
				dodajPolaLosowo(Plansza);
				panelStartowy.setVisible(false);
				panelSudoku.setVisible(true);
			}
		};

		ActionListener zPlikuListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JFileChooser fileChooser = new JFileChooser();
				String zPliku = null;
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					Plansza = new PlanszaSudoku(zPliku);
					try {
						int i = 0;
						int[] tablicaZpliku = new int[81];
						Scanner scanner = new Scanner(selectedFile);
						do {
							String wiersz = scanner.nextLine();
							Plansza.zmienWartoscPola(i, Integer.parseInt(wiersz));
							i++;
						} while (scanner.hasNextLine());
						dodajPolaZpliku(Plansza);
						panelStartowy.setVisible(false);
						panelSudoku.setVisible(true);
						System.out.println(i);
						System.out.println(tablicaZpliku.length);
						scanner.close();

					} catch (IOException e) {
					}
					
//					System.out.println(selectedFile.getName());

				}
			}
		};
		
		ActionListener wyjscieListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		};
		
		ActionListener zacznijOdNowaListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				panelStartowy.setVisible(true);
				panelSudoku.setVisible(false);
				for (int i = 0; i < 81; i++) {
				Plansza.getPola()[i].setNrWiersza(i/9);
				Plansza.getPola()[i].setNrKolumny(i%9);
				Plansza.getPola()[i].setNrKwadratu(3*(i/27) + ((i/3)%3));
				Plansza.getPola()[i].setWartoscPola(0);				
				}
				
				ukladSudoku.removeAll();
				
										
			}
		};

	private void dodajPolaLosowo(PlanszaSudoku PlanszaS) {

		ukladSudoku.setName("ukladSudoku");
		ukladSudoku.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
		GridLayout kwadratySudoku = new GridLayout(3, 3);
		kwadratySudoku.setHgap(10);
		kwadratySudoku.setVgap(10);
		ukladSudoku.setLayout(kwadratySudoku);
		panelSudoku.add(ukladSudoku, BorderLayout.CENTER);

		for (int i = 0; i < 9; i++) {
			JPanel jedenKwadratSudoku = new JPanel();
			GridLayout polaJednegoKwadratu = new GridLayout(3, 3);
			jedenKwadratSudoku.setLayout(polaJednegoKwadratu);

			for (int j = 0; j < 9; j++) {
				JTextField tF = new JTextField();
				tF.setDocument(new LimitZnakowWpolu(1));

				tF.setFont(font);
				tF.setHorizontalAlignment(SwingConstants.CENTER);
				tF.setName(String.valueOf(18 * (i / 3) + (3 * i) + 9 * (j / 3) + (j % 3)));
				polaTekstowe.add(tF);
				if (PlanszaS.pobierzWartoscPola(18 * (i / 3) + (3 * i) + 9 * (j / 3) + (j % 3)) != 0) {
					tF.setText(String.valueOf(PlanszaS.pobierzWartoscPola(18 * (i / 3) + (3 * i) + (9 * (j / 3)) + (j % 3))));
					tF.setEnabled(false);															
				}
				tF.getDocument().addDocumentListener(new SprawdzPole(tF, Plansza.getPola(), polaTekstowe));	
				jedenKwadratSudoku.add(tF);
			}
			ukladSudoku.add(jedenKwadratSudoku);
		}
	}

	private void dodajPolaZpliku(PlanszaSudoku PlanszaS) {

		ukladSudoku.setName("ukladSudoku");
		ukladSudoku.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
		GridLayout kwadratySudoku = new GridLayout(3, 3);
		kwadratySudoku.setHgap(10);
		kwadratySudoku.setVgap(10);
		ukladSudoku.setLayout(kwadratySudoku);
		panelSudoku.add(ukladSudoku, BorderLayout.CENTER);

		for (int i = 0; i < 9; i++) {
			JPanel jedenKwadratSudoku = new JPanel();
			GridLayout polaJednegoKwadratu = new GridLayout(3, 3);
			jedenKwadratSudoku.setLayout(polaJednegoKwadratu);

			for (int j = 0; j < 9; j++) {
				JTextField tF = new JTextField();
				tF.setDocument(new LimitZnakowWpolu(1));

				tF.setFont(font);
				tF.setHorizontalAlignment(SwingConstants.CENTER);
				tF.setName(String.valueOf(18 * (i / 3) + (3 * i) + 9 * (j / 3) + (j % 3)));
				polaTekstowe.add(tF);
				if (PlanszaS.pobierzWartoscPola(18 * (i / 3) + (3 * i) + 9 * (j / 3) + (j % 3)) != 0) {
					tF.setText(String.valueOf(PlanszaS.pobierzWartoscPola(18 * (i / 3) + (3 * i) + (9 * (j / 3)) + (j % 3))));
					tF.setEnabled(false);
				}
				tF.getDocument().addDocumentListener(new SprawdzPole(tF, Plansza.getPola(), polaTekstowe));
				jedenKwadratSudoku.add(tF);
			}
			ukladSudoku.add(jedenKwadratSudoku);
		}
	}

}
