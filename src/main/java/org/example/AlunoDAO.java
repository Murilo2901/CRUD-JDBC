package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {

    public void inserir(String nome, String matricula, String curso){
        String sql = "INSERT INTO alunos (nome, matricula, curso) Values (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, nome);
            stmt.setString(2, matricula);
            stmt.setString(3, curso);
            stmt.executeUpdate();

            System.out.println("Aluno(a) inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}