package model.vo;

public class FuncionarioVO extends PessoaVO {
	private long id;
	private CargoVO cargo;
	private String login;
	private String senha;
	
	public long getID() {
	    return this.id;
	}
	
	public void setID(long id) {
		if(id > 0) {
			this.id = id;
		} else {
			System.out.println("ID inv�lido");
		}
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		if(login != null && !login.isEmpty()) {
			this.login = login;
		} else {
			System.out.println("Login nulo ou vazio!");
		}
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		if(senha != null && !senha.isEmpty()) {
			this.senha = senha;
		} else {
			System.out.println("Senha nula ou vazia!");
		}
	}
	
	public CargoVO getCargo() {
		return cargo;
	}
	
	public void setCargo(CargoVO cargo) {
		if(cargo != null) {
			this.cargo = cargo;
		} else {
			System.out.println("Cargo nulo ou vazio!");
		}
	}

}
