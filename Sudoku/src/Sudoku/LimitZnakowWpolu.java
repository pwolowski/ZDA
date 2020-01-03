package Sudoku;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitZnakowWpolu extends PlainDocument {
	private int max;
	LimitZnakowWpolu(int max){
		super();
		this.max= max;
	}
	 @Override
	 public void insertString(int offset, String tekst, AttributeSet atrybuty){
		 if(tekst == null) {
			 return;
		 }
		 if ((getLength() + tekst.length()) <= max) {
			 try {
			 super.insertString(offset, tekst, atrybuty);
			 }
			 catch(BadLocationException bl) {
				 
			 }
		 }
	 }

}
