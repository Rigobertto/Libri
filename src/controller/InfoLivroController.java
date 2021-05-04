package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.vo.LivroVO;
import view.Telas;

public class InfoLivroController implements Initializable{
	@FXML private Label ide;
	@FXML private Label titulo;
	@FXML private Label autor;
	@FXML private Label editora;
	@FXML private Label paginas;
	@FXML private Label idioma;
	@FXML private Label val_compra;
	@FXML private Label val_venda;
	@FXML private Label codISBN10;
	@FXML private Label codISBN13;
	@FXML private Label estoque;
	@FXML private Label dataPublicacao;
	private static LivroVO livro;
	
	public void initialize(URL url, ResourceBundle rb) {
		ide.setText(String.valueOf(livro.getID()));
		titulo.setText("Livro: " + livro.getTitulo());
		autor.setText(livro.getAutor());
		editora.setText(livro.getEditora());
		idioma.setText(livro.getIdioma());
		val_compra.setText(String.valueOf(livro.getValorCompra()));
		val_venda.setText(String.valueOf(livro.getValorVenda()));
		codISBN10.setText(livro.getCodISBN10());
		codISBN13.setText(livro.getCodISBN13());
		estoque.setText(String.valueOf(livro.getEstoque()));
		paginas.setText(String.valueOf(livro.getPaginas()));
		try {
			SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
			String data = formatoData.format(livro.getDataPubli());
			dataPublicacao.setText(data);

			} catch (Exception e) {}
	}
	public LivroVO getLivro() {
		return livro;
	}

	public static void setLivro(LivroVO livroo) {
		livro = livroo;
	}

	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public void voltar(ActionEvent event) {
		try {
			Telas.telaMenuLivro();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
