/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidades.xml;

import cidades.bean.Cidade;
import java.util.List;

/**
 *
 * @author linuxifrs
 */
public abstract class LerXML {

  public abstract List<Cidade> lerCidades(String pathXML);
}
