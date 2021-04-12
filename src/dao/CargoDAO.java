package model.dao;

import model.vo.CargoVO;
import java.sql.*;

public class CargoDAO extends BaseDAO{
	public void inserir(CargoVO cargo) {
		conn = getConnection();
		String sql = "insert into cargo(nome, salario) values(?, ?)";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, cargo.getNome());
			pst.setDouble(2, cargo.getSalario());
			pst.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(CargoVO cargo) {
		conn = getConnection();
		String sql = "delete from cargo where id = ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cargo.getID());
			pst.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(CargoVO cargo, CargoVO novoCargo) {
		conn = getConnection();
		String sql = "update cargo set nome = ?, salario = ? where id = ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, novoCargo.getNome());
			pst.setDouble(2, novoCargo.getSalario());
			pst.setInt(3, cargo.getID());
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarID(CargoVO cargo) {
		conn = getConnection();
		String sql = "select * from cargo where id = ?;";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cargo.getID());
			
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarNome(CargoVO cargo) {
		conn = getConnection();
		String sql = "select * from cargo where nome ilike ?;";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cargo.getNome());
			
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet listar() {
		conn = getConnection();
		String sql = "select * from cargo";
		
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
