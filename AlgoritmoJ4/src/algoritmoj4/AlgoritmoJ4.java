/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoj4;

import arquivos.OcupacaoCSV;
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
    //CandidatoDAO candidatoDAO = new CandidatoDAO();
    //CandidatoCSV.criarCandidatoCVS(candidatoDAO.getAllCandidato());

    OcupacaoDAO ocupacaoDAO = new OcupacaoDAO();
    OcupacaoCSV.criarOcupacaoCSVS(ocupacaoDAO.getAllOcupacao());

  }

}
