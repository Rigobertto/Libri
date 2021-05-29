package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.vo.FuncionarioVO;
import model.vo.LivroVO;
import view.Telas;

public class ListarPedidoController implements Initializable{

    @FXML
    private TableView<LivroVO> tabelaPedido;
	    @FXML
	    private TableColumn<LivroVO, Integer> ide;
	    @FXML
	    private TableColumn<LivroVO, String> titulo;
	    @FXML
	    private TableColumn<LivroVO, String> codISBN10;
	    @FXML
	    private TableColumn<LivroVO, String> codISBN13;
	    @FXML
	    private TableColumn<LivroVO, Integer> quantidade;
	    @FXML
	    private TableColumn<LivroVO, Double> valorUnitario;
	    @FXML
	    private TableColumn<LivroVO, Double> totalLivro;
	    
    @FXML
    private TextField pesquisa;
    @FXML
    private ComboBox<?> pesquisac;
    @FXML
    private Label erroSelect;
    @FXML
    private Label totalCompra;
    private static FuncionarioVO funcionario;
    
	public static FuncionarioVO getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(FuncionarioVO funcionario) {
		ListarPedidoController .funcionario = funcionario;
	}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    }
    
    
    @FXML
    void atualizar(ActionEvent event) {
    	
    }

    @FXML
    void box(ActionEvent event) {

    }

    @FXML
    void buscar(ActionEvent event) {
    	
    }

    @FXML
    void cadastrar(ActionEvent event) {
    	
    }

    @FXML
    void excluir(ActionEvent event) {
    	
    }

    @FXML
    void logOut(ActionEvent event) {
    	try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void finalizarCompra(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
    	try {
    		MenuPrincipalController.setFuncionario(funcionario);
			Telas.telaMenuPrincipal();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }

}

