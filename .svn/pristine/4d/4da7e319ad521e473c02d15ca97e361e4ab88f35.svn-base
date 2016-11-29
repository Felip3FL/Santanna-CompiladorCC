package fundamentos.regex.exemplos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class TestaMatch {
	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Informe seu Nome");

		while (!nome.equals("SAIR")) {
			
			if (nome.matches("^[Jj]oão.*")) {
				
				Matcher mtx = Pattern.compile("^[Jj]oão (.*) (.*)").matcher(nome);
				
				if (mtx.find()) {
					JOptionPane.showMessageDialog(null,
							"Bem Vindo João,\n seu sobrenome é [" + mtx.group(1) + "]\n[" + mtx.group(2) + "]");
				} else {
					JOptionPane.showMessageDialog(null, "Bem Vindo João");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Seu nome não é João");
			}
			
			nome = JOptionPane.showInputDialog("Informe seu Nome");
		}
	}
}
