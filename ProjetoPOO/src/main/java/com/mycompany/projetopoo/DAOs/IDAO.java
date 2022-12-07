/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo.DAOs;
import java.util.List;
/**
 *
 * @author suKarolainy
 * @param <Paciente>
 */
public interface IDAO<Paciente, K> {
    
    /**
     * Executa o procedimento de salvamento (inserção ou atualização) do objeto
     * mapeado no banco de dados.
     * 
     * @param o Objeto a ser salvo no banco de dados.
     * @return Valor da chave primária gerada pela inclusão de um novo registro
     * ou mesmo valor da chave primária do objeto original presistido anteriormente.
     */
    public K salvar(Paciente o);

    /**
     * Exclui o registro do objeto no banco de dados.
     * 
     * @param o Objeto a ser excluído.<br>
     * <i>OBS.: o único valor útil é a identidade do objeto mapeado.</i>
     * @return Condição de sucesso ou falha na exclusão.
     */
    public Boolean excluir(Paciente o);

    /**
     * Recupera um dado objeto mapeado para o banco de dados por meio de sua
     * chave de identidade.
     * 
     * @param id Identidade do objeto.
     * @return Objeto segundo registro persistido.
     */
    public Paciente localizarPorId(K id);

    /**
     * Recupera todos os objetos mapeados para o banco de dados do tipo específico.
     * @return Lista (geralmente um <code>ArrayList<T></code>) de objetos persistidos.
     */
    public List<Paciente> localizarTodos();

}
