package fundamentos.resposta;

import javax.swing.JOptionPane;

public class Utilitarios {
	public static int leInteiro(Object ... param) {
		String temp = JOptionPane.showInputDialog(formataMensagem(param));
		return Integer.parseInt(temp);		
	}
	
	public static double leReal(Object ... param) {
		String temp = JOptionPane.showInputDialog(formataMensagem(param));
		return Double.parseDouble(temp);		
	}
	
	public static void escrevaL(Object ... param) {		
		JOptionPane.showMessageDialog(null, formataMensagem(param));
	}
	
	private static String formataMensagem(Object ... param) {
		String fmt = "";
		for (int i = 0; i < param.length; i++) {
			if(param[i] instanceof String) {
				fmt += "%s";
			} else if(param[i] instanceof Double) {
				fmt += "%,.2f";
			} else if(param[i] instanceof Integer) {
				fmt += "%d";
			}
		}
		return String.format(fmt, param);
	}
}
