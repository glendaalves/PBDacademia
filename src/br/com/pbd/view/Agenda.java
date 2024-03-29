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
public class Agenda extends javax.swing.JInternalFrame {

    /**
     * Creates new form Agenda
     */
    public Agenda() {
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

        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        labelcadastro2 = new javax.swing.JLabel();
        LabelAgenda = new java.awt.Label();
        txtnome = new javax.swing.JTextField();
        botaoFechar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaAgenda = new javax.swing.JTable();
        botaoadicionar = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(962, 739));

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

        labelcadastro2.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        labelcadastro2.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro2.setText("Acompanamento da Agenda");

        LabelAgenda.setText("Aluno :");

        txtnome.setEnabled(false);

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

        TabelaAgenda.setAutoCreateRowSorter(true);
        TabelaAgenda.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TabelaAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TabelaAgenda.setRowHeight(30);
        jScrollPane3.setViewportView(TabelaAgenda);

        botaoadicionar.setBackground(new java.awt.Color(255, 255, 255));
        botaoadicionar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoadicionar.setForeground(new java.awt.Color(0, 102, 102));
        botaoadicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/plus (1).png"))); // NOI18N
        botaoadicionar.setText("Adicionar Exercicio");
        botaoadicionar.setBorderPainted(false);
        botaoadicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoadicionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoadicionarMouseExited(evt);
            }
        });
        botaoadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoadicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelcadastro2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(LabelAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(botaoadicionar)
                        .addGap(28, 28, 28)
                        .addComponent(botaoFechar)))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelcadastro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoadicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtnome))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void botaoadicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoadicionarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoadicionarMouseEntered

    private void botaoadicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoadicionarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoadicionarMouseExited

    private void botaoadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoadicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoadicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label LabelAgenda;
    private javax.swing.JTable TabelaAgenda;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton botaoadicionar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelcadastro2;
    private javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the LabelAgenda
     */
    public java.awt.Label getLabelAgenda() {
        return LabelAgenda;
    }

    /**
     * @param LabelAgenda the LabelAgenda to set
     */
    public void setLabelAgenda(java.awt.Label LabelAgenda) {
        this.LabelAgenda = LabelAgenda;
    }

    /**
     * @return the TabelaAgenda
     */
    public javax.swing.JTable getTabelaAgenda() {
        return TabelaAgenda;
    }

    /**
     * @param TabelaAgenda the TabelaAgenda to set
     */
    public void setTabelaAgenda(javax.swing.JTable TabelaAgenda) {
        this.TabelaAgenda = TabelaAgenda;
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
     * @return the botaoadicionar
     */
    public javax.swing.JButton getBotaoadicionar() {
        return botaoadicionar;
    }

    /**
     * @param botaoadicionar the botaoadicionar to set
     */
    public void setBotaoadicionar(javax.swing.JButton botaoadicionar) {
        this.botaoadicionar = botaoadicionar;
    }

    /**
     * @return the jPanel2
     */
    public javax.swing.JPanel getjPanel2() {
        return jPanel2;
    }

    /**
     * @param jPanel2 the jPanel2 to set
     */
    public void setjPanel2(javax.swing.JPanel jPanel2) {
        this.jPanel2 = jPanel2;
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
     * @return the jScrollPane3
     */
    public javax.swing.JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    /**
     * @param jScrollPane3 the jScrollPane3 to set
     */
    public void setjScrollPane3(javax.swing.JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
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
     * @return the txtnome
     */
    public javax.swing.JTextField getTxtnome() {
        return txtnome;
    }

    /**
     * @param txtnome the txtnome to set
     */
    public void setTxtnome(javax.swing.JTextField txtnome) {
        this.txtnome = txtnome;
    }


}
