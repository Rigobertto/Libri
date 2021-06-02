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
import javafx.scene.control.TextField;
import model.bo.CargoBO;
import model.bo.FuncionarioBO;
import model.vo.CargoVO;
import model.vo.FuncionarioVO;
import struct.LinkedListDoubly;
import view.Telas;

public class CadastrarFuncionarioController implements Initializable{
	@FXML private TextField nome;
	@FXML private TextField cpf;
	@FXML private TextField idade;
	@FXML private TextField nascimento;
	@FXML private TextField email;
	@FXML private TextField senha;
	@FXML private TextField rua;
	@FXML private TextField login;
	@FXML private Label erroAut;
	@FXML private ComboBox<String> cargo;
	@FXML private ComboBox<String> genero;
	FuncionarioBO bo = new FuncionarioBO();
	CargoBO cargobo = new CargoBO();
	private static FuncionarioVO funcionario;
    
	public static FuncionarioVO getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(FuncionarioVO funcionario) {
		CadastrarFuncionarioController.funcionario = funcionario;
	}
	private ObservableList<String> generoCategorias;
	List<String> generos = new LinkedListDoubly<>();
	
	private ObservableList<String> cargoCategorias;
	List<String> cargos = new LinkedListDoubly<>();
	
	public void initialize(URL url, ResourceBundle rb) {
    	carregarGenero();
    	carregarCargo();
    }
	
	public void cadastrar(){
		try {
			FuncionarioVO vo = new FuncionarioVO();
			vo.setNome(nome.getText());
			vo.setCPF(cpf.getText());
			vo.setIdade(Integer.parseInt(idade.getText()));
			vo.setNascimento(nascimento.getText());
			vo.setEmail(email.getText());
			//String endereco = cep.getText() + "," + bairro.getText() + "," + rua.getText() + "," + numero.getText();
			vo.setEndereco(rua.getText());
			vo.setLogin(login.getText());
			vo.setSenha(senha.getText());
			if(genero.getValue() == "MASCULINO") {
				vo.setGenero("M");
			}else if(genero.getValue() == "FEMININO") {
				vo.setGenero("F");
			}else{
				vo.setGenero("O");
			}
			CargoVO cargovo = new CargoVO();
			cargovo.setNome(cargo.getValue());
			cargovo = cargobo.buscarNome(cargovo);
			vo.setCargo(cargovo);
			bo.inserir(vo);
			erroAut.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
			erroAut.setText("Falha ao Cadastrar!");
			erroAut.setVisible(true);
		}
	}
	
	public void carregarGenero(){
		generos.add("MASCULINO");
		generos.add("FEMININO");
		generos.add("OUTRO");
		generoCategorias = FXCollections.observableArrayList(generos);
		genero.setItems(generoCategorias);
	}
	
	public void carregarCargo(){
		cargoCategorias = FXCollections.observableArrayList(cargobo.listarNomes());
		cargo.setItems(cargoCategorias);
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
