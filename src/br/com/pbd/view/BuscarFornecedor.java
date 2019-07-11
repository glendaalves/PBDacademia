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
import javax.swing.JTextField;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BuscarFornecedor extends javax.swing.JInternalFrame {

    private Icon Iconeditar, Iconexcluir;
    private JButton btnEx, btnEd;

    /**
     * Creates new form BuscarFornecedor
     */
    public BuscarFornecedor() {
        initComponents();
        Iconeditar = new ImageIcon(getClass().getResource("/br/com/pbd/resource/editarr.png"));
        Iconexcluir = new ImageIcon(getClass().getResource("/br/com/pbd/resource/Exclui.png"));

        btnEd = new JButton(Iconeditar);
        btnEd.setName("editar");
        btnEd.setBorder(null);
        btnEd.setContentAreaFilled(false);

        btnEx = new JButton(Iconexcluir);
        btnEx.setName("excluir");
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
        botaoAdicionar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFornecedor = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisa = new br.com.pbd.modelos.JTextFieldHint(new JTextField(), "pesquisar", " Pesquise por Nome Fantasa CNPJ ou Razao Social ");

        setPreferredSize(new java.awt.Dimension(962, 739));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        labelcadastro.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        labelcadastro.setForeground(new java.awt.Color(0, 102, 102));
        labelcadastro.setText("Buscar DE Fornecedor");

        botaoAdicionar.setBackground(new java.awt.Color(255, 255, 255));
        botaoAdicionar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoAdicionar.setForeground(new java.awt.Color(0, 102, 102));
        botaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/plus (1).png"))); // NOI18N
        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.setBorderPainted(false);
        botaoAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoAdicionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoAdicionarMouseExited(evt);
            }
        });
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

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

        label1.setText("Pesquise:");

        tabelaFornecedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabelaFornecedor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelaFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome Fantasia", "Razão Social", "CNPJ"
            }
        ));
        tabelaFornecedor.setFocusable(false);
        tabelaFornecedor.setRowHeight(30);
        tabelaFornecedor.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaFornecedor);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("DeVinne Txt BT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista dos Fornecedores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0))
        );

        txtPesquisa.setPreferredSize(new java.awt.Dimension(6, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(botaoAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoFechar))
                            .addComponent(labelcadastro))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelcadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
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

    private void botaoAdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAdicionarMouseEntered
        getBotaoAdicionar().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaoAdicionar().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_botaoAdicionarMouseEntered

    private void botaoAdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAdicionarMouseExited
        getBotaoAdicionar().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaoAdicionar().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_botaoAdicionarMouseExited

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed

    }//GEN-LAST:event_botaoAdicionarActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JLabel labelcadastro;
    private javax.swing.JTable tabelaFornecedor;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the botaoAdicionar
     */
    public javax.swing.JButton getBotaoAdicionar() {
        return botaoAdicionar;
    }

    /**
     * @param botaoAdicionar the botaoAdicionar to set
     */
    public void setBotaoAdicionar(javax.swing.JButton botaoAdicionar) {
        this.botaoAdicionar = botaoAdicionar;
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
     * @return the tabelaFornecedor
     */
    public javax.swing.JTable getTabelaFornecedor() {
        return tabelaFornecedor;
    }

    /**
     * @param tabelaFornecedor the tabelaFornecedor to set
     */
    public void setTabelaFornecedor(javax.swing.JTable tabelaFornecedor) {
        this.tabelaFornecedor = tabelaFornecedor;
    }

    /**
     * @return the txtPesquisa
     */
    public javax.swing.JTextField getTxtPesquisa() {
        return txtPesquisa;
    }

    /**
     * @param txtPesquisa the txtPesquisa to set
     */
    public void setTxtPesquisa(javax.swing.JTextField txtPesquisa) {
        this.txtPesquisa = txtPesquisa;
    }

    /**
     * @return the btnEx
     */
    public JButton getBtnEx() {
        return btnEx;
    }

    /**
     * @return the btnEd
     */
    public JButton getBtnEd() {
        return btnEd;
    }

}
