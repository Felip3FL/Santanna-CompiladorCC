package fundamentos.regex.exemplos;

import javax.swing.JOptionPane;

/*
  [99]9.999[-X[X]]
      1.389-A
     20.345-ZZ
    995.393
    934.564-A  
 */

public class TesteCodigo {
	public static void main(String[] args) {

		String codigo = "[0-9]{1,3}\\.[0-9]{3}(-[A-Z]{1,2})?";

		String txt = JOptionPane.showInputDialog("Informe o código do produto");

		while (!txt.equals("SAIR")) {

			if (txt.matches(codigo)) {
				JOptionPane.showMessageDialog(null, "Código Válido");
			} else {
				JOptionPane.showMessageDialog(null, "Código Inválido");
			}
			
			txt = JOptionPane.showInputDialog("Informe o código do produto");
		}
	}
}
