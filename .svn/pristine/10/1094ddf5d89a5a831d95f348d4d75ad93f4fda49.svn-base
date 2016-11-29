package fundamentos.regex.exemplos;

import javax.swing.JOptionPane;

public class ValidaCodigo {
	public static void main(String[] args) {
		while (true) {

//		   023.234-23A
//          23.234-2ZX   		
//			23.234-2A
//			23.234-29
//			 2.234
			while(true) {  
				String txt = JOptionPane.showInputDialog("Informe o Código");
				if (txt.matches("[0-9]{1,3}\\.[0-9]{3}(-[0-9]([0-9]|[A-Z])([A-Z])?)?")) {
					JOptionPane.showMessageDialog(null, "OK");
				} else {
					JOptionPane.showMessageDialog(null, "- - - - E R R O - - - -");
				}
			}
		}
	}
}
