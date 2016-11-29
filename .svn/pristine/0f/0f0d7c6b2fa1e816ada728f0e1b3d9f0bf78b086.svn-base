package api.jdbc.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DB {
	private static DB thisInstance;
	private Map<String, DBConnection> connections;

	private DB() {
		connections = new HashMap<>();
	}

	public static DB newInstance() {
		if (thisInstance == null) {
			thisInstance = new DB();
		}
		return thisInstance;
	}

	public Connection getConnection(String properties) throws GerenteException {
		if (!connections.containsKey(properties)) {
			return newConnection(properties);
		} else {
			return connections.get(properties).getCon();
		}
	}

	public Connection newConnection(String properties) throws GerenteException {
		try {
			if (!connections.containsKey(properties)) {
				ResourceBundle res = ResourceBundle.getBundle(properties);
				Class.forName(res.getString("driver"));
				Connection con = DriverManager.getConnection(
						res.getString("url"), res.getString("user"),
						res.getString("pwd"));
				connections.put(properties, new DBConnection(con));
			}
			return connections.get(properties).getNewCon();
		} catch (MissingResourceException ex) {
			throw new GerenteException(
					"Falha ao localizar os parâmetros de conexão");
		} catch (ClassNotFoundException ex) {
			throw new GerenteException("Driver JDBC não encontrado");
		} catch (SQLException ex) {
			throw new GerenteException(
					"Houve problema na conexão ao banco de dados");
		}
	}

	public void close(String properties) throws GerenteException {
		try {
			if (connections.containsKey(properties)) {
				DBConnection con = connections.get(properties);
				if(con.getCount() == 1) {
					con.getCon().close();
					connections.remove(properties);
				} else {
					con.setCount(con.getCount()-1);
				}
			}
		} catch (SQLException ex) {
			throw new GerenteException(
					"Houve problema ao encerrar a conexão com o banco de dados");
		}
	}

	private class DBConnection {
		private Connection con;
		private int count;

		public DBConnection(Connection con) {
			this.con = con;
			count = 1;
		}

		public Connection getCon() {
			return con;
		}

		public Connection getNewCon() {
			count++;
			return con;
		}

		public int getCount() {
			return count;
		}
		
		public void setCount(int count) {
			this.count = count;
		}
	}

}
