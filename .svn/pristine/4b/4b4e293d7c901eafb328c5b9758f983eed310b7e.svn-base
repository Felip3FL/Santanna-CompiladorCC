package objeto.resposta.produtoCalendario;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.greef.ui.calendar.JCalendar;

import fundamentos.lib.SwUtil;

@SuppressWarnings("serial")
public class CadProduto extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblDescr;
	private JTextField tfDescr;
	private JPanel pnData;
	private JCalendar calendar;
	private JLabel lblTipo;
	private JComboBox<TipoDeProduto> comboBox;
	private JButton btnSalvar;
	private JButton btnListar;
	private JButton btnCdigo;
	private JButton btnSair;
	private JPanel pnBotoes;
	
	private List<Produto> cadastro = new ArrayList<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadProduto frame = new CadProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(11, 16, 37, 16);

		tfNome = new JTextField();
		tfNome.setBounds(66, 11, 317, 26);
		tfNome.setColumns(10);

		lblDescr = new JLabel("Descr.");
		lblDescr.setBounds(11, 60, 40, 16);

		tfDescr = new JTextField();
		tfDescr.setBounds(69, 55, 461, 26);
		tfDescr.setColumns(10);

		pnData = new JPanel();
		pnData.setBounds(11, 93, 203, 181);
		pnData.setBorder(new TitledBorder(null, "Data de Validade", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(226, 93, 28, 16);

		comboBox = new JComboBox<>();
		comboBox.setBounds(272, 93, 188, 27);
		comboBox.setModel(new DefaultComboBoxModel<>(TipoDeProduto.values()));
		contentPane.setLayout(null);

		calendar = new JCalendar();
		calendar.setBackground(Color.LIGHT_GRAY);
		calendar.setTooltipDatePattern("dd/MM/yyyy");
		calendar.setColor("Calendar.Today.Background", new Color(102, 204, 255));
		calendar.setTodayDate();
		pnData.add(calendar);
		
		contentPane.add(pnData);
		contentPane.add(lblTipo);
		contentPane.add(comboBox);
		contentPane.add(lblNome);
		contentPane.add(tfNome);
		contentPane.add(lblDescr);
		contentPane.add(tfDescr);

		pnBotoes = new JPanel();
		pnBotoes.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		pnBotoes.setBounds(258, 135, 248, 137);
		contentPane.add(pnBotoes);
		pnBotoes.setLayout(null);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		btnSalvar.setBounds(35, 34, 81, 29);
		pnBotoes.add(btnSalvar);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(129, 34, 81, 29);
		pnBotoes.add(btnListar);

		btnCdigo = new JButton("Código");
		btnCdigo.addActionListener(this);
		btnCdigo.setBounds(35, 68, 81, 29);
		pnBotoes.add(btnCdigo);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(129, 68, 81, 29);
		pnBotoes.add(btnSair);
		
		getRootPane().setDefaultButton(btnSalvar);
	}

	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		if(botao.equals(btnSalvar)) {
			Produto prod = new Produto();
			prod.setNome(tfNome.getText());
			prod.setDescricao(tfDescr.getText());
			
			// Obtendo a data do calendário na Janela
			Date validade = calendar.getSelectedDate();
			// Convertendo o tipo java.util.Date para java.time.LocalDate
			LocalDate data = validade.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			// Atribuindo a data em Produto
			prod.setValidade(data);
			
			// Obtem o tipo selecionado no comboBox e atribui ao Produto
			prod.setTipo(comboBox.getItemAt(comboBox.getSelectedIndex()));
			cadastro.add(prod);
			
			// Limpa todos os campos da tela
			SwUtil.limpa(this);
			
			// ajusta a data do calendário para hoje
			calendar.setTodayDate();

			tfNome.requestFocus();
		} else if(botao.equals(btnListar)) {
			String msg = "Cadastro de Produtos\n\n";
			for (Produto prod : cadastro) 
				msg += prod + "\n";
			JOptionPane.showMessageDialog(this, msg);
		} else if(botao.equals(btnCdigo)) {
			String msg = "Cadastro de Produtos\n\n";
			for (Produto prod : cadastro) 
				msg += "Nome: " + prod.getNome() + " Tipo: " + prod.getTipo() + " nº " + prod.getTipo().getCodigo() + "\n";
			JOptionPane.showMessageDialog(this, msg);
		} else {
			System.exit(0);
		}
	}
}
