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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.CargoBO;
import model.vo.CargoVO;
import model.vo.FuncionarioVO;
import struct.LinkedListDoubly;
import view.Telas;

public class MenuCargoController implements Initializable{
	@FXML private TableView<CargoVO> tabelaCargo;
 		@FXML private TableColumn<CargoVO, String> cargo;
 		@FXML private TableColumn<CargoVO, Double> salario;
 		@FXML private TableColumn<CargoVO, Long> ide;
 	@FXML private TextField pesquisa;
 	@FXML private ComboBox<String> pesquisac;
 	@FXML private TextField erroSelec;
 	
 	CargoBO bo = new CargoBO();
 	ObservableList<CargoVO> cargos;
 	
	private static FuncionarioVO funcionario;
	    
	public static FuncionarioVO getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(FuncionarioVO funcionario) {
		MenuCargoController.funcionario = funcionario;
	}
 	public void initialize(URL url, ResourceBundle rb) {
 		listar();
 		box();
 	}
	
	public void listar(){
		cargos = FXCollections.observableArrayList(bo.listar());
		ide.setCellValueFactory(new PropertyValueFactory<CargoVO, Long>("ID"));
		cargo.setCellValueFactory(new PropertyValueFactory<CargoVO, String>("nome"));
		salario.setCellValueFactory(new PropertyValueFactory<CargoVO, Double>("salario"));
		tabelaCargo.setItems(cargos);
	}
	
	public void box(){
		List<String> lista = new LinkedListDoubly<>();
		lista.add("ID");
		lista.add("Cargo");
		ObservableList<String> ob = FXCollections.observableArrayList(lista);
		pesquisac.setItems(ob);
	}
	
	public void buscar(ActionEvent event) {
		String selec = pesquisac.getSelectionModel().getSelectedItem();
		String pesq = pesquisa.getText();
		
		if(selec != null && pesq != null) {
			CargoVO vo = new CargoVO();
			
			if(selec.equals("ID")) {
				int id = Integer.parseInt(pesq);
				vo.setID(id);
				cargos = FXCollections.observableArrayList(bo.buscarID(vo));	
				tabelaCargo.setItems(cargos);
				
			} else if(selec.equals("Cargo")) {
				vo.setNome(pesq);
				cargos = FXCollections.observableArrayList(bo.buscarNome(vo));	
				tabelaCargo.setItems(cargos);
				
			} else {
				erroSelec.setText("Selecione tipo da pesquisa");
				erroSelec.setVisible(true);
				}
			}
	}
	
	public void cadastrar(ActionEvent event) {
		try {
			CadastrarCargoController.setFuncionario(funcionario);
			Telas.telaCadastrarCargo();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(ActionEvent event) {
		try {
			CargoVO cargo = tabelaCargo.getSelectionModel().getSelectedItem();
			AtualizarCargoController.setCargo(cargo);
			AtualizarCargoController.setFuncionario(funcionario);
			Telas.telaAtualizarCargo();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void excluir(ActionEvent event) {
		try {
			PopupConfirmarController.setControl(3);
			CargoVO cargovo = tabelaCargo.getSelectionModel().getSelectedItem();
			if(cargovo.getNome().equals("GERENTE") || cargovo.getNome().equals("CAIXA") || cargovo.getNome().equals("VENDEDOR")) {
				
			}else {
				Telas.setCsel(tabelaCargo.getSelectionModel().getSelectedItem());
				Telas.popupConfirmar();
			}
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
			MenuFuncionarioController.setFuncionario(funcionario);
			Telas.telaMenuFuncionario();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
