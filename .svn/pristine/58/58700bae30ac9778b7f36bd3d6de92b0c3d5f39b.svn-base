package fundamentos.datas.exemplos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class DatasDoMes {
	public static void main(String[] args) {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		fmt.setLenient(false);

		String texto = JOptionPane.showInputDialog("Informe a Data");
		try {
			Date data = fmt.parse(texto);

			System.out.println(fmt.format(data));

			fmt.applyPattern("EEEE, 'dia' d 'de' MMMM 'de' yyyy");
			System.out.println(fmt.format(data));

			fmt.applyPattern("EEE, 'dia' d 'de' MMM 'de' yyy");
			System.out.println(fmt.format(data));

			fmt.applyPattern("EE, 'dia' d 'de' MM 'de' yy");
			System.out.println(fmt.format(data));

			fmt.applyPattern("E, 'dia' d 'de' M 'de' y");
			System.out.println(fmt.format(data));
			
		} catch (ParseException ex) {
			System.out.println("Data Inválida");
		}
	}
}
