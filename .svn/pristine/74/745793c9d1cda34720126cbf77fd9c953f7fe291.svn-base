package fundamentos.math.exemplos;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MathTestAredondamento {
	public static void main(String[] args) {
		
		BigDecimal b1 = new BigDecimal("1");
		BigDecimal b2 = b1.divide(new BigDecimal("3"), 
				new MathContext(16, RoundingMode.HALF_UP));
		System.out.println(b2);
		BigDecimal b3 = b2.multiply(new BigDecimal("3"),
				new MathContext(2, RoundingMode.HALF_UP));
		System.out.println(b3);
		
		double d1 = 1d;
		double d2 = d1 / 3d;
		System.out.println(d2);
		double d3 = d2 * 3d;
		System.out.println(d3);

		System.out.println("-------------------------------");
		
		BigDecimal bx1 = new BigDecimal("0.9");
		BigDecimal bx2 = bx1.subtract(new BigDecimal("0.8"));
		System.out.println(bx2);
		
		double dx1 = 0.9;
		double dx1_2 = 0.8;
		double dx2 = dx1 - dx1_2;
		System.out.println(dx2);

	}
}
