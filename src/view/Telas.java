package medbay.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Telas extends Application{
	private static Stage primaryStage;
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
		telaMenuLivro();
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
	
}