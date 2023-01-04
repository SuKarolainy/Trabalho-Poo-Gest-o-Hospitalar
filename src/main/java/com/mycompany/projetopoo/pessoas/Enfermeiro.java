/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.pessoas;

import com.mycompany.projetopoo.dados.Pessoa;
import java.time.LocalDate;

/**
 *
 * @author suKarolainy
 */
public class Enfermeiro extends Pessoa{
    private String coren;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Enfermeiro() {
    }

    public Enfermeiro(String coren) {
        this.coren = coren;
    }

    public Enfermeiro(Long id, String nome, String cpf, LocalDate dataNascimento, String telefone, String email) {
        super(id, nome, cpf, dataNascimento, telefone, email);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }    
    //</editor-fold>
    
    @Override
    public String toString() {
        return "Enfermeiro{" 
                + "coren=" + coren 
                + '}';
    }
}
