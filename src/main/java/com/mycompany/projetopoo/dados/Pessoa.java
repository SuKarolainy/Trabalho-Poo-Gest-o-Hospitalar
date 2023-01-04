/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.dados;

import com.mycompany.projetopoo.pessoas.Entity;
import java.time.LocalDate;

/**
 *
 * @author suKarolainy
 */
public class Pessoa extends Entity{
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    public Endereco endereco;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String cpf, LocalDate dataNascimento, String telefone, String email) {
        super(id);
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
    }

    public Pessoa(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    @Override
    public String toString(){
        return "Pessoa{"
                + ",nome=" + nome
                + ",cpf=" + cpf
                + ",dataNascimento=" + dataNascimento
                + ",telefone=" + telefone
                + ",email=" + email
                + ",endereco=" + endereco
                + '}';
    }
}
