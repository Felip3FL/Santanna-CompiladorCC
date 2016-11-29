package fundamentos.resposta;

/*
 Analise a classe Excecao para identificar possíveis exceções
 originadas durante a sua execução.

 Uma vez identificado, modifique o programa para solucionar o(s) problema(s).
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Excecao extends JPanel {
	private JTextField tfNum1 = new JTextField(3);
	private JTextField tfNum2 = new JTextField(3);
	private JButton btOk = new JButton("Ok");
	private JButton btFechar = new JButton("Fechar");

	public Excecao() {
		setLayout(new GridLayout(3, 1));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JPanel titulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titulo.add(new JLabel("Informe dois (2) números"));
		add(titulo);

		JPanel numeros = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		numeros.add(new Label("Primeiro Número"));
		numeros.add(tfNum1);
		numeros.add(Box.createHorizontalStrut(10));
		numeros.add(new Label("Segundo Número"));
		numeros.add(tfNum2);
		add(numeros);

		JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		btOk.setToolTipText("Processa o cálculo");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					int num1 = Integer.parseInt(tfNum1.getText());
					int num2 = Integer.parseInt(tfNum2.getText());

					double resultado = num1 / num2;

					JOptionPane.showMessageDialog(getParent(),
							String.format("O resultado da divisão de %d por %d é %,.2f", num1, num2, resultado),
							"Resultado", JOptionPane.INFORMATION_MESSAGE);

					tfNum1.setText("");
					tfNum2.setText("");
					tfNum1.requestFocus();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(getParent(),"Dados Inválidos");
				} catch (ArithmeticException ex) {
					JOptionPane.showMessageDialog(getParent(), "O último nº NÃO pode ser ZERO, ANIMAL");
				}
			}
		});
		botoes.add(btOk);
		btFechar.setToolTipText("Finaliza o programa");
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.exit(0);
			}
		});
		botoes.add(btFechar);
		add(botoes);
	}

	public static void main(String[] args) {
		JFrame tela = new JFrame("Processa Números");
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.getContentPane().add(new Excecao(), "Center");
		tela.pack();
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setVisible(true);
	}
}
