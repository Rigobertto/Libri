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
	 @FXML private TableColumn<LivroVO, String> editora;
	 //@FXML private TableColumn<LivroVO, String> idioma;
	 @FXML private TableColumn<LivroVO, Integer> paginas;
	 @FXML private TableColumn<LivroVO, Integer> ide;
	 @FXML private TableColumn<LivroVO, Double> val_compra;
	 @FXML private TableColumn<LivroVO, Double> val_venda;

	public void initialize(URL url, ResourceBundle rb) {
    	listar();
    }
	 public void listar(){
		
	 }
	 
	 LivroBO bo = new LivroBO();
	 ObservableList<LivroVO> livro= FXCollections.observableArrayList(bo.listar());
		ide.setCellValueFactory(new PropertyValueFactory<LivroVO, Integer>("id"));
		titulo.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("titulo"));
		autor.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("autor"));
		editora.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("editora"));
		val_compra.setCellValueFactory(new PropertyValueFactory<LivroVO, Double>("val_compra"));
		val_venda.setCellValueFactory(new PropertyValueFactory<LivroVO, Double>("val_venda"));
		estoque.setCellValueFactory(new PropertyValueFactory<LivroVO, Integer>("estoque"));
		paginas.setCellValueFactory(new PropertyValueFactory<LivroVO, Integer>("paginas"));
		tabelaLivro.setItems(livro);
}
