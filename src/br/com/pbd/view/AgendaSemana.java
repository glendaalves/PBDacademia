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
public class AgendaSemana extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgendaSemana
     */
    public AgendaSemana() {
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
        jPanel4 = new javax.swing.JPanel();
        labeldia_semana = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        combodia = new javax.swing.JComboBox<>();
        botaoadicionar = new javax.swing.JButton();
        combodia1 = new javax.swing.JComboBox<>();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(962, 739));
        jPanel2.setLayout(null);

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

        jPanel2.add(jPanel9);
        jPanel9.setBounds(0, 41, 962, 9);

        labelcadastro2.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        labelcadastro2.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro2.setText("Acompanamento da Agenda");
        jPanel2.add(labelcadastro2);
        labelcadastro2.setBounds(10, 11, 386, 30);

        LabelAgenda.setAlignment(java.awt.Label.CENTER);
        LabelAgenda.setText("Aluno :");
        jPanel2.add(LabelAgenda);
        LabelAgenda.setBounds(40, 70, 150, 35);

        txtnome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnome.setEnabled(false);
        jPanel2.add(txtnome);
        txtnome.setBounds(200, 70, 500, 30);

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
        jPanel2.add(botaoFechar);
        botaoFechar.setBounds(770, 70, 160, 35);

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

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 266, 942, 375);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        labeldia_semana.setFont(new java.awt.Font("DeVinne Txt BT", 0, 18)); // NOI18N
        labeldia_semana.setForeground(new java.awt.Color(255, 255, 255));
        labeldia_semana.setText("Segunda- Feira");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labeldia_semana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labeldia_semana, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(16, 216, 214, 44);

        label1.setText("Escolha o dia da Semana :");
        jPanel2.add(label1);
        label1.setBounds(26, 137, 152, 35);

        jPanel2.add(combodia);
        combodia.setBounds(196, 139, 300, 35);

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
        jPanel2.add(botaoadicionar);
        botaoadicionar.setBounds(574, 137, 210, 35);

        combodia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEGUNDA-FEIRA", "TERÇA-FEIRA", "QUARTA-FEIRA", "QUINTA-FEIRA", "SEXTA-FEIRA", "SABADO", "DOMINGO" }));
        jPanel2.add(combodia1);
        combodia1.setBounds(200, 140, 300, 35);

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
    private javax.swing.JComboBox<String> combodia;
    private javax.swing.JComboBox<String> combodia1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private javax.swing.JLabel labelcadastro2;
    private javax.swing.JLabel labeldia_semana;
    private javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables

    public void Limpar() {

        getCombodia().setSelectedIndex(0);

    }

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
     * @return the combodia
     */
    public javax.swing.JComboBox<String> getCombodia() {
        return combodia;
    }

    /**
     * @param combodia the combodia to set
     */
    public void setCombodia(javax.swing.JComboBox<String> combodia) {
        this.combodia = combodia;
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
     * @return the jPanel4
     */
    public javax.swing.JPanel getjPanel4() {
        return jPanel4;
    }

    /**
     * @param jPanel4 the jPanel4 to set
     */
    public void setjPanel4(javax.swing.JPanel jPanel4) {
        this.jPanel4 = jPanel4;
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
     * @return the labeldia_semana
     */
    public javax.swing.JLabel getLabeldia_semana() {
        return labeldia_semana;
    }

    /**
     * @param labeldia_semana the labeldia_semana to set
     */
    public void setLabeldia_semana(javax.swing.JLabel labeldia_semana) {
        this.labeldia_semana = labeldia_semana;
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

    /**
     * @return the combodia1
     */
    public javax.swing.JComboBox<String> getCombodia1() {
        return combodia1;
    }

}