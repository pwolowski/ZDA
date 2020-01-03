package Sudoku;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JOptionPane;

public class PanelStartowy extends JFrame {
	
	JPanel nawigacjaStartowa;
	BoxLayout startowy;
	JButton nowaPlanszaLosowo;
	JButton nowaPlanszaZpliku;
	JButton wyjscie;
	Font font;
	Font fontMenu;
		
	public PanelStartowy() {
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.nawigacjaStartowa = new JPanel();
	this.startowy = new BoxLayout(nawigacjaStartowa, BoxLayout.Y_AXIS);
	this.font = new Font("Arial", Font.BOLD, 40);
	this.fontMenu = new Font("Arial", Font.BOLD, 20);
	
	String info = "Program jest elektroniczna wersja lamiglowki SUDOKU \n\n"
				+ " - Program jest zabezpieczony przed wprowadzaniem danych o nieodpowiednim formacie, badz lamiacych reguly poprawnego rozwiazania \n"
				+ " - Niewlasciwa/niezgodna z zasadami gry wartosc jest sygnalizowana podswietleniem pola na czerwono \n"
				+ " - Prawidlowe rozwiazanie planszy jest komunikowane poprzez zmiane koloru tla na zielony\n\n"	
				+ "Pawel Wolowski Styczen, 2020";
	
	JMenuBar pasekMenu = new JMenuBar();
	JMenu pomoc = new JMenu("Info");
	pomoc.setFont(fontMenu);
	JMenuItem oProgramie = new JMenuItem("O Programie");
	oProgramie.setFont(fontMenu);
	pomoc.add(oProgramie);
	pasekMenu.add(pomoc);	
	setJMenuBar(pasekMenu);
	
	//Tutaj sluchacz jako wyrazenie Lambda
	
	oProgramie.addActionListener(event -> {
		JOptionPane.showMessageDialog(null, info,"SUDOKU", JOptionPane.INFORMATION_MESSAGE);		
	});
	
	nowaPlanszaLosowo = new JButton("Generuj nowa plansze losowo");
	nowaPlanszaLosowo.setFont(font);
	nowaPlanszaLosowo.setMaximumSize(new Dimension(600, 60));

	nowaPlanszaZpliku = new JButton("Generuj nowa plansze z pliku");
	nowaPlanszaZpliku.setFont(font);
	nowaPlanszaZpliku.setMaximumSize(new Dimension(600, 60));

	wyjscie = new JButton("Wyjscie");
	wyjscie.setFont(font);
	wyjscie.setMaximumSize(new Dimension(600, 60));
	
	nawigacjaStartowa.setLayout(startowy);
	nawigacjaStartowa.add(nowaPlanszaLosowo);
	nawigacjaStartowa.add(Box.createRigidArea(new Dimension(0, 50)));
	nawigacjaStartowa.add(nowaPlanszaZpliku);
	nawigacjaStartowa.add(Box.createRigidArea(new Dimension(0, 50)));
	nawigacjaStartowa.add(wyjscie);
	nawigacjaStartowa.setBorder(new EmptyBorder(new Insets(150, 80, 150, 80)));

	this.setSize(800, 800);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	this.add(nawigacjaStartowa, BorderLayout.CENTER);

	this.setTitle("SUDOKU");

	this.setVisible(true);
	}

}
