/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projetopoo;
import com.mycompany.projetopoo.Consulta.Atendimento;
import com.mycompany.projetopoo.Consulta.Triagem;
import com.mycompany.projetopoo.Dados.LocalDateTime;

import com.mycompany.projetopoo.Dados.Pessoa;
import com.mycompany.projetopoo.Pessoas.Paciente;

/**
 *
 * @author ho.aecsky
 */
public class ProjetoPOO {

    public static void main(String[] args) {
        Atendimento atendimento =  new Atendimento();
        Triagem triagem = new Triagem();
        triagem.setDoenças("diabetes");
        triagem.setRemediosUsoContinuo("insulina");
        //atendimento.getTriagem().getDoenças();
        //atendimento.getTriagem().getRemediosUsoContinuo();
        System.out.println("Detalhes do atendimento: " + atendimento.getTriagem());
        System.out.println("O paciente tem: " + triagem.getDoenças());
                
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Ana");
        
        Paciente paciente = new Paciente();
        //paciente.getPessoa().getNome();
        System.out.println("Nome do paciente: " + pessoa.getNome());
        //System.out.println("Nome do paciente: " + paciente.getPessoa());
    }
}
