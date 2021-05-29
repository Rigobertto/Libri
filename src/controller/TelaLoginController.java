package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.bo.FuncionarioBO;
import model.vo.FuncionarioVO;
import view.Telas;

public class TelaLoginController {
	@FXML private TextField login;
	@FXML private PasswordField senha;
	@FXML private Label erroAut;
	FuncionarioBO bo = new FuncionarioBO();
	FuncionarioVO vo = new FuncionarioVO();

	public void autenticar(ActionEvent event) {
		try {
			vo.setLogin(login.getText());
			vo.setSenha(senha.getText());
			vo = bo.autenticar(vo);
			System.out.println(vo.getCargo().getNome());
			if(vo.getCargo().getNome().equalsIgnoreCase("GERENTE")) {
				MenuPrincipalController.setFuncionario(vo);
				System.out.println(vo.getNome());
				Telas.telaMenuPrincipal();
			}else if(vo.getCargo().getNome().equalsIgnoreCase("VENDENDOR")) {
				
			}else if(vo.getCargo().getNome().equalsIgnoreCase("CAIXA")) {
				
			}else {
				erroAut.setVisible(true);
			}
		}catch(Exception e){
			erroAut.setVisible(true);
			e.printStackTrace();
		}
	}
}
