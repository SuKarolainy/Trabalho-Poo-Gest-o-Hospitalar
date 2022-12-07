/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.Pessoas;

import com.mycompany.projetopoo.Dados.Endereço;
import com.mycompany.projetopoo.Dados.Pessoa;
import java.time.LocalDate;

/**
 *
 * @author suKarolainy
 */
public class Enfermeiro extends Pessoa{
    private Pessoa pessoa;
    private String coren;

    public Enfermeiro() {
    }

    public Enfermeiro(Long id, String nome, String cpf, LocalDate dataNascimento, String telefone, String email, Endereço endereço) {
        super(id, nome, cpf, dataNascimento, telefone, email, endereço);
    }

    public Enfermeiro(String coren) {
        this.coren = coren;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
