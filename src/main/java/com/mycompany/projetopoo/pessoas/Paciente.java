/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.pessoas;

import com.mycompany.projetopoo.dados.Endereco;
import com.mycompany.projetopoo.dados.Pessoa;
import java.time.LocalDate;

/**
 *
 * @author suKarolainy
 */
public class Paciente extends Pessoa{

    public Paciente(Long id, String nome, String cpf, LocalDate dataNascimento, String telefone, String email) {
        super(id, nome, cpf, dataNascimento, telefone, email);
    }
    
    public void getDataNascimento(String text) {
        this.setDataNascimento(LocalDate.MIN.now());
    }

    public void setDataNascimento(LocalDate now) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
