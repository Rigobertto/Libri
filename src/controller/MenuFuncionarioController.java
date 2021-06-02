package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
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
import model.bo.FuncionarioBO;
import model.vo.CargoVO;
import model.vo.FuncionarioVO;
import struct.LinkedListDoubly;
import view.Telas;

public class MenuFuncionarioController implements Initializable {
	@FXML private TableView<FuncionarioVO> tabelaFuncionario;
	 	@FXML private TableColumn<FuncionarioVO, String> nome;
	 	@FXML private TableColumn<FuncionarioVO, String> cargo;
	 	@FXML private TableColumn<FuncionarioVO, String> genero;
	 	@FXML private TableColumn<FuncionarioVO, Long> ide;
	 	@FXML private TableColumn<FuncionarioVO, String> login;
	 	@FXML private TableColumn<FuncionarioVO, String> senha;
	 	@FXML private TableColumn<FuncionarioVO, String> cpf;
	 	@FXML private ComboBox<String> pesquisac;
	 	@FXML private TextField pesquisa;
	 	@FXML private Label erroSelec;
	 	
	FuncionarioBO bo = new FuncionarioBO();
	ObservableList<FuncionarioVO> funcionario;
	private static FuncionarioVO funci;
    
	public static FuncionarioVO getFuncionario() {
		return funci;
	}

	public static void setFuncionario(FuncionarioVO func) {
		MenuFuncionarioController.funci = func;
	}
	public void initialize(URL url, ResourceBundle rb) {
    	listar();
    	box();
    }
	
	public void listar() {
		funcionario = FXCollections.observableArrayList(bo.listarf());
		ide.setCellValueFactory(new PropertyValueFactory<FuncionarioVO, Long>("ID"));
		nome.setCellValueFactory(new PropertyValueFactory<FuncionarioVO, String>("nome"));
		cargo.setCellValueFactory((TableColumn.CellDataFeatures<FuncionarioVO, String> param) -> new SimpleStringProperty(param.getValue().getCargo().getNome()));
		cpf.setCellValueFactory(new PropertyValueFactory<FuncionarioVO, String>("CPF"));
		login.setCellValueFactory(new PropertyValueFactory<FuncionarioVO, String>("login"));
		senha.setCellValueFactory(new PropertyValueFactory<FuncionarioVO, String>("senha"));
		genero.setCellValueFactory(new PropertyValueFactory<FuncionarioVO, String>("genero"));
		tabelaFuncionario.setItems(funcionario);
	}
	
	public void buscar(ActionEvent event) {
		String selec = pesquisac.getSelectionModel().getSelectedItem();
		String pesq = pesquisa.getText();
		
		if(selec != null && pesq != null) {
			FuncionarioVO vo = new FuncionarioVO();
			if(selec.equals("ID")) {
				int id = Integer.parseInt(pesq);
				vo.setID(id);
				funcionario = FXCollections.observableArrayList(bo.buscarID(vo));	
				tabelaFuncionario.setItems(funcionario);
//			} else if(selec.equals("Nome")) {
//				vo.setNome(pesq);
//				funcionario = FXCollections.observableArrayList(bo.buscaNome(vo));	
//				tabelaFuncionario.setItems(funcionario);
			} else if(selec.equals("Cargo")) {
				CargoVO c = new CargoVO();
				c.setNome(pesq);
				vo.setCargo(c);
				
				funcionario = FXCollections.observableArrayList(bo.buscarCargo(vo));	
				tabelaFuncionario.setItems(funcionario);
			} else if(selec.equals("CPF")) {
				vo.setCPF(pesq);
				funcionario = FXCollections.observableArrayList(bo.buscarCPF(vo));	
				tabelaFuncionario.setItems(funcionario);
			}
		} else {
			erroSelec.setText("Selecione tipo da pesquisa");
			erroSelec.setVisible(true);
		}
	}
	
	public void box() {
		List<String> lista = new LinkedListDoubly<>();
		lista.add("ID");
		lista.add("Nome");
		lista.add("Cargo");
		lista.add("CPF");
		
		ObservableList<String> ob = FXCollections.observableArrayList(lista);
		pesquisac.setItems(ob);
	}
	
	public void menuCargo(ActionEvent event) {
		try {
			MenuCargoController.setFuncionario(funci);
			Telas.telaMenuCargo();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void gerarPDF(ActionEvent event) {
		
	}
	
	public void atualizar(ActionEvent event) {
		try {
			FuncionarioVO func = tabelaFuncionario.getSelectionModel().getSelectedItem();
			AtualizarFuncionarioController.setFuncionario(func);
			AtualizarFuncionarioController.setFunc(funci);
			Telas.telaAtualizarFuncionario();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrar(ActionEvent event) {
		try {
			CadastrarFuncionarioController.setFuncionario(funci);
			Telas.telaCadastrarFuncionario();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent event) {
		try {
			PopupConfirmarController.setControl(1);
			Telas.setFsel(tabelaFuncionario.getSelectionModel().getSelectedItem());
	    	Telas.popupConfirmar();
		}catch(Exception e) {
			e.printStackTrace();
		}
	 }
	
	public void visualizar(ActionEvent event) {
		try {
			FuncionarioVO funcionario = tabelaFuncionario.getSelectionModel().getSelectedItem();
			InfoFuncionarioController.setFuncionario(funcionario);
			InfoFuncionarioController.setFunc(funci);
			Telas.telaInfoFuncionario();
		}catch(Exception e) {
			e.printStackTrace();
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
			MenuPrincipalController.setFuncionario(funci);
			Telas.telaMenuPrincipal();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
