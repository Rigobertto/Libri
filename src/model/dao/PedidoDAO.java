package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.List;

import model.vo.PedidoVO;
import model.vo.LivroVO;

public class PedidoDAO extends BaseDAO implements InterfaceDAO<PedidoVO>{

	public void inserir(PedidoVO pedido) {
		conn = getConnection();
		String sql = "insert into pedido(id_pedido, operacao, id_livro, quantidade, valor, id_funcionario, data_pedido, hora, lucro) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		List<LivroVO> livros = pedido.getLivros();
		
		try {
			for(int i = 0; i < livros.size(); i++) {
				LivroVO livro = livros.get(i);
				
				PreparedStatement pst = conn.prepareStatement(sql);
				
				pst.setLong(1, pedido.getID());
				pst.setString(2, pedido.getOperacao());
				pst.setLong(3, livro.getID());
				pst.setInt(4, livro.getEstoque()); //quantidade pedida
				
				double v = 0, l = 0;
				if(pedido.getOperacao().equals("compra")) {
					v = ((double)livro.getValorCompra()) * livro.getEstoque();
					l = -1 * livro.getValorCompra();
				} else if(pedido.getOperacao().equals("venda")) {
					v = ((double)livro.getValorVenda()) * livro.getEstoque();
					l = livro.getValorVenda() - livro.getValorCompra();
				}
				
				pst.setDouble(5, v);
				pst.setLong(6, pedido.getFuncionario().getID());
				pst.setDate(7, new Date(pedido.getData().getTimeInMillis()));
				pst.setTime(8, new Time(pedido.getHora().getTimeInMillis()));
				pst.setDouble(9, l);
				
				pst.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(PedidoVO pedido) {
		conn = getConnection();
		String sql = "delete from pedido where id_pedido = ?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, pedido.getID());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(PedidoVO pedido, PedidoVO novoPedido) {
		//depois de confirmado o pedido não pode ser atualizado, apenas removido
	}

	public ResultSet buscarID(PedidoVO pedido) {
		conn = getConnection();
		String sql = "select * from pedido where id_pedido = ?";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, pedido.getID());
		
			rs = pst.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarData(PedidoVO pedido) {
		conn = getConnection();
		String sql = "select * from pedido where data_pedido = ?";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setDate(1, new Date(pedido.getData().getTimeInMillis()));
		
			rs = pst.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet buscarFuncionario(PedidoVO pedido) {
		conn = getConnection();
		String sql = "select * from pedido where id_funcionario = ?";
		
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, pedido.getFuncionario().getID());
		
			rs = pst.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet listar() {
		conn = getConnection();
		String sql = "select * from pedido";
		
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
