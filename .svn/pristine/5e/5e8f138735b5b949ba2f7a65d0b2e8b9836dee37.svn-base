package fundamentos.lib;

import java.awt.Color;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VerificaValor extends InputVerifier implements Validador {
	private JLabel msg;
	private StatusValidador ok = StatusValidador.EM_BRANCO;
	private NumberFormat numberFormat = NumberFormat.getNumberInstance();
	private Color fore = Color.white;
	private Color back = Color.red;
	private boolean usaCor;

	public VerificaValor() {
		usaCor = true;
	}

	public VerificaValor(NumberFormat format) {
		usaCor = true;
		this.numberFormat = format;
	}

	public VerificaValor(Color fore, Color back) {
		usaCor = true;
		this.fore = fore;
		this.back = back;
	}

	public VerificaValor(NumberFormat format, Color fore, Color back) {
		usaCor = true;
		this.fore = fore;
		this.back = back;
		this.numberFormat = format;
	}

	public VerificaValor(JLabel err) {
		msg = err;
		usaCor = false;
	}

	public VerificaValor(JLabel err, NumberFormat format) {
		msg = err;
		usaCor = false;
		this.numberFormat = format;
	}

	public VerificaValor(JLabel err, boolean cor) {
		msg = err;
		usaCor = cor;
	}

	public VerificaValor(JLabel err, NumberFormat format, boolean cor) {
		msg = err;
		usaCor = cor;
		this.numberFormat = format;
	}

	public StatusValidador isOk() {
		return ok;
	}

	@Override
	public boolean verify(JComponent input) {
		if (input instanceof JTextField) {
			JTextField textField = (JTextField) input;
			String txt = textField.getText();

			try {
				if(txt.isEmpty()) {
					ok = StatusValidador.EM_BRANCO;
				} else {
					numberFormat.parse(textField.getText());
					ok = StatusValidador.OK;
				}
				if(msg != null)
					msg.setText("");
				if(usaCor) {
					input.setBackground(Color.white);
					input.setForeground(Color.black);
				}
			} catch (ParseException ex) {
				ok = StatusValidador.ERRO;
				if(msg != null)
					msg.setText("Valor Inválido");
				if(usaCor) {
					input.setBackground(back);
					input.setForeground(fore);
				}
			}
		}

		return true;
	}
}