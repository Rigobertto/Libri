package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Tela extends Application{
	private static Stage primaryStage;
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void setPrimaryStage(Stage primaryStage) {
		Tela.primaryStage = primaryStage;
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
		menuLivro();
		
		
	}
	
	//Metodo tela de Login
	public static void telaLogin() throws Exception {
		Parent root = FXMLLoader.load(Tela.class.getResource("screams/TelaLogin.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	//Metodo tela do Menu Livro
	public static void menuLivro() throws Exception {
		Parent root = FXMLLoader.load(Tela.class.getResource("screams/MenuLivro.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
}
