/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.Dados;

/**
 *
 * @author ho.aecsky
 */
public class Pessoa {
    private String nome;
    private Long cpf;
    private LocalDateTime dataNascimento;
    private Byte idade;

    public Pessoa() {
    }

    public Pessoa(String nome, Long cpf, LocalDateTime dataNascimento, Byte idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Byte getIdade() {
        return idade;
    }

    public void setIdade(Byte idade) {
        this.idade = idade;
    }
    
    
}
