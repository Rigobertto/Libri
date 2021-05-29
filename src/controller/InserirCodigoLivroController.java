package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.bo.LivroBO;
import model.vo.LivroVO;
import view.Telas;

public class InserirCodigoLivroController {

    @FXML private TextField codigoProduto;
    @FXML private TextField quantidade;
    @FXML private Label codigo;
    @FXML private Label qntd;
    private static int control = 0;
	private static LivroVO lvr;
	private static boolean com = false;
	
	@FXML
    void ok(ActionEvent event) {
    	
    }
	
	@FXML
    void cancelar(ActionEvent event) {
		Telas.getPopup().close();
    }
    
    public static int getControl() {
		return control;
	}
	
	public static void setControl(int control) {
		InserirCodigoLivroController.control = control;
	}
	
	public static LivroVO getLivro() {
		return lvr;
	}

	public static void setLivro(LivroVO livro) {
		InserirCodigoLivroController.lvr = livro;
	}
	
	public static boolean isCom() {
		return com;
	}

	public static void setCom(boolean com) {
		InserirCodigoLivroController.com = com;
	}
	
	
}
