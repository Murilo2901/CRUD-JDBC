package org.example;

import java.sql.Connection;
import java.util.Scanner;
//import java.sql.Date;
//import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.conectar()) {
            if (conn != null) {
                System.out.println("Conexão realizada com sucesso!");
            } else {
                System.out.println("Falha na conexão.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner Sc = new Scanner(System.in);

        System.out.println("Digite o nome do funcionário:");
        String nome = Sc.nextLine();

        System.out.println("Digite o cargo:");
        String cargo = Sc.nextLine();

        System.out.println("Digite o salário:");
        double salario = Sc.nextDouble();

        FuncionarioDAO dao = new FuncionarioDAO();
        dao.inserir(nome, cargo, salario);

        Sc.close();
    }
}