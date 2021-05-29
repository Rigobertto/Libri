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
import model.vo.Util;
import struct.LinkedListDoubly;
import view.Telas;

public class AtualizarFuncionarioController implements Initializable{
	@FXML private TextField nome;
	@FXML private TextField cpf;
	@FXML private TextField idade;
	@FXML private TextField nascimento;
	@FXML private TextField email;
	@FXML private TextField rua;
	@FXML private TextField login;
	@FXML private TextField senha;
	@FXML private Label erroAut;
	@FXML private ComboBox<String> cargo;
	@FXML private ComboBox<String> genero;
	FuncionarioBO bo = new FuncionarioBO();
	CargoBO cargobo = new CargoBO();
	private static FuncionarioVO funcionario;
	private static FuncionarioVO func;
	
	public static FuncionarioVO getFunc() {
		return func;
	}

	public static void setFunc(FuncionarioVO func) {
		AtualizarFuncionarioController.func = func;
	}

	private ObservableList<String> generoCategorias;
	List<String> generos = new LinkedListDoubly<>();
	
	private ObservableList<String> cargoCategorias;
	List<String> cargos = new LinkedListDoubly<>();
	
	public void initialize(URL url, ResourceBundle rb) {
    	carregarGenero();
    	carregarCargo();
    	nome.setText(funcionario.getNome());
    	idade.setText(String.valueOf(funcionario.getIdade()));
    	//nascimento.setPromptText(funcionario.get)
    	email.setText(funcionario.getEmail());
    	rua.setText(funcionario.getEndereco());
    	login.setText(funcionario.getLogin());
    	senha.setText(funcionario.getSenha());
    	cpf.setText(funcionario.getCPF());
    	cargo.setPromptText(funcionario.getCargo().getNome());
    	genero.setPromptText(funcionario.getGenero());
    	nascimento.setText(Util.formataData(funcionario.getNascimento()));
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
	
	public void atualizar(ActionEvent event) {
		try {
			FuncionarioVO novoFuncionario = new FuncionarioVO();
			//novoFuncionario.setID(funcionario.getID());
			novoFuncionario.setNome(nome.getText());
			novoFuncionario.setCPF(cpf.getText());
			novoFuncionario.setLogin(login.getText());
			novoFuncionario.setSenha(senha.getText());
			novoFuncionario.setEmail(email.getText());
			novoFuncionario.setEndereco(rua.getText());
			novoFuncionario.setIdade(Integer.parseInt(idade.getText()));
			novoFuncionario.setNascimento(nascimento.getText());
			if(genero.getValue() == "MASCULINO") {
				novoFuncionario.setGenero("M");
			}else if(genero.getValue() == "FEMININO") {
				novoFuncionario.setGenero("F");
			}else{
				novoFuncionario.setGenero("O");
			}
			CargoVO cargovo = new CargoVO();
			cargovo.setNome(cargo.getValue());
			cargovo = cargobo.buscarNome(cargovo);
			novoFuncionario.setCargo(cargovo);
			bo.atualizar(funcionario, novoFuncionario);
			erroAut.setText("Sucesso ao Cadastrar!");
			erroAut.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
			erroAut.setText("Falha ao Cadastrar!");
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
			MenuFuncionarioController.setFuncionario(func);
			Telas.telaMenuFuncionario();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FuncionarioVO getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(FuncionarioVO funcionario) {
		AtualizarFuncionarioController.funcionario = funcionario;
	}
}
