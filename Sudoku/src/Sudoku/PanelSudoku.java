package Sudoku;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelSudoku extends JFrame {

	JPanel nawigacjaSudoku;
	JButton zakonczGre;
	JButton noweRozdanie;
	Font font;

	public PanelSudoku() {

		font = new Font("Arial", Font.BOLD, 40);

		this.zakonczGre = new JButton("Zakoncz");
		this.zakonczGre.setFont(font);
		this.zakonczGre.setMaximumSize(new Dimension(180, 100));

		this.noweRozdanie = new JButton("Zacznij od nowa");
		this.noweRozdanie.setFont(font);
		this.noweRozdanie.setMaximumSize(new Dimension(180, 100));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(800, 800);

		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("SUDOKU");

		this.nawigacjaSudoku = new JPanel();
		nawigacjaSudoku.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
		GridLayout podPlansza = new GridLayout(1, 2);
		podPlansza.setHgap(10);
		nawigacjaSudoku.setLayout(podPlansza);
		nawigacjaSudoku.add(noweRozdanie);
		nawigacjaSudoku.add(zakonczGre);

		this.add(nawigacjaSudoku, BorderLayout.SOUTH);

	}

}
