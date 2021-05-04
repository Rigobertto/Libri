package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.bo.LivroBO;
import model.vo.LivroVO;
import view.Telas;

public class CadastrarLivroController {
	@FXML private TextField titulo;
	@FXML private TextField autor;
	@FXML private TextField editora;
	@FXML private TextField paginas;
	@FXML private TextField idioma;
	@FXML private TextField val_compra;
	@FXML private TextField val_venda;
	@FXML private TextField codISBN10;
	@FXML private TextField codISBN13;
	@FXML private TextField estoque;
	@FXML private TextField dataPublicacao;
	@FXML private Label erroAut;
	
	public void cadastrar(ActionEvent event) {
		try {
			LivroVO vo = new LivroVO();
			LivroBO bo = new LivroBO();
			
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
			
			bo.inserir(vo);
			erroAut.setText("Sucesso ao Cadastrar");
			erroAut.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
			erroAut.setText("Erro ao Cadastrar");
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
			Telas.telaMenuLivro();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
