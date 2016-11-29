package fundamentos.regex.exemplos.sw04Regex.model;

import java.text.NumberFormat;

public class Produto {
	private String codigo;
	private String descr;
	private double valor;

	private static NumberFormat numberFormat = NumberFormat.getNumberInstance();
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo + " descr: " + descr + " valor: " + numberFormat.format(valor);
	}

}
