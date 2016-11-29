package fundamentos.lib;

import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class TableVerificaData extends InputVerifier {
	private boolean ok = true;
	private DateFormat dateFormat = DateFormat.getDateInstance();
	private Color fore = Color.white;
	private Color back = Color.red;
	private boolean defaultColor = true;

	public TableVerificaData() {
		this(null, null, null);
	}

	public TableVerificaData(DateFormat format) {
		this(format, null, null);
	}

	public TableVerificaData(DateFormat format, Color fore, Color back) {
		if(format != null)
			dateFormat = format;
		
		if (fore != null && back != null) {
			this.fore = fore;
			this.back = back;
			defaultColor = false;
		}
	}

	@Override
	public boolean verify(JComponent input) {
		if (input instanceof JTextField) {
			JTextField textField = (JTextField) input;

			try {
				dateFormat.parse(textField.getText());
				ok = true;
				input.setBackground(Color.white);
				input.setForeground(Color.black);
			} catch (ParseException ex) {
				ok = false;
				if (defaultColor) {
					input.setBackground(Color.red);
					input.setForeground(Color.white);
				} else {
					input.setBackground(back);
					input.setForeground(fore);
				}
			}
		}

		return ok;
	}
}