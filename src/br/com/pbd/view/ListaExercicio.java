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
public class ListaExercicio extends javax.swing.JInternalFrame {

    private JButton btnSelecio, btnEx;
    private Icon Iconselecionar, Iconexcluir;

    /**
     * Creates new form ListaExercicio
     */
    public ListaExercicio() {
        initComponents();

        Iconselecionar = new ImageIcon(getClass().getResource("/br/com/pbd/resource/selecionar.png"));
        Iconexcluir = new ImageIcon(getClass().getResource("/br/com/pbd/resource/Exclui.png"));
        
        btnSelecio = new JButton(Iconselecionar);
        btnSelecio.setName("Selecionar");
        btnSelecio.setBorder(null);
        btnSelecio.setContentAreaFilled(false);

        btnEx = new JButton(Iconexcluir);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        labelcadastro2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaexercicio = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        botaoFechar = new javax.swing.JButton();
        label1 = new java.awt.Label();
        pesquise = new br.com.pbd.modelos.JTextFieldHint(new JTextField(), "pesquisar", " Pesquise por Descrição Objetivo ou Nivel ");

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
        labelcadastro2.setText("exercícios");

        tabelaexercicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabelaexercicio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelaexercicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaexercicio.setFocusable(false);
        tabelaexercicio.setRowHeight(30);
        tabelaexercicio.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelaexercicio);
        if (tabelaexercicio.getColumnModel().getColumnCount() > 0) {
            tabelaexercicio.getColumnModel().getColumn(1).setMaxWidth(100);
            tabelaexercicio.getColumnModel().getColumn(2).setMaxWidth(100);
            tabelaexercicio.getColumnModel().getColumn(3).setMaxWidth(100);
            tabelaexercicio.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("DeVinne Txt BT", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Escolhas os Exercicios");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, 0))
        );

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

        label1.setText("Pesquisar :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelcadastro2)
                        .addGap(0, 785, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquise, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(botaoFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelcadastro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pesquise, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
    }//GEN-LAST:event_botaoFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFechar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JLabel labelcadastro2;
    private javax.swing.JTextField pesquise;
    private javax.swing.JTable tabelaexercicio;
    // End of variables declaration//GEN-END:variables

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
     * @return the jPanel3
     */
    public javax.swing.JPanel getjPanel3() {
        return jPanel3;
    }

    /**
     * @param jPanel3 the jPanel3 to set
     */
    public void setjPanel3(javax.swing.JPanel jPanel3) {
        this.jPanel3 = jPanel3;
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
     * @return the pesquise
     */
    public javax.swing.JTextField getPesquise() {
        return pesquise;
    }

    /**
     * @param pesquise the pesquise to set
     */
    public void setPesquise(javax.swing.JTextField pesquise) {
        this.pesquise = pesquise;
    }


    /**
     * @return the tabelaexercicio
     */
    public javax.swing.JTable getTabelaexercicio() {
        return tabelaexercicio;
    }

    /**
     * @param tabelaexercicio the tabelaexercicio to set
     */
    public void setTabelaexercicio(javax.swing.JTable tabelaexercicio) {
        this.tabelaexercicio = tabelaexercicio;
    }

    /**
     * @return the btnSelecio
     */
    public JButton getBtnSelecio() {
        return btnSelecio;
    }

    /**
     * @return the btnEx
     */
    public JButton getBtnEx() {
        return btnEx;
    }

}
