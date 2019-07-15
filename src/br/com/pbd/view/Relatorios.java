/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Glenda Alves de Lima
 */
public class Relatorios extends javax.swing.JInternalFrame {

    private RelatorioAluno relatorioAluno = new RelatorioAluno();
    private  RelatorioFornecedor  relatorioFornecedor = new RelatorioFornecedor();
    private RelatorioProfessor relatorioProfessor = new RelatorioProfessor();
    private RelatorioFuncionario relatorioFuncionario = new RelatorioFuncionario();
    private RelatorioContas relatorioContas = new RelatorioContas();

    public Relatorios() {
        initComponents();
        fundos(relatorioAluno);
        fundos(relatorioFornecedor);
        fundos(relatorioProfessor);
        fundos(relatorioFuncionario);
        fundos(relatorioContas);

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
        PanelPrincipal = new javax.swing.JPanel();
        BotaoRaluno = new javax.swing.JButton();
        BotaoSair = new javax.swing.JButton();
        BotaoRexercicio = new javax.swing.JButton();
        BotaoRcaixa = new javax.swing.JButton();
        BotaoRproduto = new javax.swing.JButton();
        BotaoRprofessor = new javax.swing.JButton();
        BotaoRconta = new javax.swing.JButton();
        BotaoRfornecedor = new javax.swing.JButton();
        BotaoRfuncionario = new javax.swing.JButton();
        AreaPanel = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(962, 739));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        BotaoRaluno.setBackground(new java.awt.Color(255, 255, 255));
        BotaoRaluno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BotaoRaluno.setForeground(new java.awt.Color(0, 102, 102));
        BotaoRaluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/stats.png"))); // NOI18N
        BotaoRaluno.setText("Aluno");
        BotaoRaluno.setBorderPainted(false);
        BotaoRaluno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoRaluno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotaoRaluno.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BotaoRaluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoRalunoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoRalunoMouseExited(evt);
            }
        });
        BotaoRaluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRalunoActionPerformed(evt);
            }
        });

        BotaoSair.setBackground(new java.awt.Color(255, 255, 255));
        BotaoSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BotaoSair.setForeground(new java.awt.Color(0, 102, 102));
        BotaoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/Cancela.png"))); // NOI18N
        BotaoSair.setText("Sair");
        BotaoSair.setBorderPainted(false);
        BotaoSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotaoSair.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BotaoSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoSairMouseExited(evt);
            }
        });
        BotaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSairActionPerformed(evt);
            }
        });

        BotaoRexercicio.setBackground(new java.awt.Color(255, 255, 255));
        BotaoRexercicio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BotaoRexercicio.setForeground(new java.awt.Color(0, 102, 102));
        BotaoRexercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/Rgym.png"))); // NOI18N
        BotaoRexercicio.setText("Exercicio");
        BotaoRexercicio.setBorderPainted(false);
        BotaoRexercicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoRexercicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotaoRexercicio.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BotaoRexercicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoRexercicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoRexercicioMouseExited(evt);
            }
        });
        BotaoRexercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRexercicioActionPerformed(evt);
            }
        });

        BotaoRcaixa.setBackground(new java.awt.Color(255, 255, 255));
        BotaoRcaixa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BotaoRcaixa.setForeground(new java.awt.Color(0, 102, 102));
        BotaoRcaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/bars-graphic.png"))); // NOI18N
        BotaoRcaixa.setText("Caixa");
        BotaoRcaixa.setBorderPainted(false);
        BotaoRcaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoRcaixa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotaoRcaixa.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BotaoRcaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoRcaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoRcaixaMouseExited(evt);
            }
        });
        BotaoRcaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRcaixaActionPerformed(evt);
            }
        });

        BotaoRproduto.setBackground(new java.awt.Color(255, 255, 255));
        BotaoRproduto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BotaoRproduto.setForeground(new java.awt.Color(0, 102, 102));
        BotaoRproduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/shopping-online.png"))); // NOI18N
        BotaoRproduto.setText(" Produto");
        BotaoRproduto.setBorderPainted(false);
        BotaoRproduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoRproduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotaoRproduto.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BotaoRproduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoRprodutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoRprodutoMouseExited(evt);
            }
        });
        BotaoRproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRprodutoActionPerformed(evt);
            }
        });

        BotaoRprofessor.setBackground(new java.awt.Color(255, 255, 255));
        BotaoRprofessor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BotaoRprofessor.setForeground(new java.awt.Color(0, 102, 102));
        BotaoRprofessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/form.png"))); // NOI18N
        BotaoRprofessor.setText("Professor");
        BotaoRprofessor.setBorderPainted(false);
        BotaoRprofessor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoRprofessor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotaoRprofessor.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BotaoRprofessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoRprofessorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoRprofessorMouseExited(evt);
            }
        });
        BotaoRprofessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRprofessorActionPerformed(evt);
            }
        });

        BotaoRconta.setBackground(new java.awt.Color(255, 255, 255));
        BotaoRconta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BotaoRconta.setForeground(new java.awt.Color(0, 102, 102));
        BotaoRconta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/browser.png"))); // NOI18N
        BotaoRconta.setText("Conta a Pagar");
        BotaoRconta.setBorderPainted(false);
        BotaoRconta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoRconta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotaoRconta.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BotaoRconta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoRcontaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoRcontaMouseExited(evt);
            }
        });
        BotaoRconta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRcontaActionPerformed(evt);
            }
        });

        BotaoRfornecedor.setBackground(new java.awt.Color(255, 255, 255));
        BotaoRfornecedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BotaoRfornecedor.setForeground(new java.awt.Color(0, 102, 102));
        BotaoRfornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/product.png"))); // NOI18N
        BotaoRfornecedor.setText("Fornecedor");
        BotaoRfornecedor.setBorderPainted(false);
        BotaoRfornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoRfornecedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotaoRfornecedor.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BotaoRfornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoRfornecedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoRfornecedorMouseExited(evt);
            }
        });
        BotaoRfornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRfornecedorActionPerformed(evt);
            }
        });

        BotaoRfuncionario.setBackground(new java.awt.Color(255, 255, 255));
        BotaoRfuncionario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BotaoRfuncionario.setForeground(new java.awt.Color(0, 102, 102));
        BotaoRfuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/link.png"))); // NOI18N
        BotaoRfuncionario.setText("Funcionario");
        BotaoRfuncionario.setBorderPainted(false);
        BotaoRfuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoRfuncionario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotaoRfuncionario.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BotaoRfuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoRfuncionarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoRfuncionarioMouseExited(evt);
            }
        });
        BotaoRfuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRfuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addComponent(BotaoRaluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoRprofessor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoRfornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoRfuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoRconta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoRexercicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoRcaixa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoRproduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BotaoRaluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotaoRexercicio, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
            .addComponent(BotaoRcaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotaoSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotaoRproduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotaoRprofessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotaoRconta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotaoRfornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotaoRfuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        AreaPanel.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        AreaPanel.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout AreaPanelLayout = new javax.swing.GroupLayout(AreaPanel);
        AreaPanel.setLayout(AreaPanelLayout);
        AreaPanelLayout.setHorizontalGroup(
            AreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AreaPanelLayout.createSequentialGroup()
                .addGroup(AreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AreaPanelLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1))
                    .addGroup(AreaPanelLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AreaPanelLayout.setVerticalGroup(
            AreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AreaPanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AreaPanel)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(AreaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoRalunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRalunoActionPerformed
  
    }//GEN-LAST:event_BotaoRalunoActionPerformed

    private void BotaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoSairActionPerformed

    private void BotaoRexercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRexercicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoRexercicioActionPerformed

    private void BotaoRcaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRcaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoRcaixaActionPerformed

    private void BotaoRprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRprodutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoRprodutoActionPerformed

    private void BotaoRprofessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRprofessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoRprofessorActionPerformed

    private void BotaoRcontaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRcontaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoRcontaActionPerformed

    private void BotaoRfornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRfornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoRfornecedorActionPerformed

    private void BotaoRfuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRfuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoRfuncionarioActionPerformed

    private void BotaoRalunoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRalunoMouseEntered
        getBotaoRaluno().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoRaluno().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_BotaoRalunoMouseEntered

    private void BotaoRprofessorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRprofessorMouseEntered
        getBotaoRprofessor().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoRprofessor().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_BotaoRprofessorMouseEntered

    private void BotaoRfornecedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRfornecedorMouseEntered
        getBotaoRfornecedor().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoRfornecedor().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_BotaoRfornecedorMouseEntered

    private void BotaoRfuncionarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRfuncionarioMouseEntered
        getBotaoRfuncionario().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoRfuncionario().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece:
    }//GEN-LAST:event_BotaoRfuncionarioMouseEntered

    private void BotaoRcontaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRcontaMouseEntered
        getBotaoRconta().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoRconta().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_BotaoRcontaMouseEntered

    private void BotaoRexercicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRexercicioMouseEntered
        getBotaoRexercicio().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoRexercicio().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_BotaoRexercicioMouseEntered

    private void BotaoRcaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRcaixaMouseEntered
        getBotaoRcaixa().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoRcaixa().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_BotaoRcaixaMouseEntered

    private void BotaoRprodutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRprodutoMouseEntered
        getBotaoRproduto().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoRproduto().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_BotaoRprodutoMouseEntered

    private void BotaoSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSairMouseEntered
        getBotaoSair().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoSair().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_BotaoSairMouseEntered

    private void BotaoRalunoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRalunoMouseExited
        getBotaoRaluno().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoRaluno().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_BotaoRalunoMouseExited

    private void BotaoRprofessorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRprofessorMouseExited
        getBotaoRprofessor().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoRprofessor().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_BotaoRprofessorMouseExited

    private void BotaoRfornecedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRfornecedorMouseExited
        getBotaoRfornecedor().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoRfornecedor().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_BotaoRfornecedorMouseExited

    private void BotaoRfuncionarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRfuncionarioMouseExited
        getBotaoRfuncionario().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoRfuncionario().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_BotaoRfuncionarioMouseExited

    private void BotaoRcontaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRcontaMouseExited
        getBotaoRconta().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoRconta().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_BotaoRcontaMouseExited

    private void BotaoRexercicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRexercicioMouseExited
        getBotaoRexercicio().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoRexercicio().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_BotaoRexercicioMouseExited

    private void BotaoRcaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRcaixaMouseExited
        getBotaoRcaixa().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoRcaixa().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_BotaoRcaixaMouseExited

    private void BotaoRprodutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRprodutoMouseExited
        getBotaoRproduto().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoRproduto().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_BotaoRprodutoMouseExited

    private void BotaoSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSairMouseExited
        getBotaoSair().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoSair().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_BotaoSairMouseExited
    public void fundos(JInternalFrame frame) {
        ((BasicInternalFrameUI) frame.getUI()).setNorthPane(null);
        frame.setBorder(null);
        getAreaPanel().add(frame);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane AreaPanel;
    private javax.swing.JButton BotaoRaluno;
    private javax.swing.JButton BotaoRcaixa;
    private javax.swing.JButton BotaoRconta;
    private javax.swing.JButton BotaoRexercicio;
    private javax.swing.JButton BotaoRfornecedor;
    private javax.swing.JButton BotaoRfuncionario;
    private javax.swing.JButton BotaoRproduto;
    private javax.swing.JButton BotaoRprofessor;
    private javax.swing.JButton BotaoSair;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

   
    public void Ativar() {
        for (Component cp : getPanelPrincipal().getComponents()) {
            cp.setEnabled(true);
        }
    }
     public void Desativar() {
        for (Component cp : getPanelPrincipal().getComponents()) {
            cp.setEnabled(false);
        }
    }

    /**
     * @return the relatorioAluno
     */
    public RelatorioAluno getRelatorioAluno() {
        return relatorioAluno;
    }

    /**
     * @param relatorioAluno the relatorioAluno to set
     */
    public void setRelatorioAluno(RelatorioAluno relatorioAluno) {
        this.relatorioAluno = relatorioAluno;
    }

    /**
     * @return the relatorioFornecedor
     */
    public RelatorioFornecedor getRelatorioFornecedor() {
        return relatorioFornecedor;
    }

    /**
     * @param relatorioFornecedor the relatorioFornecedor to set
     */
    public void setRelatorioFornecedor(RelatorioFornecedor relatorioFornecedor) {
        this.relatorioFornecedor = relatorioFornecedor;
    }

    /**
     * @return the relatorioProfessor
     */
    public RelatorioProfessor getRelatorioProfessor() {
        return relatorioProfessor;
    }

    /**
     * @param relatorioProfessor the relatorioProfessor to set
     */
    public void setRelatorioProfessor(RelatorioProfessor relatorioProfessor) {
        this.relatorioProfessor = relatorioProfessor;
    }

    /**
     * @return the relatorioFuncionario
     */
    public RelatorioFuncionario getRelatorioFuncionario() {
        return relatorioFuncionario;
    }

    /**
     * @param relatorioFuncionario the relatorioFuncionario to set
     */
    public void setRelatorioFuncionario(RelatorioFuncionario relatorioFuncionario) {
        this.relatorioFuncionario = relatorioFuncionario;
    }

    /**
     * @return the relatorioContas
     */
    public RelatorioContas getRelatorioContas() {
        return relatorioContas;
    }

    /**
     * @param relatorioContas the relatorioContas to set
     */
    public void setRelatorioContas(RelatorioContas relatorioContas) {
        this.relatorioContas = relatorioContas;
    }

    /**
     * @return the AreaPanel
     */
    public javax.swing.JDesktopPane getAreaPanel() {
        return AreaPanel;
    }

    /**
     * @param AreaPanel the AreaPanel to set
     */
    public void setAreaPanel(javax.swing.JDesktopPane AreaPanel) {
        this.AreaPanel = AreaPanel;
    }

    /**
     * @return the BotaoRaluno
     */
    public javax.swing.JButton getBotaoRaluno() {
        return BotaoRaluno;
    }

    /**
     * @param BotaoRaluno the BotaoRaluno to set
     */
    public void setBotaoRaluno(javax.swing.JButton BotaoRaluno) {
        this.BotaoRaluno = BotaoRaluno;
    }

    /**
     * @return the BotaoRcaixa
     */
    public javax.swing.JButton getBotaoRcaixa() {
        return BotaoRcaixa;
    }

    /**
     * @param BotaoRcaixa the BotaoRcaixa to set
     */
    public void setBotaoRcaixa(javax.swing.JButton BotaoRcaixa) {
        this.BotaoRcaixa = BotaoRcaixa;
    }

    /**
     * @return the BotaoRconta
     */
    public javax.swing.JButton getBotaoRconta() {
        return BotaoRconta;
    }

    /**
     * @param BotaoRconta the BotaoRconta to set
     */
    public void setBotaoRconta(javax.swing.JButton BotaoRconta) {
        this.BotaoRconta = BotaoRconta;
    }

    /**
     * @return the BotaoRexercicio
     */
    public javax.swing.JButton getBotaoRexercicio() {
        return BotaoRexercicio;
    }

    /**
     * @param BotaoRexercicio the BotaoRexercicio to set
     */
    public void setBotaoRexercicio(javax.swing.JButton BotaoRexercicio) {
        this.BotaoRexercicio = BotaoRexercicio;
    }

    /**
     * @return the BotaoRfornecedor
     */
    public javax.swing.JButton getBotaoRfornecedor() {
        return BotaoRfornecedor;
    }

    /**
     * @param BotaoRfornecedor the BotaoRfornecedor to set
     */
    public void setBotaoRfornecedor(javax.swing.JButton BotaoRfornecedor) {
        this.BotaoRfornecedor = BotaoRfornecedor;
    }

    /**
     * @return the BotaoRfuncionario
     */
    public javax.swing.JButton getBotaoRfuncionario() {
        return BotaoRfuncionario;
    }

    /**
     * @param BotaoRfuncionario the BotaoRfuncionario to set
     */
    public void setBotaoRfuncionario(javax.swing.JButton BotaoRfuncionario) {
        this.BotaoRfuncionario = BotaoRfuncionario;
    }

    /**
     * @return the BotaoRproduto
     */
    public javax.swing.JButton getBotaoRproduto() {
        return BotaoRproduto;
    }

    /**
     * @param BotaoRproduto the BotaoRproduto to set
     */
    public void setBotaoRproduto(javax.swing.JButton BotaoRproduto) {
        this.BotaoRproduto = BotaoRproduto;
    }

    /**
     * @return the BotaoRprofessor
     */
    public javax.swing.JButton getBotaoRprofessor() {
        return BotaoRprofessor;
    }

    /**
     * @param BotaoRprofessor the BotaoRprofessor to set
     */
    public void setBotaoRprofessor(javax.swing.JButton BotaoRprofessor) {
        this.BotaoRprofessor = BotaoRprofessor;
    }

    /**
     * @return the BotaoSair
     */
    public javax.swing.JButton getBotaoSair() {
        return BotaoSair;
    }

    /**
     * @param BotaoSair the BotaoSair to set
     */
    public void setBotaoSair(javax.swing.JButton BotaoSair) {
        this.BotaoSair = BotaoSair;
    }

    /**
     * @return the PanelPrincipal
     */
    public javax.swing.JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    /**
     * @param PanelPrincipal the PanelPrincipal to set
     */
    public void setPanelPrincipal(javax.swing.JPanel PanelPrincipal) {
        this.PanelPrincipal = PanelPrincipal;
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

   
    
   
}
