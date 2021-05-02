package model.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import model.vo.PessoaVO;

public class PessoaDAO extends BaseDAO implements InterfaceDAO<PessoaVO>{

	public void inserir(PessoaVO pessoa) {
		conn = getConnection();
		String sql = "insert into pessoa(nome, nascimento, genero, cpf, idade, endereco, email) values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, pessoa.getNome());
			pst.setDate(2, new Date(pessoa.getNascimento().getTimeInMillis()));
			pst.setString(3, pessoa.getGenero());
			pst.setString(4, pessoa.getCPF());
			pst.setInt(5, pessoa.getIdade());
			pst.setString(6, pessoa.getEndereco());
			pst.setString(7, pessoa.getEmail());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void remover(PessoaVO pessoa) {
		conn = getConnection();
		String sql = "delete from pessoa where ide = ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, pessoa.getIDpessoa());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(PessoaVO pessoa, PessoaVO novaPessoa) {
		conn = getConnection();
		String sql = "update pessoa set nome = ?, nascimento = ?, genero = ?, cpf = ?, idade = ?, endereco = ?, email = ? where ide = ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, novaPessoa.getNome());
			pst.setDate(2, new Date(novaPessoa.getNascimento().getTimeInMillis()));
			pst.setString(3, novaPessoa.getGenero());
			pst.setString(4, novaPessoa.getCPF());
			pst.setInt(5, novaPessoa.getIdade());
			pst.setString(6, novaPessoa.getEndereco());
			pst.setString(7, novaPessoa.getEmail());
			pst.setLong(8, pessoa.getIDpessoa());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet buscarID(PessoaVO pessoa) {
		conn = getConnection();
		String sql = "select * from pessoa where ide = ?";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, pessoa.getIDpessoa());
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarCPF(PessoaVO pessoa) {
		conn = getConnection();
		String sql = "select * from pessoa where cpf = ?";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, pessoa.getCPF());
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet listar() {
		conn = getConnection();
		String sql = "select * from pessoa";
		
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
