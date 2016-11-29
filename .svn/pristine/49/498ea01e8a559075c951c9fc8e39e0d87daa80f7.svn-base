package objeto.exemplos.figuras;

import java.awt.Color;

public abstract class Figura {
	public abstract void exibir();

	public void imprimir() {
	}
}

class TrianguloEquilatero {
	private Triangulo obj  = new Triangulo();

	public Triangulo getObj() {
		return obj;
	}

	public void setObj(Triangulo obj) {
		this.obj = obj;
	}

	
}

class TesteFigura {
	public static void main(String[] args) {
		Figura[] listaDeFiguras = new Figura[2];

		listaDeFiguras[0] = new Triangulo();
		listaDeFiguras[1] = new Quadrado();

		for (int i = 0; i < listaDeFiguras.length; i++) {
			Figura obj = listaDeFiguras[i];
			if (obj instanceof Triangulo) {
				Triangulo tri = (Triangulo) obj;
				tri.pinta(Color.white);
			}
			obj.exibir();
			obj.imprimir();
			obj.toString();
		}
	}
}