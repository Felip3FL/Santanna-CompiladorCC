package introducao;

import javax.swing.JOptionPane;

/**
 * Essa classe visa ilustrar o uso e comentários comuns 
 * de documentação.
 * 
 * Para gerar a documentação deve-se utilizar o comando
 *
 * javadoc Documentacao.java -d [dir doc]
 *
 * @author Jose Antonio da Silva
 * @version 1
 */

public class Documentacao {
  /**
   * Armazena um texto qualquer
   * @see java.lang.String
   */
  private String texto;

  /**
   * Construtor padrão da classe. Ele atribui o conteudo
   * de seu par&acirc;metro Texto ao atributo Texto da classe.
   * @param texto O texto a ser atribuido ao atributo Texto
   */
  public Documentacao(String texto) {
    this.texto = texto;
  }

  /**
   * Esse método inverte o conteúdo do atributo Texto.
   * @return Um objeto <code>String</code> com o conteúdo
   * invertido do atributo Texto.
   */
  public String inverso() {
    String st = "";
	for (int i = 0; i < texto.length(); i++)
		st = texto.charAt(i) + st;
    return st;
  }

  /**
   * Método responsável pela inicialização do programa.
   * Cria a instância da classe Documentacao e a usa para
   * exibir o inverso da palavra ROMA em uma caixa de diálogo.
   * @param args recebe parâmetros da linha de comando (não é utilizado)
   * @see javax.swing.JOptionPane
   */
  public static void main(String[] args) {
    String txt = JOptionPane.showInputDialog("Entre com uma palavra");
    Documentacao dc = new Documentacao(txt);
    String st = dc.inverso();

    JOptionPane.showMessageDialog(null, st);
    System.exit(0);
  }
}
