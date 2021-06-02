package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.FuncionarioVO;

public class FuncionarioDAO extends BaseDAO{
	
	public void inserir(FuncionarioVO funcionario) {
		conn = getConnection();
		String sql = "insert into funcionario(id_pessoa, id_cargo, login, senha) values(?, ?, ?, ?)";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, funcionario.getIDpessoa());
			pst.setLong(2, funcionario.getCargo().getID());
			pst.setString(3, funcionario.getLogin());
			pst.setString(4, funcionario.getSenha());
			pst.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void remover(FuncionarioVO funcionario) {
		conn = getConnection();
		String sql = "delete from funcionario where ide = ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, funcionario.getID());
			pst.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(FuncionarioVO funcionario, FuncionarioVO novoFuncionario) {
		conn = getConnection();
		String sql = "update funcionario set id_cargo = ?, login = ?, senha = ? where ide = ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, novoFuncionario.getCargo().getID());
			pst.setString(2, novoFuncionario.getLogin());
			pst.setString(3, novoFuncionario.getSenha());
			pst.setLong(4, funcionario.getID());
			pst.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet buscarID(FuncionarioVO funcionario) {
		conn = getConnection();
		String sql = "select * from funcionario where ide = ?";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, funcionario.getID());
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarIDpessoa(FuncionarioVO funcionario) {
		conn = getConnection();
		String sql = "select * from funcionario where id_pessoa = ?";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, funcionario.getIDpessoa());
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarCargo(FuncionarioVO funcionario) {
		conn = getConnection();
		String sql = "select * from funcionario where id_cargo = ?";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, funcionario.getCargo().getID());
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet autenticar(FuncionarioVO funcionario) {
		conn = getConnection();
		String sql = "select * from funcionario where login = ? and senha = ?";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, funcionario.getLogin());
			pst.setString(2, funcionario.getSenha());
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet listar() {
		conn = getConnection();
		String sql = "select * from funcionario";
		
		Statement st;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
