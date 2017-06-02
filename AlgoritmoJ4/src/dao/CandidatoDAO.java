/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Candidato;
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
public class CandidatoDAO {

  public ArrayList<Candidato> getAllCandidato() {
    ArrayList<Candidato> candidatos = new ArrayList<>();
    try {
      Connection conn = Conexao.createConnection();

      String sql
              = "select c.nome, c.sequencial, "
              + "       c.cpf, c.data_nasc dtnascimento, "
              + "       c.sexo, ce.cod_ocupacao ocupacao \n"
              + "  from candidato c\n"
              + "  join candidato_eleicao ce on (ce.seq_candidato = c.sequencial)\n"
              + "  join eleicao_municipal em on (em.ano = ce.ano_eleicao) "
              + "                           and (em.cod_municipio = ce.cod_municipio)\n"
              + "  join municipio m on (m.codigo = em.cod_municipio)\n"
              + " where m.uf = 'RS'\n"
              + "   and em.ano = 2016;";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        candidatos.add(new Candidato(
                rs.getString("sequencial"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("sexo"),
                rs.getDate("dtnascimento"),
                new Ocupacao(rs.getInt("ocupacao"), "")));
      }

      rs.close();
      ps.close();
      conn.close();
    } catch (SQLException ex) {
      Logger.getLogger(OcupacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return candidatos;
  }
}
