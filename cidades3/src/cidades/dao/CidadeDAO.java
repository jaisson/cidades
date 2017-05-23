/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidades.dao;

import cidades.bean.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linuxifrs
 */
public class CidadeDAO {

  public static void inserirCidades(List<Cidade> cidades) {
    try {
      String sql = "insert into cidade (codigo, nome, uf) values (?, ?, ?)";
      try (Connection conn = Conexao.createConnection()) {
        conn.setAutoCommit(false);
        try (PreparedStatement psmt = conn.prepareStatement(sql)) {
          for (Cidade cidade : cidades) {
            psmt.setInt(1, cidade.getCodigo());
            psmt.setString(2, cidade.getNome());
            psmt.setString(3, cidade.getUf());
            psmt.addBatch();
          }
          psmt.executeBatch();
          conn.commit();
        }
        conn.close();

        System.out.println("inserir cliente");
        ClienteDAO.inserirClientes(cidades);

      }
    } catch (SQLException ex) {
      Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
