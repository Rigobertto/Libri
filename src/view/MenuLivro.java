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
				cadastrarLivro();
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
	
	public static void cadastrarLivro(){
		LivroBO bo = new LivroBO();
		
		System.out.println();
		System.out.println("----- Digite as informações do livro -----");
		LivroVO livro = new LivroVO();
		System.out.print("Título: ");
		livro.setTitulo(in.nextLine());
		
		System.out.print("Autor: ");
		livro.setAutor(in.nextLine());
		
		System.out.print("Editora: ");
		livro.setEditora(in.nextLine());
		
		System.out.print("Idioma: ");
		livro.setIdioma(in.nextLine());
		
		System.out.print("Quantidade de páginas: ");
		livro.setPaginas(in.nextInt());
		
		System.out.print("Estoque: ");
		livro.setEstoque(in.nextInt());
		
		System.out.print("Data de publicação: ");
		livro.setDataPubli(in.nextLine());
		
		System.out.print("Código ISBN10: ");
		livro.setCodISBN10(in.nextLine());
		
		System.out.print("Código ISBN13: ");
		livro.setCodISBN13(in.nextLine());
		
		System.out.print("Valor de Compra: ");
		livro.setValorCompra(in.nextFloat());
		
		System.out.println("Valor de Venda: ");
		livro.setValorVenda(in.nextFloat());
		
		bo.inserir(livro);
	}
}
