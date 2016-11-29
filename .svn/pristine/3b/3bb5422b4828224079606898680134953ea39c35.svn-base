package objeto.exemplos.classe.heranca.colegas;

import javax.swing.JOptionPane;

public class CadColega {
	public static void main(String[] args) {
		Colega[] lista = new Colega[3];

		// Cadastra os Colegas
		for (int i = 0; i < lista.length; i++) {
			int op = JOptionPane.showOptionDialog(null,
					"Selecione o Tipo de Colega", "Cadastro de Colegas",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, new String[] { "FaceBook", "Twitter", "WhatsApp" }, "FaceBook");

			if (op == 0) { // Colega do FaceBook
				String nome = JOptionPane.showInputDialog("Informe o Nome");
				String email = JOptionPane.showInputDialog("Informe o E-Mail");
				String temp = JOptionPane.showInputDialog("Informe a Idade");
				int idade = Integer.parseInt(temp);
				String face = JOptionPane.showInputDialog("Informe o seu end. do Face");

				ColegadoFace col = new ColegadoFace();
				col.setNome(nome);
				col.setEmail(email);
				col.setIdade(idade);
				col.setFacebook(face);

				lista[i] = col;
			} else if (op == 1) { // colega do Twitter
				String nome = JOptionPane.showInputDialog("Informe o Nome");
				String email = JOptionPane.showInputDialog("Informe o E-Mail");
				String temp = JOptionPane.showInputDialog("Informe a Idade");
				int idade = Integer.parseInt(temp);
				String twit = JOptionPane.showInputDialog("Informe o seu end. do Twitter");

				ColegadoTwitter col = new ColegadoTwitter();
				col.setNome(nome);
				col.setEmail(email);
				col.setIdade(idade);
				col.setTwitter(twit);

				lista[i] = col;
			} else if (op == 2) { // colega do WhatsApp
				String nome = JOptionPane.showInputDialog("Informe o Nome");
				String email = JOptionPane.showInputDialog("Informe o E-Mail");
				String temp = JOptionPane.showInputDialog("Informe a Idade");
				int idade = Integer.parseInt(temp);
				String num = JOptionPane.showInputDialog("Informe o seu numº. de Celular");

				ColegaWhatsApp col = new ColegaWhatsApp();
				col.setNome(nome);
				col.setEmail(email);
				col.setIdade(idade);
				col.setNumTelefone(num);
				
				lista[i] = col;
			} else {
				break;
			}
		}

		// Apresenta a lista dos colegas cadastrados
		String msg = "Cadastro de Colegas\n\n";
		for (int i = 0; i < lista.length; i++) {
			Colega obj = lista[i];
			msg += obj + "\n";
		}

		JOptionPane.showMessageDialog(null, msg);
	}
}
