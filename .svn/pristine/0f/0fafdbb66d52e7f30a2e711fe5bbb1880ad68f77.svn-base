package fundamentos.enumeracao;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fundamentos.gui.Util;

enum Estacoes {
	PRIMAVERA(22) {
		@Override
		public String toString() {
			return "Primavera";
		}
	},
	VERAO(28){
		@Override
		public String toString() {
			return "Verão";
		}
	},
	OUTONO(19) {
		@Override
		public String toString() {
			return "Outono";
		}
	},
	INVERNO(12) {
		@Override
		public String toString() {
			return "Inverno";
		}
	};
	
	private int temperatura;
	
	public int getTemperatura() {
		return temperatura;
	}
	
	private Estacoes(int temperatura) {
		this.temperatura = temperatura;
	}
}


public class Teste {
	public static void main(String[] args) {
		List<Estacoes> temporada = new ArrayList<>();

		JFrame tela = new JFrame("Temporada");
		
		JComboBox<Estacoes> combo = new JComboBox<>();
		combo.setModel(new DefaultComboBoxModel<>(Estacoes.values()));
		
		JPanel selecao = Util.criaPainel("Estações", combo);
		JPanel botoes = Util.criaPainel(
				Util.criaBotao("Inserir", KeyEvent.VK_I, (e) -> {
						Estacoes item = (Estacoes)combo.getSelectedItem();
						temporada.add(item);
						
						combo.setSelectedIndex(0);
					}),
				Util.criaBotao("Listar", KeyEvent.VK_L, (e) -> {
						String msg = "Estações Selecionadas\n\n";
						for (Estacoes item : temporada) {
							msg += item + " Temperatura esperada: " + item.getTemperatura() + "\n";
						}
						JOptionPane.showMessageDialog(tela, msg);
					}),
				Util.criaBotao("Sair", KeyEvent.VK_S, (e) -> {
						System.exit(0);
					})
				);
		
		tela.add(selecao, BorderLayout.CENTER);
		tela.add(botoes, BorderLayout.SOUTH);
		
		tela.pack();
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);
	}
}