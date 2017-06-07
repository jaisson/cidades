/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.OcupacaoDAO;

/**
 *
 * @author linuxifrs
 */
public class Ocupacao {

  private Integer codigo;
  private String descricao;

  public Ocupacao() {
  }

  public Ocupacao(Integer codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public int hash(int key) {
    return key % (OcupacaoDAO.getTotalOcupacao() / 10);
  }
}
