/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.daos;

import com.mycompany.projetopoo.pessoas.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suellen, Lorena, Emerson;
 */
public class MedicoDao extends Dao<Medico>{
        public static final String TABLE = "medicos";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE
                + " (id, nome, cpf, dataNascimento, telefone, email, crm, especialidade)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE
                + " set id = ?, nome = ?, cpf = ?, dataNascimento = ?, telefone = ?, email = ?, crm = ?, especialidade = ?"
                + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Medico e) {
        try {
            pstmt.setLong(1, e.getId());
            pstmt.setString(2, e.getNome());
            pstmt.setString(3, e.getCpf());
            pstmt.setLocalDate(4, e.getDataNascimento());
            pstmt.setString(5, e.getTelefone());
            pstmt.setString(6, e.getEmail());
            pstmt.setString(7, e.getCrm());
            pstmt.setString(8, e.getEspecialidade());

            if (e.getId() != null && e.getId() > 0) {
                pstmt.setLong(6, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, nome, cpf, dataNascimento, telefone, email, crm, especialidade"
                + " from " + TABLE
                + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, nome, cpf, dataNascimento, telefone, email, crm, especialidade"
                + " from " + TABLE;
    }

    private String getfindAllByPartialNameStatment() {
        return " select id, nome, cpf, dataNascimento, telefone, email, crm, especialidade"
                + " from " + TABLE
                + " where nome like ?";
    }
    
    public List<Medico> findAllByPartialName(String partialName) {

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
    public Medico extractObject(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                return new Medico (
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getDate("dataNascimento"), //converter LocalDate para String ??
                        resultSet.getString("telefone"),
                        resultSet.getString("email"),
                        resultSet.getString("crm"),
                        resultSet.getString("especialidade")
                );
            } catch (SQLException ex) {
                Logger.getLogger(MedicoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

}
