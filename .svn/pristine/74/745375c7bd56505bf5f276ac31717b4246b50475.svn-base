package fundamentos.datas.exemplos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

public class DiffData8 {
	public static void main(String[] args) {		
		String temp = JOptionPane.showInputDialog("Data!?");
		
		try {
			LocalDate passado = LocalDate.parse(temp, getDateTimeFormatter());

			LocalDate agora = LocalDate.now();

			long dias = ChronoUnit.DAYS.between(passado, agora);

			System.out.println("Dias: " + dias);
		} catch (DateTimeParseException ex) {
			ex.printStackTrace();
		}
	}
	
	public static DateTimeFormatter getDateTimeFormatter() {
		return  new DateTimeFormatterBuilder()
		.appendValue(ChronoField.DAY_OF_MONTH, 2).appendLiteral('/')
		.appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('/')
		.appendValue(ChronoField.YEAR, 4)
		.toFormatter()
		.withResolverStyle(ResolverStyle.STRICT);
	}
}
