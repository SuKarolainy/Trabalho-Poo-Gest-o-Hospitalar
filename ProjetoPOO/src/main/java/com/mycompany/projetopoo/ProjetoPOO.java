/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projetopoo;
/*
import com.mycompany.projetopoo.DAOs.Dao;
import com.mycompany.projetopoo.DAOs.DbConnection;
import com.mycompany.projetopoo.DAOs.IDAO;
import com.mycompany.projetopoo.DAOs.PacienteDao;
*/
import com.mycompany.projetopoo.Pessoas.Paciente;
import java.time.LocalDate;

/**
 *
 * @author suKarolainy
 */
public class ProjetoPOO {

    public static void main(String[] args) {

        Paciente paciente = new Paciente();
        
        paciente.setNome("Ana");
        paciente.setCpf("123456789");
        //paciente.setDataNascimento(LocalDate.MIN="12/02/2022");
        
        
        System.out.println("Dados do paciente: \nNome: " + paciente.getNome());
        
    }
}
