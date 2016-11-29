package fundamentos.lib;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public abstract class SwUtil {
	public static DateTimeFormatter getDateTimeFormatter() {
		return  new DateTimeFormatterBuilder()
		.appendValue(ChronoField.DAY_OF_MONTH, 2).appendLiteral('/')
		.appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('/')
		.appendValue(ChronoField.YEAR, 4)
		.toFormatter()
		.withResolverStyle(ResolverStyle.STRICT);
	}
	
	@SuppressWarnings("rawtypes")
	public static void limpa(Container obj) {
		for (Component comp : obj.getComponents()) {
			if (comp instanceof JTextField) {
				((JTextField) comp).setText("");
			} else if (comp instanceof JTextArea) {
				((JTextArea) comp).setText("");
			} else if (comp instanceof JComboBox) {
				((JComboBox) comp).setSelectedIndex(0);
			} else if (comp instanceof Container) {
				limpa((Container) comp);
			}
		}
	}

	public static StatusValidador verificaStatus(Container obj) {
		StatusValidador resultado = StatusValidador.OK;

		for (Component comp : obj.getComponents()) {
			if (comp instanceof JTextField) {
				InputVerifier verifier = ((JTextField) comp).getInputVerifier();
				if (verifier != null && verifier instanceof Validador) {
					StatusValidador status = ((Validador) verifier).isOk();
					if (!status.equals(StatusValidador.OK)) {
						if(status.equals(StatusValidador.ERRO)) {
							resultado = status;
						} else if(!(comp instanceof OptionalTextField) || 
								(comp instanceof OptionalTextField && !((OptionalTextField)comp).isOptional())) {
							resultado = status;						
						}
					}
				}
			} else if (comp instanceof Container) {
				StatusValidador st = verificaStatus((Container) comp);
				if (!st.equals(StatusValidador.OK))
					resultado = st;
			}
		}

		return resultado;
	}

	public static boolean verificaVazio(Container obj) {
		boolean resultado = true;

		for (Component comp : obj.getComponents()) {
			if (comp instanceof JTextField) {
				if(!(comp instanceof OptionalTextField) ||
				    !((OptionalTextField)comp).isOptional()) {
					if (((JTextField) comp).getText().isEmpty())
						resultado = false;
				} 
			} else if (comp instanceof JTextArea) {
				if (((JTextArea) comp).getText().isEmpty())
					resultado = false;
			} else if (comp instanceof Container) {
				if (!verificaVazio((Container) comp))
					resultado = false;
			}
		}

		return resultado;
	}

	public static JFormattedTextField criaMascara(String s) {
		return criaMascara(s, null);
	}
	
	/*
	Character   Description
	  #         Qualquer número valido, usa Character.isDigit.
	  '         Permite a utilização de qualquer caractere de formatação que está nesta lista
	  U         Qualquer charactere (Character.isLetter). Todas as letras minúsculas  são mapeadas para Maiúculas.
	  L         Qualquer charactere (Character.isLetter). Todas as letras Maiúculas  são mapeadas para minúsculas.
	  A         Qualquer charactere ou numero (Character.isLetter ou Character.isDigit)
	  ?         Qualquer charactere (Character.isLetter).
	  *         Qualquer coisa.
	  H         Qualquer charactere hexadecimal (0-9, a-f or A-F).
	*/

	public static JFormattedTextField criaMascara(String s, String chars) {
		MaskFormatter formatter = null;

		try {
			formatter = new MaskFormatter(s);
			if(chars != null)
				formatter.setValidCharacters(chars);
		} catch(ParseException exc) {
			System.err.println("Máscara inválida: " + exc.getMessage());
			System.exit(-1);
		}

		JFormattedTextField field = new JFormattedTextField(formatter);
		field.setColumns(s.length());

		return field;
	}
	
	public static JPanel criaPainel(String label, JComponent obj) {

		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel(label));
		p.add(obj);
		return p;
	}

	public static JPanel criaPainel(LayoutManager layout, JComponent... obj) {

		JPanel p = new JPanel(layout);
		for (JComponent comp : obj)
			p.add(comp);

		return p;
	}

	public static JPanel criaPainel(JButton... obj) {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
		for (JComponent comp : obj) {
			p.add(comp);
		}
		return p;
	}

	public static JButton criaBotao(String label, int key, ActionListener act) {
		JButton bt = new JButton(label);
		bt.setMnemonic(key);
		bt.addActionListener(act);
		return bt;
	}

}



