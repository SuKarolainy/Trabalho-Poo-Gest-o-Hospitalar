/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.daos;

import com.mycompany.projetopoo.pessoas.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Suellen, Lorena, Emerson;
 */
public class PacienteDao
        extends Dao<Paciente> {

    public static final String TABLE = "paciente";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE
                + " (nome, cpf, dataNascimento, telefone, email)"
                + " values (?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE
                + " set nome = ?, cpf = ?, dataNascimento = ?, telefone = ?, email = ?"
                + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Paciente e) {
        try {
            pstmt.setString(1, e.getNome());
            pstmt.setString(2, e.getCpf());
//            pstmt.setString(3, e.getDataNascimento()); // converter LocalDate para String ???
            pstmt.setString(4, e.getTelefone());
            pstmt.setString(5, e.getEmail());

            if (e.getId() != null && e.getId() > 0) {
                pstmt.setLong(6, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, nome, cpf, dataNascimento, telefone, email"
                + " from " + TABLE
                + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, nome, cpf, dataNascimento, telefone, email"
                + " from " + TABLE;
    }

    private String getfindAllByPartialNameStatment() {
        return " select id, nome, cpf, dataNascimento, telefone, email"
                + " from " + TABLE
                + " where nome like ?";
    }
    
    public List<Paciente> findAllByPartialName(String partialName) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getfindAllByPartialNameStatment())) {

            preparedStatement.setString(1, "%" + partialName + "%");

            System.out.println(">> SQL: " + preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            return extractObjects(resultSet);

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }

    @Override
    public String getMoveToTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getRestoreFromTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getFindAllOnTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Paciente extractObject(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                return new Paciente (
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
//                        resultSet.getDate("dataNascimento"), //converter LocalDate para String ??
                        resultSet.getString("telefone"),
                        resultSet.getString("email")
                );
            } catch (SQLException ex) {
                Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

}

