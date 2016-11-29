package fundamentos.datas.respostas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

@SuppressWarnings("serial")
public class VerificaData extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblInforme;
	private JFormattedTextField tfData;
	private JButton btnVerificar;
	private JButton btnSair;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerificaData frame = new VerificaData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VerificaData() {
		setTitle("Verifica Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInforme = new JLabel("Informe uma Data");
		lblInforme.setBounds(23, 31, 122, 16);
		contentPane.add(lblInforme);

		// Constroi o verificador de data
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		df.setLenient(false);
		DateFormatter dtf = new DateFormatter(df);
		
		// Associa ao JFormattedTextField
		tfData = new JFormattedTextField(dtf);
		tfData.setBounds(157, 25, 134, 28);
		contentPane.add(tfData);
		tfData.setColumns(10);
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(this);
		btnVerificar.setBounds(23, 83, 117, 29);
		contentPane.add(btnVerificar);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(213, 83, 117, 29);
		contentPane.add(btnSair);
		
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		if(botao.equals(btnVerificar)) {
			Date data = (Date) tfData.getValue();

			if(data != null) {
				JOptionPane.showMessageDialog(null, "Data Válida");
				tfData.setValue(null);
				tfData.requestFocus();
			} else
				JOptionPane.showMessageDialog(null, "Data Inválida");
		} else {
			System.exit(0);
		}
	}
}
