/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidades.bean;

import java.util.List;

/**
 *
 * @author linuxifrs
 */
public class Cidade {

  private Integer codigo;
  private String nome;
  private String uf;
  private List<Cliente> clientes;

  public Cidade() {
  }

  public Cidade(Integer codigo, String nome, String uf, List<Cliente> clientes) {
    this.codigo = codigo;
    this.nome = nome;
    this.uf = uf;
    this.clientes = clientes;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public List<Cliente> getClientes() {
    return clientes;
  }

  public void setClientes(List<Cliente> clientes) {
    this.clientes = clientes;
  }

}
