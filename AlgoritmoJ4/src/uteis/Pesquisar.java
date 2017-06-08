/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import bean.Candidato;
import bean.Ocupacao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author linuxifrs
 */
public class Pesquisar {

  public static Candidato buscarCpf(String cpf) {
    Candidato candidato = new Candidato();
    try {

      FileReader fileReader = new FileReader(new File(new File("").getCanonicalPath() + "/candidato.csv"));
      BufferedReader lerArq = new BufferedReader(fileReader);
      String linha = "";
      int qtdPesquisa = 0;
      while ((linha = lerArq.readLine()) != null) {
        String dados[] = linha.split(";");
        String sequencial = dados[0];
        String Nome = dados[1];
        String cpfPesquisa = dados[2];
        String sexo = dados[3];
        int hashOcupcao = Integer.parseInt(dados[6]);
        int ocupcao = Integer.parseInt(dados[5]);

        if (cpfPesquisa.equals(cpf)) {
          JOptionPane.showMessageDialog(null, "Quantidade de Pesquisa: " + qtdPesquisa);
          candidato.setSequencial(sequencial);
          candidato.setNome(Nome);
          candidato.setCpf(cpf);
          candidato.setOcupacao(buscarOcupacao(hashOcupcao, ocupcao));

          return candidato;
        }
        qtdPesquisa++;
      }
    } catch (IOException ex) {
      System.out.println("erro");
    }

    return candidato;
  }

  private static Ocupacao buscarOcupacao(int hashOcupcao, int ocupacao) {
    Ocupacao o = new Ocupacao();
    FileReader fileReader = null;
    try {
      fileReader = new FileReader(new File(new File("").getCanonicalPath() + "/" + hashOcupcao + ".csv"));
      BufferedReader lerArq = new BufferedReader(fileReader);
      String linha = "";
      int qtdPesquisa = 1;
      while ((linha = lerArq.readLine()) != null) {
        String dados[] = linha.split(";");
        int cdOcupacao = Integer.parseInt(dados[0]);
        String dsOcupacao = dados[1];

        if (cdOcupacao == ocupacao) {
          JOptionPane.showMessageDialog(null, "Quantidade de Pesquisa para Ocupação: " + qtdPesquisa);
          JOptionPane.showMessageDialog(null, "Arquivo da Ocupação: " + new File(new File("").getCanonicalPath() + "/" + hashOcupcao + ".csv").toString());
          o.setCodigo(ocupacao);
          o.setDescricao(dsOcupacao);
          return o;
        }
        qtdPesquisa++;
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Pesquisar.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Pesquisar.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        fileReader.close();
      } catch (IOException ex) {
        Logger.getLogger(Pesquisar.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    return o;
  }
}
