package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.bo.LivroBO;
import model.vo.FuncionarioVO;
import model.vo.LivroVO;
import model.vo.Util;
import view.Telas;

public class AtualizarLivroController implements Initializable{
	@FXML private TextField titulo;
    @FXML private TextField autor;
    @FXML private TextField editora;
    @FXML private TextField codISBN10;
    @FXML private TextField codISBN13;
    @FXML private TextField idioma;
    @FXML private TextField estoque;
    @FXML private TextField dataPublicacao;
    @FXML private TextField val_compra;
    @FXML private TextField val_venda;
    @FXML private TextField paginas;
    @FXML private Label erroAut;
    private static LivroVO livro;
    Util util = new Util();
    private static FuncionarioVO funcionario;
    
	public static FuncionarioVO getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(FuncionarioVO funcionario) {
		AtualizarLivroController.funcionario = funcionario;
	}

	public void initialize(URL url, ResourceBundle rb) {
    	titulo.setText(livro.getTitulo());
    	autor.setText(livro.getAutor());
    	editora.setText(livro.getEditora());
    	codISBN10.setText(livro.getCodISBN10());
    	codISBN13.setText(livro.getCodISBN13());
    	idioma.setText(livro.getIdioma());
    	val_compra.setText(String.valueOf(livro.getValorCompra()));
    	val_venda.setText(String.valueOf(livro.getValorVenda()));
    	estoque.setText(String.valueOf(livro.getEstoque()));
    	paginas.setText(String.valueOf(livro.getPaginas()));
    	dataPublicacao.setText(Util.formataData(livro.getDataPubli()));
    }
    
    @FXML void atualizar(ActionEvent event) {
    	try {
	    	LivroVO vo = new LivroVO();
	    	LivroBO bo = new LivroBO();
	    	vo.setID(livro.getID());
	    	vo.setTitulo(titulo.getText());
			vo.setAutor(autor.getText());
			vo.setEditora(editora.getText());
			vo.setEstoque(Integer.parseInt(estoque.getText()));
			vo.setIdioma(idioma.getText());
			vo.setPaginas(Integer.parseInt(paginas.getText()));
			vo.setValorCompra(Double.parseDouble(val_compra.getText()));
			vo.setValorVenda(Double.parseDouble(val_venda.getText()));
			vo.setDataPubli(dataPublicacao.getText());
			vo.setCodISBN10(codISBN10.getText());
			vo.setCodISBN13(codISBN13.getText());
			vo.setDataPubli(dataPublicacao.getText());
			bo.atualizar(livro, vo);
			erroAut.setText("Sucesso ao Atualizar");
			erroAut.setVisible(true);
    	}catch(Exception e){
    		e.printStackTrace();
			erroAut.setText("Erro ao Atualizar");
			erroAut.setVisible(true);
    	}
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
			MenuLivroController.setFuncionario(funcionario);
			Telas.telaMenuLivro();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    public LivroVO getLivro() {
		return livro;
	}

	public static void setLivro(LivroVO livro) {
		AtualizarLivroController.livro = livro;
	}
}
