/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.view;

import java.awt.Color;

/**
 *
 * @author Glenda Alves de Lima
 */
public class RelatorioExercicio extends javax.swing.JInternalFrame {

    /**
     * Creates new form RelatorioExercicio
     */
    public RelatorioExercicio() {
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

        jPanel1 = new javax.swing.JPanel();
        labelcadastro2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        labelcadastro3 = new javax.swing.JLabel();
        botaoconfirmar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelcadastro5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        combotreino = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(871, 559));

        labelcadastro2.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        labelcadastro2.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro2.setText("Relatorio Exercicio");

        jPanel9.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        labelcadastro3.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        labelcadastro3.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro3.setText("escolha um Tipo  :");

        botaoconfirmar.setBackground(new java.awt.Color(255, 255, 255));
        botaoconfirmar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoconfirmar.setForeground(new java.awt.Color(0, 102, 102));
        botaoconfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/free printer icon.png"))); // NOI18N
        botaoconfirmar.setBorderPainted(false);
        botaoconfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoconfirmarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoconfirmarMouseExited(evt);
            }
        });
        botaoconfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoconfirmarActionPerformed(evt);
            }
        });

        botaoCancelar.setBackground(new java.awt.Color(255, 255, 255));
        botaoCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoCancelar.setForeground(new java.awt.Color(0, 102, 102));
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/Cancela.png"))); // NOI18N
        botaoCancelar.setBorderPainted(false);
        botaoCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoCancelarMouseExited(evt);
            }
        });
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        labelcadastro5.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        labelcadastro5.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro5.setText("Relatorio dos exercicio por tipo");

        jPanel11.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        combotreino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BAIXO PESO", "NORMAL", "SOBREPESO", "OBESO I", "OBESO II", "OBESO III" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelcadastro2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(labelcadastro5)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(labelcadastro3)
                                .addGap(27, 27, 27)
                                .addComponent(combotreino, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(313, 313, 313)
                                .addComponent(botaoconfirmar)
                                .addGap(54, 54, 54)
                                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 319, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelcadastro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(labelcadastro5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combotreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelcadastro3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoconfirmar)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoconfirmarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoconfirmarMouseEntered
        getBotaoconfirmar().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoconfirmar().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_botaoconfirmarMouseEntered

    private void botaoconfirmarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoconfirmarMouseExited
        getBotaoconfirmar().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoconfirmar().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_botaoconfirmarMouseExited

    private void botaoCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCancelarMouseEntered
        getBotaoCancelar().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoCancelar().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_botaoCancelarMouseEntered

    private void botaoCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCancelarMouseExited
        getBotaoCancelar().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoCancelar().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_botaoCancelarMouseExited

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed

    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoconfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoconfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoconfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoconfirmar;
    private javax.swing.JComboBox<String> combotreino;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labelcadastro2;
    private javax.swing.JLabel labelcadastro3;
    private javax.swing.JLabel labelcadastro5;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the botaoCancelar
     */
    public javax.swing.JButton getBotaoCancelar() {
        return botaoCancelar;
    }

    /**
     * @param botaoCancelar the botaoCancelar to set
     */
    public void setBotaoCancelar(javax.swing.JButton botaoCancelar) {
        this.botaoCancelar = botaoCancelar;
    }

    /**
     * @return the botaoconfirmar
     */
    public javax.swing.JButton getBotaoconfirmar() {
        return botaoconfirmar;
    }

    /**
     * @param botaoconfirmar the botaoconfirmar to set
     */
    public void setBotaoconfirmar(javax.swing.JButton botaoconfirmar) {
        this.botaoconfirmar = botaoconfirmar;
    }

    /**
     * @return the combotreino
     */
    public javax.swing.JComboBox<String> getCombotreino() {
        return combotreino;
    }

    /**
     * @param combotreino the combotreino to set
     */
    public void setCombotreino(javax.swing.JComboBox<String> combotreino) {
        this.combotreino = combotreino;
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
     * @return the jPanel11
     */
    public javax.swing.JPanel getjPanel11() {
        return jPanel11;
    }

    /**
     * @param jPanel11 the jPanel11 to set
     */
    public void setjPanel11(javax.swing.JPanel jPanel11) {
        this.jPanel11 = jPanel11;
    }

    /**
     * @return the jPanel9
     */
    public javax.swing.JPanel getjPanel9() {
        return jPanel9;
    }

    /**
     * @param jPanel9 the jPanel9 to set
     */
    public void setjPanel9(javax.swing.JPanel jPanel9) {
        this.jPanel9 = jPanel9;
    }

    /**
     * @return the labelcadastro2
     */
    public javax.swing.JLabel getLabelcadastro2() {
        return labelcadastro2;
    }

    /**
     * @param labelcadastro2 the labelcadastro2 to set
     */
    public void setLabelcadastro2(javax.swing.JLabel labelcadastro2) {
        this.labelcadastro2 = labelcadastro2;
    }

    /**
     * @return the labelcadastro3
     */
    public javax.swing.JLabel getLabelcadastro3() {
        return labelcadastro3;
    }

    /**
     * @param labelcadastro3 the labelcadastro3 to set
     */
    public void setLabelcadastro3(javax.swing.JLabel labelcadastro3) {
        this.labelcadastro3 = labelcadastro3;
    }

    /**
     * @return the labelcadastro5
     */
    public javax.swing.JLabel getLabelcadastro5() {
        return labelcadastro5;
    }

    /**
     * @param labelcadastro5 the labelcadastro5 to set
     */
    public void setLabelcadastro5(javax.swing.JLabel labelcadastro5) {
        this.labelcadastro5 = labelcadastro5;
    }


}