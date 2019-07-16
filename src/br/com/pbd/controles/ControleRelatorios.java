/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Funcionario;
import br.com.pbd.modelos.Professor;
import br.com.pbd.modelos.Render;
import br.com.pbd.sql.SQLconexao;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRVariable;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleRelatorios implements ActionListener {

    private Principal principal;
    private Mensagens mensagens;
    private Connection conn;
    private List<Professor> professors;
    private List<Funcionario> funcionarios;
    private Fachada fachada;

    public ControleRelatorios(Principal principal, Fachada fachada) throws SQLException {
        this.principal = principal;
        this.fachada = fachada;
        principal.getBotaoRelatorios().addActionListener(this);
        principal.getRelatorios().getBotaoSair().addActionListener(this);
        principal.getRelatorios().getBotaoRaluno().addActionListener(this);
        principal.getRelatorios().getBotaoRprofessor().addActionListener(this);
        principal.getRelatorios().getBotaoRfornecedor().addActionListener(this);
        principal.getRelatorios().getBotaoRfuncionario().addActionListener(this);
        principal.getRelatorios().getBotaoRconta().addActionListener(this);
        principal.getRelatorios().getBotaoRexercicio().addActionListener(this);
        principal.getRelatorios().getBotaoRcaixa().addActionListener(this);
        principal.getRelatorios().getRelatorioAluno().getBotaoCancelar().addActionListener(this);
        principal.getRelatorios().getRelatorioAluno().getBotaoconfirmar().addActionListener(this);
        principal.getRelatorios().getRelatorioFornecedor().getBotaoconfirmar().addActionListener(this);
        principal.getRelatorios().getRelatorioFornecedor().getBotaoCancelar().addActionListener(this);
        principal.getRelatorios().getRelatorioProfessor().getBotaoCancelar().addActionListener(this);
        principal.getRelatorios().getRelatorioProfessor().getBotaoconfirmar().addActionListener(this);
        principal.getRelatorios().getRelatorioProfessor().getBotaoconfirmaragenda().addActionListener(this);
        principal.getRelatorios().getRelatorioFuncionario().getBotaoCancelar().addActionListener(this);
        principal.getRelatorios().getRelatorioFuncionario().getBotaoconfirmar().addActionListener(this);
        principal.getRelatorios().getRelatorioFuncionario().getBotaoconfirmatarefa().addActionListener(this);
        principal.getRelatorios().getRelatorioContas().getBotaoCancelar().addActionListener(this);
        principal.getRelatorios().getRelatorioContas().getBotaoconfirmar().addActionListener(this);
        principal.getRelatorios().getRelatorioExercicio().getBotaoCancelar().addActionListener(this);
        principal.getRelatorios().getRelatorioExercicio().getBotaoconfirmar().addActionListener(this);
        principal.getRelatorios().getRelatorioVenda().getBotaoCancelar().addActionListener(this);
        principal.getRelatorios().getRelatorioVenda().getBotaoconfirmar().addActionListener(this);

        mensagens = new Mensagens(principal, true);
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PBD", "postgres", "123");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.getBotaoRelatorios()) {
            principal.Desativar();
        }
        if (e.getSource() == principal.getRelatorios().getRelatorioAluno().getBotaoconfirmar()) {

            try {
                exibirRelatorioAlun();
            } catch (SQLException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == principal.getRelatorios().getRelatorioFornecedor().getBotaoconfirmar()) {

            try {
                exibirRelatorioFornecedor();
            } catch (SQLException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == principal.getRelatorios().getRelatorioProfessor().getBotaoconfirmar()) {

            try {
                exibirRelatorioProfessoor();
            } catch (SQLException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == principal.getRelatorios().getRelatorioProfessor().getBotaoconfirmaragenda()) {

            try {
                exibirRelatorioProfessoorAgenda();
            } catch (SQLException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == principal.getRelatorios().getRelatorioFuncionario().getBotaoconfirmatarefa()) {

            try {
                exibirRelatorioFuncionarioTarefa();
            } catch (SQLException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == principal.getRelatorios().getRelatorioFuncionario().getBotaoconfirmar()) {

            try {
                exibirRelatorioFuncionario();
            } catch (SQLException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == principal.getRelatorios().getRelatorioContas().getBotaoconfirmar()) {

            try {
                exibirRelatorioConta();
            } catch (SQLException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == principal.getRelatorios().getRelatorioExercicio().getBotaoconfirmar()) {

            try {
                exibirRelatorioExercicio();
            } catch (SQLException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == principal.getRelatorios().getRelatorioVenda().getBotaoconfirmar()) {

            try {
                exibirRelatorioVenda();
            } catch (SQLException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(ControleRelatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
         if (e.getSource() == principal.getRelatorios().getBotaoRcaixa()) {
            preencherFuncionario();
            principal.getRelatorios().getRelatorioVenda().setVisible(true);
            principal.getRelatorios().Desativar();
        }
        if (e.getSource() == principal.getRelatorios().getRelatorioVenda().getBotaoCancelar()) {
            principal.getRelatorios().Ativar();
            principal.getRelatorios().getRelatorioVenda().setVisible(false);
        }
        if (e.getSource() == principal.getRelatorios().getBotaoRexercicio()) {
            preencherFuncionario();
            principal.getRelatorios().getRelatorioExercicio().setVisible(true);
            principal.getRelatorios().Desativar();
        }
        if (e.getSource() == principal.getRelatorios().getRelatorioExercicio().getBotaoCancelar()) {
            principal.getRelatorios().Ativar();
            principal.getRelatorios().getRelatorioExercicio().setVisible(false);
        }
        if (e.getSource() == principal.getRelatorios().getBotaoRconta()) {
            preencherFuncionario();
            principal.getRelatorios().getRelatorioContas().setVisible(true);
            principal.getRelatorios().Desativar();
        }
        if (e.getSource() == principal.getRelatorios().getRelatorioContas().getBotaoCancelar()) {
            principal.getRelatorios().Ativar();
            principal.getRelatorios().getRelatorioContas().setVisible(false);
        }
        if (e.getSource() == principal.getRelatorios().getBotaoRfuncionario()) {
            preencherFuncionario();
            principal.getRelatorios().getRelatorioFuncionario().setVisible(true);
            principal.getRelatorios().Desativar();
        }
        if (e.getSource() == principal.getRelatorios().getRelatorioFuncionario().getBotaoCancelar()) {
            principal.getRelatorios().Ativar();
            principal.getRelatorios().getRelatorioFuncionario().setVisible(false);
        }
        if (e.getSource() == principal.getRelatorios().getBotaoRaluno()) {
            principal.getRelatorios().getRelatorioAluno().setVisible(true);
            principal.getRelatorios().Desativar();
        }
        if (e.getSource() == principal.getRelatorios().getBotaoRfornecedor()) {
            principal.getRelatorios().getRelatorioFornecedor().setVisible(true);
            principal.getRelatorios().Desativar();
        }
        if (e.getSource()
                == principal.getRelatorios().getRelatorioFornecedor().getBotaoCancelar()) {
            principal.getRelatorios().Ativar();
            principal.getRelatorios().getRelatorioFornecedor().setVisible(false);
        }
        if (e.getSource()
                == principal.getRelatorios().getRelatorioAluno().getBotaoCancelar()) {
            principal.getRelatorios().Ativar();
            principal.getRelatorios().getRelatorioAluno().setVisible(false);

        }
        if (e.getSource() == principal.getRelatorios().getBotaoRprofessor()) {
            preencherProfessor();
            principal.getRelatorios().getRelatorioProfessor().setVisible(true);
            principal.getRelatorios().Desativar();
        }
        if (e.getSource()
                == principal.getRelatorios().getRelatorioProfessor().getBotaoCancelar()) {
            principal.getRelatorios().Ativar();
            principal.getRelatorios().getRelatorioProfessor().setVisible(false);
        }

        if (e.getSource() == principal.getRelatorios().getBotaoSair()) {
            principal.Ativar();
            principal.getRelatorios().setVisible(false);
        }
    }

    public void preencherProfessor() {
        professors = fachada.getAllPro();
        principal.getRelatorios().getRelatorioProfessor().getComboProfessor().removeAllItems();
        for (Professor pro : professors) {
            principal.getRelatorios().getRelatorioProfessor().getComboProfessor().addItem(pro.getNome());

        }

    }

    public void preencherFuncionario() {
        funcionarios = fachada.getAllFun();
        principal.getRelatorios().getRelatorioFuncionario().getComboFuncionario().removeAllItems();
        for (Funcionario pro : funcionarios) {
            principal.getRelatorios().getRelatorioFuncionario().getComboFuncionario().addItem(pro.getNome());

        }

    }

    public void exibirRelatorioAlun() throws SQLException, JRException {

        InputStream fonte = ControleRelatorios.class.getResourceAsStream("/br/com/pbd/RelatoriosView/RelatorioAlun.jasper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Situacao", principal.getRelatorios().getRelatorioAluno().getComboPosicao().getSelectedItem().toString());
        map.put("DataInicio", principal.getRelatorios().getRelatorioAluno().getCalendarioIn().getDate());
        map.put("DataFinal", principal.getRelatorios().getRelatorioAluno().getCalendarioFin().getDate());
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fonte);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);

        JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
        jrviewer.setVisible(true);
        jrviewer.toFront();

    }

    public void exibirRelatorioFornecedor() throws SQLException, JRException {

        InputStream fonte = ControleRelatorios.class.getResourceAsStream("/br/com/pbd/RelatoriosView/RelatorioFornecedor.jasper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dataInicio", principal.getRelatorios().getRelatorioFornecedor().getCalendarioIn().getDate());
        map.put("DataFinal", principal.getRelatorios().getRelatorioFornecedor().getCalendarioFin().getDate());
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fonte);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
        JasperViewer jrviewer = new JasperViewer(jasperPrint, false);

        jrviewer.setVisible(true);
        jrviewer.toFront();

    }

    public void exibirRelatorioProfessoor() throws SQLException, JRException {

        InputStream fonte = ControleRelatorios.class.getResourceAsStream("/br/com/pbd/RelatoriosView/RelatorioProfessorPeriodo.jasper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dataInicio", principal.getRelatorios().getRelatorioProfessor().getCalendarioIn().getDate());
        map.put("DataFinal", principal.getRelatorios().getRelatorioProfessor().getCalendarioFin().getDate());
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fonte);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
        JasperViewer jrviewer = new JasperViewer(jasperPrint, false);

        jrviewer.setVisible(true);
        jrviewer.toFront();

    }

    public void exibirRelatorioProfessoorAgenda() throws SQLException, JRException {

        InputStream fonte = ControleRelatorios.class.getResourceAsStream("/br/com/pbd/RelatoriosView/RelatorioProfessorAgenda.jasper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Professor", principal.getRelatorios().getRelatorioProfessor().getComboProfessor().getSelectedItem().toString());
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fonte);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
        JasperViewer jrviewer = new JasperViewer(jasperPrint, false);

        jrviewer.setVisible(true);
        jrviewer.toFront();

    }

    public void exibirRelatorioFuncionarioTarefa() throws SQLException, JRException {

        InputStream fonte = ControleRelatorios.class.getResourceAsStream("/br/com/pbd/RelatoriosView/RelatorioFuncionarioTarefa.jasper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Funcionario", principal.getRelatorios().getRelatorioFuncionario().getComboFuncionario().getSelectedItem().toString());
        map.put("status", principal.getRelatorios().getRelatorioFuncionario().getCombostatus().getSelectedItem().toString());
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fonte);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
        JasperViewer jrviewer = new JasperViewer(jasperPrint, false);

        jrviewer.setVisible(true);
        jrviewer.toFront();

    }

    public void exibirRelatorioFuncionario() throws SQLException, JRException {

        InputStream fonte = ControleRelatorios.class.getResourceAsStream("/br/com/pbd/RelatoriosView/RelatorioFuncionario.jasper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dataInicio", principal.getRelatorios().getRelatorioFuncionario().getCalendarioIn().getDate());
        map.put("DataFinal", principal.getRelatorios().getRelatorioFuncionario().getCalendarioFin().getDate());
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fonte);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
        JasperViewer jrviewer = new JasperViewer(jasperPrint, false);

        jrviewer.setVisible(true);
        jrviewer.toFront();

    }

    public void exibirRelatorioConta() throws SQLException, JRException {

        InputStream fonte = ControleRelatorios.class.getResourceAsStream("/br/com/pbd/RelatoriosView/RelatorioContas.jasper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", principal.getRelatorios().getRelatorioContas().getComboconta().getSelectedItem().toString());
        map.put("DataInicio", principal.getRelatorios().getRelatorioContas().getCalendarioIn().getDate());
        map.put("DataFinal", principal.getRelatorios().getRelatorioContas().getCalendarioFin().getDate());
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fonte);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
        JasperViewer jrviewer = new JasperViewer(jasperPrint, false);

        jrviewer.setVisible(true);
        jrviewer.toFront();

    }

    public void exibirRelatorioExercicio() throws SQLException, JRException {

        InputStream fonte = ControleRelatorios.class.getResourceAsStream("/br/com/pbd/RelatoriosView/RelatorioExercicio.jasper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("s", principal.getRelatorios().getRelatorioExercicio().getCombotreino().getSelectedItem().toString());
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fonte);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
        JasperViewer jrviewer = new JasperViewer(jasperPrint, false);

        jrviewer.setVisible(true);
        jrviewer.toFront();

    }
     public void exibirRelatorioVenda() throws SQLException, JRException {

        InputStream fonte = ControleRelatorios.class.getResourceAsStream("/br/com/pbd/RelatoriosView/RelatorioVenda.jasper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("situacao", principal.getRelatorios().getRelatorioVenda().getCalendariodata().getDate());
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fonte);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
        JasperViewer jrviewer = new JasperViewer(jasperPrint, false);

        jrviewer.setVisible(true);
        jrviewer.toFront();

    }
}
