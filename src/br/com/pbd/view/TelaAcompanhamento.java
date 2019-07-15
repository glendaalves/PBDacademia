/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.view;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Glenda Alves de Lima
 */
public class TelaAcompanhamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form Acompanhamento
     */
    
    private JButton  btnEx;
    private Icon  Iconexcluir;
    public TelaAcompanhamento() {
        initComponents();
        
        Iconexcluir = new ImageIcon(getClass().getResource("/br/com/pbd/resource/Exclui.png"));
        btnEx = new JButton(getIconexcluir());
        btnEx.setName("Excluir");
        btnEx.setBorder(null);
        btnEx.setContentAreaFilled(false);
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
        jPanel7 = new javax.swing.JPanel();
        labelcadastro = new javax.swing.JLabel();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        peito = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        ombro = new javax.swing.JTextField();
        label3 = new java.awt.Label();
        cintura = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        quadril = new javax.swing.JTextField();
        label5 = new java.awt.Label();
        coxa = new javax.swing.JTextField();
        label6 = new java.awt.Label();
        panturrilha = new javax.swing.JTextField();
        label7 = new java.awt.Label();
        braco = new javax.swing.JTextField();
        label8 = new java.awt.Label();
        antebraco = new javax.swing.JTextField();
        label9 = new java.awt.Label();
        txtaluno = new javax.swing.JTextField();
        label10 = new java.awt.Label();
        altura = new javax.swing.JTextField();
        label11 = new java.awt.Label();
        peso = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(962, 739));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        labelcadastro.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        labelcadastro.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro.setText("Acompanhamento");

        botaoSalvar.setBackground(new java.awt.Color(255, 255, 255));
        botaoSalvar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoSalvar.setForeground(new java.awt.Color(0, 102, 102));
        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/Salva.png"))); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.setBorderPainted(false);
        botaoSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoSalvarMouseExited(evt);
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/oie_transparent (13).png"))); // NOI18N

        label1.setText("Peito :");

        peito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peitoActionPerformed(evt);
            }
        });

        label2.setText("Ombro :");

        label3.setText("Cintura :");

        label4.setText("Quadril :");

        label5.setText("Coxa :");

        label6.setText("Panturrilha :");

        label7.setText("Braço :");

        label8.setText("Antebraço :");

        label9.setText("Aluno :");

        txtaluno.setEnabled(false);
        txtaluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalunoActionPerformed(evt);
            }
        });

        label10.setText("Altura:");

        altura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alturaActionPerformed(evt);
            }
        });

        label11.setText("Peso:");

        peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelcadastro)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(48, Short.MAX_VALUE)
                        .addComponent(botaoSalvar)
                        .addGap(40, 40, 40)
                        .addComponent(botaoCancelar)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtaluno, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(peso, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(altura, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(coxa, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ombro, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cintura, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(quadril)
                                            .addComponent(peito)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panturrilha, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(braco, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(antebraco, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(labelcadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtaluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(altura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ombro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cintura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quadril, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panturrilha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(braco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(antebraco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSalvarMouseEntered
        getBotaoSalvar().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoSalvar().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_botaoSalvarMouseEntered

    private void botaoSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSalvarMouseExited
        getBotaoSalvar().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoSalvar().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_botaoSalvarMouseExited

    private void botaoCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCancelarMouseEntered
        getBotaoCancelar().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoCancelar().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_botaoCancelarMouseEntered

    private void botaoCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCancelarMouseExited
        getBotaoCancelar().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoCancelar().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_botaoCancelarMouseExited

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        setVisible(false);
        limpar();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void peitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peitoActionPerformed

    private void txtalunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalunoActionPerformed

    private void alturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alturaActionPerformed

    private void pesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField altura;
    private javax.swing.JTextField antebraco;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField braco;
    private javax.swing.JTextField cintura;
    private javax.swing.JTextField coxa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JLabel labelcadastro;
    private javax.swing.JTextField ombro;
    private javax.swing.JTextField panturrilha;
    private javax.swing.JTextField peito;
    private javax.swing.JTextField peso;
    private javax.swing.JTextField quadril;
    private javax.swing.JTextField txtaluno;
    // End of variables declaration//GEN-END:variables

    public void limpar() {
        getPeito().setText("");
        getOmbro().setText("");
        getCintura().setText("");
        getQuadril().setText("");
        getCoxa().setText("");
        getPanturrilha().setText("");
        getBraco().setText("");
        getAntebraco().setText("");
        getTxtaluno().setText("");
        getPeso().setText("");
        getAltura().setText("");
    }

    /**
     * @return the btnEx
     */
    public JButton getBtnEx() {
        return btnEx;
    }

    /**
     * @param btnEx the btnEx to set
     */
    public void setBtnEx(JButton btnEx) {
        this.btnEx = btnEx;
    }

    /**
     * @return the Iconexcluir
     */
    public Icon getIconexcluir() {
        return Iconexcluir;
    }

    /**
     * @param Iconexcluir the Iconexcluir to set
     */
    public void setIconexcluir(Icon Iconexcluir) {
        this.Iconexcluir = Iconexcluir;
    }

    /**
     * @return the altura
     */
    public javax.swing.JTextField getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(javax.swing.JTextField altura) {
        this.altura = altura;
    }

    /**
     * @return the antebraco
     */
    public javax.swing.JTextField getAntebraco() {
        return antebraco;
    }

    /**
     * @param antebraco the antebraco to set
     */
    public void setAntebraco(javax.swing.JTextField antebraco) {
        this.antebraco = antebraco;
    }

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
     * @return the botaoSalvar
     */
    public javax.swing.JButton getBotaoSalvar() {
        return botaoSalvar;
    }

    /**
     * @param botaoSalvar the botaoSalvar to set
     */
    public void setBotaoSalvar(javax.swing.JButton botaoSalvar) {
        this.botaoSalvar = botaoSalvar;
    }

    /**
     * @return the braco
     */
    public javax.swing.JTextField getBraco() {
        return braco;
    }

    /**
     * @param braco the braco to set
     */
    public void setBraco(javax.swing.JTextField braco) {
        this.braco = braco;
    }

    /**
     * @return the cintura
     */
    public javax.swing.JTextField getCintura() {
        return cintura;
    }

    /**
     * @param cintura the cintura to set
     */
    public void setCintura(javax.swing.JTextField cintura) {
        this.cintura = cintura;
    }

    /**
     * @return the coxa
     */
    public javax.swing.JTextField getCoxa() {
        return coxa;
    }

    /**
     * @param coxa the coxa to set
     */
    public void setCoxa(javax.swing.JTextField coxa) {
        this.coxa = coxa;
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
     * @return the jPanel7
     */
    public javax.swing.JPanel getjPanel7() {
        return jPanel7;
    }

    /**
     * @param jPanel7 the jPanel7 to set
     */
    public void setjPanel7(javax.swing.JPanel jPanel7) {
        this.jPanel7 = jPanel7;
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
     * @return the label10
     */
    public java.awt.Label getLabel10() {
        return label10;
    }

    /**
     * @param label10 the label10 to set
     */
    public void setLabel10(java.awt.Label label10) {
        this.label10 = label10;
    }

    /**
     * @return the label11
     */
    public java.awt.Label getLabel11() {
        return label11;
    }

    /**
     * @param label11 the label11 to set
     */
    public void setLabel11(java.awt.Label label11) {
        this.label11 = label11;
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
     * @return the label3
     */
    public java.awt.Label getLabel3() {
        return label3;
    }

    /**
     * @param label3 the label3 to set
     */
    public void setLabel3(java.awt.Label label3) {
        this.label3 = label3;
    }

    /**
     * @return the label4
     */
    public java.awt.Label getLabel4() {
        return label4;
    }

    /**
     * @param label4 the label4 to set
     */
    public void setLabel4(java.awt.Label label4) {
        this.label4 = label4;
    }

    /**
     * @return the label5
     */
    public java.awt.Label getLabel5() {
        return label5;
    }

    /**
     * @param label5 the label5 to set
     */
    public void setLabel5(java.awt.Label label5) {
        this.label5 = label5;
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
     * @return the label7
     */
    public java.awt.Label getLabel7() {
        return label7;
    }

    /**
     * @param label7 the label7 to set
     */
    public void setLabel7(java.awt.Label label7) {
        this.label7 = label7;
    }

    /**
     * @return the label8
     */
    public java.awt.Label getLabel8() {
        return label8;
    }

    /**
     * @param label8 the label8 to set
     */
    public void setLabel8(java.awt.Label label8) {
        this.label8 = label8;
    }

    /**
     * @return the label9
     */
    public java.awt.Label getLabel9() {
        return label9;
    }

    /**
     * @param label9 the label9 to set
     */
    public void setLabel9(java.awt.Label label9) {
        this.label9 = label9;
    }

    /**
     * @return the labelcadastro
     */
    public javax.swing.JLabel getLabelcadastro() {
        return labelcadastro;
    }

    /**
     * @param labelcadastro the labelcadastro to set
     */
    public void setLabelcadastro(javax.swing.JLabel labelcadastro) {
        this.labelcadastro = labelcadastro;
    }

    /**
     * @return the ombro
     */
    public javax.swing.JTextField getOmbro() {
        return ombro;
    }

    /**
     * @param ombro the ombro to set
     */
    public void setOmbro(javax.swing.JTextField ombro) {
        this.ombro = ombro;
    }

    /**
     * @return the panturrilha
     */
    public javax.swing.JTextField getPanturrilha() {
        return panturrilha;
    }

    /**
     * @param panturrilha the panturrilha to set
     */
    public void setPanturrilha(javax.swing.JTextField panturrilha) {
        this.panturrilha = panturrilha;
    }

    /**
     * @return the peito
     */
    public javax.swing.JTextField getPeito() {
        return peito;
    }

    /**
     * @param peito the peito to set
     */
    public void setPeito(javax.swing.JTextField peito) {
        this.peito = peito;
    }

    /**
     * @return the peso
     */
    public javax.swing.JTextField getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(javax.swing.JTextField peso) {
        this.peso = peso;
    }

    /**
     * @return the quadril
     */
    public javax.swing.JTextField getQuadril() {
        return quadril;
    }

    /**
     * @param quadril the quadril to set
     */
    public void setQuadril(javax.swing.JTextField quadril) {
        this.quadril = quadril;
    }

    /**
     * @return the txtaluno
     */
    public javax.swing.JTextField getTxtaluno() {
        return txtaluno;
    }

    /**
     * @param txtaluno the txtaluno to set
     */
    public void setTxtaluno(javax.swing.JTextField txtaluno) {
        this.txtaluno = txtaluno;
    }

   
}
