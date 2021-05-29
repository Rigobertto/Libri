package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.bo.CargoBO;
import model.bo.FuncionarioBO;
import model.bo.LivroBO;
import view.Telas;

public class PopupConfirmarController implements Initializable{
	@FXML private Label msg;
	private static int control = 0;
	   
	public void initialize(URL url, ResourceBundle rb) {
		if (control == 0)
			msg.setText("Confirmar Venda?");
		else if (control == 1)
    		msg.setText("Excluir Funcionário?");
		else if(control == 2)
			msg.setText("Excluir Livro?");
		else if(control == 3)
			msg.setText("Excluir Cargo?");
	}
	
	 @FXML
	 void ok(ActionEvent event) {
		 try {
	    	if(control == 0) {
//		    	PedidoBO pbo = new PedidoBO();
//		    	Telas.getVenda().setHora();
//		    	vbo.adicionar(Telas.getVenda());
//		    	gerarPdf();
//		    	Telas.getPopup().close();
//		    	Telas.telaListarPedido();
	    	} else if (control == 1) {
		    		FuncionarioBO fbo = new FuncionarioBO();
		    		fbo.remover(Telas.getFsel());
		    		Telas.getPopup().close();
		    		Telas.telaMenuFuncionario();
		    		
	    	} else if(control == 2) {
	    		LivroBO lbo = new LivroBO();
	    		lbo.remover(Telas.getLsel());
	    		Telas.getPopup().close();
	    		Telas.telaMenuLivro();
	    		
	    	}else if(control == 3) {
	    		CargoBO cbo = new CargoBO();
	    		cbo.remover(Telas.getCsel());
	    		Telas.getPopup().close();
	    		Telas.telaMenuCargo();
	    	}
	    	
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }

	 @FXML
	 void cancelar(ActionEvent event) {
	    	Telas.getPopup().close();
	    }
	    
	 public static int getControl() {
			return control;
	 }

	public static void setControl(int control) {
		PopupConfirmarController.control = control;
	}
}
