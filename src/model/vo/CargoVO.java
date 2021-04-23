package model.vo;

public class CargoVO {
	private long id;
	private String nome;
	private double salario;
	
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
	
	public String getNome() {
		return new String(this.nome);
	}
	
	public void setNome(String nome) {
		if(nome != null && !nome.isEmpty()) {
			this.nome = nome;
		} else {
			System.out.println("Nome nulo ou vazio!");
		}
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		if(salario >= 400) {
			this.salario = salario;
		}else {
			System.out.println("Salario mínimo não atingido");
		}
	}
	
	public String toString() {
		return nome + ", " + salario;
	}
}
