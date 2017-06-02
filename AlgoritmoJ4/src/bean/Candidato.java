/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Date;

/**
 *
 * @author linuxifrs
 */
public class Candidato {

  private String sequencial;
  private String nome;
  private String cpf;
  private String sexo;
  private Date dtNascimento;
  private Integer ocupacao;

  public Candidato() {
  }

  public Candidato(String sequencial, String nome, String cpf, String sexo, Date dtNascimento, Integer ocupacao) {
    this.sequencial = sequencial;
    this.nome = nome;
    this.cpf = cpf;
    this.sexo = sexo;
    this.dtNascimento = dtNascimento;
    this.ocupacao = ocupacao;
  }

  public String getSequencial() {
    return sequencial;
  }

  public void setSequencial(String sequencial) {
    this.sequencial = sequencial;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public Date getDtNascimento() {
    return dtNascimento;
  }

  public void setDtNascimento(Date dtNascimento) {
    this.dtNascimento = dtNascimento;
  }

  public Integer getOcupacao() {
    return ocupacao;
  }

  public void setOcupacao(Integer ocupacao) {
    this.ocupacao = ocupacao;
  }

}
