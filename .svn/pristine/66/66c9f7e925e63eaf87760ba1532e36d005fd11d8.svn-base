package fundamentos.lib;

import java.awt.Color;
import java.util.regex.Pattern;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VerificaRegex extends InputVerifier implements Validador {
	private JLabel msg;
	private StatusValidador ok = StatusValidador.EM_BRANCO;
	private Pattern ptrn = null;
	private Color fore = Color.white;
	private Color back = Color.red;
	private boolean usaCor;

	public VerificaRegex(String regex) {
		usaCor = true;
		ptrn = Pattern.compile(regex);
	}

	public VerificaRegex(String regex, Color fore, Color back) {
		usaCor = true;
		this.fore = fore;
		this.back = back;
		ptrn = Pattern.compile(regex);
	}

	public VerificaRegex(JLabel err, String regex) {
		msg = err;
		usaCor = false;
		ptrn = Pattern.compile(regex);
	}

	public VerificaRegex(JLabel err, String regex, boolean cor) {
		msg = err;
		usaCor = cor;
		ptrn = Pattern.compile(regex);
	}

	@Override
	public StatusValidador isOk() {
		return ok;
	}

	@Override
	public boolean verify(JComponent input) {
		if (input instanceof JTextField) {
			JTextField textField = (JTextField) input;
			String txt = textField.getText();

			if (txt.matches(ptrn.pattern()) || txt.isEmpty()) {
				ok = txt.isEmpty() ? StatusValidador.EM_BRANCO : StatusValidador.OK;
				if(msg != null)
					msg.setText("");
				if(usaCor) {
					input.setBackground(Color.white);
					input.setForeground(Color.black);
				}
			} else {
				ok = StatusValidador.ERRO;
				if(msg != null)
					msg.setText("Campo Inválido");
				if(usaCor) {
					input.setBackground(back);
					input.setForeground(fore);
				}
			}
		}
		return true;
	}
}


