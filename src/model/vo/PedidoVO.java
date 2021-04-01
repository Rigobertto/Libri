package model.vo;
import java.util.Calendar;

public class PedidoVO {
	private LivroVO livro;
	float valor;
	FuncionarioVO funcionario;
	Calendar data;
	Calendar hora;
	//Operação (compra ou venda); Método? -Rigo
	float lucro;
	
	public LivroVO getLivro() {
		return livro;
	}
	public void setLivro(LivroVO livro) {
		this.livro = livro;
	}
	
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
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
	
	public float getLucro() {
		return lucro;
	}
	public void setLucro(float lucro) {
		this.lucro = lucro;
	}
}
