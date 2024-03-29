package controller;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Calendar;
import java.util.Iterator;
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
			erroSelect.setVisible(false);
			listar();
	    }
		
		public void listar() {
			livros = FXCollections.observableArrayList(ListarPedidoController.getLivros());
			
			ide.setCellValueFactory(new PropertyValueFactory<LivroVO, Long>("ID"));
			titulo.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("titulo"));
			codISBN10.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("codISBN10"));
			codISBN13.setCellValueFactory(new PropertyValueFactory<LivroVO, String>("codISBN13"));
			quantidade.setCellValueFactory(new PropertyValueFactory<LivroVO, Integer>("estoque"));
			valorUnitario.setCellValueFactory(new PropertyValueFactory<LivroVO, Double>("ValorVenda"));
			totalLivro.setCellValueFactory(new PropertyValueFactory<LivroVO, Double>("ValorCompra")); //a variável valor_compra, que não seria usada, é usada nessa operação pra colocar o valor total
			tabelaPedido.setItems(livros);
				
			valor = 0;
			Iterator<LivroVO> it = ListarPedidoController.getLivros().iterator();
			while(it.hasNext()) {
				valor += it.next().getValorCompra();
			}
			totalCompra.setText("Total da compra: R$" + valor);
		}
	    
	    @FXML
	    void atualizar(ActionEvent event) {
	    	if(tabelaPedido.getSelectionModel().getSelectedItem() != null) {
		    	InserirCodigoLivroController.setLivro(tabelaPedido.getSelectionModel().getSelectedItem());
		    	InserirCodigoLivroController.setAdd(false);
		    	Telas.telaInserirCodigo();
	    	} else {
	    		erroSelect.setVisible(true);
	    	}
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
	    		if(ListarPedidoController.getLivros().get(i) != null && ListarPedidoController.getLivros().get(i).getID() == livro.getID()) {
	    			ListarPedidoController.getLivros().remove(i);

					if(ListarPedidoController.getLivros().size() == 0) {
						ListarPedidoController.setLivros();
					}
					
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
	    	PedidoVO ped = pedido;
	    	try {
	    		gerarNota(ped);
	    	}catch(IOException E) {
	    		E.printStackTrace();
	    	}
	    	try {
	    		ListarPedidoController.setLivros();
	    		ListarPedidoController.setFuncionario(funcionario);
				Telas.telaListarPedido();
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void cancelarCompra(ActionEvent event) {
	    	try {
	    		ListarPedidoController.setLivros();
	    		ListarPedidoController.setFuncionario(funcionario);
				Telas.telaListarPedido();
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }

	    @FXML
	    void voltar(ActionEvent event) {
	    	try {
	    		ListarPedidoController.setLivros();
	    		ListarPedidoController.setFuncionario(funcionario);
				Telas.telaListarPedido();
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
	
	public void gerarNota(PedidoVO ped) throws IOException {
	    	try {
		    	FileWriter arq = new FileWriter("C:\\Users\\rigor\\Desktop\\NotaFiscal\\" + ped.getID() + ".txt");
		        PrintWriter gravarArq = new PrintWriter(arq);
	
		        gravarArq.printf("Nota Fiscal\n");
		        gravarArq.printf("-------------\n");
		        Iterator<LivroVO> a = ListarPedidoController.getLivros().iterator();
		        while(a.hasNext()) { 
		        	LivroVO lvo = new LivroVO();
		        	lvo = a.next();
		        	gravarArq.printf("Livro: " + lvo.getTitulo() + " - Quantidade: " + lvo.getEstoque() +" - Valor do livro: R$" + lvo.getValorVenda() + "\n");
			        
		        }
		        	
		        gravarArq.printf("-------------\n");
		        gravarArq.printf("Valor total do produto: R$" + String.valueOf(ped.getValor()) + "\n");
		        gravarArq.printf("\n");
	
		        arq.close();
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	}
		
		}
}
