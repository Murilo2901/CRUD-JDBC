package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {

    public void inserir(String nome, String matricula, String curso){
        String sql = "INSERT INTO alunos (nome, matricula, curso) VALUES (?,?,?)";

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

    public void atualizarCurso(String matricula, String novoCurso) {
        String sql = "UPDATE alunos SET curso = ? WHERE matricula = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoCurso);
            stmt.setString(2, matricula);
            stmt.executeUpdate();

            System.out.println("Curso atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarAluno(String matricula) {
        String sql = "DELETE FROM alunos WHERE matricula = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matricula);
            stmt.executeUpdate();

            System.out.println("Aluno deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
