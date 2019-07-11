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
public class RelatorioAluno extends javax.swing.JInternalFrame {

    /**
     * Creates new form RelatorioFuncionario
     */
    public RelatorioAluno() {
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
        labelcadastro4 = new javax.swing.JLabel();
        comboPosicao = new javax.swing.JComboBox<>();
        labelcadastro5 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        botaoconfirmar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelcadastro2.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        labelcadastro2.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro2.setText("Relatorio aluno");

        jPanel9.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        labelcadastro3.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        labelcadastro3.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro3.setText("escolha um periodo :");

        label1.setText("Inicial :");

        label2.setText("Final :");

        labelcadastro4.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        labelcadastro4.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro4.setText("escolha um Tipo de Aluno :");

        comboPosicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ativo", "desistente", "ex-aluno" }));

        labelcadastro5.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        labelcadastro5.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro5.setText("escolha o nome do Relatorio :");

        textNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeActionPerformed(evt);
            }
        });

        botaoconfirmar.setBackground(new java.awt.Color(255, 255, 255));
        botaoconfirmar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoconfirmar.setForeground(new java.awt.Color(0, 102, 102));
        botaoconfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/Salva.png"))); // NOI18N
        botaoconfirmar.setText("Confirmar");
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
        botaoCancelar.setText("Cancelar");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelcadastro2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelcadastro4)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboPosicao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelcadastro3)
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(calendarioIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(59, 59, 59)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(calendarioFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(botaoconfirmar)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(labelcadastro5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoCancelar)
                        .addGap(158, 158, 158))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelcadastro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelcadastro4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPosicao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelcadastro3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendarioIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calendarioFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelcadastro5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoconfirmar))
                .addContainerGap(134, Short.MAX_VALUE))
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

    private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoconfirmar;
    private com.toedter.calendar.JCalendar calendarioFin;
    private com.toedter.calendar.JCalendar calendarioIn;
    private javax.swing.JComboBox<String> comboPosicao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel9;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JLabel labelcadastro2;
    private javax.swing.JLabel labelcadastro3;
    private javax.swing.JLabel labelcadastro4;
    private javax.swing.JLabel labelcadastro5;
    private javax.swing.JTextField textNome;
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
     * @return the comboPosicao
     */
    public javax.swing.JComboBox<String> getComboPosicao() {
        return comboPosicao;
    }

    /**
     * @param comboPosicao the comboPosicao to set
     */
    public void setComboPosicao(javax.swing.JComboBox<String> comboPosicao) {
        this.comboPosicao = comboPosicao;
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
     * @return the textNome
     */
    public javax.swing.JTextField getTextNome() {
        return textNome;
    }

    /**
     * @param textNome the textNome to set
     */
    public void setTextNome(javax.swing.JTextField textNome) {
        this.textNome = textNome;
    }

    

    
}
