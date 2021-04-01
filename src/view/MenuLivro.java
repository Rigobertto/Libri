package view;

import java.util.Scanner;

public class MenuLivro {
	static Scanner in = new Scanner(System.in);
	private static int menu_livro;
	
	public static int getMenuLivro() {
		return menu_livro;
	}

	public static void setMenuLivro(int menu_livro) {
		MenuLivro.menu_livro = menu_livro;
	}
	
	public static void exibirMenuLivro(){
		do {
			System.out.println("----------------------");
			System.out.println("----MENU DE LIVROS----");
			System.out.print("1 = Cadastrar Livro\n"
					+ "2 = Excluir Livro\n"
					+ "3 = Listar Livros e Estoque\n"
					+ "4 = Voltar Menu Principal\n");
			System.out.print("Escolha uma opção: ");
			setMenuLivro(in.nextInt());
			switch (getMenuLivro()){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				Menu.exibirMenu(); //Volta ao menu principal
				break;
			default:
				//Console.clear();
				System.out.println("Opção inválida!\n");
				break;
			}
		}while(getMenuLivro() < 1 || getMenuLivro() > 4);
		
	}
}
