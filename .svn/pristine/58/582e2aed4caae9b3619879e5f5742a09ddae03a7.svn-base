package fundamentos.datas.exemplos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ConverteData {
	public static void main(String[] args) {
		// Cria uma data armazenando num objeto do tipo Calendar
		Calendar data = new GregorianCalendar(2001, Calendar.OCTOBER, 10);
		
		// Converte o objeto Calendar em Date
		Date novaData = data.getTime();
		System.out.println(novaData);
		
		// Obtem a data do sistema e armazenando num objeto do tipo Date
		Date agora = new Date();
		System.out.println(agora);
		
		// Converte o objeto Date para Calendar
		Calendar minhaData = Calendar.getInstance();
		minhaData.setTime(agora);
		
		// Soma 30 dias e subtrai 2 anos da data
		minhaData.add(Calendar.DAY_OF_MONTH, 30);
		minhaData.add(Calendar.YEAR, -2);
		
		// Formata a data
		System.out.format("%1$td/%1$tm/%1$tY%n", minhaData);
		
		                                          // Segunda-feira, 30 de Janeiro de 2016
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
		System.out.println(sdf.format(minhaData.getTime()));
	}
}
