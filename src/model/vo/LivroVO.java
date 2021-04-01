package model.vo;

import java.util.Calendar;

public class LivroVO {
	private String titulo;
	private String autor;
	private String cod_ISBN10;
	private String cod_ISBN13;
	private int paginas;
	private String editora;
	private int estoque;
	private float val_compra;
	private float val_venda;
	private String idioma;
	private Calendar data_publi;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getCodISBN10() {
		return cod_ISBN10;
	}
	public void setCodISBN10(String cod_ISBN10) {
		this.cod_ISBN10 = cod_ISBN10;
	}
	
	public String getCodISBN13() {
		return cod_ISBN13;
	}
	public void setCodISBN13(String cod_ISBN13) {
		this.cod_ISBN13 = cod_ISBN13;
	}
	
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		if(paginas > 0){
			this.paginas = paginas;
		}else {
			System.out.println("Número de páginas do livro inválido!");
		}
	}
	
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public float getValorCompra() {
		return val_compra;
	}
	public void setValorCompra(float val_compra) {
		this.val_compra = val_compra;
	}
	
	public float getValorVenda() {
		return val_venda;
	}
	public void setValorVenda(float val_venda) {
		this.val_venda = val_venda;
	}
	
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public Calendar getDataPubli() {
		return data_publi;
	}
	public void setDataPubli(Calendar data_publi) {
		this.data_publi = data_publi;
	}
}
