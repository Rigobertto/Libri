package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.bo.LivroBO;
import model.vo.FuncionarioVO;
import model.vo.LivroVO;
import view.Telas;

public class InserirCodigoLivroController implements Initializable{

    @FXML private TextField codigoProduto;
    @FXML private TextField quantidade;
    @FXML private Label codigo;
    @FXML private Label qntd;
	private static LivroVO livro;
	private static boolean add; //true = add e false = edit
	
	private static FuncionarioVO funcionario;
	
	public static FuncionarioVO getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(FuncionarioVO funcionario) {
		InserirCodigoLivroController.funcionario = funcionario;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		codigo.setVisible(false);
		qntd.setVisible(false);
		
		if(!add) {
			codigoProduto.setText(livro.getID() + "");
			quantidade.setText(livro.getEstoque() + "");
		} 
	}
	
	@FXML
    void ok(ActionEvent m) {
		codigo.setVisible(false);
		qntd.setVisible(false);
		
    	if(add) {
    		livro = new LivroVO();
    		if(codigoProduto.getText() != null && quantidade.getText() != null) {
    			long id = Long.parseLong(codigoProduto.getText());	
    			livro.setID(id);
    			
    			LivroBO livrobo = new LivroBO();
    			livro = livrobo.buscarID(livro);
    			
    			if(livro != null) { //checa se o código é válido
    				int quant = Integer.parseInt(quantidade.getText());
        			livro.setEstoque(quant);
        			
    				livro = livrobo.verificarEstoque(livro);
    				
    				if(livro != null) { //checa se tem estoque suficiente
    					ListarPedidoController.getLivros().add(livro);
    					
    					try {
    						PedidoItensController.setFuncionario(funcionario);
							Telas.telaPedidoItens();
							Telas.getPopup().close();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    				} else {
    					qntd.setVisible(true);
    				}
    				
    			} else {
    				codigo.setVisible(true);
    			}
    		}
    	} else {
    		long id = Long.parseLong(codigoProduto.getText());	
    		int quant = Integer.parseInt(quantidade.getText());
    		
    		for(int i = 1; i <= ListarPedidoController.getLivros().size(); i++) {
    			if(ListarPedidoController.getLivros().get(i).getID() == livro.getID()) {
    				if(id == livro.getID()) {
    					ListarPedidoController.getLivros().get(i).setEstoque(quant);
    					
    					try {
							Telas.telaPedidoItens();
							Telas.getPopup().close();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    					
    					break;
    				} else {
    					ListarPedidoController.getLivros().remove(i);
    					
    	    			livro.setID(id);
    	    			
    	    			LivroBO livrobo = new LivroBO();
    	    			livro = livrobo.buscarID(livro);
    	    			
    	    			if(livro != null) { //checa se o código é válido
    	        			livro.setEstoque(quant);
    	        			
    	    				livro = livrobo.verificarEstoque(livro);
    	    				
    	    				if(livro != null) { //checa se tem estoque suficiente
    	    					ListarPedidoController.getLivros().add(livro);
    	    					
    	    					try {
    								Telas.telaPedidoItens();
    								Telas.getPopup().close();
    							} catch (Exception e) {
    								// TODO Auto-generated catch block
    								e.printStackTrace();
    							}
    	    				} else {
    	    					qntd.setVisible(true);
    	    				}
    	    				
    	    			} else {
    	    				codigo.setVisible(true);
    	    			}
    	    			
    	    			break;
    				}
    			}
    		}
    	}
    }
	
	@FXML
    void cancelar(ActionEvent event) {
		Telas.getPopup().close();
    }
	
	public static LivroVO getLivro() {
		return livro;
	}

	public static void setLivro(LivroVO livro) {
		InserirCodigoLivroController.livro = livro;
	}
	
	public static boolean isAdd() {
		return add;
	}

	public static void setAdd(boolean add) {
		InserirCodigoLivroController.add = add;
	}	
}
