package fundamentos.datas.exemplos;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class DiffData {
	public static void main(String[] args) {
		DateFormat fmt = DateFormat.getDateInstance();
		fmt.setLenient(false);
		
		String temp = JOptionPane.showInputDialog("Data!?");
		
		try {
			Date passado = fmt.parse(temp);

			Calendar agora = Calendar.getInstance();

			long miliPassado = passado.getTime();
			long miliAgora = agora.getTimeInMillis();

			long dif = miliAgora - miliPassado;
			long dias = dif / 1000 / 60 / 60 / 24;

			System.out.println("Dias: " + dias);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
	}
}
