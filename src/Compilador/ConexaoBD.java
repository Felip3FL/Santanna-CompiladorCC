package Compilador;

import java.sql.*; //Blibioteca do banco de dados Mysql
import java.text.SimpleDateFormat; //Blibioteca para capturar caracteres

public class ConexaoBD {

	static String status = ""; //Variavel que informa o status da conexão

	
	///////// CONEXAO COM O BANCO PARA ANALISE SINTATICA /////////
	
	
	public static Connection conexaolec(String sql, int i, String chave[], String pr[], String tipo[]) throws SQLException {

		Connection conn = null; // Variavel para conexão, atributo do tipo Connection
		Statement st = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance(); // Carregando o Drive MySQL para a conexão																
			String url = "jdbc:mysql://localhost/projetocc?user=root&password=fl"; // Local, NomeUsuario, Senha..
			conn = DriverManager.getConnection(url); // Enviando dados para o banco
			status = "Conexão com banco tbl_lexico com sucesso (Conexaolec)";

			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM tbl_lexico WHERE PALAVRA_RESERVADA='"+ sql + "'");
					
			rs.next();

			if (rs.getRow() != 0) {

				chave[i] = rs.getString("CHAVE");
				pr[i] = rs.getString("PALAVRA_RESERVADA");
				tipo[i] = rs.getString("TIPO");
			} else {
				pr[i] = sql;
				tipo[i] = "id";
			}

		} // Close the result set, statement, and the connection

		catch (SQLException e) {
			status = e.getMessage();
		}

		catch (ClassNotFoundException e) {
			status = e.getMessage();
		}

		catch (Exception e) {
			status = e.getMessage();
		}

		return conn;
	}

	
	///////// CONEXAO COM O BANCO PARA A VERIFICACAO DA SEMANTICA /////////
	
	
	public String conexaosen(String sql) throws SQLException {

		System.out.println(sql);
		String xxx;
		int linha = 1;
		int i;
		xxx = "";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;


		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance(); // Carregando o Drive MySQL para a conexão																
			String url = "jdbc:mysql://localhost/projetocc?user=root&password=fl"; // Local, NomeUsuario, Senha..
			conn = DriverManager.getConnection(url); // Enviando dados para o banco

			System.out.println("Executou a query = " + sql);
			stmt = conn.createStatement();

			rset = stmt.executeQuery(sql);

			rset.next();
			// int x =
			// rset.getRow();KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK

			if (rset.getRow() != 0) {
				// return(rset)
				// rset.findColumn(sql);

				if (sql.charAt(0) == 'S') {

					while (rset.next() == true) {
						linha = rset.getRow();
					}
					rset.close();
					rset = stmt.executeQuery(sql);
					rset.next();
					// linha=rset.getFetchSize();

					ResultSetMetaData rsmd = rset.getMetaData();
					int numColumns = rsmd.getColumnCount();
					int j;
					j = 1;
					i = 1;
					for (j = 1; j <= numColumns; j++) {
						xxx = xxx + rsmd.getColumnName(j) + " | ";
					}

					xxx = xxx + "\n";

					for (i = 1; i <= linha; i++) {
						for (j = 1; j <= numColumns; j++) {
							xxx = xxx + rset.getString(j) + " | ";
						}
						rset.next();
						xxx = xxx + "\n";
					}

				} else if (sql.charAt(0) == 'D') {
					xxx = "Registro deletado com sucesso.";
				} else {

					xxx = "Registro inserido com sucesso.";
				}
				return (xxx);
			} // Close the result set, statement, and the connection

		} catch (Exception e) {

			xxx = e.toString();
			return (xxx);
		} finally {
			rset = stmt.getResultSet();
			if (rset != null) {
				rset.close();
			} else {

			}

			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
		return (xxx);
	}

	
	///////// CONEXAO COM O BANCO PARA ENVIA O LOG /////////
	
	
	public static Connection conexaoLog(String metodo, boolean acao, String descricao) throws SQLException {

		Connection conn = null; // Variavel para conexão, atributo do tipo Connection

		java.util.Date data = new java.util.Date();
		SimpleDateFormat hora = new SimpleDateFormat("yyyy-MM-dd:HH.mm.ss");

		String mensagem;
		if (acao == true) {
			mensagem = "Sucesso";
		} else {
			mensagem = "Falha";
		}
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); //Carregando o Drive MySQL para a conexão
			
			String url = "jdbc:mysql://localhost/projetocc?user=root&password=fl";  //Local, NomeUsuario, Senha...
            conn = DriverManager.getConnection(url); //Enviando dados para o banco
            
            
    		Statement comandoSQL = conn.createStatement(); //Instanciando comandoSQL  
    		comandoSQL.execute("INSERT INTO tbl_log VALUES ('"+ hora.format(data) + "','" + metodo + "','" + mensagem + "','" + descricao + "')");
    		System.out.println ("LOG ["+ hora.format(data) + "] " + metodo + " | " + mensagem + " | " + descricao);
		}
	
		
		catch (SQLException e) {
			status = e.getMessage();
		}

		catch (ClassNotFoundException e) {
			status = e.getMessage();
		}

		catch (Exception e) {
			status = e.getMessage();
		}

		return conn;

	}

}