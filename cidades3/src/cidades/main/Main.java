/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidades.main;

import cidades.bean.Cidade;
import cidades.dao.PopulaBD;
import cidades.dao.PopulaBDImpl;
import cidades.xml.LerXML;
import cidades.xml.LerXMLImpl;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author linuxifrs
 */
public class Main {

  public static void main(String[] args) {
    JFileChooser chooserArquivo = new JFileChooser();
    int escolha = chooserArquivo.showOpenDialog(chooserArquivo.getParent());
    String arquivo = chooserArquivo.getSelectedFile().getAbsolutePath();
    
    System.out.println("Lendo o XML");
    LerXML lx = new LerXMLImpl();
    List<Cidade> cidades = lx.lerCidades(arquivo);
    
    for(Cidade cidade : cidades) {
      System.out.println(cidade.getNome());
    }

    System.out.println("Inserindo no arquivo");
    PopulaBD pb = new PopulaBDImpl();
    pb.populaBD(cidades);
  }
}
