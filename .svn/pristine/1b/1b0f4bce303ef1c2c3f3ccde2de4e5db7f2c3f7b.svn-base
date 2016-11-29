package fundamentos.math.exemplos;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;

public class Resumo {
	public static void main(String[] args) {
		System.out.println(Math.ceil(5.1));
		System.out.println(Math.floor(5.99));
		System.out.println(Math.rint(5.4));
		System.out.println(Math.round(5.4));
		System.out.println(Math.pow(3, 3));
		System.out.println(Math.PI);
		System.out.println("-------- Math.random() --------------------");
		for (int i = 0; i < 3; i++) {
			System.out.println(Math.random());
		}
		System.out.println("----------------------------");
		for (int i = 0; i < 3; i++) {
			System.out.println(Math.random()*10);
		}
		System.out.println("----------------------------");
		for (int i = 0; i < 3; i++) {
			System.out.println(Math.ceil(Math.random()*10));
		}
		System.out.println("----------------------------");
		for (int i = 0; i < 3; i++) {
			System.out.println((int)Math.ceil(Math.random()*10));
		}
		System.out.println("-------- Random --------------------");

		Random rdn = new Random();
		for (int i = 0; i < 3; i++) {
			System.out.println(rdn.nextInt());
		}
		System.out.println("----------------------------");
		
		String valor = "R$ 123.234,45";
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		fmt.setMaximumFractionDigits(2);
		
		try {
			Number num = fmt.parse(valor);
			double dinheiro = num.doubleValue();
			System.out.println(dinheiro);
			
			String valorFormatado = fmt.format(dinheiro);
			System.out.println(valorFormatado);
		} catch (ParseException e) {
			System.out.println("Nº inválido");
		}
	}
}
