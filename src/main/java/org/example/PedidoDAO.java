package org.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {

    public void inserir(String cliente, Date data_pedido, double total) {
        String sql = "INSERT INTO pedidos (cliente, data_pedido, total) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente);
            stmt.setDate(2, data_pedido);
            stmt.setDouble(3, total);
            stmt.executeUpdate();

            System.out.println("Pedido inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarTotal(int id, double novoTotal) {
        String sql = "UPDATE pedidos SET total = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, novoTotal);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("Valor total atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPedido(int id) {
        String sql = "DELETE FROM pedidos WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Pedido deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
