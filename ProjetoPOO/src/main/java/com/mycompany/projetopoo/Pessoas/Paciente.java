/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.Pessoas;

import com.mycompany.projetopoo.Dados.Pessoa;
import java.time.LocalDate;

/**
 *
 * @author suKarolainy
 */
public class Paciente extends Pessoa{

    private Pessoa pessoa;
    private String profissao;
    private String tipoSanguineo;
    private String alergia;
    private String doencasCronicas;
    private String remediosControlados;
    private boolean estado;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void getDataNascimento(String text) {
        this.setDataNascimento(LocalDate.MIN.now());
    }

    public Paciente() {
    }

    public Paciente(String profissao, String tipoSanguineo, String alergia, String doencasCronicas, String remediosControlados, boolean estado) {
        this.profissao = profissao;
        this.tipoSanguineo = tipoSanguineo;
        this.alergia = alergia;
        this.doencasCronicas = doencasCronicas;
        this.remediosControlados = remediosControlados;
        this.estado = estado;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getTipoSanguineo(String text) {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getAlergia(java.lang.String text) {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getDoencasCronicas() {
        return doencasCronicas;
    }

    public void setDoencasCronicas(String doencasCronicas) {
        this.doencasCronicas = doencasCronicas;
    }

    public String getRemediosControlados() {
        return remediosControlados;
    }

    public void setRemediosControlados(String remediosControlados) {
        this.remediosControlados = remediosControlados;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
