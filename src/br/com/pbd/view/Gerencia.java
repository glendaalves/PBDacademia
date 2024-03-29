/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.view;

import br.com.pbd.sql.PostgresBackup_Curso;
import java.awt.Color;

/**
 *
 * @author Glenda Alves de Lima
 */
public class Gerencia extends javax.swing.JInternalFrame {

    /**
     * Creates new form Gerencia
     */
    public Gerencia() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Conbousuario = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelausuario = new javax.swing.JTable();
        botaoFechar = new javax.swing.JButton();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        botaoBackup = new javax.swing.JButton();

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(962, 739));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Conbousuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FUNCIONARIO", "PROFESSOR" }));

        tabelausuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelausuario.setRowHeight(30);
        jScrollPane1.setViewportView(tabelausuario);

        botaoFechar.setBackground(new java.awt.Color(255, 255, 255));
        botaoFechar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoFechar.setForeground(new java.awt.Color(0, 102, 102));
        botaoFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/Cancela.png"))); // NOI18N
        botaoFechar.setText("Fechar");
        botaoFechar.setBorderPainted(false);
        botaoFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoFecharMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoFecharMouseExited(evt);
            }
        });
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharActionPerformed(evt);
            }
        });

        label1.setText("Escolha o Usuario :");

        label2.setText(" Backup :");

        botaoBackup.setBackground(new java.awt.Color(255, 255, 255));
        botaoBackup.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoBackup.setForeground(new java.awt.Color(0, 102, 102));
        botaoBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/reset.png"))); // NOI18N
        botaoBackup.setText("Backup");
        botaoBackup.setBorderPainted(false);
        botaoBackup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoBackupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoBackupMouseExited(evt);
            }
        });
        botaoBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBackupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(Conbousuario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(botaoBackup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoFechar)
                .addGap(59, 59, 59))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Conbousuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botaoFechar)
                                .addComponent(botaoBackup))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Controle de Acesso", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoFecharMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoFecharMouseEntered
        getBotaoFechar().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoFechar().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_botaoFecharMouseEntered

    private void botaoFecharMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoFecharMouseExited
        getBotaoFechar().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoFechar().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_botaoFecharMouseExited

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void botaoBackupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoBackupMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoBackupMouseEntered

    private void botaoBackupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoBackupMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoBackupMouseExited

    private void botaoBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBackupActionPerformed
        PostgresBackup_Curso pb = new PostgresBackup_Curso();
    }//GEN-LAST:event_botaoBackupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Conbousuario;
    private javax.swing.JButton botaoBackup;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JTable tabelausuario;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the Conbousuario
     */
    public javax.swing.JComboBox<String> getConbousuario() {
        return Conbousuario;
    }

    /**
     * @param Conbousuario the Conbousuario to set
     */
    public void setConbousuario(javax.swing.JComboBox<String> Conbousuario) {
        this.Conbousuario = Conbousuario;
    }

    /**
     * @return the jPanel1
     */
    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * @param jPanel1 the jPanel1 to set
     */
    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @param jScrollPane1 the jScrollPane1 to set
     */
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * @return the jTabbedPane1
     */
    public javax.swing.JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    /**
     * @param jTabbedPane1 the jTabbedPane1 to set
     */
    public void setjTabbedPane1(javax.swing.JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    /**
     * @return the tabelausuario
     */
    public javax.swing.JTable getTabelausuario() {
        return tabelausuario;
    }

    /**
     * @param tabelausuario the tabelausuario to set
     */
    public void setTabelausuario(javax.swing.JTable tabelausuario) {
        this.tabelausuario = tabelausuario;
    }

    /**
     * @return the botaoFechar
     */
    public javax.swing.JButton getBotaoFechar() {
        return botaoFechar;
    }

    /**
     * @param botaoFechar the botaoFechar to set
     */
    public void setBotaoFechar(javax.swing.JButton botaoFechar) {
        this.botaoFechar = botaoFechar;
    }

    /**
     * @return the botaoBackup
     */
    public javax.swing.JButton getBotaoBackup() {
        return botaoBackup;
    }

    /**
     * @param botaoBackup the botaoBackup to set
     */
    public void setBotaoBackup(javax.swing.JButton botaoBackup) {
        this.botaoBackup = botaoBackup;
    }

}
