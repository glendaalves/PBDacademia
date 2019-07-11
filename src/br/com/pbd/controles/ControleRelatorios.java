/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.Relatorios.RelatorioAluno;
import br.com.pbd.sql.SQLconexao;
import br.com.pbd.view.Principal;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleRelatorios implements ActionListener {

    Principal principal;
    private static final EntityManager manager = SQLconexao.getEntityManager();

    public ControleRelatorios(Principal principal) {
        this.principal = principal;
        principal.getBotaoRelatorios().addActionListener(this);
        principal.getRelatorios().getBotaoSair().addActionListener(this);
        principal.getRelatorios().getBotaoRaluno().addActionListener(this);
        principal.getRelatorios().getRelatorioAluno().getBotaoCancelar().addActionListener(this);
        principal.getRelatorios().getRelatorioAluno().getBotaoconfirmar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.getBotaoRelatorios()) {
            principal.Desativar();
        }
        if (e.getSource() == principal.getRelatorios().getRelatorioAluno().getBotaoconfirmar()) {

            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PBD", "postgres", "123");
            } catch (SQLException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

            HashMap params = new HashMap();
            Object para = principal.getRelatorios().getRelatorioAluno().getComboPosicao().getSelectedItem().toString();

            params.put("Situacao", para);

            //Invocando a geração do relatório 
            try {
                //Exibindo o relatório na tela para o usuário 
                JasperPrint print = JasperFillManager.fillReport("C:\\Users\\Glenda Alves de Lima\\Documents\\NetBeansProjects\\projetoPBD\\PBD2019.1\\src\\br\\com\\pbd\\RelatoriosView\\RelatorioAluno.jasper", params, conn); // Coloca ai o local, Onde você salvou o Seu reporte Tamplate
                JasperViewer jv = new JasperViewer(print, false);
                jv.setVisible(true); //chama o formulario para visualização
                jv.toFront(); //set o formulario a frente da aplicação
            } catch (Exception ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource()
                == principal.getRelatorios().getBotaoRaluno()) {
            principal.getRelatorios().getRelatorioAluno().setVisible(true);
            principal.getRelatorios().Desativar();
        }

        if (e.getSource()
                == principal.getRelatorios().getRelatorioAluno().getBotaoCancelar()) {
            principal.getRelatorios().Ativar();
            principal.getRelatorios().getRelatorioAluno().setVisible(false);

        }

        if (e.getSource()
                == principal.getRelatorios().getBotaoSair()) {
            principal.Ativar();
            principal.getRelatorios().setVisible(false);
        }
    }

}
