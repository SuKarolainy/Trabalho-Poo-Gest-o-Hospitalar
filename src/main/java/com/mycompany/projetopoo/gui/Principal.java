/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projetopoo.gui;

import com.mycompany.projetopoo.daos.DbConnection;
import com.mycompany.projetopoo.daos.MedicoDao;
import com.mycompany.projetopoo.pessoas.Enfermeiro;
import com.mycompany.projetopoo.pessoas.Medico;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *
 * @author suKarolainy
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dskPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuInicio = new javax.swing.JMenu();
        mnuInicioSobre = new javax.swing.JMenuItem();
        mnuInicioSair = new javax.swing.JMenuItem();
        mnuAtend = new javax.swing.JMenu();
        mnuAtendCadastrar = new javax.swing.JMenuItem();
        mnuAtendTriagem = new javax.swing.JMenuItem();
        mnuAtendAtendimentoMedico = new javax.swing.JMenuItem();
        mnuAtendAtendimento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout dskPrincipalLayout = new javax.swing.GroupLayout(dskPrincipal);
        dskPrincipal.setLayout(dskPrincipalLayout);
        dskPrincipalLayout.setHorizontalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        dskPrincipalLayout.setVerticalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(dskPrincipal);

        mnuInicio.setText("Início ");
        mnuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInicioActionPerformed(evt);
            }
        });

        mnuInicioSobre.setText("Sobre");
        mnuInicioSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInicioSobreActionPerformed(evt);
            }
        });
        mnuInicio.add(mnuInicioSobre);

        mnuInicioSair.setText("Sair");
        mnuInicioSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInicioSairActionPerformed(evt);
            }
        });
        mnuInicio.add(mnuInicioSair);

        jMenuBar1.add(mnuInicio);

        mnuAtend.setText("Atendimento");
        mnuAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAtendActionPerformed(evt);
            }
        });

        mnuAtendCadastrar.setText("Cadastrar paciente");
        mnuAtendCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAtendCadastrarActionPerformed(evt);
            }
        });
        mnuAtend.add(mnuAtendCadastrar);

        mnuAtendTriagem.setText("Triagem paciente");
        mnuAtendTriagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAtendTriagemActionPerformed(evt);
            }
        });
        mnuAtend.add(mnuAtendTriagem);

        mnuAtendAtendimentoMedico.setText("Atendimento médico");
        mnuAtendAtendimentoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAtendAtendimentoMedicoActionPerformed(evt);
            }
        });
        mnuAtend.add(mnuAtendAtendimentoMedico);

        mnuAtendAtendimento.setText("Consultar atendimento");
        mnuAtendAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAtendAtendimentoActionPerformed(evt);
            }
        });
        mnuAtend.add(mnuAtendAtendimento);

        jMenuBar1.add(mnuAtend);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuInicioActionPerformed

    private void mnuInicioSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInicioSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mnuInicioSairActionPerformed

    private void mnuInicioSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInicioSobreActionPerformed
        // TODO add your handling code here:
        attachInternalFrame(Sobre.getInstance());
    }//GEN-LAST:event_mnuInicioSobreActionPerformed

    private void mnuAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuAtendActionPerformed

    private void mnuAtendAtendimentoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtendAtendimentoMedicoActionPerformed
        // TODO add your handling code here:
        attachInternalFrame(AtendimentoMedico.getInstance());
    }//GEN-LAST:event_mnuAtendAtendimentoMedicoActionPerformed

    private void mnuAtendCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtendCadastrarActionPerformed
        // TODO add your handling code here:
        attachInternalFrame(CadastroPaciente.getInstance());
    }//GEN-LAST:event_mnuAtendCadastrarActionPerformed

    private void mnuAtendTriagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtendTriagemActionPerformed
        // TODO add your handling code here:
        attachInternalFrame(TriagemPaciente.getInstance());
    }//GEN-LAST:event_mnuAtendTriagemActionPerformed

    private void mnuAtendAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtendAtendimentoActionPerformed
        // TODO add your handling code here:
        attachInternalFrame(Atendimento.getInstance());
    }//GEN-LAST:event_mnuAtendAtendimentoActionPerformed

    private void attachInternalFrame(JInternalFrame window) {
        // Attach internal window to desktop pane
        if (!window.isVisible()) {
            window.setVisible(true);
            dskPrincipal.add(window);
        }

        // Focus and restore the internal window
        try {
            window.setSelected(true);
            window.setIcon(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName())
                    .log(Level.INFO, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        Connection conn = DbConnection.getConnection();
        
        System.out.println("> " + conn);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
        
        
        new MedicoDao().saveOrUpdate(
            new Medico(
                        crm, especialidade, Long.MIN_VALUE, nome, cpf, LocalDate.MIN, telefone, email)String nome("Ana"),
            )
        );
        
        
        
        Medico medico2 = new Medico();
        medico2.setNome("Ana Maria");
        medico2.setCrm("123654/MG");
        medico2.setEspecialidade("Neurologista");
        
        Enfermeiro enfermeiro1 = new Enfermeiro();
        enfermeiro1.setNome("Mariana");
        enfermeiro1.setCoren("321654MG");
        
        Enfermeiro enfermeiro2 = new Enfermeiro();
        enfermeiro2.setNome("Eliza");
        enfermeiro2.setCoren("321689MG");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskPrincipal;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mnuAtend;
    private javax.swing.JMenuItem mnuAtendAtendimento;
    private javax.swing.JMenuItem mnuAtendAtendimentoMedico;
    private javax.swing.JMenuItem mnuAtendCadastrar;
    private javax.swing.JMenuItem mnuAtendTriagem;
    private javax.swing.JMenu mnuInicio;
    private javax.swing.JMenuItem mnuInicioSair;
    private javax.swing.JMenuItem mnuInicioSobre;
    // End of variables declaration//GEN-END:variables

}
