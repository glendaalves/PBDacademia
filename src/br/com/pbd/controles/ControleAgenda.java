/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.Daos.DaoAgenda;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Agenda;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Exercicio;
import br.com.pbd.modelos.Professor;
import br.com.pbd.modelos.Render;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleAgenda extends MouseAdapter implements ActionListener {

    private Principal principal;
    private List<Aluno> alunos;
    private Aluno aluno;
    private List<Professor> professors;
    private List<Agenda> agendas;
    private List<Exercicio> exercicios, listaagendada;
    private Exercicio ex;
    private Agenda agenda;
    private Long id;
    private int escolha;
    private final int salvar = 0, editar = 1, excluir = 2;
    private ControleLogin controleLogin;
    private Mensagens mensagens;
    private Fachada fachada;

    public ControleAgenda(Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;

        principal.getAgendaExercicios().getBotaosalvar().addActionListener(this);
        principal.getBotaoAgenda().addActionListener(this);
        principal.getAgendaExercicios().getTabelaAgendamento().addMouseListener(this);
        principal.getAgendaExercicios().getBotaoFechar().addActionListener(this);

        exercicios = new ArrayList<Exercicio>();
        listaagendada = new ArrayList<Exercicio>();
        agendas = new ArrayList<Agenda>();
        mensagens = new Mensagens(principal, true);

        principal.getAgendaExercicios().getComboturno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.getAgendaExercicios().getComboHorario().removeAllItems();
                preencherHorario();
            }
        });

        principal.getAgendaExercicios().getComboAluno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preencherTabela();
            }
        });

    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == principal.getAgendaExercicios().getTabelaAgendamento()) {
            int ro = retornaIndice(principal.getAgendaExercicios().getTabelaAgendamento(), e);
            agenda = agendas.get(ro);
            if (escolha == editar) {
                principal.getAgendaExercicios().getBotaosalvar().setEnabled(true);
                principal.getAgendaExercicios().getBotaoFechar().setText("Cancelar");
                principal.getAgendaExercicios().getTxtdia().setText(agenda.getDia_semana());
                principal.getAgendaExercicios().getComboAluno().setEnabled(false);
                principal.getAgendaExercicios().getComboprofessor().setEnabled(true);
                principal.getAgendaExercicios().getComboHorario().setEnabled(true);
                principal.getAgendaExercicios().getComboturno().setEnabled(true);
            }
            if (escolha == excluir) {

            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == principal.getBotaoAgenda()) {
            preencherAluno();
            preencherProfessor();
            preencherHorario();
            principal.Desativar();
            principal.getAgendaExercicios().getBotaosalvar().setEnabled(false);
        }
        if (e.getSource() == principal.getAgendaExercicios().getBotaoFechar()) {
            if (principal.getAgendaExercicios().getBotaoFechar().getText().equals("Fechar")) {
                principal.getAgendaExercicios().setVisible(false);

                if (controleLogin.getProfessor() != null) {
                    principal.AtivarP();

                } else {
                    principal.Ativar();
                }
            } else {
                principal.getAgendaExercicios().getComboAluno().setEnabled(true);
                principal.getAgendaExercicios().getComboprofessor().setEnabled(false);
                principal.getAgendaExercicios().getComboHorario().setEnabled(false);
                principal.getAgendaExercicios().getComboturno().setEnabled(false);
                principal.getAgendaExercicios().Limpar();
                principal.getAgendaExercicios().getBotaoFechar().setText("Fechar");
                principal.getAgendaExercicios().getBotaosalvar().setEnabled(false);
            }
        }

        if (e.getSource() == principal.getAgendaExercicios().getBotaosalvar()
                && principal.getAgendaExercicios().getComboturno().isEnabled()) {

            int indiceA = principal.getAgendaExercicios().getComboAluno().getSelectedIndex();
            int indiceP = principal.getAgendaExercicios().getComboprofessor().getSelectedIndex();

            try {
                
                Aluno aluno = alunos.get(indiceA);
                Professor professor = professors.get(indiceP);

                agenda.setAluno(aluno);
                agenda.setProfessor(professor);

                agenda.setHorario(ConverterTime(principal.getAgendaExercicios().getComboHorario().getSelectedItem().toString()));
                agenda.setTurno(principal.getAgendaExercicios().getComboturno().getSelectedItem().toString());
                fachada.salvar(agenda);

                mensagens.mensagens("Agendado com Sucesso", "info");

                principal.getAgendaExercicios().getComboAluno().setEnabled(true);
                principal.getAgendaExercicios().getComboprofessor().setEnabled(false);
                principal.getAgendaExercicios().getComboHorario().setEnabled(false);
                principal.getAgendaExercicios().getComboturno().setEnabled(false);
                principal.getAgendaExercicios().Limpar();
                preencherTabela();
                principal.getAgendaExercicios().getBotaoFechar().setText("Fechar");
                principal.getAgendaExercicios().getBotaosalvar().setEnabled(false);

            } catch (java.lang.IllegalStateException n) {
                mensagens.mensagens("Voce precisa preencher todos os campos !", "advertencia");
                mensagens.setVisible(true);
            } catch (javax.persistence.RollbackException roll) {
                mensagens.mensagens("Erro !!!", "erro");
            }catch (java.lang.ArrayIndexOutOfBoundsException erro) {
                mensagens.mensagens("Erro !!! Aluno ou Professor Invalido", "erro");
        } 
           
        }

    }

    public void preencherAluno() {
        alunos = fachada.getAll();
        principal.getAgendaExercicios().getComboAluno().removeAllItems();
        for (Aluno p : alunos) {
            principal.getAgendaExercicios().getComboAluno().addItem(p.getNome());

        }

    }

    public void preencherProfessor() {
        professors = new DaoGenerico<Professor>().getAll(Professor.class);
        principal.getAgendaExercicios().getComboprofessor().removeAllItems();
        for (Professor pro : professors) {
            principal.getAgendaExercicios().getComboprofessor().addItem(pro.getNome());

        }

    }

    public void preencherHorario() {

        if (principal.getAgendaExercicios().getComboturno().getSelectedItem().equals("MANHÃ")) {
            manha();

        } else if (principal.getAgendaExercicios().getComboturno().getSelectedItem().equals("TARDE")) {
            tarde();

        } else if (principal.getAgendaExercicios().getComboturno().getSelectedItem().equals("NOITE")) {
            noite();

        }

    }

    public void preencherTabela() {
        int indiceA = principal.getAgendaExercicios().getComboAluno().getSelectedIndex();
        if (indiceA > -1) {
            aluno = alunos.get(indiceA);
            agendas = new DaoAgenda().usandoID(aluno);
        }

        principal.getAgendaExercicios().getTabelaAgendamento().setDefaultRenderer(Object.class, new Render());

        int i = 0;
        String turno = "Não Definido", professor = "Não Escolhido", horario = "Não Definido";

        try {
            String[] colunas = new String[]{"Aluno", "Professor", "Dias", "Turno", "Horario", "Editar", "Ecluir"};
            Object[][] dados = new Object[agendas.size()][7];
            for (Agenda a : agendas) {

                if (a.getProfessor() == null) {
                    dados[i][0] = aluno.getNome();
                    dados[i][1] = professor;
                    dados[i][2] = a.getDia_semana();
                    dados[i][3] = turno;
                    dados[i][4] = horario;
                    dados[i][5] = principal.getAgendaExercicios().getBtnEd();
                    dados[i][6] = principal.getAgendaExercicios().getBtnEx();

                } else {
                    dados[i][0] = aluno.getNome();
                    dados[i][1] = a.getProfessor().getNome();
                    dados[i][2] = a.getDia_semana();
                    dados[i][3] = a.getTurno();
                    dados[i][4] = a.getHorario();
                    dados[i][5] = principal.getAgendaExercicios().getBtnEd();
                    dados[i][6] = principal.getAgendaExercicios().getBtnEx();

                }
                i++;
            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getAgendaExercicios().getTabelaAgendamento().getColumnModel();
            principal.getAgendaExercicios().getTabelaAgendamento().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void manha() {

        principal.getAgendaExercicios().getComboHorario().addItem("05:00");
        principal.getAgendaExercicios().getComboHorario().addItem("06:00");
        principal.getAgendaExercicios().getComboHorario().addItem("07:00");
        principal.getAgendaExercicios().getComboHorario().addItem("08:00");
        principal.getAgendaExercicios().getComboHorario().addItem("09:00");
        principal.getAgendaExercicios().getComboHorario().addItem("10:00");
        principal.getAgendaExercicios().getComboHorario().addItem("11:00");

    }

    public void tarde() {

        principal.getAgendaExercicios().getComboHorario().addItem("12:00");
        principal.getAgendaExercicios().getComboHorario().addItem("13:00");
        principal.getAgendaExercicios().getComboHorario().addItem("14:00");
        principal.getAgendaExercicios().getComboHorario().addItem("15:00");
        principal.getAgendaExercicios().getComboHorario().addItem("16:00");
        principal.getAgendaExercicios().getComboHorario().addItem("17:00");

    }

    public void noite() {

        principal.getAgendaExercicios().getComboHorario().addItem("18:00");
        principal.getAgendaExercicios().getComboHorario().addItem("19:00");
        principal.getAgendaExercicios().getComboHorario().addItem("20:00");
        principal.getAgendaExercicios().getComboHorario().addItem("21:00");
        principal.getAgendaExercicios().getComboHorario().addItem("22:00");
        principal.getAgendaExercicios().getComboHorario().addItem("23:00");
        principal.getAgendaExercicios().getComboHorario().addItem("00:00");

    }

    public java.sql.Time ConverterTime(String relogio) {
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
        java.util.Date data = null;
        try {
            data = formatador.parse(relogio);
        } catch (ParseException ex) {
            Logger.getLogger(ControleAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Time(data.getTime());

    }

    private int retornaIndice(JTable tabela, MouseEvent e) {
        int ro = 0;
        int column = tabela.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / tabela.getRowHeight();

        if (row < tabela.getRowCount() && row >= 0 && column < tabela.getColumnCount() && column >= 0) {
            Object value = tabela.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                if (boton.getName().equals("editar")) {
                    ro = tabela.getSelectedRow();
                    escolha = editar;

                }
                if (boton.getName().equals("excluir")) {
                    ro = tabela.getSelectedRow();
                    escolha = excluir;

                }

            }
        }
        return ro;
    }

}
