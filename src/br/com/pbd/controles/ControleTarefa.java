/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Render;
import br.com.pbd.modelos.Tarefa;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.Principal;
import br.com.pbd.view.TelaTarefa;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleTarefa extends MouseAdapter implements ActionListener {

    private Principal principal;
    private List<Tarefa> tarefas;
    private Tarefa tarefa;
    private java.sql.Date dataF, dataI;
    private int escolha;
    private final int salvar = 0, editar = 1, excluir = 2;
    private Fachada fachada;

    private Mensagens mensagens;

    public ControleTarefa(Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;
        principal.getTarefa().getBotaoSalvar().addActionListener(this);
        principal.getBotaoTarefa().addActionListener(this);
        principal.getTarefa().getTabelaTarefas().addMouseListener(this);
        principal.getTarefa().getBotaoFechar().addActionListener(this);
        principal.getTarefa().getBotaoAdiciona().addActionListener(this);
        principal.getTarefa().getBotaoCancelar().addActionListener(this);
        mensagens = new Mensagens(principal, true);

        principal.getTarefa().getTxtPesquisa().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                tarefas = fachada.buscaT(principal.getTarefa().getTxtPesquisa().getText());
                preencherTabela(tarefas);
            }

        });

    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == principal.getTarefa().getTabelaTarefas()) {
            int ro = retornaIndice(principal.getTarefa().getTabelaTarefas(), e);
            tarefa = tarefas.get(ro);
            if (escolha == editar) {
                for (Component cp : principal.getTarefa().getPanelCadastro().getComponents()) {
                    cp.setEnabled(true);
                }
                principal.getTarefa().getLabelcadastro2().setText("ATUALIZAR TAREFA");
                principal.getTarefa().getBotaoAdiciona().setVisible(false);
                principal.getTarefa().getBotaoFechar().setVisible(false);
                principal.getTarefa().getTabelaTarefas().setVisible(false);
                principal.getTarefa().getjScrollPane2().setVisible(false);
                principal.getTarefa().getTxtPesquisa().setVisible(false);
                principal.getTarefa().getLabel6().setVisible(false);
                principal.getTarefa().getPanellist().setVisible(false);
                principal.getTarefa().getDatainicial().setEnabled(false);
                principal.getTarefa().preencherCadastro(tarefa);
                tarefas = fachada.getAllT();
                preencherTabela(tarefas);
                principal.getTarefa().getTxtPesquisa().setText("");

            }
            if (escolha == excluir) {

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == principal.getBotaoTarefa()) {
            tarefas = fachada.getAllT();
            preencherTabela(tarefas);
            principal.getTarefa().Limpar();
            principal.Desativar();
            principal.getTarefa().getTxtPesquisa().setText("");
            principal.getTarefa().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getTarefa().getPanelCadastro().getComponents()) {
                cp.setEnabled(false);
            }
        }
        if (e.getSource() == principal.getTarefa().getBotaoAdiciona()) {
            escolha = salvar;
            tarefas = fachada.getAllT();
            preencherTabela(tarefas);
            principal.getTarefa().getTxtPesquisa().setText("");
            for (Component cp : principal.getTarefa().getPanelCadastro().getComponents()) {
                cp.setEnabled(true);
            }
        }
        if (e.getSource() == principal.getTarefa().getBotaoFechar()) {
            principal.getTarefa().setVisible(false);
            principal.getTarefa().getLabelcadastro2().setText(" TAREFA");
            principal.Ativar();
        }
        if (e.getSource() == principal.getTarefa().getBotaoCancelar()) {

            principal.getTarefa().getTabelaTarefas().setVisible(true);
            principal.getTarefa().getBotaoAdiciona().setVisible(true);
            principal.getTarefa().getBotaoFechar().setVisible(true);
            principal.getTarefa().getjScrollPane2().setVisible(true);
            principal.getTarefa().getTxtPesquisa().setVisible(true);
            principal.getTarefa().getLabel6().setVisible(true);
            principal.getTarefa().getPanellist().setVisible(true);
            principal.getTarefa().getDatainicial().setEnabled(true);
            principal.getTarefa().Limpar();
            principal.getTarefa().getTxtPesquisa().setText("");
            tarefas = fachada.getAllT();
            preencherTabela(tarefas);
            principal.getTarefa().getLabelcadastro2().setText(" TAREFA");
            principal.getTarefa().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getTarefa().getPanelCadastro().getComponents()) {
                cp.setEnabled(false);
            }
        }

        if (e.getSource() == principal.getTarefa().getBotaoSalvar()) {
            if (escolha == salvar) {
                salvarTarefa();

            }
            if (escolha == editar) {
                EditarTarefa(tarefa);

            }
        }

    }

    public void salvarTarefa() {

        Tarefa tarefa = new Tarefa();

        try {
            dataI = ConverterData(principal.getTarefa().getDatainicial().getDate());
            tarefa.setData_inicial(dataI);
            dataF = ConverterData(principal.getTarefa().getDatafinal().getDate());
            tarefa.setDate_final(dataF);

            tarefa.setDescricao(principal.getTarefa().getDescrição().getText());
            tarefa.setPrioridade(principal.getTarefa().getComboprioridade().getSelectedItem().toString());
            tarefa.setStatus(principal.getTarefa().getCombostatus().getSelectedItem().toString());
            tarefa.setFuncionario(ControleLogin.getFuncionario());
            fachada.salvar(tarefa);
            mensagens.mensagens("Cadastrado com Sucesso", "info");
            tarefas = fachada.getAllT();
            preencherTabela(tarefas);
            principal.getTarefa().Limpar();
            principal.getTarefa().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getTarefa().getPanelCadastro().getComponents()) {
                cp.setEnabled(false);
            }
        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("voce precisa preencher todos os campos!", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (java.lang.NullPointerException e) {
            mensagens.mensagens("Erro !!! Data Invaida", "erro");
        }

    }

    public java.sql.Date ConverterData(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public void preencherTabela(List<Tarefa> lista) {

        principal.getTarefa().getTabelaTarefas().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Funcionario ", "Descricao", "Data Final", "Prioridades", "Status", "Editar", "Ecluir"};
            Object[][] dados = new Object[lista.size()][7];
            for (int i = 0; i < lista.size(); i++) {

                Tarefa e = lista.get(i);
                dados[i][0] = e.getFuncionario().getNome();
                dados[i][1] = e.getDescricao();
                dados[i][2] = e.getDate_final();
                dados[i][3] = e.getPrioridade();
                dados[i][4] = e.getStatus();
                dados[i][5] = principal.getTarefa().getBtnEd();
                dados[i][6] = principal.getTarefa().getBtnEx();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getTarefa().getTabelaTarefas().getColumnModel();
            principal.getTarefa().getTabelaTarefas().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void EditarTarefa(Tarefa tare) {

        try {
            tare.setDescricao(principal.getTarefa().getDescrição().getText());
            tare.setPrioridade(principal.getTarefa().getComboprioridade().getSelectedItem().toString());
            tare.setStatus(principal.getTarefa().getCombostatus().getSelectedItem().toString());
            tare.setFuncionario(ControleLogin.getFuncionario());

            dataF = ConverterData(principal.getTarefa().getDatafinal().getDate());
            tare.setDate_final(dataF);
            fachada.salvar(tarefa);
            mensagens.mensagens("Editado com Sucesso", "info");
            principal.getTarefa().setVisible(true);
            tarefas = fachada.getAllT();
            preencherTabela(tarefas);
            principal.getTarefa().getTabelaTarefas().setVisible(true);
            principal.getTarefa().getjScrollPane2().setVisible(true);
            principal.getTarefa().getTxtPesquisa().setVisible(true);
            principal.getTarefa().getLabel6().setVisible(true);
            principal.getTarefa().getPanellist().setVisible(true);
            principal.getTarefa().getDatainicial().setEnabled(true);
            principal.getTarefa().Limpar();
            principal.getTarefa().getLabelcadastro2().setText(" TAREFA");
            principal.getTarefa().getBotaoAdiciona().setVisible(true);
            principal.getTarefa().getBotaoFechar().setVisible(true);
            principal.getTarefa().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getTarefa().getPanelCadastro().getComponents()) {
                cp.setEnabled(false);
            }
        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("voce precisa preencher todos os campos!", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (java.lang.NullPointerException e) {
            mensagens.mensagens("Erro !!! Data Invalida", "erro");
        }

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
                ro = tabela.getSelectedRow();
                if (boton.getName().equals("editar")) {
                    escolha = editar;

                }
                if (boton.getName().equals("excluir")) {
                    escolha = excluir;

                }

            }
        }
        return ro;
    }

}
