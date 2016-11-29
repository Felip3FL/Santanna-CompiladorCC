package api.jdbc.exemplos.curso;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.jdbc.lib.DB;
import api.jdbc.lib.GerenteException;

public class GerenteDeDados {
	private Connection con;
	private PreparedStatement consultaTodos;
	private PreparedStatement removeId;
	private PreparedStatement inserirReg;
	private PreparedStatement atualizaReg;

	// Inicializa a conexão e cria as declarações SQL
	public GerenteDeDados() throws GerenteException {
		try {
			con = DB.newInstance().getConnection("api.jdbc.exemplos.curso.curso");
			
			// Cria as declarações SQL para operações do Banco de Dados
			consultaTodos = con.prepareStatement("Select * from curso");
			removeId = con.prepareStatement("delete from curso where idcurso=?");
			inserirReg = con.prepareStatement("insert into curso (nome, matricula, descricao) values (?, ? , ?)");
			atualizaReg = con.prepareStatement("update curso set nome=?, matricula=?, descricao=? where idcurso=?"); 
		} catch (SQLException ex) {
			throw new GerenteException("Problemas na conexão com o Banco de Dados");
		}
	}

	public void salvar(Curso obj) throws GerenteException {
		try {
			if (obj.getId() == null) { // É registro Novo?
				inserirReg.setString(1, obj.getNome());
				inserirReg.setDate(2, new Date(obj.getMatricula().getTime()));
				inserirReg.setString(3, obj.getDescricao());
				inserirReg.execute();
			} else { // Atualiza registro
				atualizaReg.setString(1, obj.getNome());
				atualizaReg.setDate(2, new Date(obj.getMatricula().getTime()));
				atualizaReg.setString(3, obj.getDescricao());
				atualizaReg.setInt(4, obj.getId());  // <<========
				atualizaReg.execute();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new GerenteException("Erro na Conexão com o Banco de Dados");
		}
	}

	public List<Curso> listaTodos() throws GerenteException {
		List<Curso> lista = null;
		try {
			lista = new ArrayList<Curso>();

			ResultSet resultado = consultaTodos.executeQuery();

			while (resultado.next()) {
				Curso obj = new Curso();
				obj.setId(resultado.getInt("idcurso"));
				obj.setNome(resultado.getString("nome"));
				obj.setMatricula(resultado.getDate("matricula"));
				obj.setDescricao(resultado.getString("descricao"));
				lista.add(obj);
			}
			
		} catch (SQLException ex) {
			throw new GerenteException("Erro na Conxão com o Banco de Dados");
		}
		return lista;
	}

	public void remover(Integer id) throws GerenteException {
		try {
			removeId.setInt(1, id);
			removeId.execute();
		}catch(SQLException ex) {
			throw new GerenteException("Erro na Conxão com o Banco de Dados");
		}
	}

	public void fechar() {
		try {
			DB.newInstance().close("api.jdbc.exemplos.curso.curso");
		} catch(GerenteException ex) {
		}
	}
}
