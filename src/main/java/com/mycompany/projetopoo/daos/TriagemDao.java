/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.daos;

import com.mycompany.projetopoo.atendimento.Triagem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suKarolainy
 */
public class TriagemDao extends Dao<Triagem> {
    public static final String TABLE = "triagem";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE
                + " (id, tipoSanguineo, alergias, doencasCronicas, medicamentosControlados, motivoAtendimento, prioridadeAtendimento)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE
                + " set id =?, tipoSanguineo = ?, alergias = ?, doencasCronicas = ?, medicamentosControlados = ?, motivoAtendimento = ?, prioridadeAtendimento = ?"
                + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Triagem e) {
        try {
            pstmt.setLong(1, e.getId());
            pstmt.setString(2, e.getTipoSanguineo());
            pstmt.setString(3, e.getAlergias());
            pstmt.setString(4, e.getDoencasCronicas());
            pstmt.setString(5, e.getMedicamentosControlados());
            pstmt.setString(6, e.getMotivoAtendimento());
            pstmt.setString(7, e.getPrioridadeAtendimento());

            if (e.getId() != null && e.getId() > 0) {
                pstmt.setLong(3, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TriagemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, tipoSanguineo, alergias, doencasCronicas, medicamentosControlados, motivoAtendimento, prioridadeAtendimento"
                + " from " + TABLE
                + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, tipoSanguineo, alergias, doencasCronicas, medicamentosControlados, motivoAtendimento, prioridadeAtendimento"
                + " from " + TABLE;
    }

    private String getfindAllByPartialNameStatment() {
        return " select id, tipoSanguineo, alergias, doencasCronicas, medicamentosControlados, motivoAtendimento, prioridadeAtendimento"
                + " from " + TABLE
                + " where nome like ?";
    }
    
    public List<Triagem> findAllByPartialName(String partialName) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getfindAllByPartialNameStatment())) {

            preparedStatement.setString(1, "%" + partialName + "%");

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object
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

    /**
     * Extracts the movie from the result set with the associated genre
     *
     * @param resultSet The record in the database
     * @return The movie located
     */
    @Override
    public Triagem extractObject(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                return new Triagem (
                                                resultSet.getString("tipoSanguineo"),
                        resultSet.getString("alergias"),
                        resultSet.getString("doencasCronicas"),
                        resultSet.getString("medicamentosControlados"),
                        resultSet.getString("motivoAtendimento"),
                        resultSet.getString("prioridadeAtendimento")
                );
            } catch (SQLException ex) {
                Logger.getLogger(TriagemDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

}

