package objeto.resposta.produtoCalendario;

import java.util.NoSuchElementException;

public enum TipoDeProduto {
	DE_CONSTRUCAO(10) {
		@Override
		public String toString() {
			return "de Construção";
		}
	},
	FACA_VOCE_MESMO(15) {
		@Override
		public String toString() {
			return "faça Você mesmo";
		}
	},
	DE_PINTURA(20) {
		@Override
		public String toString() {
			return "de Pintura";
		}
	},
	PARA_CARROS(25) {
		@Override
		public String toString() {
			return "para Carros";
		}
	};
	
	private int codigo;
	
	private TipoDeProduto(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public TipoDeProduto valueOf(int codigo) {
		switch (codigo) {
		case 10:
			return TipoDeProduto.DE_CONSTRUCAO;
		case 15:
			return TipoDeProduto.FACA_VOCE_MESMO;
		case 20:
			return TipoDeProduto.DE_PINTURA;
		case 25:
			return TipoDeProduto.PARA_CARROS;
		default:
			throw new NoSuchElementException("Tipo de Produto Inválido");
		}
	}
}
