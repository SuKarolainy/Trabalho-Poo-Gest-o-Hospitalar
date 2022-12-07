/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.Dados;

/**
 *
 * @author suKarolainy
 */
public class Endereço {
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private Integer numero;
    private String complemento;

    public Endereço() {
    }

    public Endereço(String pais, String estado, String cidade, String bairro, String logradouro, Integer numero, String complemento) {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }


    @Override
    public String toString(){
        return "endereço{"
                + "pais=" + pais
                + ",estado=" + estado
                + ",cidade=" + cidade
                + ",bairro=" + bairro
                + ",logradouro=" + logradouro
                + ",numero" + numero
                + ",complemento=" + complemento
                + '}';
    }
}
    

