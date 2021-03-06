/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidades.dao;

import cidades.bean.Cidade;
import cidades.bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author linuxifrs
 */
public class ClienteDAO {

  public static void inserirClientes(List<Cidade> cidades) {
    try {
      String sql = "insert into cliente (matricula, nome, nascimento, cidade) values (?, ?, ?, ?)";
      try (Connection conn = Conexao.createConnection()) {
        conn.setAutoCommit(false);
        try (PreparedStatement psmt = conn.prepareStatement(sql)) {
          for (Cidade cidade : cidades) {
            Integer cid = cidade.getCodigo();
            List<Cliente> clientes = cidade.getClientes();
            for (Cliente cliente : clientes) {
              psmt.setInt(1, cliente.getMatricula());
              psmt.setString(2, cliente.getNome());
              psmt.setDate(3, cliente.getNascimento());
              psmt.setInt(4, cid);
              psmt.addBatch();
            }
          }

          psmt.executeBatch();
        }
        conn.commit();
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      System.out.println(ex.getNextException());
    }
  }
}
