/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoj4;

import arquivos.CandidatoCSV;
import arquivos.OcupacaoCSV;
import dao.CandidatoDAO;
import dao.OcupacaoDAO;

/**
 *
 * @author linuxifrs
 */
public class AlgoritmoJ4 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    OcupacaoDAO ocupacaoDAO = new OcupacaoDAO();
    OcupacaoCSV.criarOcupacaoCSVS(ocupacaoDAO.getAllOcupacao());

    CandidatoDAO candidatoDAO = new CandidatoDAO();
    CandidatoCSV.criarCandidatoCVS(candidatoDAO.getAllCandidato());

  }

}
