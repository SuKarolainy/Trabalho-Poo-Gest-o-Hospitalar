/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.atendimento;

import com.mycompany.projetopoo.pessoas.Entity;
import com.mycompany.projetopoo.pessoas.Paciente;
import java.time.LocalDateTime;

/**
 *
 * @author suKarolainy
 */
public class Atendimento extends Entity{
    private LocalDateTime horarioAtendimento;
    private Triagem triagem;
    private Consulta consulta;
    private Paciente paciente;

    public Atendimento(Long id) {
        super(id);
    }
    
 //atend tem chave estrangeira de paciente, triagem e consulta
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Atendimento() {
    }

    public Atendimento(LocalDateTime horarioAtendimento, Triagem triagem, Consulta consulta, Paciente paciente) {
        this.horarioAtendimento = horarioAtendimento;
        this.triagem = triagem;
        this.consulta = consulta;
        this.paciente = paciente;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public LocalDateTime getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(LocalDateTime horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Atendimento{" 
                + "horarioAtendimento=" + horarioAtendimento 
                + ", triagem=" + triagem 
                + ", consulta=" + consulta 
                + ", paciente=" + paciente 
                + '}';
    }
}
