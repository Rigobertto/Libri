package model.bo;

import java.util.List;
import model.dao.PessoaDAO;
import model.vo.PessoaVO;
import model.vo.Util;
import struct.LinkedListDoubly;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaBO implements InterfaceBO<PessoaVO>{
	PessoaDAO dao = new PessoaDAO();

	public void inserir(PessoaVO pessoa) {
		if(pessoa != null) {
			if(buscarCPF(pessoa) == null) {
				dao.inserir(pessoa);
			} else System.out.println("Já existe uma pessoa com esse CPF");
		}
	}

	public void remover(PessoaVO pessoa) {
		if(pessoa != null) {
			if(buscarID(pessoa) != null) {
				dao.remover(pessoa);
			} else System.out.println("Não existe");
		}
	}

	public void atualizar(PessoaVO pessoa, PessoaVO novaPessoa) {
		if(pessoa != null && novaPessoa != null) {
			if(buscarID(pessoa) != null) {
				dao.atualizar(pessoa, novaPessoa);
			} else System.out.println("Não existe");
		}
	}

	public PessoaVO buscarID(PessoaVO pessoa) {
		ResultSet rs = dao.buscarID(pessoa);
		
		try {
			if(rs.next()) {
				PessoaVO p = new PessoaVO();
				
				p.setIDpessoa(rs.getLong("ide"));
				p.setNome(rs.getString("nome"));
				p.setNascimento(Util.inverteData(rs.getString("nascimento")));
				p.setGenero(rs.getString("genero"));
				p.setCPF(rs.getString("cpf"));
				p.setIdade(rs.getInt("idade"));
				p.setEndereco(rs.getString("endereco"));
				p.setEmail(rs.getString("email"));
				
				return p;
			} else return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public PessoaVO buscarCPF(PessoaVO pessoa) {
		ResultSet rs = dao.buscarCPF(pessoa);
		
		try {
			if(rs.next()) {
				PessoaVO p = new PessoaVO();
				
				p.setIDpessoa(rs.getLong("ide"));
				p.setNome(rs.getString("nome"));
				p.setNascimento(Util.inverteData(rs.getString("nascimento")));
				p.setGenero(rs.getString("genero"));
				p.setCPF(rs.getString("cpf"));
				p.setIdade(rs.getInt("idade"));
				p.setEndereco(rs.getString("endereco"));
				p.setEmail(rs.getString("email"));
				
				return p;
			} else return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<PessoaVO> listar() {
		ResultSet rs = dao.listar();
		List<PessoaVO> list = new LinkedListDoubly<PessoaVO>();
		
		try {
			while(rs.next()) {
				PessoaVO pessoa = new PessoaVO();
				
				pessoa.setIDpessoa(rs.getLong("ide"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setNascimento(Util.inverteData(rs.getString("nascimento")));
				pessoa.setGenero(rs.getString("genero"));
				pessoa.setCPF(rs.getString(rs.getString("cpf")));
				pessoa.setIdade(rs.getInt("idade"));
				pessoa.setEndereco(rs.getString("endereco"));
				pessoa.setEmail(rs.getString("email"));
				
				list.add(pessoa);
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
