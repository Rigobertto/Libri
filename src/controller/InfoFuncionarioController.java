package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.vo.FuncionarioVO;
import model.vo.Util;
import view.Telas;

public class InfoFuncionarioController implements Initializable{
	@FXML private Label ide;
	@FXML private Label nome;
	@FXML private Label cpf;
	@FXML private Label idade;
	@FXML private Label nascimento;
	@FXML private Label email;
	@FXML private Label senha;
	@FXML private Label endereco;
	@FXML private Label login;
	@FXML private Label cargo;
	@FXML private Label genero;
	@FXML private Label salario;
	private static FuncionarioVO funcionario;
	private static FuncionarioVO func;
    
	public static FuncionarioVO getFunc() {
		return func;
	}

	public static void setFunc(FuncionarioVO func) {
		InfoFuncionarioController.func = func;
	}
	Util util = new Util();
	
	public void initialize(URL url, ResourceBundle rb) {
    	nome.setText("Nome: " + funcionario.getNome());
    	ide.setText(String.valueOf(funcionario.getID()));
    	cpf.setText(funcionario.getCPF());
    	idade.setText(String.valueOf(funcionario.getIdade()));
    	email.setText(funcionario.getEmail());
    	senha.setText(funcionario.getSenha());
    	login.setText(funcionario.getLogin());
    	endereco.setText(funcionario.getEndereco());
    	cargo.setText(funcionario.getCargo().getNome());
    	salario.setText(String.valueOf(funcionario.getCargo().getSalario()));
    	genero.setText(funcionario.getGenero());
    	nascimento.setText(Util.formataData(funcionario.getNascimento()));
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
		InfoFuncionarioController.funcionario = funcionario;
	}
}
