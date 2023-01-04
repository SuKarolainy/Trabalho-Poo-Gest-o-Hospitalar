/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.dados;

import com.mycompany.projetopoo.pessoas.Entity;

/**
 *
 * @author suKarolainy
 */
public class Endereco extends Entity{
    private String bairro;
    private String logradouro;
    private Integer numero;
    private String complemento;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Endereco() {
    }

    public Endereco(Long id, String bairro, String logradouro, Integer numero, String complemento) {
        super(id);
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
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
        return "Endereco{"
                + ",bairro=" + bairro
                + ",logradouro=" + logradouro
                + ",numero" + numero
                + ",complemento=" + complemento
                + '}';
    }
}
