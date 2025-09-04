package org.example;

import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.conectar()) {
            if (conn != null) {
                System.out.println("✅ Conexão realizada com sucesso!");
            } else {
                System.out.println("❌ Falha na conexão.");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Gerenciar Alunos");
            System.out.println("2 - Gerenciar Produtos");
            System.out.println("3 - Gerenciar Pedidos");
            System.out.println("4 - Gerenciar Livros");
            System.out.println("5 - Gerenciar Funcionários");
            System.out.println("6 - Gerenciar Usuários");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> menuAluno(sc);
                case 2 -> menuProduto(sc);
                case 3 -> menuPedido(sc);
                case 4 -> menuLivro(sc);
                case 5 -> menuFuncionario(sc);
                case 6 -> menuUsuario(sc);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void menuAluno(Scanner sc) {
        AlunoDAO dao = new AlunoDAO();
        System.out.println("\n--- MENU ALUNO ---");
        System.out.println("1 - Inserir");
        System.out.println("2 - Atualizar Curso");
        System.out.println("3 - Deletar");
        System.out.print("Escolha: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Matrícula: ");
                String matricula = sc.nextLine();
                System.out.print("Curso: ");
                String curso = sc.nextLine();
                dao.inserir(nome, matricula, curso);
            }
            case 2 -> {
                System.out.print("Matrícula: ");
                String matricula = sc.nextLine();
                System.out.print("Novo curso: ");
                String curso = sc.nextLine();
                dao.atualizarCurso(matricula, curso);
            }
            case 3 -> {
                System.out.print("Matrícula: ");
                String matricula = sc.nextLine();
                dao.deletarAluno(matricula);
            }
        }
    }

    private static void menuProduto(Scanner sc) {
        ProdutoDAO dao = new ProdutoDAO();
        System.out.println("\n--- MENU PRODUTO ---");
        System.out.println("1 - Inserir");
        System.out.println("2 - Atualizar Preço");
        System.out.println("3 - Deletar");
        System.out.print("Escolha: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Preço: ");
                double preco = sc.nextDouble();
                System.out.print("Quantidade: ");
                int qtd = sc.nextInt();
                dao.inserir(nome, preco, qtd);
            }
            case 2 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Novo preço: ");
                double preco = sc.nextDouble();
                dao.atualizarPreco(nome, preco);
            }
            case 3 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                dao.deletarProduto(nome);
            }
        }
    }

    private static void menuPedido(Scanner sc) {
        PedidoDAO dao = new PedidoDAO();
        System.out.println("\n--- MENU PEDIDO ---");
        System.out.println("1 - Inserir");
        System.out.println("2 - Atualizar Total");
        System.out.println("3 - Deletar");
        System.out.print("Escolha: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Cliente: ");
                String cliente = sc.nextLine();
                System.out.print("Data (AAAA-MM-DD): ");
                String dataStr = sc.nextLine();
                Date data = Date.valueOf(dataStr);
                System.out.print("Valor total: ");
                double total = sc.nextDouble();
                dao.inserir(cliente, data, total);
            }
            case 2 -> {
                System.out.print("ID do pedido: ");
                int id = sc.nextInt();
                System.out.print("Novo total: ");
                double total = sc.nextDouble();
                dao.atualizarTotal(id, total);
            }
            case 3 -> {
                System.out.print("ID do pedido: ");
                int id = sc.nextInt();
                dao.deletarPedido(id);
            }
        }
    }

    private static void menuLivro(Scanner sc) {
        LivroDAO dao = new LivroDAO();
        System.out.println("\n--- MENU LIVRO ---");
        System.out.println("1 - Inserir");
        System.out.println("2 - Atualizar Autor");
        System.out.println("3 - Deletar");
        System.out.print("Escolha: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Título: ");
                String titulo = sc.nextLine();
                System.out.print("Autor: ");
                String autor = sc.nextLine();
                System.out.print("Ano de publicação: ");
                int ano = sc.nextInt();
                dao.inserir(titulo, autor, ano);
            }
            case 2 -> {
                System.out.print("Título: ");
                String titulo = sc.nextLine();
                System.out.print("Novo autor: ");
                String autor = sc.nextLine();
                dao.atualizarAutor(titulo, autor);
            }
            case 3 -> {
                System.out.print("Título: ");
                String titulo = sc.nextLine();
                dao.deletarLivro(titulo);
            }
        }
    }

    private static void menuFuncionario(Scanner sc) {
        FuncionarioDAO dao = new FuncionarioDAO();
        System.out.println("\n--- MENU FUNCIONÁRIO ---");
        System.out.println("1 - Inserir");
        System.out.println("2 - Atualizar Salário");
        System.out.println("3 - Deletar");
        System.out.print("Escolha: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Cargo: ");
                String cargo = sc.nextLine();
                System.out.print("Salário: ");
                double salario = sc.nextDouble();
                dao.inserir(nome, cargo, salario);
            }
            case 2 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Novo salário: ");
                double salario = sc.nextDouble();
                dao.atualizarSalario(nome, salario);
            }
            case 3 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                dao.deletarFuncionario(nome);
            }
        }
    }

    private static void menuUsuario(Scanner sc) {
        UsuarioDAO dao = new UsuarioDAO();
        System.out.println("\n--- MENU USUÁRIO ---");
        System.out.println("1 - Inserir");
        System.out.println("2 - Atualizar Email");
        System.out.println("3 - Deletar");
        System.out.print("Escolha: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                dao.inserir(nome, email);
            }
            case 2 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Novo email: ");
                String email = sc.nextLine();
                dao.atualizarEmail(nome, email);
            }
            case 3 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                dao.deletarUsuario(nome);
            }
        }
    }
}
