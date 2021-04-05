package model.vo;

import java.util.Calendar;

import model.vo.Util;

public class PessoaVO {
	private int id;
	private String nome;
	private Calendar nascimento;
	private String genero;
	private String cpf;
	private int idade;
	private String endereco;
	private String email;
	
	public int getID() {
	    return id;
	}
	
	public void setID(int id) {
		if(id > 0) {
			this.id = id;
		} else {
			System.out.println("ID inv�lido");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome != null && !nome.isEmpty()) {
			this.nome = nome;
		} else {
			System.out.println("Nome nulo ou vazio!");
		}
	}
	
	public int getIdade() {			
		return idade;
	}
	
	public void setIdade(int idade) {
		if(idade > 13) { // Provavelmente uma futura excepcion para idades menores que 0 | idade mínima pra jovem aprediz é 14
			this.idade = idade;
		}else {
			System.out.println("Idade inválida!");
		}
	}
	
	public Calendar getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(String nascimento) {
		if (nascimento != null && !nascimento.isEmpty()) {
			Calendar data = Util.formataData(nascimento);
			if(data != null) {
				Calendar hoje = Calendar.getInstance();
				if(data.get(Calendar.YEAR) >= hoje.get(Calendar.YEAR)) {
					System.out.println("Data de nascimento inválida!");
				} else this.nascimento = data;
			} else System.out.println("Data de nascimento inválida!");
		} else System.out.println("Data de nascimento nula ou vazia!");
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) { // Programar a validação de CPF
		if(nome != null && !nome.isEmpty()) {
			if(Util.isCPF(cpf))
				this.cpf = cpf;
			else 
				System.out.println("CPF inválido");
		} else {
			System.out.println("CPF nulo ou vazio");
		}
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		if(genero != null && !genero.isEmpty()) {
			genero = genero.toUpperCase();
			if(genero.equals("M") || genero.equals("F") || genero.equals("O")){
				this.genero = genero;
			} else {
				System.out.println("Gênero inválido!");
			}
		} else {
			System.out.println("Gênero nulo ou vazio");
		}
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		if (endereco != null && !endereco.isEmpty())
			this.endereco = endereco.toUpperCase();
		else 
			System.out.println("Endereco inválido!");
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if(email != null && !email.isEmpty()) {
			if(email.indexOf("@")> -1)
				this.email = email;
			else
				System.out.println("Email inválido");
		} else System.out.println("Email vazio ou nulo");
	}
}
