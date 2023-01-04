/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.daos;

import com.mycompany.projetopoo.dados.Endereco;
import com.mycompany.projetopoo.pessoas.Paciente;
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
public class EnderecoDao extends Dao<Endereco>{
    public static final String TABLE = "endereços";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE
                + " (id, bairro, logradouro, numero, complemento)"
                + " values (?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE
                + " set id = ?, bairro = ?, logradouro = ?, numero = ?, complemento = ?"
                + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Endereco e) {
        try {
            pstmt.setLong(1, e.getId());
            pstmt.setString(2, e.getBairro());
            pstmt.setString(3, e.getLogradouro());
            pstmt.setInt(4, e.getNumero());
            pstmt.setString(5, e.getComplemento());

            if (e.getId() != null && e.getId() > 0) {
                pstmt.setLong(6, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, bairro, logradouro, numero, complemento"
                + " from " + TABLE
                + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, bairro, logradouro, numero, complemento"
                + " from " + TABLE;
    }

    private String getfindAllByPartialNameStatment() {
        return " select id, bairro, logradouro, numero, complemento"
                + " from " + TABLE
                + " where nome like ?";
    }
    
    public List<Endereco> findAllByPartialName(String partialName) {

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

    @Override
    public Endereco extractObject(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                return new Endereco (null,
                        resultSet.getString("bairro"),
                        resultSet.getString("logradouro"),
                        resultSet.getInt("numero"),
                        resultSet.getString("complemento")
                );
            } catch (SQLException ex) {
                Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
}
