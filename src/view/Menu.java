package view;
import java.util.Scanner;
//import java.io.Console;
public class Menu {
	static Scanner in = new Scanner(System.in);
	private static int menu_principal;
	
	public static int getMenuPrincipal() {
		return menu_principal;
	}

	public static void setMenuPrincipal(int menu_principal) {
		Menu.menu_principal = menu_principal;
	}

	public static void exibirMenu() {
		do {
			System.out.println("----------------------");
			System.out.print("----MENU PRINCIPAL----\n"
					+ "1 = Menu Livros \n"
					+ "2 = Menu Funcion�rios \n"
					+ "3 = Menu Informa��es adicionais \n");
			System.out.print("Escolha uma op��o: ");
			setMenuPrincipal(in.nextInt());
			switch (getMenuPrincipal()){
			case 1:
				MenuLivro.exibirMenuLivro();
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				//Console.clear();
				System.out.println("Op��o inv�lida!\n");
				break;
			}
		}while(getMenuPrincipal() < 1 || getMenuPrincipal() > 3);
	}
	
	
}
