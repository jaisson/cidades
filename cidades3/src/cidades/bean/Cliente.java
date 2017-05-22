/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidades.bean;

import java.sql.Date;

/**
 *
 * @author linuxifrs
 */
public class Cliente {

  private Integer matricula;
  private String nome;
  private Date nascimento;

  public Integer getMatricula() {
    return matricula;
  }

  public void setMatricula(Integer matricula) {
    this.matricula = matricula;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getNascimento() {
    return nascimento;
  }

  public void setNascimento(Date nascimento) {
    this.nascimento = nascimento;
  }

  public Cliente() {
  }

  public Cliente(Integer matricula, String nome, Date nascimento) {
    this.matricula = matricula;
    this.nome = nome;
    this.nascimento = nascimento;
  }

}
