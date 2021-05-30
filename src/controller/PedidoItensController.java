package controller;

import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.PedidoBO;
import model.vo.FuncionarioVO;
import model.vo.LivroVO;
import model.vo.PedidoVO;
import view.Telas;

public class PedidoItensController implements Initializable {
	@FXML
    private TableView<LivroVO> tabelaPedido;
	    @FXML
	    private TableColumn<LivroVO, Long> ide;
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
	    private Label erroSelect;
	    @FXML
	    private Label totalCompra;
	    private static FuncionarioVO funcionario;
	    private static ObservableList<LivroVO> livros;
	    private static float valor;
	    
		public static FuncionarioVO getFuncionario() {
			return funcionario;
		}

		public static void setFuncionario(FuncionarioVO funcionario) {
			PedidoItensController.funcionario = funcionario;
		}
	   
		@Override
	    public void initialize(URL url, ResourceBundle rb) {
			listar();
	    }
		
		public void listar() {
			livros = FXCollections.observableArrayList(ListarPedidoController.getLivros());
			ide.setCellValueFactory(new PropertyValueFactory<LivroVO, Long>("ID"));
			titulo.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("titulo"));
			codISBN10.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("codISBN10"));
			codISBN13.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("codISBN13"));
			quantidade.setCellValueFactory(new PropertyValueFactory<LivroVO, Integer>("estoque"));
			valorUnitario.setCellValueFactory(new PropertyValueFactory<LivroVO, Double>("ValorCompra"));
			totalLivro.setCellValueFactory(new PropertyValueFactory<LivroVO, Double>("ValorVenda")); //a variável valor_compra, que não seria usada, é usada nessa operação pra colocar o valor total
			tabelaPedido.setItems(livros);
			
			valor = 0;
			for(int i = 1; i <= ListarPedidoController.getLivros().size(); i++) {
				valor += ListarPedidoController.getLivros().get(i).getValorCompra();
			}
			totalCompra.setText("Total da compra: R$" + valor);
		}
	    
	    @FXML
	    void atualizar(ActionEvent event) {
	    	InserirCodigoLivroController.setLivro(tabelaPedido.getSelectionModel().getSelectedItem());
	    	InserirCodigoLivroController.setAdd(false);
	    	Telas.telaInserirCodigo();
	    }

	    @FXML
	    void cadastrar(ActionEvent event) {
	    	InserirCodigoLivroController.setAdd(true);
	    	Telas.telaInserirCodigo();
	    }

	    @FXML
	    void excluir(ActionEvent event) {
	    	LivroVO livro = tabelaPedido.getSelectionModel().getSelectedItem();
	    	
	    	for(int i = 1; i <= ListarPedidoController.getLivros().size(); i++) {
	    		if(ListarPedidoController.getLivros().get(i).getID() == livro.getID()) {
	    			ListarPedidoController.getLivros().remove(i);
	    			try {
						Telas.telaPedidoItens();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			break;
	    		}
	    	}
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
	    	PedidoVO pedido = new PedidoVO();
	    	pedido.setLivros(ListarPedidoController.getLivros());
	    	pedido.setValor(valor);
	    	pedido.setFuncionario(funcionario);
	    	pedido.setData(Calendar.getInstance());
	    	pedido.setHora(Calendar.getInstance());
	    	
	    	PedidoBO pedidobo = new PedidoBO();
	    	pedidobo.inserir(pedido);
	    }
	    
	    @FXML
	    void cancelarCompra(ActionEvent event) {
	    	try {
	    		ListarPedidoController.setFuncionario(funcionario);
				Telas.telaListarPedido();
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }

	    @FXML
	    void voltar(ActionEvent event) {
	    	try {
	    		ListarPedidoController.setFuncionario(funcionario);
				Telas.telaListarPedido();
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
}
