/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Ocupacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linuxifrs
 */
public class OcupacaoDAO {

  public static Integer getTotalOcupacao() {
    Integer totalRg = 0;
    try {
      Connection conn = Conexao.createConnection();

      String sql = "SELECT COUNT(*) TOTAL FROM OCUPACAO";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        totalRg = rs.getInt("TOTAL");
      }

      rs.close();
      ps.close();
      conn.close();
    } catch (SQLException ex) {
      Logger.getLogger(OcupacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return totalRg;
  }

  public ArrayList<Ocupacao> getAllOcupacao() {
    ArrayList<Ocupacao> ocupacoes = new ArrayList<>();
    try {
      Connection conn = Conexao.createConnection();

      String sql = "SELECT CODIGO, DESCRICAO FROM OCUPACAO";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        ocupacoes.add(new Ocupacao(rs.getInt("CODIGO"), rs.getString("DESCRICAO")));
      }

      rs.close();
      ps.close();
      conn.close();
    } catch (SQLException ex) {
      Logger.getLogger(OcupacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ocupacoes;
  }
}
