# Sistema de Gerenciamento para Livraria - LIBRI
---
## Contextualização 
#### No campo do mini mundo literário, uma livraria funciona como intermediadora entre a editora de livros e o consumidor final. Ela tem o papel de comprar livros da editora e oferecer espaço para venda destes livros para o consumidor, em outras palavras, trabalhando diretamente com o consumo de livros dos clientes. É através da livraria onde se tira dados de preferências, gostos, valores, e entre outras informações que a editora precisa para continuar fabricando. Portanto, para a livraria, faz-se necessário que uma grande quantidade de informações seja organizada a fim de que o gerenciamento desses produtos seja facilitado para um vendedor. Dessa forma podemos agilizar o processo de compra de livros de uma editora e revendê-la para o cliente final. Para este tipo de mini mundo, uma das principais vantagens de se ter um sistema gerenciável é o **estoque**, no qual, é importante ter esse controle dos produtos que estão entrando e saindo do  estabelecimento.
---
## Objetivo
#### Desenvolver um sistema para gerenciamento de uma Livraria com recursos dispostos para o usuário acessar e manipular, com facilidade e agilidade, os produtos comprados, vendidos e o estoque, além de ter visibilidade do lucro obtido.
---
## Descrição de cada funcionalidade
* Cadastro de Livros;
* Alteração de Livros;
* Exclusão de Livros;
* Cadastro de Funcionários;
* Alteração de Funcionários;
* Exclusão de funcionários;
* Controle de estoque de Livros (adição e subtração de unidades);
* Monitoramento de Lucro.
---
## Recursos adotados em cada funcionalidade
* Java 8;
* IDE: Eclipse versão 2020;
* API JavaFX 8;
* Editor gráfico Scene Builder;
* iTextPdf
* Banco de Dados PostgreSQL;
* JDBC.
---
## Classes-entidade e seus atributos
1. Classe Livro{
   * Título;
   * Autor;
   * Código ISBN-10;
   * Código ISBN-13;
   * Páginas;
   * Editora;
   * Estoque;
   * Valor de Compra;
   * Valor de Venda;
   * Idioma;
   * Data de publicação;}
 
2. Classe Funcionário{
   * Nome;
   * Data de nascimento;
   * Gênero;
   * CPF;
   * Cargo;
   * Login;
   * Senha;}

3. Classe Pedido {
   * Livros;
   * Valor;
   * Funcionário;
   * Data;
   * Hora;
   * Operação (compra ou venda);
   * Lucro;}
---
## Arquitetura
#### O sistema será estruturado de acordo com a Arquitetura Modelo-Visão-Controle (MVC), que visa a reutilização de código e separação de conceitos em três camadas interligadas, onde a apresentação dos dados e a interação com o usuário ficam separadas dos métodos de interação com o banco de dados, visando maior organização e agilidade.
---
## Demais informações pertinentes
#### Em geral, as editoras entram em acordo com as livrarias para que o preço de capa do livro seja vendido por 50% a mais para o consumidor final em comparação com o preço que a livraria comprou da editora, ou seja, o valor do livro final é dividido 50% para editora e 50% para a livraria. Essa porcentagem pode variar de editora para editora, no nosso sistema iremos adotar o valor padrão de 50%.
---
## Interface Figma
#### https://www.figma.com/file/ox35LTYdP88FEyejFs7z5l/Libri?node-id=0%3A1
