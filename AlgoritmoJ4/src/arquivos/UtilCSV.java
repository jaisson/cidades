/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linuxifrs
 */
public class UtilCSV {

  public static void salvar(String arquivo, String conteudo, boolean adicionar) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(arquivo, adicionar);
      PrintWriter pw = new PrintWriter(fw);
      pw.println(conteudo);
      pw.flush();
      pw.close();
    } catch (IOException ex) {
      Logger.getLogger(UtilCSV.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        fw.close();
      } catch (IOException ex) {
        Logger.getLogger(UtilCSV.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
