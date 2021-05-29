package controller;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.vo.FuncionarioVO;
import model.vo.Util;
import view.Telas;

public class MenuPrincipalController implements Initializable{
	@FXML private Label dataAtual;
	@FXML private WebView web;
	@FXML private Label func;
	private WebEngine we;
	
	Calendar c = Calendar.getInstance();
	Util util = new Util();
	String data = Util.formataData(c);
	private static FuncionarioVO funcionario;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		dataAtual.setText("Data: " + data);
		we = web.getEngine();
		String link = "https://www.instagram.com/libri_livraria/";
		we.load(link);
		//System.out.println(funcionario.getNome());
		String str = "Olá " + funcionario.getNome() + " - " + funcionario.getCargo().getNome();
		func.setText(str);
	}
	
	public void informacoes(){
		
	}
	
	public void instagram(){
		we = web.getEngine();
		String link = "https://www.instagram.com/libri_livraria/";
		we.load(link);	
	}
	
	public void whatsapp(){
		we = web.getEngine();
		String link = "https://web.whatsapp.com/";
		we.load(link);
	}
	
	public void facebook(){
		we = web.getEngine();
		String link = "https://www.facebook.com/";
		we.load(link);
	}
	
	public void menuLivro(){
		try {
			MenuLivroController.setFuncionario(funcionario);
			Telas.telaMenuLivro();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void menuPedido(){
		try {
			ListarPedidoController.setFuncionario(funcionario);
			Telas.telaListarPedido();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void menuFuncionario(){
		try {
			MenuFuncionarioController.setFuncionario(funcionario);
			Telas.telaMenuFuncionario();
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
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FuncionarioVO getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(FuncionarioVO funcionario) {
		MenuPrincipalController.funcionario = funcionario;
	}
	
}
