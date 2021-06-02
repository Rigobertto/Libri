package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.bo.PedidoBO;
import model.vo.PedidoVO;
import view.Telas;

public class PopupExcluirPedidoController {
	 @FXML
	 private Label msg;
	 private static PedidoVO pedido;
	 
	 public static PedidoVO getPedido() {
		 return pedido;
	 }
	 
	 public static void setPedido(PedidoVO pedido) {
		 PopupExcluirPedidoController.pedido = pedido;
	 }

	 @FXML
	 void no(ActionEvent event) {
		 Telas.getPopup().close();
	 }

	 @FXML
	 void yes(ActionEvent event) {
		 PedidoBO bo = new PedidoBO();
		 bo.remover(pedido);
		 
		 try {
			 Telas.telaListarPedido();
			 Telas.getPopup().close();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
}
