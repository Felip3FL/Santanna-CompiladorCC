package fundamentos.datas.respostas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fundamentos.lib.SwUtil;

@SuppressWarnings("serial")
public class DiasDeVida extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblDataDeNascimento;
	private JFormattedTextField tfData;
	private JButton btnCalcular;
	private JButton btnSair;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiasDeVida frame = new DiasDeVida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DiasDeVida() {
		setTitle("Dias de Vida");
		setBounds(100, 100, 337, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(23, 30, 137, 16);
		contentPane.add(lblDataDeNascimento);
		
		tfData = SwUtil.criaMascara("##/##/####");
		tfData.setBounds(171, 24, 134, 28);
		contentPane.add(tfData);
		tfData.setColumns(10);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(23, 75, 117, 29);
		contentPane.add(btnCalcular);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(188, 75, 117, 29);
		contentPane.add(btnSair);
		
		setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		if(botao.equals(btnCalcular)) {
			try {
				DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
				df.setLenient(false);
				// Valida a data
				Date d = (Date) df.parse(tfData.getText());

				// Calcula o nº de dias entre a data informada e hoje
				long dias = (Calendar.getInstance().getTimeInMillis() - 
						            d.getTime()) / 1000 / 60 / 60 / 24;

				// Mostra o resultado
				JOptionPane.showMessageDialog(this, "Você já viveu " + dias + " dias", "R E S U L T A D O",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Data inválida", "E R R O", 
						JOptionPane.ERROR_MESSAGE);
			}
			tfData.setText("");
			tfData.requestFocus();
		} else {
			System.exit(0);
		}
	}
}
