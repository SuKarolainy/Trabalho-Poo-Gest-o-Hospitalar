/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.Consulta;

/**
 *
 * @author ho.aecsky
 */
public class Triagem {
    private String doenças;
    private String remediosUsoContinuo;

    public Triagem() {
    }

    public Triagem(String doenças, String remediosUsoContinuo) {
        this.doenças = doenças;
        this.remediosUsoContinuo = remediosUsoContinuo;
    }

    public String getDoenças() {
        return doenças;
    }

    public void setDoenças(String doenças) {
        this.doenças = doenças;
    }

    public String getRemediosUsoContinuo() {
        return remediosUsoContinuo;
    }

    public void setRemediosUsoContinuo(String remediosUsoContinuo) {
        this.remediosUsoContinuo = remediosUsoContinuo;
    }
    
}
