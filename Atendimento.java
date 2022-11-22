/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.Consulta;
import com.mycompany.projetopoo.Pessoas.Funcionário;
import com.mycompany.projetopoo.Dados.LocalDateTime;
/**
 *
 * @author ho.aecsky
 */
public class Atendimento {
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Funcionário quemRecepcionouPaciente;
    private Triagem triagem;
    private Tratamento tratamento;

    public Atendimento() {
    }
    
    
    public Atendimento(LocalDateTime entrada, LocalDateTime saida, Funcionário quemRecepcionouPaciente, Triagem triagem, Tratamento tratamento) {
        this.entrada = entrada;
        this.saida = saida;
        this.quemRecepcionouPaciente = quemRecepcionouPaciente;
        this.triagem = triagem;
        this.tratamento = tratamento;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public Funcionário getQuemRecepcionouPaciente() {
        return quemRecepcionouPaciente;
    }

    public void setQuemRecepcionouPaciente(Funcionário quemRecepcionouPaciente) {
        this.quemRecepcionouPaciente = quemRecepcionouPaciente;
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }
    
}
