/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import bean.Ocupacao;
import java.util.ArrayList;
import uteis.Utilitario;

/**
 *
 * @author linuxifrs
 */
public class OcupacaoCSV {

  public static void criarOcupacaoCSVS(ArrayList<Ocupacao> ocupacoes) {
    for (Ocupacao ocupacao : ocupacoes) {
      String conteudo = ocupacao.getCodigo() + ";"
              + Utilitario.removeAcentos(ocupacao.getDescricao());
      UtilCSV.salvar(ocupacao.hash(ocupacao.getCodigo()) + ".csv", conteudo, true);
    }
  }
}
