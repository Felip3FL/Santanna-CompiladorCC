package fundamentos.gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Tela2 extends JFrame implements ActionListener {
	private JTextField tfNome = new JTextField(20);
	private JTextField tfEmail = new JTextField(20);
	private JButton btOk = new JButton("Ok");
	private JButton btSair = new JButton("Sair");

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Tela2 tela = new Tela2();
			tela.setVisible(true);
		});
	}

	public Tela2() {
		setLayout(new GridLayout(3, 1));

		JPanel pnCampos = new JPanel();
		pnCampos.add(new JLabel("Nome"));
		pnCampos.add(tfNome);
		add(pnCampos);

		JPanel pnCampos2 = new JPanel();
		pnCampos2.add(new JLabel("E-Mail"));
		pnCampos2.add(tfEmail);
		add(pnCampos2);

		JPanel pnBotoes = new JPanel();

		getRootPane().setDefaultButton(btOk);
		btOk.addActionListener(this);

		pnBotoes.add(btOk);

		btSair.addActionListener(this);
		pnBotoes.add(btSair);
		add(pnBotoes);

		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();

		if (botao.equals(btOk)) {
			String nome = tfNome.getText();
			String email = tfEmail.getText();

			JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nE-Mail: " + email);

			tfNome.setText("");
			tfEmail.setText("");
			tfNome.requestFocus();
		} else {
			System.exit(0);
		}
	}
}
