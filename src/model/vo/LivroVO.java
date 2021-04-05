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
		if(titulo != null && !titulo.isEmpty()) {
			this.titulo = titulo;
		} else {
			System.out.println("Titulo nulo ou vazio!");
		}
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		if(autor != null && !autor.isEmpty()) {
			this.autor = autor;
		} else {
			System.out.println("Autor nulo ou vazio!");
		}
	}
	
	public String getCodISBN10() {
		return cod_ISBN10;
	}
	
	public void setCodISBN10(String cod_ISBN10) {
		if(cod_ISBN10 != null && !cod_ISBN10.isEmpty()) {
			if(Util.isISBN10(cod_ISBN10))
				this.cod_ISBN10 = cod_ISBN10;
			else System.out.println("Código inválido");
		} else {
			System.out.println("Código nulo ou vazio!");
		}
	}
	
	public String getCodISBN13() {
		return cod_ISBN13;
	}
	
	public void setCodISBN13(String cod_ISBN13) {
		if(cod_ISBN13 != null && !cod_ISBN13.isEmpty()) {
			if(Util.isISBN13(cod_ISBN13))
				this.cod_ISBN13 = cod_ISBN13;
			else System.out.println("Código inválido");
		} else {
			System.out.println("Código nulo ou vazio!");
		}
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
		if(editora != null && !editora.isEmpty()) {
			this.editora = editora;
		} else {
			System.out.println("Editora nulo ou vazio!");
		}
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
		if(idioma != null && !idioma.isEmpty()) {
			this.idioma = idioma;
		} else {
			System.out.println("Idioma nulo ou vazio!");
		}
	}
	
	public Calendar getDataPubli() {
		return data_publi;
	}
	
	public void setDataPubli(String data_publi) {
		if ( data_publi != null && !data_publi.isEmpty()) {
			Calendar data = Util.formataData(data_publi);
			if(data != null) {
				Calendar hoje = Calendar.getInstance();
				if(data.get(Calendar.YEAR) >= hoje.get(Calendar.YEAR)) {
					System.out.println("Data de nascimento inválida!");
				} else this.data_publi = data;
			} else System.out.println("Data de nascimento inválida!");
		} else System.out.println("Data de nascimento nula ou vazia!");
	}
}
