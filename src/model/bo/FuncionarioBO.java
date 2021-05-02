package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.FuncionarioDAO;
import model.vo.CargoVO;
import model.vo.FuncionarioVO;
import model.vo.PessoaVO;
import model.vo.Util;

public class FuncionarioBO extends PessoaBO {
	FuncionarioDAO dao = new FuncionarioDAO();
	
	public void inserir(FuncionarioVO funcionario) {
		if(funcionario != null) {	
			super.inserir(funcionario);
			PessoaVO p = super.buscarCPF(funcionario);
			funcionario.setIDpessoa(p.getIDpessoa());
			
			dao.inserir(funcionario);
		} else System.out.println("Funcionario nulo");
	}
	
	public void remover(FuncionarioVO funcionario) {
		if(funcionario != null) {	
			if(buscarID(funcionario) != null) {
				dao.remover(funcionario);
				super.remover(funcionario);
			} else System.out.println(("Funcionário não existe"));
		}
	}
	
	public void atualizar(FuncionarioVO funcionario, FuncionarioVO novoFuncionario) {
		if(funcionario != null && novoFuncionario != null) {
			if(buscarID(funcionario) != null) {
				super.atualizar(funcionario, novoFuncionario);
				dao.atualizar(funcionario, novoFuncionario);
			}
		}
	}
	
	public FuncionarioVO buscarID(FuncionarioVO funcionario) {
		ResultSet rs = dao.buscarID(funcionario);
		
		try {
			if(rs.next()) {
				FuncionarioVO func = new FuncionarioVO();
				func.setIDpessoa(rs.getLong("id_pessoa"));
				
				PessoaVO p = super.buscarID(func);
				
				func.setNome(p.getNome());
				func.setNascimento(Util.formataData(p.getNascimento()));
				func.setGenero(p.getGenero());
				func.setCPF(p.getCPF());
				func.setIdade(p.getIdade());
				func.setEndereco(p.getEndereco());
				func.setEmail(p.getEmail());
				
				func.setID(rs.getLong("ide"));
				
				CargoVO cargo = new CargoVO();
				cargo.setID(rs.getLong("id_cargo"));
				CargoBO bo = new CargoBO();
				cargo = bo.buscarID(cargo);
				func.setCargo(cargo);
				
				func.setLogin(rs.getString("login"));
				func.setSenha(rs.getString("senha"));
				
				return func;
			} else return null;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public FuncionarioVO buscarIDpessoa(FuncionarioVO funcionario) {
		ResultSet rs = dao.buscarIDpessoa(funcionario);

		try {
			if(rs.next()) {
				FuncionarioVO func = new FuncionarioVO();
				func.setIDpessoa(rs.getLong("id_pessoa"));
				
				PessoaVO p = super.buscarID(func);
				
				func.setNome(p.getNome());
				func.setNascimento(Util.formataData(p.getNascimento()));
				func.setGenero(p.getGenero());
				func.setCPF(p.getCPF());
				func.setIdade(p.getIdade());
				func.setEndereco(p.getEndereco());
				func.setEmail(p.getEmail());
				
				func.setID(rs.getLong("ide"));
				
				CargoVO cargo = new CargoVO();
				cargo.setID(rs.getLong("id_cargo"));
				CargoBO bo = new CargoBO();
				cargo = bo.buscarID(cargo);
				func.setCargo(cargo);
				
				func.setLogin(rs.getString("login"));
				func.setSenha(rs.getString("senha"));
				
				return func;
			} else return null;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public FuncionarioVO buscarCPF(FuncionarioVO funcionario) {
		if(funcionario != null) {
			PessoaVO f = new FuncionarioVO();
			f = super.buscarCPF(funcionario);
		
			if(f != null) {
				FuncionarioVO func = new FuncionarioVO();
				func.setIDpessoa(f.getIDpessoa());
		
				func = buscarIDpessoa(func);
				
				if(func != null) {
					return func;
				} else {
					return null;
				}
				
			} else {
				System.out.println("pessoa não existe");
				return null;
			}
		} else {
			System.out.println("nulo");
			return null;
		}
	}
}
