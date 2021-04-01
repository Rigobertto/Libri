package model.vo;

public class FuncionarioVO extends PessoaVO{
	private String cargo;
	private float salario;
	private int id;
	private String login;
	private String senha;
	
	public int getID() {
	    return this.id;
	}
	public void setID(int id) {
		if(id > 0) {
			this.id = id;
		}else {
			System.out.println("ID inválido");
		}
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		if(salario >= 1.039f) { // Salario minimo em março de 2021
			this.salario = salario;
		}else {
			System.out.println("Salario mínimo não atingido");
		}
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
