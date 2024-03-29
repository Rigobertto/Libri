package model.bo;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.PedidoVO;
import model.dao.PedidoDAO;
import model.vo.Util;
import struct.LinkedListDoubly;
import model.vo.LivroVO;
import model.vo.FuncionarioVO;

public class PedidoBO implements InterfaceBO<PedidoVO>{
	PedidoDAO dao = new PedidoDAO();
	
	public void inserir(PedidoVO pedido) {
		if(pedido != null) {
			List<PedidoVO> lista = listar();
			
			if(lista == null) {
				pedido.setID(1);
			} else {
				long lastId = lista.get(lista.size()).getID();
				pedido.setID(lastId + 1);
			}
			
			dao.inserir(pedido);
			//atualizar estoque
		} else {
			System.out.println("Pedido vazio");
		}
	}

	public void remover(PedidoVO pedido) {
		if(pedido != null) {
			PedidoVO result = buscarID(pedido);
			
			if(result != null) {
				dao.remover(result);
			} else {
				System.out.println("Esse pedido não existe");
			}
		} else {
			System.out.println("Pedido inválido");
		}
	}

	public void atualizar(PedidoVO pedido, PedidoVO novoPedido) {
		//não é possível atuallizar
	}

	public PedidoVO buscarID(PedidoVO pedido) {
		ResultSet rs = dao.buscarID(pedido);
		
		LivroBO lbo = new LivroBO();
		
		long lastId = 0;
		
		try {
			PedidoVO p = new PedidoVO();
			while(rs.next()) {
				if(lastId != rs.getLong("id_pedido")) {
					lastId = rs.getLong("id_pedido");
					p.setID(lastId);
					
					String data = rs.getString("data_pedido");
					p.setData(Util.formataData(Util.inverteData(data)));
					p.setDataS();
					
					p.setHora(Util.formataHora(rs.getString("hora")));
					p.setHoraS();
					
					List<LivroVO> livros = new LinkedListDoubly<LivroVO>();
					LivroVO lvo = new LivroVO();
					lvo.setID(rs.getLong("id_livro"));
					
					lvo = lbo.buscarID(lvo);
					lvo.setEstoque(rs.getInt("quantidade"));
					livros.add(lvo);
					p.setLivros(livros);
					
					p.setValor(rs.getDouble("valor"));
					
					FuncionarioVO fvo = new FuncionarioVO();
					fvo.setID(rs.getLong("id_funcionario"));
					FuncionarioBO fbo = new FuncionarioBO();
					fvo = fbo.buscarID(fvo);
					p.setFuncionario(fvo);
					p.setVendedor();
					
					p.setLucro(rs.getDouble("lucro"));
				} else {
					LivroVO lvo = new LivroVO();
					lvo.setID(rs.getLong("id_livro"));
					
					lvo = lbo.buscarID(lvo);
					lvo.setEstoque(rs.getInt("quantidade"));
					p.getLivros().add(lvo);
					
					p.setValor(p.getValor() + rs.getDouble("valor"));
					p.setLucro(p.getLucro() + rs.getDouble("lucro"));
				}
			}
			
			if(lastId == 0) {
				return null;
			} else {
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<PedidoVO> buscarData(PedidoVO pedido) {
		ResultSet rs = dao.buscarData(pedido);
		List<PedidoVO> pedidos = new LinkedListDoubly<PedidoVO>();
		
		LivroBO lbo = new LivroBO();
		
		long lastId = 0;
		int cont = -1;
		
		try {
			while(rs.next()) {
				PedidoVO p = new PedidoVO();
				
				if(lastId != rs.getLong("id_pedido")) {
					lastId = rs.getLong("id_pedido");
					p.setID(lastId);
					
					String data = rs.getString("data_pedido");
					p.setData(Util.formataData(Util.inverteData(data)));
			        p.setDataS();
					
					p.setHora(Util.formataHora(rs.getString("hora")));
					p.setHoraS();
					
					List<LivroVO> livros = new LinkedListDoubly<LivroVO>();
					LivroVO lvo = new LivroVO();
					lvo.setID(rs.getLong("id_livro"));
					
					lvo = lbo.buscarID(lvo);
					lvo.setEstoque(rs.getInt("quantidade"));
					livros.add(lvo);
					p.setLivros(livros);
					
					p.setValor(rs.getDouble("valor"));
					
					FuncionarioVO fvo = new FuncionarioVO();
					fvo.setID(rs.getLong("id_funcionario"));
					FuncionarioBO fbo = new FuncionarioBO();
					fvo = fbo.buscarID(fvo);
					p.setFuncionario(fvo);
					p.setVendedor();
					
					p.setLucro(rs.getDouble("lucro"));
					
					cont++;
					
					pedidos.add(p);
				} else {
					LivroVO lvo = new LivroVO();
					lvo.setID(rs.getLong("id_livro"));
					
					lvo = lbo.buscarID(lvo);
					lvo.setEstoque(rs.getInt("quantidade"));
					pedidos.get(cont).getLivros().add(lvo);
					
					p.setValor(pedidos.get(cont).getValor() + rs.getDouble("valor"));
					p.setLucro(pedidos.get(cont).getLucro() + rs.getDouble("lucro"));
				}
			}
			
			if(lastId == 0) {
				return null;
			} else {
				return pedidos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<PedidoVO> buscarFuncionario(PedidoVO pedido){
		ResultSet rs = dao.buscarFuncionario(pedido);
		List<PedidoVO> pedidos = new LinkedListDoubly<PedidoVO>();
		
		LivroBO lbo = new LivroBO();
		
		long lastId = 0;
		int cont = -1;
		
		try {
			while(rs.next()) {
				PedidoVO p = new PedidoVO();
				
				if(lastId != rs.getLong("id_pedido")) {
					lastId = rs.getLong("id_pedido");
					p.setID(lastId);
					
					String data = rs.getString("data_pedido");
					p.setData(Util.formataData(Util.inverteData(data)));
					p.setDataS();
					
					p.setHora(Util.formataHora(rs.getString("hora")));
					p.setHoraS();
					
					List<LivroVO> livros = new LinkedListDoubly<LivroVO>();
					LivroVO lvo = new LivroVO();
					lvo.setID(rs.getLong("id_livro"));
					
					lvo = lbo.buscarID(lvo);
					lvo.setEstoque(rs.getInt("quantidade"));
					livros.add(lvo);
					p.setLivros(livros);
					
					p.setValor(rs.getDouble("valor"));
					
					FuncionarioVO fvo = new FuncionarioVO();
					fvo.setID(rs.getLong("id_funcionario"));
					FuncionarioBO fbo = new FuncionarioBO();
					fvo = fbo.buscarID(fvo);
					p.setFuncionario(fvo);
					p.setVendedor();
					
					p.setLucro(rs.getDouble("lucro"));
					
					cont++;
					
					pedidos.add(p);
				} else {
					LivroVO lvo = new LivroVO();
					lvo.setID(rs.getLong("id_livro"));
					
					lvo = lbo.buscarID(lvo);
					lvo.setEstoque(rs.getInt("quantidade"));
					pedidos.get(cont).getLivros().add(lvo);
					
					p.setValor(pedidos.get(cont).getValor() + rs.getDouble("valor"));
					p.setLucro(pedidos.get(cont).getLucro() + rs.getDouble("lucro"));
				}
			}
			
			if(lastId == 0) {
				return null;
			} else {
				return pedidos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<PedidoVO> listar() {
		ResultSet rs = dao.listar();
		List<PedidoVO> pedidos = new LinkedListDoubly<PedidoVO>();
		
		LivroBO lbo = new LivroBO();
		
		long lastId = 0;
		int cont = 0;
		
		try {
			while(rs.next()) {
				PedidoVO p = new PedidoVO();
				
				if(lastId != rs.getLong("id_pedido")) {
					lastId = rs.getLong("id_pedido");
					p.setID(lastId);
					
					String data = rs.getString("data_pedido");
					p.setData(Util.formataData(Util.inverteData(data)));
					p.setDataS();
					
					p.setHora(Util.formataHora(rs.getString("hora")));
					p.setHoraS();
					
					List<LivroVO> livros = new LinkedListDoubly<LivroVO>();
					LivroVO lvo = new LivroVO();
					lvo.setID(rs.getLong("id_livro"));
					
					lvo = lbo.buscarID(lvo);
					lvo.setEstoque(rs.getInt("quantidade"));
					livros.add(lvo);
					p.setLivros(livros);
					
					p.setValor(rs.getDouble("valor"));
					
					FuncionarioVO fvo = new FuncionarioVO();
					fvo.setID(rs.getLong("id_funcionario"));
					FuncionarioBO fbo = new FuncionarioBO();
					fvo = fbo.buscarID(fvo);
					p.setFuncionario(fvo);
					p.setVendedor();
					
					p.setLucro(rs.getDouble("lucro"));
					
					cont++;
					
					pedidos.add(p);
				} else {
					LivroVO lvo = new LivroVO();
					lvo.setID(rs.getLong("id_livro"));
					
					lvo = lbo.buscarID(lvo);
					lvo.setEstoque(rs.getInt("quantidade"));
					pedidos.get(cont).getLivros().add(lvo);
					
					p.setValor(pedidos.get(cont).getValor() + rs.getDouble("valor"));
					p.setLucro(pedidos.get(cont).getLucro() + rs.getDouble("lucro"));
				}
			}
			
			if(lastId == 0) {
				return null;
			} else {
				return pedidos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void mostrar(List<PedidoVO> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
