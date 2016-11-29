package fundamentos.resposta;

import static fundamentos.resposta.Utilitarios.escrevaL;
import static fundamentos.resposta.Utilitarios.leInteiro;
import static fundamentos.resposta.Utilitarios.leReal;

public class Ex02a {
	public static void main(String[] args) {
		String msg = "Cálculo Salarial\n\n";
		
		double salHora = leReal("Informe o Salário Hora");
		msg += String.format("Sal. Hora: R$ %,.2f\n", salHora);
		
		int horas = leInteiro("Informe o nº de horas trabalhadas");
		msg += String.format("Horas trab.: %d\n", horas);

		int dep = leInteiro("Informe o nº de dependentes");
		msg += String.format("Nº de Dep: %d\n", dep);
		
		double salBruto = horas * salHora + 50 * dep;
		msg += String.format("Sal. Bruto: R$ %,.2f\n", salBruto);

		double inss;
		if(salBruto <= 1000) {
			inss = salBruto * 0.085;
		} else {
			inss = salBruto * 0.09;
		}
		msg += String.format("Desc INSS: R$ %,.2f\n", inss);

		double ir;
		if(salBruto <= 500) {
			ir = 0;
		} else if(salBruto <= 1000) {
			ir = salBruto * 0.05;
		} else {
			ir = salBruto * 0.07;
		}
		msg += String.format("Desc. IR: R$ %,.2f\n", ir);

		double salLiq = salBruto - inss - ir;
		msg += String.format("Sal. Liq: R$ %,.2f\n", salLiq);

		escrevaL(msg);
	}
}
