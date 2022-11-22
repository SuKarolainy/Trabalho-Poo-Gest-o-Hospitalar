/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.Consulta;
import com.mycompany.projetopoo.Pessoas.Médico;

/**
 *
 * @author ho.aecsky
 */
public class Tratamento {
    private Médico medico;
    private String exames;
    private String medicamentos;

    public Tratamento() {
    }

    public Tratamento(Médico medico, String exames, String medicamentos) {
        this.medico = medico;
        this.exames = exames;
        this.medicamentos = medicamentos;
    }

    public Médico getMedico() {
        return medico;
    }

    public void setMedico(Médico medico) {
        this.medico = medico;
    }

    public String getExames() {
        return exames;
    }

    public void setExames(String exames) {
        this.exames = exames;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
    
}
