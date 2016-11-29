package fundamentos.exemplos;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;

import javax.swing.JOptionPane;

public class ExemploConversao4 {
	public static void main(String[] args) {		
		// Leitura de um nº inteiro
		int garrafas = leInteiro("Informe o nº de garafas");
		
		// Leitura do preço de cada garrafa
		double preco = leReal("Informe o preço do Mé!");
		
		// Calculando o prejuizo;
		double total = preco * garrafas;
		
		// Apresentar o valor Final
		JOptionPane.showMessageDialog(null, String.format("O valor Total é de R$ %,.2f", total) );
	}

	public static int leInteiro(String msg) {
		int num = 0;
		do {
			try {
				String temp = JOptionPane.showInputDialog(msg);
				num = Integer.parseInt(temp);
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Nº inválido", "== ERRO ==", 
						JOptionPane.ERROR_MESSAGE);
			}
		} while(num == 0);
		
		return num;
	}

	public static double leReal(String msg) {
		// Configurando o Formatador de númeors
		NumberFormat fmt = NumberFormat.getNumberInstance();
		fmt.setMaximumFractionDigits(2);
		fmt.setMinimumFractionDigits(2);	

		ParsePosition pos = new ParsePosition(0);
		
		double num = 0;		
		do {
			try {
				String temp = JOptionPane.showInputDialog(msg);
				num = fmt.parse(temp, pos).doubleValue();
				if(temp.length() != pos.getIndex()) {
					num = 0;
					throw new ParseException("Valor inválido", pos.getIndex());
				}
			} catch(ParseException ex) {
				JOptionPane.showMessageDialog(null, "Valor inválido", "== ERRO ==", 
						JOptionPane.ERROR_MESSAGE);
			}
		} while(num == 0);
		return num;
	}
}
