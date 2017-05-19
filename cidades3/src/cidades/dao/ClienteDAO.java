/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidades.dao;

import cidades.bean.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linuxifrs
 */
public class ClienteDAO {

  public static void inserirClientes(List<Cliente> clientes) {
    try {
      String sql = "insert into cliente (matricula, nome, nascimento, cidade) values (?, ?, ?, ?)";
      try (Connection conn = Conexao.createConnection()) {
        conn.setAutoCommit(false);
        PreparedStatement psmt = conn.prepareStatement(sql);
        for (Cliente cliente : clientes) {
          psmt.setInt(1, cliente.getMatricula());
          psmt.setString(2, cliente.getNome());
          psmt.setDate(3, cliente.getNascimento());
          psmt.setInt(4, cliente.getCidade().getCodigo());
          psmt.addBatch();
        }
        psmt.executeBatch();
        conn.commit();
      } 
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      System.out.println(ex.getNextException());
      //Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}