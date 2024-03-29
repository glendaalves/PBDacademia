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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Glenda Alves de Lima
 */
public class Acesso extends javax.swing.JDialog {

    private JButton btnRe, btnEd;
    private Icon IconRes, IconEditar;

    /**
     * Creates new form Acesso
     */
    public Acesso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        IconEditar = new ImageIcon(getClass().getResource("/br/com/pbd/resource/editarr.png"));
        IconRes = new ImageIcon(getClass().getResource("/br/com/pbd/resource/Exclui.png"));
        
        btnRe = new JButton(getIconRes());
        btnRe.setName("reset");
        btnRe.setBorder(null);
        btnRe.setContentAreaFilled(false);

        btnEd = new JButton(getIconEditar());
        btnEd.setName("editar");
        btnEd.setBorder(null);
        btnEd.setContentAreaFilled(false);
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
        label1 = new java.awt.Label();
        txtnome = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        senha = new br.com.pbd.modelos.JPassWordFieldHint(new JPasswordField(), "p", "Senha");  ;
        confirmar = new br.com.pbd.modelos.JPassWordFieldHint(new JPasswordField(), "p", "Senha");  ;
        botaosalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(399, 422));

        label1.setText("Usuario :");

        txtnome.setEnabled(false);

        label2.setText("Nova Senha :");

        label3.setText("Confirmar Senha :");

        botaosalvar.setBackground(new java.awt.Color(255, 255, 255));
        botaosalvar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaosalvar.setForeground(new java.awt.Color(0, 102, 102));
        botaosalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/Salva.png"))); // NOI18N
        botaosalvar.setText("Salvar");
        botaosalvar.setBorderPainted(false);
        botaosalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaosalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaosalvarMouseExited(evt);
            }
        });
        botaosalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaosalvarActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pbd/resource/585e4beacb11b227491c3399.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaosalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(botaosalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );

        setBounds(650, 220, 415, 456);
    }// </editor-fold>//GEN-END:initComponents

    private void botaosalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaosalvarMouseEntered
        getBotaosalvar().setBackground(new Color(204, 204, 204)); // cor de fundo quando aparece
        getBotaosalvar().setForeground(new Color(255, 255, 255)); // cor da letra quando aparece
    }//GEN-LAST:event_botaosalvarMouseEntered

    private void botaosalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaosalvarMouseExited
        getBotaosalvar().setBackground(new Color(255, 255, 255));// Fundo Quando Solta
        getBotaosalvar().setForeground(new Color(0, 102, 102));// letra quando solta cor
    }//GEN-LAST:event_botaosalvarMouseExited

    private void botaosalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaosalvarActionPerformed

    }//GEN-LAST:event_botaosalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Acesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Acesso dialog = new Acesso(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaosalvar;
    private javax.swing.JTextField confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JTextField senha;
    private javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables

    public void limpa(){
        senha.setText("");
        confirmar.setText("");
    }
    /**
     * @return the btnRe
     */
    public JButton getBtnRe() {
        return btnRe;
    }

    /**
     * @param btnRe the btnRe to set
     */
    public void setBtnRe(JButton btnRe) {
        this.btnRe = btnRe;
    }

    /**
     * @return the btnEd
     */
    public JButton getBtnEd() {
        return btnEd;
    }

    /**
     * @param btnEd the btnEd to set
     */
    public void setBtnEd(JButton btnEd) {
        this.btnEd = btnEd;
    }

    /**
     * @return the IconRes
     */
    public Icon getIconRes() {
        return IconRes;
    }

    /**
     * @param IconRes the IconRes to set
     */
    public void setIconRes(Icon IconRes) {
        this.IconRes = IconRes;
    }

    /**
     * @return the IconEditar
     */
    public Icon getIconEditar() {
        return IconEditar;
    }

    /**
     * @param IconEditar the IconEditar to set
     */
    public void setIconEditar(Icon IconEditar) {
        this.IconEditar = IconEditar;
    }

    /**
     * @return the botaosalvar
     */
    public javax.swing.JButton getBotaosalvar() {
        return botaosalvar;
    }

    /**
     * @param botaosalvar the botaosalvar to set
     */
    public void setBotaosalvar(javax.swing.JButton botaosalvar) {
        this.botaosalvar = botaosalvar;
    }

    /**
     * @return the confirmar
     */
    public javax.swing.JTextField getConfirmar() {
        return confirmar;
    }

    /**
     * @param confirmar the confirmar to set
     */
    public void setConfirmar(javax.swing.JTextField confirmar) {
        this.confirmar = confirmar;
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
     * @return the senha
     */
    public javax.swing.JTextField getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(javax.swing.JTextField senha) {
        this.senha = senha;
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
