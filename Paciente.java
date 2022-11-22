/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.Pessoas;
import com.mycompany.projetopoo.Dados.Pessoa;
import com.mycompany.projetopoo.Dados.Endereço;
import com.mycompany.projetopoo.Dados.Comunicação;
/**
 *
 * @author ho.aecsky
 */
public class Paciente {
    private Pessoa pessoa;
    private Endereço endereço;
    private Comunicação comunicação;

    public Paciente() {
    }

    public Paciente(Pessoa pessoa, Endereço endereço, Comunicação comunicação) {
        this.pessoa = pessoa;
        this.endereço = endereço;
        this.comunicação = comunicação;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereço getEndereço() {
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        this.endereço = endereço;
    }

    public Comunicação getComunicação() {
        return comunicação;
    }

    public void setComunicação(Comunicação comunicação) {
        this.comunicação = comunicação;
    }
    
    @Override
    public String toString(){
        return "Paciente{"
                +"nome=" + nome
                +",cpf=" + cpf
                +",dataNascimento=" + dataNascimento
                +",idade=" + idade
                + '}';
    }
}
