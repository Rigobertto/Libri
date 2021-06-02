package controller;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.vo.FuncionarioVO;
import model.vo.LivroVO;
import model.vo.Util;
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
	Util util = new Util();
	private static FuncionarioVO func;
    
	public static FuncionarioVO getFunc() {
		return func;
	}

	public static void setFunc(FuncionarioVO func) {
		InfoLivroController.func = func;
	}
	
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
		dataPublicacao.setText(Util.formataData(livro.getDataPubli()));
	
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
			MenuLivroController.setFuncionario(func);
			Telas.telaMenuLivro();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
