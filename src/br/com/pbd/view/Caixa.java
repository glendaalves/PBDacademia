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
public class Caixa extends javax.swing.JInternalFrame {

    /**
     * Creates new form Caixa
     */
    public Caixa() {
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
        botaoFecharcaixa = new javax.swing.JButton();
        botaofechar = new javax.swing.JButton();
        label6 = new java.awt.Label();
        calendario = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabeladespesas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelamensalidade = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelavenda = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtlucro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoAbrirCaixa = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(962, 739));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
        labelcadastro2.setText("Caixa");

        botaoFecharcaixa.setBackground(new java.awt.Color(255, 255, 255));
        botaoFecharcaixa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoFecharcaixa.setForeground(new java.awt.Color(0, 102, 102));
        botaoFecharcaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/caixa.png"))); // NOI18N
        botaoFecharcaixa.setText("Fechar Caixa");
        botaoFecharcaixa.setBorderPainted(false);
        botaoFecharcaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoFecharcaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoFecharcaixaMouseExited(evt);
            }
        });
        botaoFecharcaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharcaixaActionPerformed(evt);
            }
        });

        botaofechar.setBackground(new java.awt.Color(255, 255, 255));
        botaofechar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaofechar.setForeground(new java.awt.Color(0, 102, 102));
        botaofechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/Cancela.png"))); // NOI18N
        botaofechar.setText("Fechar");
        botaofechar.setBorderPainted(false);
        botaofechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaofecharMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaofecharMouseExited(evt);
            }
        });
        botaofechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaofecharActionPerformed(evt);
            }
        });

        label6.setText("Pesquisa :");

        jLabel5.setFont(new java.awt.Font("Felix Titling", 1, 12)); // NOI18N
        jLabel5.setText("despesas pagas");

        tabeladespesas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabeladespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {"", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data", "Numero", "Paciente", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabeladespesas.setEnabled(false);
        tabeladespesas.setRowHeight(25);
        tabeladespesas.setSelectionBackground(new java.awt.Color(153, 204, 255));
        tabeladespesas.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(tabeladespesas);

        jLabel4.setFont(new java.awt.Font("Felix Titling", 1, 12)); // NOI18N
        jLabel4.setText("Mensalidades Recebidas");

        tabelamensalidade.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabelamensalidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {"", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data", "Numero", "Paciente", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelamensalidade.setEnabled(false);
        tabelamensalidade.setRowHeight(25);
        tabelamensalidade.setSelectionBackground(new java.awt.Color(153, 204, 255));
        tabelamensalidade.setShowHorizontalLines(false);
        jScrollPane3.setViewportView(tabelamensalidade);

        jLabel6.setFont(new java.awt.Font("Felix Titling", 1, 12)); // NOI18N
        jLabel6.setText("Vendas Recebidas ");

        tabelavenda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabelavenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {"", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data", "Numero", "Paciente", "Valor Total"
            }
        ));
        tabelavenda.setRowHeight(25);
        tabelavenda.setSelectionBackground(new java.awt.Color(153, 204, 255));
        tabelavenda.setShowHorizontalLines(false);
        jScrollPane4.setViewportView(tabelavenda);

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lucro Diario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        jLabel8.setText("R$");

        txtlucro.setBackground(new java.awt.Color(153, 255, 153));
        txtlucro.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        txtlucro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtlucro.setEnabled(false);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/caixa1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtlucro, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlucro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor em Caixa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        jLabel1.setText("R$");

        txttotal.setBackground(new java.awt.Color(153, 255, 153));
        txttotal.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        txttotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txttotal.setEnabled(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/caixa1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttotal, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        botaoAbrirCaixa.setBackground(new java.awt.Color(255, 255, 255));
        botaoAbrirCaixa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoAbrirCaixa.setForeground(new java.awt.Color(0, 102, 102));
        botaoAbrirCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/caixa.png"))); // NOI18N
        botaoAbrirCaixa.setText("Abrir Caixa");
        botaoAbrirCaixa.setBorderPainted(false);
        botaoAbrirCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoAbrirCaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoAbrirCaixaMouseExited(evt);
            }
        });
        botaoAbrirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAbrirCaixaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(labelcadastro2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(botaoFecharcaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoAbrirCaixa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaofechar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelcadastro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoFecharcaixa)
                            .addComponent(botaofechar)
                            .addComponent(botaoAbrirCaixa))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaofecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaofecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_botaofecharActionPerformed

    private void botaofecharMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaofecharMouseExited
        getBotaofechar().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaofechar().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_botaofecharMouseExited

    private void botaofecharMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaofecharMouseEntered
        getBotaofechar().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaofechar().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_botaofecharMouseEntered

    private void botaoFecharcaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharcaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoFecharcaixaActionPerformed

    private void botaoFecharcaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoFecharcaixaMouseExited
        getBotaoFecharcaixa().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoFecharcaixa().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_botaoFecharcaixaMouseExited

    private void botaoFecharcaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoFecharcaixaMouseEntered
        getBotaoFecharcaixa().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoFecharcaixa().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_botaoFecharcaixaMouseEntered

    private void botaoAbrirCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAbrirCaixaMouseEntered
        getBotaoAbrirCaixa().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoAbrirCaixa().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_botaoAbrirCaixaMouseEntered

    private void botaoAbrirCaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAbrirCaixaMouseExited
        getBotaoAbrirCaixa().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoAbrirCaixa().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_botaoAbrirCaixaMouseExited

    private void botaoAbrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAbrirCaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoAbrirCaixaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAbrirCaixa;
    private javax.swing.JButton botaoFecharcaixa;
    private javax.swing.JButton botaofechar;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private java.awt.Label label6;
    private javax.swing.JLabel labelcadastro2;
    private javax.swing.JTable tabeladespesas;
    private javax.swing.JTable tabelamensalidade;
    private javax.swing.JTable tabelavenda;
    private javax.swing.JTextField txtlucro;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the botaoFecharcaixa
     */
    public javax.swing.JButton getBotaoFecharcaixa() {
        return botaoFecharcaixa;
    }

    /**
     * @param botaoFecharcaixa the botaoFecharcaixa to set
     */
    public void setBotaoFecharcaixa(javax.swing.JButton botaoFecharcaixa) {
        this.botaoFecharcaixa = botaoFecharcaixa;
    }

    /**
     * @return the botaofechar
     */
    public javax.swing.JButton getBotaofechar() {
        return botaofechar;
    }

    /**
     * @param botaofechar the botaofechar to set
     */
    public void setBotaofechar(javax.swing.JButton botaofechar) {
        this.botaofechar = botaofechar;
    }

    /**
     * @return the calendario
     */
    public com.toedter.calendar.JDateChooser getCalendario() {
        return calendario;
    }

    /**
     * @param calendario the calendario to set
     */
    public void setCalendario(com.toedter.calendar.JDateChooser calendario) {
        this.calendario = calendario;
    }

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * @param jLabel1 the jLabel1 to set
     */
    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    /**
     * @return the jLabel2
     */
    public javax.swing.JLabel getjLabel2() {
        return jLabel2;
    }

    /**
     * @param jLabel2 the jLabel2 to set
     */
    public void setjLabel2(javax.swing.JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    /**
     * @return the jLabel4
     */
    public javax.swing.JLabel getjLabel4() {
        return jLabel4;
    }

    /**
     * @param jLabel4 the jLabel4 to set
     */
    public void setjLabel4(javax.swing.JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    /**
     * @return the jLabel5
     */
    public javax.swing.JLabel getjLabel5() {
        return jLabel5;
    }

    /**
     * @param jLabel5 the jLabel5 to set
     */
    public void setjLabel5(javax.swing.JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    /**
     * @return the jLabel6
     */
    public javax.swing.JLabel getjLabel6() {
        return jLabel6;
    }

    /**
     * @param jLabel6 the jLabel6 to set
     */
    public void setjLabel6(javax.swing.JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    /**
     * @return the jLabel8
     */
    public javax.swing.JLabel getjLabel8() {
        return jLabel8;
    }

    /**
     * @param jLabel8 the jLabel8 to set
     */
    public void setjLabel8(javax.swing.JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    /**
     * @return the jLabel9
     */
    public javax.swing.JLabel getjLabel9() {
        return jLabel9;
    }

    /**
     * @param jLabel9 the jLabel9 to set
     */
    public void setjLabel9(javax.swing.JLabel jLabel9) {
        this.jLabel9 = jLabel9;
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
     * @return the jScrollPane2
     */
    public javax.swing.JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    /**
     * @param jScrollPane2 the jScrollPane2 to set
     */
    public void setjScrollPane2(javax.swing.JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
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
     * @return the jScrollPane4
     */
    public javax.swing.JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    /**
     * @param jScrollPane4 the jScrollPane4 to set
     */
    public void setjScrollPane4(javax.swing.JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    /**
     * @return the label6
     */
    public java.awt.Label getLabel6() {
        return label6;
    }

    /**
     * @param label6 the label6 to set
     */
    public void setLabel6(java.awt.Label label6) {
        this.label6 = label6;
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
     * @return the tabeladespesas
     */
    public javax.swing.JTable getTabeladespesas() {
        return tabeladespesas;
    }

    /**
     * @param tabeladespesas the tabeladespesas to set
     */
    public void setTabeladespesas(javax.swing.JTable tabeladespesas) {
        this.tabeladespesas = tabeladespesas;
    }

    /**
     * @return the tabelamensalidade
     */
    public javax.swing.JTable getTabelamensalidade() {
        return tabelamensalidade;
    }

    /**
     * @param tabelamensalidade the tabelamensalidade to set
     */
    public void setTabelamensalidade(javax.swing.JTable tabelamensalidade) {
        this.tabelamensalidade = tabelamensalidade;
    }

    /**
     * @return the tabelavenda
     */
    public javax.swing.JTable getTabelavenda() {
        return tabelavenda;
    }

    /**
     * @param tabelavenda the tabelavenda to set
     */
    public void setTabelavenda(javax.swing.JTable tabelavenda) {
        this.tabelavenda = tabelavenda;
    }

    /**
     * @return the txtlucro
     */
    public javax.swing.JTextField getTxtlucro() {
        return txtlucro;
    }

    /**
     * @param txtlucro the txtlucro to set
     */
    public void setTxtlucro(javax.swing.JTextField txtlucro) {
        this.txtlucro = txtlucro;
    }

    /**
     * @return the txttotal
     */
    public javax.swing.JTextField getTxttotal() {
        return txttotal;
    }

    /**
     * @param txttotal the txttotal to set
     */
    public void setTxttotal(javax.swing.JTextField txttotal) {
        this.txttotal = txttotal;
    }

    /**
     * @return the botaoAbrirCaixa
     */
    public javax.swing.JButton getBotaoAbrirCaixa() {
        return botaoAbrirCaixa;
    }

    /**
     * @param botaoAbrirCaixa the botaoAbrirCaixa to set
     */
    public void setBotaoAbrirCaixa(javax.swing.JButton botaoAbrirCaixa) {
        this.botaoAbrirCaixa = botaoAbrirCaixa;
    }

}
