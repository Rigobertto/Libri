package model.vo;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class PedidoVO {
	private long id;
	private List<LivroVO> livros;
	private double valor;
	private FuncionarioVO funcionario;
	private String vendedor;
	private Calendar data;
	private Calendar hora;
	private String dataS;
	private String horaS;
	private double lucro;
	
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
	
	public List<LivroVO> getLivros() {
		return livros;
	}
	
	public void setLivros(List<LivroVO> livros) {
		this.livros = livros;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public FuncionarioVO getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(FuncionarioVO funcionario) {
		this.funcionario = funcionario;
	}
	
	public String getVendedor() {
		return vendedor;
	}
	
	public void setVendedor() {
		vendedor = funcionario.getNome();
	}
	
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public String getDataS() {
		return dataS;
	}
	
	public void setDataS() {
		dataS = Util.formataData(data);
	}
	
	public void setDataS(String data) {
		dataS = data;
		this.data = Util.formataData(data);
	}
	
	public Calendar getHora() {
		return hora;
	}
	
	public void setHora(Calendar hora) {
		this.hora = hora;
	}
	
	public String getHoraS() {
		return horaS;
	}
	
	public void setHoraS() {
		horaS = Util.formataHora(hora);
	}
	
	public double getLucro() {
		return lucro;
	}
	
	public void setLucro(double lucro) {
		this.lucro = lucro;
	}
	
	public String toString() {
		String r = "";
		
		r = id + " - " + Util.formataData(data) + " - " + funcionario.getNome() + "\n";
		
		Iterator<LivroVO> it = livros.iterator();
		
		while(it.hasNext()) {
			r += "\t" + it.next().toString() + "\n";
		}
		
		return r;
	}

	public boolean equals(PedidoVO pedido) {
		if(pedido.id == this.id && pedido.data == this.data && pedido.funcionario.equals(this.funcionario) && pedido.hora == this.hora && pedido.lucro == this.lucro && pedido.valor == this.valor && pedido.livros.size() == this.livros.size()) {
			for(int i = 0; i < livros.size(); i++) {
				if(!pedido.livros.get(i).equals(livros.get(i))) {
					return false;
				}
			}

			return true;
		} else {
			return false;
		}
	}
}
