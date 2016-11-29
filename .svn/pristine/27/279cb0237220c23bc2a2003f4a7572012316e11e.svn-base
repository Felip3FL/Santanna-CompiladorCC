package fundamentos.math.exemplos;

import java.math.BigInteger;

public class BigFatorial {
	public static void main(String[] args) {
		String num = args[0];
		
		BigInteger fat = new BigInteger(num);
		if(fat.compareTo(BigInteger.ONE) <= 0) {
			fat = BigInteger.ONE;
		} else {
			BigInteger i = fat.subtract(BigInteger.ONE);
			while(i.compareTo(BigInteger.ONE) > 0) {
				fat = fat.multiply(i);
				i = i.subtract(BigInteger.ONE);
			}
		}
		System.out.println(fat.toString());
	}
}
