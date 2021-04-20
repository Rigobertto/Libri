package model.dao;

import model.vo.LivroVO;
import java.sql.*;

public class LivroDAO extends BaseDAO {
	public void inserir(LivroVO livro) {
		conn = getConnection();
		String sql = "insert into livro(isbn10, isbn13, paginas, editora, estoque, val_compra, val_venda, idioma, data_publicacao, titulo, autor) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, livro.getCodISBN10());
			pst.setString(2,  livro.getCodISBN13());
			pst.setInt(3, livro.getPaginas());
			pst.setString(4, livro.getEditora());
			pst.setInt(5, livro.getEstoque());
			pst.setFloat(6, livro.getValorCompra());
			pst.setFloat(7, livro.getValorVenda());
			pst.setString(8, livro.getIdioma());
			pst.setDate(9, new Date(livro.getDataPubli().getTimeInMillis()));
			pst.setString(10, livro.getTitulo());
			pst.setString(11, livro.getAutor());
			
			pst.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(LivroVO livro) {
		conn = getConnection();
		String sql = "delete from livro where id = ?;";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, livro.getID());
			pst.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(LivroVO livro, LivroVO novoLivro) {
		conn = getConnection();
		PreparedStatement pst;
		
		try {
				String sql = "update livro set isbn10 = ?, isbn13 = ?, paginas = ?, editora = ?, estoque = ?, val_compra = ?, val_venda = ?, idioma = ?, data_publicacao = ?, titulo = ?, autor = ? where id = ?";
				pst = conn.prepareStatement(sql);
				
				pst.setString(1, novoLivro.getCodISBN10());
				pst.setString(2,  novoLivro.getCodISBN13());
				pst.setInt(3, novoLivro.getPaginas());
				pst.setString(4, novoLivro.getEditora());
				pst.setInt(5, novoLivro.getEstoque());
				pst.setFloat(6, novoLivro.getValorCompra());
				pst.setFloat(7, novoLivro.getValorVenda());
				pst.setString(8, novoLivro.getIdioma());
				pst.setDate(9, new Date(novoLivro.getDataPubli().getTimeInMillis()));
				pst.setString(10, novoLivro.getTitulo());
				pst.setString(11, novoLivro.getAutor());
				pst.setLong(12, livro.getID());
				
				pst.execute();
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarID(LivroVO livro) {
		conn = getConnection();
		String sql = "select * from livro where id = ?;";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, livro.getID());
			
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarISBN10(LivroVO livro) {
		conn = getConnection();
		String sql = "select * from livro where isbn10 = ?;";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, livro.getCodISBN10());
			
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarISBN13(LivroVO livro) {
		conn = getConnection();
		String sql = "select * from livro where isbn13 = ?;";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, livro.getCodISBN13());
			
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarAutor(LivroVO livro) {
		conn = getConnection();
		String sql = "select * from livro where autor = ?;";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, livro.getAutor());
			
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarTitulo(LivroVO livro) {
		conn = getConnection();
		String sql = "select * from livro where titulo = ?;";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, livro.getTitulo());
			
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarIdioma(LivroVO livro) {
		conn = getConnection();
		String sql = "select * from livro where idioma = ?;";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, livro.getIdioma());
			
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarPublicacao(LivroVO livro) {
		conn = getConnection();
		String sql = "select * from livro where data_publicacao = ?;";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setDate(1, new Date(livro.getDataPubli().getTimeInMillis()));
			
			rs = pst.executeQuery();
			return rs;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet listar() {
		conn = getConnection();
		String sql = "select * from livro";
		
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
