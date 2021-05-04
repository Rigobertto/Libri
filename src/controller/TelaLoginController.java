package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.Telas;

public class TelaLoginController {
	@FXML private TextField login;
	@FXML private TextField senha;
	@FXML private Label erroAut;
	
	public void autenticar(ActionEvent event) {
		try {
	
		}catch(Exception e){
			erroAut.setVisible(true);
			e.printStackTrace();
		}
	}
}
