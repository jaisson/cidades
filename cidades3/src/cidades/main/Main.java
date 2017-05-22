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

/**
 *
 * @author linuxifrs
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("Lendo o XML");
    LerXML lx = new LerXMLImpl();
    List<Cidade> cidades = lx.lerCidades("caminho para o XML");

    System.out.println("Inserindo no arquivo");
    //PopulaBD pb = new PopulaBDImpl();
    //pb.populaBD(cidades);
  }
}
