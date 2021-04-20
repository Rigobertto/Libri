package model.vo;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class PedidoVO {
	private long id;
	String operacao;
	private List<LivroVO> livros;
	double valor;
	FuncionarioVO funcionario;
	Calendar data;
	Calendar hora;
	double lucro;
	
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
	
	public String getOperacao() {
		return operacao;
	}
	
	public void setOperacao(String operacao) {
		if(operacao != null && !operacao.isEmpty()) {
			this.operacao = operacao;
		} else {
			System.out.println("Operação vazia ou nula");
		}
	}
	
	public List<LivroVO> getLivros() {
		return livros;
	}
	
	public void setLivros(List<LivroVO> livros) {
		this.livros = livros;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor() {
		if(operacao == "venda") {
			Iterator<LivroVO> i = livros.iterator();
			double soma = 0.0;
			
			while(i.hasNext()) {
				soma += i.next().getValorVenda(); 
			}
			
			valor = soma;
			
		} else {
			Iterator<LivroVO> i = livros.iterator();
			double soma = 0.0;
			
			while(i.hasNext()) {
				soma += i.next().getValorCompra(); 
			}
			
			valor = soma;
		}
	}
	
	public FuncionarioVO getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(FuncionarioVO funcionario) {
		this.funcionario = funcionario;
	}
	
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public Calendar getHora() {
		return hora;
	}
	
	public void setHora(Calendar hora) {
		this.hora = hora;
	}
	
	public double getLucro() {
		return lucro;
	}
	
	public void setLucro() {
		if(operacao == "venda") {
			Iterator<LivroVO> i = livros.iterator();
			double soma = 0.0;
			
			while(i.hasNext()) {
				soma += i.next().getValorVenda(); 
			}
			
			lucro = soma / 2.0;
		} else lucro = 0.0;
	}
}
