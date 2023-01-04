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
public class Medico extends Pessoa{
    private String crm;
    private String especialidade;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Medico() {
    }

    public Medico(Long id, String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String crm, String especialidade) {
        super(id, nome, cpf, dataNascimento, telefone, email);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    
    
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    //</editor-fold>
    
    @Override
    public String toString() {
        return "Medico{" 
                + "crm=" + crm 
                + ", especialidade=" + especialidade 
                + '}';
    }
}
