package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.LivroBO;
import model.vo.FuncionarioVO;
import model.vo.LivroVO;
import struct.LinkedListDoubly;
import view.Telas;

public class BuscaLivroController implements Initializable{
	@FXML private TableView<LivroVO> tabelaLivro;
	 	@FXML private TableColumn<LivroVO, String> titulo;
	 	@FXML private TableColumn<LivroVO, String> autor;
	 	@FXML private TableColumn<LivroVO, Integer> estoque;
	 	@FXML private TableColumn<LivroVO, Integer> paginas;
	 	@FXML private TableColumn<LivroVO, Long> ide;
	 	@FXML private TableColumn<LivroVO, String> idioma;
	 	@FXML private TableColumn<LivroVO, Double> val_venda;
	 	@FXML private TableColumn<LivroVO, String> codISBN10;
	 	@FXML private TableColumn<LivroVO, String> codISBN13;
 	@FXML private ComboBox<String> pesquisac;
 	@FXML private TextField pesquisa;
 	@FXML private TextField erroSelec;
 	@FXML private Label func;
 	
	 LivroBO bo = new LivroBO();
	 LivroVO livro = new LivroVO();
	 ObservableList<LivroVO> livros;
	 private static FuncionarioVO funcionario;
	    
	public static FuncionarioVO getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(FuncionarioVO funcionario) {
		BuscaLivroController.funcionario = funcionario;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
    	listar();
    	box();
    	String str = funcionario.getNome() + " - " + funcionario.getCargo().getNome();
		func.setText(str);
    }
	
	public void listar(){
		livros = FXCollections.observableArrayList(bo.listar());
		ide.setCellValueFactory(new PropertyValueFactory<LivroVO, Long>("ID"));
		titulo.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("titulo"));
		autor.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("autor"));
		paginas.setCellValueFactory(new PropertyValueFactory<LivroVO, Integer>("paginas"));
		idioma.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("idioma"));
		val_venda.setCellValueFactory(new PropertyValueFactory<LivroVO, Double>("ValorVenda"));
		estoque.setCellValueFactory(new PropertyValueFactory<LivroVO, Integer>("estoque"));
		codISBN10.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("CodISBN10"));
		codISBN13.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("CodISBN13"));
		tabelaLivro.setItems(livros);
	}
	
	public void buscar(ActionEvent event) {
		String selec = pesquisac.getSelectionModel().getSelectedItem();
		String pesq = pesquisa.getText();
		
		if(selec != null && pesq != null) {
			LivroVO vo = new LivroVO();
			
			if(selec.equals("ID")) {
				int id = Integer.parseInt(pesq);
				vo.setID(id);
				livros = FXCollections.observableArrayList(bo.buscarID(vo));	
				tabelaLivro.setItems(livros);
				
			} else if(selec.equals("Título")) {
				vo.setTitulo(pesq);
				livros = FXCollections.observableArrayList(bo.buscarTitulo(vo));	
				tabelaLivro.setItems(livros);
				
			} else if(selec.equals("Autor")) {
				vo.setAutor(pesq);
				livros = FXCollections.observableArrayList(bo.buscarAutor(vo));	
				tabelaLivro.setItems(livros);
				
			} else if(selec.equals("COD ISBN10")) {
				vo.setCodISBN10(pesq);
				livros = FXCollections.observableArrayList(bo.buscarISBN10(vo));	
				tabelaLivro.setItems(livros);
				
			} else if(selec.equals("COD ISBN13")) {
				vo.setCodISBN13(pesq);
				livros = FXCollections.observableArrayList(bo.buscarISBN13(vo));	
				tabelaLivro.setItems(livros);
				
			} else if(selec.equals("Idioma")) {
				vo.setIdioma(pesq);
				livros = FXCollections.observableArrayList(bo.buscarIdioma(vo));	
				tabelaLivro.setItems(livros);
				
			}else if(selec.equals("Todos")) {
				try {
					BuscaLivroController.setFuncionario(funcionario);
					Telas.telaBuscaLivro();
				}catch(Exception e) {
					e.printStackTrace();
				}
			} else {
			erroSelec.setText("Selecione tipo da pesquisa");
			erroSelec.setVisible(true);
			}
		}
	}
	
	public void box() {
		List<String> lista = new LinkedListDoubly<>();
		lista.add("ID");
		lista.add("Título");
		lista.add("Autor");
		lista.add("Idioma");
		lista.add("COD ISBN10");
		lista.add("COD ISBN13");
		lista.add("Todos");
		
		ObservableList<String> ob = FXCollections.observableArrayList(lista);
		pesquisac.setItems(ob);
	}
	
	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
