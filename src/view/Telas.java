package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.vo.CargoVO;
import model.vo.FuncionarioVO;
import model.vo.LivroVO;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Telas extends Application{
	private static Stage primaryStage;
	private static Stage popup;
	private static FuncionarioVO fsel;
	private static LivroVO lsel;
	private static CargoVO csel;
	
	public static LivroVO getLsel() {
		return lsel;
	}

	public static void setLsel(LivroVO lsel) {
		Telas.lsel = lsel;
	}

	public static CargoVO getCsel() {
		return csel;
	}

	public static void setCsel(CargoVO csel) {
		Telas.csel = csel;
	}

	public static FuncionarioVO getFsel() {
		return fsel;
	}
	
	public static void setFsel(FuncionarioVO fsel) {
		Telas.fsel = fsel;
	}
	
	public static Stage getPopup() {
		return popup;
	}
	
	public static void setPopup(Stage popup) {
		Telas.popup = popup;
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	public static void main(String [] args){
		launch();
	}
	
	//Metodo Start
	@Override
	public void start(Stage primaryStage) throws Exception{
		setPrimaryStage(primaryStage);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Projeto Libri");
		primaryStage.show();
		telaLogin();
	}
	
	//Metodo TelaLogin
	public static void telaLogin() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/TelaLogin.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuLivro() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/MenuLivro.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastrarLivro() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/CadastrarLivro.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaInfoLivro() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/InfoLivros.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuPrincipal() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/MenuPrincipal.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuFuncionario() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/MenuFuncionario.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastrarFuncionario() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/CadastrarFuncionario.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaAtualizarFuncionario() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/AtualizarFuncionario.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaInfoFuncionario() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/InfoFuncionarios.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaAtualizarLivro() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/AtualizarLivro.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void popupConfirmar() throws Exception{
		popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setTitle("Confirmar ação");
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("telas/PopupConfirmar.fxml"));
			Scene cena = new Scene(root);
			popup.setScene(cena);
			popup.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	public static void telaListarPedido() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/ListarPedido.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaMenuCargo() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/MenuCargo.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaAtualizarCargo() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/AtualizarCargo.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaCadastrarCargo() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("telas/CadastrarCargo.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
}