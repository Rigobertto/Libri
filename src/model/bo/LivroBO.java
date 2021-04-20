package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.vo.LivroVO;
import model.dao.LivroDAO;
import model.vo.Util;

public class LivroBO {
	LivroDAO livrodao = new LivroDAO();
	
	public void inserir(LivroVO livro) {
		if(livro != null) {
			LivroVO l = buscarISBN13(livro);
			
			if(l != null) {
				System.out.println("Já existe um livro com o mesmo ISBN13");
			} else {
				livrodao.inserir(livro);
			}
		}
	}
	
	public void remover(LivroVO livro) {
		if(livro != null) {
			livro = buscarID(livro);
			
			if(livro != null) {
				livrodao.remover(livro);
			} else {
				System.out.println("Esse livro não existe");
			}
		}
	}
	
	public void atualizar(LivroVO livro, LivroVO novoLivro) {
		if(livro != null && novoLivro != null) {
			livro = buscarID(livro);
			
			if(livro != null) {
				livrodao.atualizar(livro, novoLivro);
			} else {
				System.out.println("Esse livro não existe");
			}
		}
	}
	
	public LivroVO buscarID(LivroVO livro) {
		ResultSet rs = livrodao.buscarID(livro);
		
		try {
			if(rs.next()) {
				livro.setID(rs.getLong("id"));
			
				livro.setCodISBN10(rs.getString("isbn10"));
				livro.setCodISBN13(rs.getString("isbn13"));
				livro.setPaginas(rs.getInt("paginas"));
				livro.setEditora(rs.getString("editora"));
				livro.setEstoque(rs.getInt("estoque"));
				livro.setValorCompra(rs.getFloat("val_compra"));
				livro.setValorVenda(rs.getFloat("val_venda"));
				livro.setIdioma(rs.getString("idioma"));
				
				String d = rs.getString("data_publicacao");
				d = Util.inverteData(d);
				livro.setDataPubli(d);
				
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
			}
			return livro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public LivroVO buscarISBN10(LivroVO livro) {
		ResultSet rs = livrodao.buscarISBN10(livro);
		
		try {
			if(rs.next()) {
				livro.setID(rs.getLong("id"));
			
				livro.setCodISBN10(rs.getString("isbn10"));
				livro.setCodISBN13(rs.getString("isbn13"));
				livro.setPaginas(rs.getInt("paginas"));
				livro.setEditora(rs.getString("editora"));
				livro.setEstoque(rs.getInt("estoque"));
				livro.setValorCompra(rs.getFloat("val_compra"));
				livro.setValorVenda(rs.getFloat("val_venda"));
				livro.setIdioma(rs.getString("idioma"));
				
				String d = rs.getString("data_publicacao");
				d = Util.inverteData(d);
				livro.setDataPubli(d);
				
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
			}
			return livro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public LivroVO buscarISBN13(LivroVO livro) {
		ResultSet rs = livrodao.buscarISBN13(livro);
		
		try {
			if(rs.next()) {
				livro.setID(rs.getLong("id"));
			
				livro.setCodISBN10(rs.getString("isbn10"));
				livro.setCodISBN13(rs.getString("isbn13"));
				livro.setPaginas(rs.getInt("paginas"));
				livro.setEditora(rs.getString("editora"));
				livro.setEstoque(rs.getInt("estoque"));
				livro.setValorCompra(rs.getFloat("val_compra"));
				livro.setValorVenda(rs.getFloat("val_venda"));
				livro.setIdioma(rs.getString("idioma"));
				
				String d = rs.getString("data_publicacao");
				d = Util.inverteData(d);
				livro.setDataPubli(d);
				
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
			}
			return livro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<LivroVO> buscarAutor (LivroVO livro){
		List<LivroVO> list = new ArrayList<LivroVO>();
		ResultSet rs = livrodao.buscarAutor(livro);
		
		try {
			while(rs.next()) {
				LivroVO l = new LivroVO();
				l.setID(rs.getLong("id"));
				l.setCodISBN10(rs.getString("isbn10"));
				l.setCodISBN13(rs.getString("isbn13"));
				l.setPaginas(rs.getInt("paginas"));
				l.setEditora(rs.getString("editora"));
				l.setEstoque(rs.getInt("estoque"));
				l.setValorCompra(rs.getFloat("val_compra"));
				l.setValorVenda(rs.getFloat("val_venda"));
				l.setIdioma(rs.getString("idioma"));
				
				String d = rs.getString("data_publicacao");
				d = Util.inverteData(d);
				l.setDataPubli(d);
				
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				
				list.add(l);
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<LivroVO> buscarTitulo(LivroVO livro) {
		List<LivroVO> list = new ArrayList<LivroVO>();
		ResultSet rs = livrodao.buscarTitulo(livro);
		
		try {
			while(rs.next()) {
				LivroVO l = new LivroVO();
				l.setID(rs.getLong("id"));
				l.setCodISBN10(rs.getString("isbn10"));
				l.setCodISBN13(rs.getString("isbn13"));
				l.setPaginas(rs.getInt("paginas"));
				l.setEditora(rs.getString("editora"));
				l.setEstoque(rs.getInt("estoque"));
				l.setValorCompra(rs.getFloat("val_compra"));
				l.setValorVenda(rs.getFloat("val_venda"));
				l.setIdioma(rs.getString("idioma"));
				
				String d = rs.getString("data_publicacao");
				d = Util.inverteData(d);
				l.setDataPubli(d);
				
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				
				list.add(l);
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<LivroVO> buscarIdioma(LivroVO livro) {
		List<LivroVO> list = new ArrayList<LivroVO>();
		ResultSet rs = livrodao.buscarIdioma(livro);
		
		try {
			while(rs.next()) {
				LivroVO l = new LivroVO();
				l.setID(rs.getLong("id"));
				l.setCodISBN10(rs.getString("isbn10"));
				l.setCodISBN13(rs.getString("isbn13"));
				l.setPaginas(rs.getInt("paginas"));
				l.setEditora(rs.getString("editora"));
				l.setEstoque(rs.getInt("estoque"));
				l.setValorCompra(rs.getFloat("val_compra"));
				l.setValorVenda(rs.getFloat("val_venda"));
				l.setIdioma(rs.getString("idioma"));
				
				String d = rs.getString("data_publicacao");
				d = Util.inverteData(d);
				l.setDataPubli(d);
				
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				
				list.add(l);
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<LivroVO> buscarPublicacao(LivroVO livro) {
		List<LivroVO> list = new ArrayList<LivroVO>();
		ResultSet rs = livrodao.buscarPublicacao(livro);
		
		try {
			while(rs.next()) {
				LivroVO l = new LivroVO();
				l.setID(rs.getLong("id"));
				l.setCodISBN10(rs.getString("isbn10"));
				l.setCodISBN13(rs.getString("isbn13"));
				l.setPaginas(rs.getInt("paginas"));
				l.setEditora(rs.getString("editora"));
				l.setEstoque(rs.getInt("estoque"));
				l.setValorCompra(rs.getFloat("val_compra"));
				l.setValorVenda(rs.getFloat("val_venda"));
				l.setIdioma(rs.getString("idioma"));
				
				String d = rs.getString("data_publicacao");
				d = Util.inverteData(d);
				l.setDataPubli(d);
				
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				
				list.add(l);
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<LivroVO> listar() {
		List<LivroVO> list = new ArrayList<LivroVO>();
		ResultSet rs = livrodao.listar();
		
		try {
			while(rs.next()) {
				LivroVO l = new LivroVO();
				l.setID(rs.getLong("id"));
				l.setCodISBN10(rs.getString("isbn10"));
				l.setCodISBN13(rs.getString("isbn13"));
				l.setPaginas(rs.getInt("paginas"));
				l.setEditora(rs.getString("editora"));
				l.setEstoque(rs.getInt("estoque"));
				l.setValorCompra(rs.getFloat("val_compra"));
				l.setValorVenda(rs.getFloat("val_venda"));
				l.setIdioma(rs.getString("idioma"));
				
				String d = rs.getString("data_publicacao");
				d = Util.inverteData(d);
				l.setDataPubli(d);
				
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				
				list.add(l);
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void mostrar(List<LivroVO> list) {
		Iterator<LivroVO> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
