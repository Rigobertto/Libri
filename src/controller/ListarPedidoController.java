package controller;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.PedidoBO;
import model.vo.FuncionarioVO;
import model.vo.LivroVO;
import model.vo.PedidoVO;
import struct.LinkedListDoubly;
import view.Telas;

public class ListarPedidoController implements Initializable{

    @FXML
    private TableView<PedidoVO> tabelaPedido;
	    @FXML
	    private TableColumn<PedidoVO, Long> id_pedido;
	    @FXML
	    private TableColumn<PedidoVO, String> data;
	    @FXML
	    private TableColumn<PedidoVO, String> hora;
	    @FXML
	    private TableColumn<PedidoVO, String> vendedor;
	    
    @FXML
    private TextField pesquisa;
    @FXML
    private ComboBox<String> pesquisac;
    @FXML
    private Label erroSelect;
    @FXML
    private Label totalCompra;
    private static FuncionarioVO funcionario;
    private static PedidoBO pedidobo = new PedidoBO();
    private static ObservableList<PedidoVO> pedidos;
    private static List<LivroVO> livros = new LinkedListDoubly<LivroVO>();
    
	public static FuncionarioVO getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(FuncionarioVO funcionario) {
		ListarPedidoController.funcionario = funcionario;
	}
    
	public static List<LivroVO> getLivros() {
		return livros;
	}
	
	@Override
    public void initialize(URL url, ResourceBundle rb) {
    	listar();
    	box();
    }

	public void listar(){
		if(funcionario.getCargo().getNome().equals("GERENTE"))
			pedidos = FXCollections.observableArrayList(pedidobo.listar());
		else if (funcionario.getCargo().getNome().equals("CAIXA")) {
			PedidoVO vo = new PedidoVO();
			vo.setFuncionario(funcionario);
			List<PedidoVO> lista = pedidobo.buscarFuncionario(vo);
			
			if(lista != null)
				pedidos = FXCollections.observableArrayList(lista);
		}
		
		if(pedidos != null) {
			id_pedido.setCellValueFactory(new PropertyValueFactory<PedidoVO, Long>("id"));
			data.setCellValueFactory(new PropertyValueFactory<PedidoVO, String>("dataS"));
			hora.setCellValueFactory(new PropertyValueFactory<PedidoVO, String>("horaS"));
			vendedor.setCellValueFactory(new PropertyValueFactory<PedidoVO, String>("vendedor"));
			tabelaPedido.setItems(pedidos);
		}
	}
	
    @FXML
    void box() {
    	List<String> lista = new LinkedListDoubly<>();
		lista.add("ID");
		lista.add("Data");
		
		if(funcionario.getCargo().getNome().equals("GERENTE"))
			lista.add("Código do Vendedor");
		
		ObservableList<String> ob = FXCollections.observableArrayList(lista);
		pesquisac.setItems(ob);
    }

    @FXML
    void buscar(ActionEvent event) {
    	String selec = pesquisac.getSelectionModel().getSelectedItem();
		String pesq = pesquisa.getText();
		
		if(selec != null && pesq != null) {
			PedidoVO pedidovo = new PedidoVO();
			
			if(selec.equals("ID")) {
				long id = Long.parseLong(pesq);
				pedidovo.setID(id);
				pedidos = FXCollections.observableArrayList(pedidobo.buscarID(pedidovo));	
				tabelaPedido.setItems(pedidos);
				
			} else if(selec.equals("Data")) {
				pedidovo.setDataS(pesq);
				pedidos = FXCollections.observableArrayList(pedidobo.buscarData(pedidovo));	
				tabelaPedido.setItems(pedidos);
				
			} else if(selec.equals("Código do Vendedor")) {
				FuncionarioVO vo = new FuncionarioVO();
				long id = Long.parseLong(pesq);
				vo.setID(id);
				pedidovo.setFuncionario(vo);
				
				pedidos = FXCollections.observableArrayList(pedidobo.buscarFuncionario(pedidovo));	
				tabelaPedido.setItems(pedidos);
				
			} else {
				erroSelect.setText("Selecione tipo da pesquisa");
				erroSelect.setVisible(true);
			}
		}
    }

    @FXML
    void cadastrar(ActionEvent event) {
    	InserirCodigoLivroController.setFuncionario(funcionario);
    	InserirCodigoLivroController.setAdd(true);
    	Telas.telaInserirCodigo();
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
    void voltar(ActionEvent event) {
    	try {
    		MenuPrincipalController.setFuncionario(funcionario);
			Telas.telaMenuPrincipal();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }

}

