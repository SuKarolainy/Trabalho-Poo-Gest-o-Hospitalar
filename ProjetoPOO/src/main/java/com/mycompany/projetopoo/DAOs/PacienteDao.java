/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.DAOs;

import com.mycompany.projetopoo.Pessoas.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suKarolainy
 */
public class PacienteDao extends Dao<Paciente, Long> {
    
    
    @Override
    public String getDeclaracaoInsert() {
        return "INSERT INTO CLIENTE (id, cpf, nome) VALUES (default, ?, ?);";
    }
    @Override
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM CLIENTE WHERE id = ?;";
    }

    @Override
    public String getDeclaracaoSelectTodos() {
        return "SELECT * FROM CLIENTE;";
    }
    
    public String getInformacaoClientes(){
        return "SELECT id, cpf, nome, telefone, endereco FROM CLIENTE;";
    }

    @Override
    public String getDeclaracaoUpdate() {
        return "UPDATE CLIENTE SET cpf = ?, nome = ?;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "DELETE FROM CLIENTE WHERE id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Paciente o) {
        try {
            if (o.getId() == null || o.getId() == 0) {
                pstmt.setString(1, o.getCpf());
                pstmt.setString(2, o.getNome());
            } else {
                pstmt.setString(1, o.getCpf());
                pstmt.setString(2, o.getNome());
                pstmt.setLong(9, o.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Paciente extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem do cliente
        Paciente paciente = new Paciente();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado do cliente a ser mapeado
        try {
            
            paciente.setId(resultSet.getLong("id"));
            paciente.setCpf(resultSet.getString("cpf"));
            paciente.setNome(resultSet.getString("Ana"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve a tarefa mapeada
        return paciente;
    }

    @Override
    public ArrayList<Paciente> extrairObjetos(ResultSet resultSet) {
        // Cria referência para inserção dos clientes a serem mapeadas
        ArrayList<Paciente> pacientes = new ArrayList<>();
        
        // Tenta...
        try {
            // ... entquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem do paciente
                Paciente paciente = new Paciente();

                // Tenta recuperar dados do registro retornado pelo banco 
                // de dados e ajustar o estado do cliente a ser mapeado
                paciente.setId(resultSet.getLong("id"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setNome(resultSet.getString("Ana"));
                
                // Insere o cliente na lista de clientes recuperados
                pacientes.add(paciente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de clientes reconstituídas dos registros do banco 
        // de dados
        return pacientes;
    }
    
    /*
     * Cria lista de objetos Cliente recuperados do banco de dados
     * somente incluindo id, cpf, nome, telefone e endereço
     * @param resultSet Resultado proveniente do banco de dados relacional.
     * @return ArrayList Cliente
     */
    public ArrayList<Paciente> extrairObjetosCliente(ResultSet resultSet) {
        // Cria referência para inserção das tarefas a serem mapeadas
        ArrayList<Paciente> pacientes = new ArrayList<>();
        
        // Tenta...
        try {
            // ... entquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem do cliente
                Paciente paciente = new Paciente();

                // Tenta recuperar dados do registro retornado pelo banco 
                // de dados e ajustar o estado do cliente a ser mapeado
                paciente.setId(resultSet.getLong("id"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setNome(resultSet.getString("Ana"));
                
                // Insere o cliente na lista de clientes recuperados
                pacientes.add(paciente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de clientes reconstituídos dos registros do banco 
        // de dados
        return pacientes;
    }
    
    /**
     * Retorna ArrayList do cliente com seus dados 
     * ( id, cpf, nome, telefone e endereço)
     * @return ArrayList Cliente
     */
    public ArrayList<Paciente> retornaDadosClientes() {

        // Declara referência para reter o(s) objeto(s) a ser(em) recuperado(s)
        ArrayList<Paciente> objetos = new ArrayList<>();

        // Tenta preparar uma sentença SQL para a conexão já estabelecida
        try (PreparedStatement pstmt
                = DbConnection.getConexao().prepareStatement(
                        // Sentença SQL para recuperação de todos os registros
                        getInformacaoClientes())) {

            // Executa o comando SQL
            ResultSet resultSet = pstmt.executeQuery();

            // Extrai objeto(s) do(s) respectivo(s) registro(s) do banco de dados
            objetos = extrairObjetosCliente(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Devolve uma lista vazia (nenhum registro encontrado) 
        // ou a relação de objeto(s) recuperado(s)
        return objetos;
    }

}
