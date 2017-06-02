/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import bean.Ocupacao;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linuxifrs
 */
public class OcupacaoCSV {

  public static void criarOcupacaoCSVS(ArrayList<Ocupacao> ocupacoes) {
    try {
      FileWriter writer = new FileWriter(new File(new File("").getCanonicalPath() + "/arquivos/") + "ocupacao.csv");

      for (Ocupacao ocupacao : ocupacoes) {
        writer.write(ocupacao.getCodigo() + ";" + ocupacao.getDescricao() + "\n");
      }
      writer.close();
    } catch (IOException ex) {
      Logger.getLogger(CandidatoCSV.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
