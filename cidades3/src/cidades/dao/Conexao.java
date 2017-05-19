/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidades.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linuxifrs
 */
public class Conexao {

  private static final String USUARIO = "postgres";
  private static final String SENHA = "postgres";
  private static final String DRIVE = "org.postgresql.Driver";
  private static final String URL = "jdbc:postgresql://localhost:5432/cidades";

  public static Connection createConnection() {
    try {
      Class.forName(DRIVE);
      Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);

      return connection;
    } catch (ClassNotFoundException | SQLException ex) {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}
