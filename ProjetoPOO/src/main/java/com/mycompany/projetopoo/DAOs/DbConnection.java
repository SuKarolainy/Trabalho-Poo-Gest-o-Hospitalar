/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.DAOs;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author suKarolainy
 */

// db>> sql.freedb.tech/3306/freedb_gestao
//user: freedb_gestaoadmin
//senha: 6$vH343YC6&mD&h
public class DbConnection {
    
    /**
     * URL de conexão com o banco de dados
     * (protocolo/sgbd/ip/porta/banco/parâmetros).
     */
    public static final String URL;

    /**
     * Retém a conexão estabelecida com o banco de dados durante a operação do
     * sistema.
     */
    private static Connection conexao;

    /**
     * Usuário para acesso ao banco de dados.
     */
    private static String usuario;

    /**
     * Senha para acesso ao banco de dados.
     */
    private static String senha;

    /**
     * Inicialização de valores estáticos.
     */
    static {
        if (false) {
            // Servidor Local
            URL = "jdbc:mysql://127.0.0.1:3306/tarefas"
                    + "?useUnicode=true"
                    + "&useJDBCCompliantTimezoneShift=true"
                    + "&serverTimezone=UTC"
                    + "&autoReconnect=true";
            usuario = "root";
            senha = "";

        } else {
            // Servidor remoto
            Properties prop = new Properties();
            String propFileName = "bd.properties";

            InputStream inputStream = DbConnection.class.getClassLoader()
                    .getResourceAsStream(propFileName);

            if (inputStream != null) {
                try {
                    prop.load(inputStream);
                } catch (IOException ex) {
                    Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("Arquivo de propriedades '" + propFileName
                        + "' não encontrado no classpath");
                System.exit(0);
            }

            URL = prop.getProperty("url");
            usuario = prop.getProperty("user");
            senha = prop.getProperty("password");
        }

    }

    //<editor-fold defaultstate="collapsed" desc="Construtor privado">
    /**
     * Construtor privado para forçar acesso à conexão pelo membro estático
     * <code>getConexao()</code> sem que sejam gerados novos objetos
     * "ConexaoBd".
     */
    private DbConnection() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        DbConnection.usuario = usuario;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        DbConnection.senha = senha;
    }
    //</editor-fold>

    /**
     * Estabele e gera a retenção da conexão com o banco de dados.
     *
     * @return Conexão com o banco de dados.
     */
    public static Connection getConexao() {

        // Se não há uma conexão estabelecida...
        if (conexao == null) {
            // ... tenta ...
            try {
                // ... estabelecer e reter a conexão a partir da URL, 
                // do usuário e da senha fornecidos
                conexao = DriverManager.getConnection(URL, usuario, senha);
            } catch (SQLException ex) {
                // TODO Rever procedimento e encerrar o programa em caso de falha
                // Caso ocorra alguma falha, registra falha
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Devolve a conexão estabelecida
        return conexao;

    }
}
