/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidades.utilitario;

import cidades.bean.Cidade;
import cidades.bean.Cliente;
import cidades.dao.CidadeDAO;
import cidades.dao.ClienteDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author linuxifrs
 */
public class LerXML {

  public static void main(String[] args) throws JDOMException, IOException, ParseException {
    BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(new File("").getCanonicalPath() + "/clientes.xml"), "ISO-8859-1"));
    SAXBuilder sb = new SAXBuilder();
    Document document = sb.build(lerArq);

    Element cidades = document.getRootElement();

    List elements = cidades.getChildren();

    Iterator i = elements.iterator();
    ArrayList<Cidade> cids = new ArrayList<>();
    ArrayList<Cliente> clis = new ArrayList<>();

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    while (i.hasNext()) {
      Element element = (Element) i.next();
      Integer codigo = Integer.parseInt(element.getAttributeValue("codigo"));
      String nome = element.getAttributeValue("nome");
      String uf = element.getAttributeValue("uf");
      Cidade cidade = new Cidade(codigo, nome, uf);

      cids.add(cidade);

      List clientes = element.getChildren();
      Iterator cli = clientes.iterator();

      while (cli.hasNext()) {
        Element elemCli = (Element) cli.next();
        Integer matricula = Integer.parseInt(elemCli.getChildText("matricula"));
        String nomeCliente = elemCli.getChildText("nome");
        String dataXml = elemCli.getChildText("nascimento");

        java.sql.Date nascimento = new java.sql.Date(format.parse(dataXml).getTime());
        Cliente c = new Cliente(matricula, nomeCliente, nascimento, cidade);

        clis.add(c);
      }
    }

    CidadeDAO.inserirCidades(cids);
    ClienteDAO.inserirClientes(clis);
  }
}
