package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.bo.CargoBO;
import model.vo.CargoVO;
import model.vo.FuncionarioVO;
import view.Telas;

public class CadastrarCargoController implements Initializable {
	@FXML private TextField nome;
	@FXML private TextField salario;
	@FXML private Label erroAut;
	private static FuncionarioVO funcionario;
	//private static CargoVO cargo;
	CargoBO bo = new CargoBO();
	
	public void initialize(URL url, ResourceBundle rb) {
    	
    }
	
	public void cadastrar(ActionEvent event) {
		try {
			CargoVO vo = new CargoVO();
			vo.setNome(nome.getText());
			vo.setSalario(Double.parseDouble(salario.getText()));
			bo.inserir(vo);
			erroAut.setText("Sucesso ao Cadastrar!");
			erroAut.setVisible(true);
		}catch(Exception e) {
			erroAut.setText("Erro ao Cadastrar!");
			erroAut.setVisible(true);
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
			MenuCargoController.setFuncionario(funcionario);
			Telas.telaMenuCargo();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FuncionarioVO getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(FuncionarioVO funcionario) {
		CadastrarCargoController.funcionario = funcionario;
	}
}
