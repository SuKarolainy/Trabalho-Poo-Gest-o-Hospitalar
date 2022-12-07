/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.DAOs;
import com.mycompany.projetopoo.Pessoas.Entidade;
import com.mycompany.projetopoo.Pessoas.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suKarolainy
 */
public abstract class Dao<Paciente, K> implements IDAO<Paciente, K>{
    public static final String DB = "freedb_gestao";

    /**
     * Executa o procedimento de salvamento (inserção ou atualização) do objeto
     * mapeado no banco de dados.
     *
     * @param o Objeto a ser salvo no banco de dados.
     * @return Valor da chave primária gerada pela inclusão de um novo registro
     * ou mesmo valor da chave primária do objeto original presistido
     * anteriormente.
     */
    @Override
    public K salvar(Paciente o) {

        Long id = 0L;

        // Novo registro
        if (((Entidade) o).getId() == null || ((Entidade) o).getId() == 0) {

            // try-with-resources libera recurso ao final do bloco (PreparedStatement)
            try (PreparedStatement pstmt
                    = DbConnection.getConexao().prepareStatement(
                            // Sentença SQL para inserção de registros
                            getDeclaracaoInsert(),
                            // Especifica que a(s) chave(s) primária(s) devem ser
                            // retornadas como resposta
                            Statement.RETURN_GENERATED_KEYS)) {

                // Prepara a declaração com os dados do objeto passado
                montarDeclaracao(pstmt, o);

                // Executa o comando SQL
                pstmt.executeUpdate();

                // Recupera os resultados da execução: chaves primárias dos registros criados
                ResultSet rs = pstmt.getGeneratedKeys();

                // Se há alguma chave, move para o primeiro registro...
                if (rs.next()) {
                    // TODO Retorno imediato (return ...)?
                    // TODO Repensar a estratégia de uso de K: Integer? String?
                    // ... e recupera o (único) longo retornado
                    id = rs.getLong(1);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            // Atualizar registro
            
            try (PreparedStatement pstmt
                    = DbConnection.getConexao().prepareStatement(
                            // Sentença SQL para atualização de registros
                            getDeclaracaoUpdate())) {

                // Prepara a declaração com os dados do objeto passado
                montarDeclaracao(pstmt, o);
               
                // Executa o comando SQL
                pstmt.executeUpdate();

                // Retorno da mesma id recebida com o objeto para manter
                // compatibilidade com o procedimento do método
                // TODO Retorno imediato (return ...)?
                id = ((Entidade) o).getId();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Cast requerido para adaptação do tipo pois, mesmo que a id seja sempre
        // longa, esse trecho de código não reconhece tal tipo implicitamente
        return (K) id;
    }

    /**
     * Exclui o registro do objeto no banco de dados.
     *
     * @param o Objeto a ser excluído.<br>
     * <i>OBS.: o único valor útil é a identidade do objeto mapeado.</i>
     * @return Condição de sucesso ou falha na exclusão.
     */
    @Override
    public Boolean excluir(Paciente o) {
        // Recupera a identidade (chave primária) do objeto a ser excluído
        Long id = ((Entidade) o).getId();

        // Se há uma identidade válida...
        if (id != null && id != 0) {
            // ... tenta preparar uma sentença SQL para a conexão já estabelecida
            try (PreparedStatement pstmt
                    = DbConnection.getConexao().prepareStatement(
                            // Sentença SQL para exclusão de registros
                            getDeclaracaoDelete())) {

                // Prepara a declaração com os dados do objeto passado
                ajustarIdDeclaracao(pstmt, (K) id);

                // Executa o comando SQL
                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            return false;
        }

        return true;
    }

    /**
     * Recupera um dado objeto mapeado para o banco de dados por meio de sua
     * chave de identidade.
     *
     * @param id Identidade do objeto.
     * @return Objeto segundo registro persistido.
     */
    @Override
    public Paciente localizarPorId(K id) {
        // Declara referência para reter o objeto a ser recuperado
        Paciente objeto = null;

        // Tenta preparar uma sentença SQL para a conexão já estabelecida
        try (PreparedStatement pstmt
                = DbConnection.getConexao().prepareStatement(
                        // Sentença SQL para busca por chave primária
                        getDeclaracaoSelectPorId())) {

            // Prepara a declaração com os dados do objeto passado
            ajustarIdDeclaracao(pstmt, id);

            // Executa o comando SQL
            ResultSet resultSet = pstmt.executeQuery();

            // Se há resultado retornado...
            if (resultSet.next()) {
                // ... extrai objeto do respectivo registro do banco de dados
                objeto = extrairObjeto(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Devolve nulo (objeto não encontrado) ou o objeto recuperado
        return objeto;
    }

    /**
     * Recupera todos os objetos mapeados para o banco de dados do tipo
     * específico.
     *
     * @return Lista (geralmente um <code>ArrayList<T></code>) de objetos
     * persistidos.
     */
    @Override
    public ArrayList<Paciente> localizarTodos() {

        // Declara referência para reter o(s) objeto(s) a ser(em) recuperado(s)
        ArrayList<Paciente> objetos = new ArrayList<>();

        // Tenta preparar uma sentença SQL para a conexão já estabelecida
        try (PreparedStatement pstmt
                = DbConnection.getConexao().prepareStatement(
                        // Sentença SQL para recuperação de todos os registros
                        getDeclaracaoSelectTodos())) {

            // Executa o comando SQL
            ResultSet resultSet = pstmt.executeQuery();

            // Extrai objeto(s) do(s) respectivo(s) registro(s) do banco de dados
            objetos = extrairObjetos(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Devolve uma lista vazia (nenhum registro encontrado) 
        // ou a relação de objeto(s) recuperado(s)
        return objetos;
    }

    /**
     * Recupera a sentença SQL específica para a inserção da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para inserção.
     */
    public abstract String getDeclaracaoInsert();

    /**
     * Recupera a sentença SQL específica para a busca da entidade no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidade.
     */
    public abstract String getDeclaracaoSelectPorId();

    /**
     * Recupera a sentença SQL específica para a busca das entidades no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidades.
     */
    public abstract String getDeclaracaoSelectTodos();

    /**
     * Recupera a sentença SQL específica para a atualização da entidade no
     * banco de dados.
     *
     * @return Sentença SQl para atualização.
     */
    public abstract String getDeclaracaoUpdate();

    /**
     * Recupera a sentença SQL específica para a exclusão da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para exclusão.
     */
    public abstract String getDeclaracaoDelete();

    /**
     * Insere o valor da chave primária na senteça SQL específica para seu uso.
     *
     * @param pstmt Declaração previamente preparada.
     * @param id Chave primária a ser inserida na sentença SQL.
     */
    public void ajustarIdDeclaracao(PreparedStatement pstmt, K id) {
        try {
            // Caso id seja um Long, emprega setLong()
            if(id instanceof Long) {
                // Cast é requerido porque K não é um tipo previamente definido
                pstmt.setLong(1, (Long) id);
            } else {
                // Caso id seja um Integer, emprega setLong()
                pstmt.setInt(1, (Integer) id);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Insere os valores do objeto na senteça SQL específica para inserção ou
     * atualização de registros no banco de dados.
     *
     * @param pstmt Declaração previamente preparada.
     * @param id Chave primária a ser inserida na sentença SQL.
     */
    public abstract void montarDeclaracao(PreparedStatement pstmt, Paciente o);

    /**
     * Cria objeto a partir do registro fornecido pelo banco de dados.
     *
     * @param resultSet Resultado proveniente do banco de dados relacional.
     * @return Objeto constituído.
     */
    public abstract Paciente extrairObjeto(ResultSet resultSet);

    /**
     * Cria objeto(s) a partir do(s) registro(s) fornecido(s) pelo banco de
     * dados.
     *
     * @param resultSet Resultado(s) proveniente(s) do banco de dados
     * relacional.
     * @return Lista de objeto(s) constituído(s).
     */
    public abstract ArrayList<Paciente> extrairObjetos(ResultSet resultSet);
}
