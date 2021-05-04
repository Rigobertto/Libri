package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.LivroBO;
import model.vo.LivroVO;
import view.Telas;

public class MenuLivroController implements Initializable{
	@FXML private TableView<LivroVO> tabelaLivro;
	 	@FXML private TableColumn<LivroVO, String> titulo;
	 	@FXML private TableColumn<LivroVO, String> autor;
	 	@FXML private TableColumn<LivroVO, Integer> estoque;
	 	@FXML private TableColumn<LivroVO, Integer> paginas;
	 	@FXML private TableColumn<LivroVO, Long> ide;
	 	@FXML private TableColumn<LivroVO, Double> val_compra;
	 	@FXML private TableColumn<LivroVO, Double> val_venda;
	 	LivroBO bo = new LivroBO();
	 LivroVO livro = new LivroVO();
	public void initialize(URL url, ResourceBundle rb) {
    	listar();
    }
	
	public void listar(){
		ObservableList<LivroVO> livro = FXCollections.observableArrayList(bo.listar());
		ide.setCellValueFactory(new PropertyValueFactory<LivroVO, Long>("ID"));
		titulo.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("titulo"));
		autor.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("autor"));
		paginas.setCellValueFactory(new PropertyValueFactory<LivroVO, Integer>("paginas"));
		val_compra.setCellValueFactory(new PropertyValueFactory<LivroVO, Double>("ValorCompra"));
		val_venda.setCellValueFactory(new PropertyValueFactory<LivroVO, Double>("ValorVenda"));
		estoque.setCellValueFactory(new PropertyValueFactory<LivroVO, Integer>("estoque"));
		tabelaLivro.setItems(livro);
	}
	
	public void excluir(ActionEvent event) {
		try {
			LivroVO livro = tabelaLivro.getSelectionModel().getSelectedItem();
			bo.remover(livro);
			Telas.telaMenuLivro();
		}catch(Exception e) {
			e.printStackTrace();
		}
	 }
	 
	public void visualizar(ActionEvent event) {
		try {
			LivroVO livro = tabelaLivro.getSelectionModel().getSelectedItem();
			InfoLivroController.setLivro(livro);
			Telas.telaInfoLivro();
		}catch(Exception e) {
			e.printStackTrace();
		}
	 }
	 
	public void alterar(ActionEvent event) {
		 
	 }
	 
	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public void voltar(ActionEvent event) {
		
	}
		
	public void cadastrar(ActionEvent event) {
		try {
			Telas.telaCadastrarLivro();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
