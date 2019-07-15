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
public class RelatorioProfessor extends javax.swing.JInternalFrame {

    /**
     * Creates new form RelatorioProfessor
     */
    public RelatorioProfessor() {
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
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        calendarioIn = new com.toedter.calendar.JCalendar();
        calendarioFin = new com.toedter.calendar.JCalendar();
        botaoconfirmar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelcadastro4 = new javax.swing.JLabel();
        botaoconfirmaragenda = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        labelcadastro5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        labelcadastro6 = new javax.swing.JLabel();
        comboProfessor = new javax.swing.JComboBox<>();
        labelcadastro7 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelcadastro2.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        labelcadastro2.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro2.setText("Relatorio Professor");

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
        labelcadastro3.setText("Escolha um periodo :");

        label1.setText("Inicial :");

        label2.setText("Final :");

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

        labelcadastro4.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        labelcadastro4.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro4.setText("Relatorio dos Professoores em um periodo");

        botaoconfirmaragenda.setBackground(new java.awt.Color(255, 255, 255));
        botaoconfirmaragenda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoconfirmaragenda.setForeground(new java.awt.Color(0, 102, 102));
        botaoconfirmaragenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/free printer icon.png"))); // NOI18N
        botaoconfirmaragenda.setBorderPainted(false);
        botaoconfirmaragenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoconfirmaragendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoconfirmaragendaMouseExited(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        labelcadastro5.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        labelcadastro5.setForeground(new java.awt.Color(0, 102, 102));

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

        labelcadastro6.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        labelcadastro6.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro6.setText("Relatorio Agenda do professor");

        labelcadastro7.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        labelcadastro7.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro7.setText("Escolha o professor :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelcadastro2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(labelcadastro4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(labelcadastro3)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(calendarioIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(calendarioFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(botaoconfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(botaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(36, 36, 36)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelcadastro7)
                .addGap(52, 52, 52)
                .addComponent(comboProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(botaoconfirmaragenda)
                .addGap(78, 78, 78))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(labelcadastro5)
                    .addContainerGap(790, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(labelcadastro6)
                    .addContainerGap(502, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelcadastro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoconfirmaragenda)
                    .addComponent(comboProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelcadastro7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(labelcadastro4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelcadastro3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calendarioIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calendarioFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(botaoconfirmar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(11, 11, 11)))
                .addGap(91, 91, 91))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(136, 136, 136)
                    .addComponent(labelcadastro5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(389, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(labelcadastro6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(445, Short.MAX_VALUE)))
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

    private void botaoconfirmaragendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoconfirmaragendaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoconfirmaragendaMouseEntered

    private void botaoconfirmaragendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoconfirmaragendaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoconfirmaragendaMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoconfirmar;
    private javax.swing.JButton botaoconfirmaragenda;
    private com.toedter.calendar.JCalendar calendarioFin;
    private com.toedter.calendar.JCalendar calendarioIn;
    private javax.swing.JComboBox<String> comboProfessor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel9;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JLabel labelcadastro2;
    private javax.swing.JLabel labelcadastro3;
    private javax.swing.JLabel labelcadastro4;
    private javax.swing.JLabel labelcadastro5;
    private javax.swing.JLabel labelcadastro6;
    private javax.swing.JLabel labelcadastro7;
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
     * @return the botaoconfirmaragenda
     */
    public javax.swing.JButton getBotaoconfirmaragenda() {
        return botaoconfirmaragenda;
    }

    /**
     * @param botaoconfirmaragenda the botaoconfirmaragenda to set
     */
    public void setBotaoconfirmaragenda(javax.swing.JButton botaoconfirmaragenda) {
        this.botaoconfirmaragenda = botaoconfirmaragenda;
    }

    /**
     * @return the calendarioFin
     */
    public com.toedter.calendar.JCalendar getCalendarioFin() {
        return calendarioFin;
    }

    /**
     * @param calendarioFin the calendarioFin to set
     */
    public void setCalendarioFin(com.toedter.calendar.JCalendar calendarioFin) {
        this.calendarioFin = calendarioFin;
    }

    /**
     * @return the calendarioIn
     */
    public com.toedter.calendar.JCalendar getCalendarioIn() {
        return calendarioIn;
    }

    /**
     * @param calendarioIn the calendarioIn to set
     */
    public void setCalendarioIn(com.toedter.calendar.JCalendar calendarioIn) {
        this.calendarioIn = calendarioIn;
    }

    /**
     * @return the comboProfessor
     */
    public javax.swing.JComboBox<String> getComboProfessor() {
        return comboProfessor;
    }

    /**
     * @param comboProfessor the comboProfessor to set
     */
    public void setComboProfessor(javax.swing.JComboBox<String> comboProfessor) {
        this.comboProfessor = comboProfessor;
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
     * @return the jPanel10
     */
    public javax.swing.JPanel getjPanel10() {
        return jPanel10;
    }

    /**
     * @param jPanel10 the jPanel10 to set
     */
    public void setjPanel10(javax.swing.JPanel jPanel10) {
        this.jPanel10 = jPanel10;
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
     * @return the label1
     */
    public java.awt.Label getLabel1() {
        return label1;
    }

    /**
     * @param label1 the label1 to set
     */
    public void setLabel1(java.awt.Label label1) {
        this.label1 = label1;
    }

    /**
     * @return the label2
     */
    public java.awt.Label getLabel2() {
        return label2;
    }

    /**
     * @param label2 the label2 to set
     */
    public void setLabel2(java.awt.Label label2) {
        this.label2 = label2;
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
     * @return the labelcadastro4
     */
    public javax.swing.JLabel getLabelcadastro4() {
        return labelcadastro4;
    }

    /**
     * @param labelcadastro4 the labelcadastro4 to set
     */
    public void setLabelcadastro4(javax.swing.JLabel labelcadastro4) {
        this.labelcadastro4 = labelcadastro4;
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

    /**
     * @return the labelcadastro6
     */
    public javax.swing.JLabel getLabelcadastro6() {
        return labelcadastro6;
    }

    /**
     * @param labelcadastro6 the labelcadastro6 to set
     */
    public void setLabelcadastro6(javax.swing.JLabel labelcadastro6) {
        this.labelcadastro6 = labelcadastro6;
    }



}
