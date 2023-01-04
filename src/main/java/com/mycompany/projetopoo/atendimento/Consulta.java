/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.atendimento;

import com.mycompany.projetopoo.pessoas.Medico;
import java.time.LocalDateTime;

/**
 *
 * @author suKarolainy
 */
public class Consulta {
    private LocalDateTime entrada;
    private LocalDateTime alta;
    private Medico medicoResponsavel;
    private String examesRealizados;

    public Consulta() {
    }

    public Consulta(LocalDateTime entrada, LocalDateTime alta, Medico medicoResponsavel, String examesRealizados) {
        this.entrada = entrada;
        this.alta = alta;
        this.medicoResponsavel = medicoResponsavel;
        this.examesRealizados = examesRealizados;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getAlta() {
        return alta;
    }

    public void setAlta(LocalDateTime alta) {
        this.alta = alta;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public String getExamesRealizados() {
        return examesRealizados;
    }

    public void setExamesRealizados(String examesRealizados) {
        this.examesRealizados = examesRealizados;
    }
    
    @Override
    public String toString() {
        return "Consulta{" 
                + "entrada=" + entrada 
                + ", alta=" + alta 
                + ", medicoResponsavel=" + medicoResponsavel 
                + ", examesRealizados=" + examesRealizados 
                + '}';
    }


}
