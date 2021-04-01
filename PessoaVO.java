package model.vo;

import java.util.Calendar;

public class PessoaVO {
	private String nome;
	private Calendar nascimento;
	private String genero;
	private String cpf;
	private int idade;
	
	public String getNome() {
		return new String(this.nome);
	}
	
	public void setNome(String nome) {
		if(nome == null) {
			System.out.println("Nome nulo!");
		}else if(!nome.isEmpty()) {
			this.nome = nome.toUpperCase(); 
		} else {
			System.out.println("Nome vazio!");
		}
		
	}
	
	public int getIdade() {			
		return this.idade;
	}
	
	public void setIdade(int idade) {
		if(idade > 0) { // Provavelmente uma futura excepcion para idades menores que 0
			this.idade = idade;
		}else {
			System.out.println("Idade inv�lida!");
		}
	}
	
	public Calendar getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) { // Programar a valida��o de CPF
		if(Util.isCPF(cpf))
			this.cpf = cpf;
		else 
			System.out.println("CPF inválido");
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public void setGenero(String genero) {
		genero = genero.toUpperCase();
		if(genero.equals("M") || genero.equals("F") || genero.equals("O")){
			this.genero = genero;
		}else {
			System.out.println("G�nero inv�lido!");
		}
	}
}
