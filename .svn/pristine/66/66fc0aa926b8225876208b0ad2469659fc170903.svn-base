package fundamentos.math.exemplos;

public class TesteAredondamento {
	public static void main(String[] args) {
		double i = Math.random();
		System.out.println(i);

		System.out.println("\n---------------------\n");
		
		for (int j = 0; j < 10; j++) {
			System.out.println(de5a15());
		}

		System.out.println("\n---------------------\n");
		
		
		System.out.println(Math.ceil(5.1));
		System.out.println(Math.floor(5.99));
		System.out.println(Math.rint(5.4));
		System.out.println(Math.round(5.4));
	}
	
	public static int de5a15() {
		int i;
		do {
			i = (int)Math.ceil(Math.random()*15);
		} while(i < 5);
		return i;
	}
}
