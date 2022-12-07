/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.Pessoas;

/**
 *
 * @author suKarolainy
 */
public abstract class Entidade {
    /**
     * Identidade da entidade (chave primária mapeada para o banco de dados)
     */
    private Long id;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    /**
     * Construtor padrão.
     */
    public Entidade() {
    }

    /**
     * Construtor sobrecarregado.
     *
     * @param id Identidade da entidade
     */
    public Entidade(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
