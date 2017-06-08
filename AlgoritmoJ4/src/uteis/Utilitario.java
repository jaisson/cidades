/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author linuxifrs
 */
public class Utilitario {

  public static String removeAcentos(String texto) {
    Pattern regra = Pattern.compile("[\\p{Alnum} ]");
    String saida = "";
    for (int i = 0; i < texto.length(); i++) {
      Matcher mt = regra.matcher(Character.toString(texto.charAt(i)));
      if (mt.matches()) {
        saida += mt.group();
      } else {
        if (!(Character.isLetter(texto.charAt(i)))) {
          continue;
        }

        String aux = Character.toString(texto.charAt(i));
        boolean upperCaseFlag = false;
        if (Character.isUpperCase(aux.charAt(0))) {
          upperCaseFlag = true;
          aux = aux.toLowerCase();
        }
        aux = aux.replace('à', 'a');
        aux = aux.replace('è', 'e');
        aux = aux.replace('ì', 'i');
        aux = aux.replace('ò', 'o');
        aux = aux.replace('ù', 'u');
        aux = aux.replace('á', 'a');
        aux = aux.replace('é', 'e');
        aux = aux.replace('í', 'i');
        aux = aux.replace('ó', 'o');
        aux = aux.replace('ú', 'u');
        aux = aux.replace('â', 'a');
        aux = aux.replace('ê', 'e');
        aux = aux.replace('î', 'i');
        aux = aux.replace('ô', 'o');
        aux = aux.replace('û', 'u');
        aux = aux.replace('ã', 'a');
        aux = aux.replace('õ', 'o');
        aux = aux.replace('ä', 'a');
        aux = aux.replace('ë', 'e');
        aux = aux.replace('ï', 'i');
        aux = aux.replace('ö', 'o');
        aux = aux.replace('ü', 'u');
        aux = aux.replace('ç', 'c');
        if (upperCaseFlag) {
          aux = aux.toUpperCase();
        }
        saida += aux;
      }
    }
    return saida;
  }

  public static String formatarString(String cpfCnpj) {
    JFormattedTextField cnpj_cpf = new javax.swing.JFormattedTextField();

    String valor = cpfCnpj.replaceAll("\\.", "").replaceAll("-", "").replaceAll("/", "").replaceAll(" ", "");
    if (valor.length() == 11) {
      try {
        cnpj_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
      } catch (ParseException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
      }
    } else {
      try {
        cnpj_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
      } catch (ParseException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
      }
    }
    cnpj_cpf.setText(valor);

    return cnpj_cpf.getText();
  }
}
