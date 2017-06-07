/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import bean.Candidato;
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
public class CandidatoCSV {

  public static void criarCandidatoCVS(ArrayList<Candidato> candidatos) {
    try {
      try (FileWriter writer = new FileWriter(new File(new File("").getCanonicalPath() + "/arquivos/") + "candidato.csv")) {
        for (Candidato candidato : candidatos) {
          writer.write(
                  candidato.getSequencial() + ";"
                  + candidato.getNome() + ";"
                  + candidato.getSexo() + ";"
                  + candidato.getDtNascimento() + ";"
                  + candidato.getOcupacao().getCodigo() + "\n");
        }
      }
    } catch (IOException ex) {
      Logger.getLogger(CandidatoCSV.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
