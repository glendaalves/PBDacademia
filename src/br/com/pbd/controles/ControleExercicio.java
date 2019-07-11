/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Academia;
import br.com.pbd.modelos.Exercicio;
import br.com.pbd.modelos.Render;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.Principal;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.persistence.NoResultException;
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
public class ControleExercicio extends MouseAdapter implements ActionListener {

    private Principal principal;
    private List<Exercicio> exercicios;
    private Exercicio ex;
    private Academia u;
    private int escolha;
    private final int salvar = 0, editar = 1, excluir = 2;
    private ControleLogin controleLogin;
    private Mensagens mensagens;
    private Fachada fachada;

    public ControleExercicio(Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;

        principal.getAgendaExercicios().getBotaosalvar().addActionListener(this);
        principal.getExercicio().getBotaoSalvar().addActionListener(this);
        principal.getBotaoExercicio().addActionListener(this);
        principal.getExercicio().getTabelaExercico().addMouseListener(this);
        principal.getExercicio().getBotaocancelar().addActionListener(this);
        principal.getExercicio().getBotaoFechar().addActionListener(this);
        principal.getExercicio().getBotaoadicionar().addActionListener(this);

        mensagens = new Mensagens(principal, true);

        principal.getExercicio().getTxtPesquisa().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                exercicios = fachada.Busca(principal.getExercicio().getTxtPesquisa().getText());
                preencherTabela(exercicios);
            }

        });

    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == principal.getExercicio().getTabelaExercico()) {
            int ro = retornaIndice(principal.getExercicio().getTabelaExercico(), e);
            ex = exercicios.get(ro);
            if (escolha == editar) {
                for (Component cp : principal.getExercicio().getPainelCadastro().getComponents()) {
                    cp.setEnabled(true);
                }
                principal.getExercicio().getLabelcadastro().setText("ATUALIZAR EXERCICIO");
                principal.getExercicio().getBotaoadicionar().setVisible(false);
                principal.getExercicio().getBotaoFechar().setVisible(false);
                principal.getExercicio().getTabelaExercico().setVisible(false);
                principal.getExercicio().getjScrollPane2().setVisible(false);
                principal.getExercicio().getTxtPesquisa().setVisible(false);
                principal.getExercicio().getLabel6().setVisible(false);
                principal.getExercicio().getPanellist().setVisible(false);
                principal.getExercicio().preencherCadastro(ex);
                exercicios = fachada.getAllE();
                preencherTabela(exercicios);
                principal.getExercicio().getTxtPesquisa().setText("");

            }
            if (escolha == excluir) {

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == principal.getBotaoExercicio()) {
            exercicios = fachada.getAllE();
            preencherTabela(exercicios);
            principal.Desativar();
            principal.getExercicio().getTxtPesquisa().setText("");
            principal.getExercicio().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getExercicio().getPainelCadastro().getComponents()) {
                cp.setEnabled(false);
            }
        }
        if (e.getSource() == principal.getExercicio().getBotaoadicionar()) {
            escolha = salvar;
            exercicios = fachada.getAllE();
            preencherTabela(exercicios);
            principal.getExercicio().getTxtPesquisa().setText("");
            for (Component cp : principal.getExercicio().getPainelCadastro().getComponents()) {
                cp.setEnabled(true);
            }
        }
        if (e.getSource() == principal.getExercicio().getBotaoFechar()) {

            principal.getExercicio().setVisible(false);
            principal.getExercicio().Limpar();
            principal.getExercicio().getLabelcadastro().setText("EXERCICIO");
            if (controleLogin.getProfessor() != null) {
                principal.AtivarP();
            } else {
                principal.Ativar();
            }

        }
        if (e.getSource() == principal.getExercicio().getBotaocancelar()) {
            principal.getExercicio().getBotaoadicionar().setVisible(true);
            principal.getExercicio().getBotaoFechar().setVisible(true);
            principal.getExercicio().getTabelaExercico().setVisible(true);
            principal.getExercicio().getjScrollPane2().setVisible(true);
            principal.getExercicio().getTxtPesquisa().setVisible(true);
            principal.getExercicio().getLabel6().setVisible(true);
            principal.getExercicio().getPanellist().setVisible(true);
            principal.getExercicio().Limpar();
            principal.getExercicio().getLabelcadastro().setText("EXERCICIO");
            principal.getExercicio().getTxtPesquisa().grabFocus();
            principal.getExercicio().getTxtPesquisa().setText("");
            exercicios = fachada.getAllE();
            preencherTabela(exercicios);
            for (Component cp : principal.getExercicio().getPainelCadastro().getComponents()) {
                cp.setEnabled(false);
            }

        }

        if (e.getSource() == principal.getExercicio().getBotaoSalvar()) {
            if (escolha == salvar) {
                salvarExercicio();

            }
            if (escolha == editar) {
                EditarExercicio(ex);

            }

        }
    }

    public void salvarExercicio() {

        try {
            u = fachada.buscaUltimoRegistro();
            Exercicio exercicio = new Exercicio();
            exercicio.setDescricao(principal.getExercicio().getTxttipo().getText());

            String peso = principal.getExercicio().getTxtpeso().getText();
            String repeticao = principal.getExercicio().getTxtrepeticao().getText();
            String serie = principal.getExercicio().getTxtserie().getText();
            int repetica = 0, seri = 0;
            Double pes = 0.0;

            repetica = Integer.parseInt(repeticao);
            seri = Integer.parseInt(serie);
            pes = Double.parseDouble(peso);

            exercicio.setPeso(pes);
            exercicio.setRepeticao(repetica);
            exercicio.setSerie(seri);
            exercicio.setIntervalo(principal.getExercicio().getTxtintervalo().getText());
            exercicio.setTreino(principal.getExercicio().getCombotreino().getSelectedItem().toString());
            exercicio.setAcademia(u);
            exercicio.setNivel(principal.getExercicio().getCombonivel().getSelectedItem().toString());
            fachada.salvar(exercicio);
            mensagens.mensagens("Cadastrado com Sucesso", "info");
            exercicios = fachada.getAllE();
            preencherTabela(exercicios);
            principal.getExercicio().Limpar();
            principal.getExercicio().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getExercicio().getPainelCadastro().getComponents()) {
                cp.setEnabled(false);
            }

        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Valores Invalido !!!", "erro");
        } catch (NoResultException uy) {
            mensagens.mensagens("Cadastre a Academia ", "advertencia");
        }

    }

    public void preencherTabela(List<Exercicio> lista) {

        principal.getExercicio().getTabelaExercico().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Descricao", "Serie", "Repetiçoes", "Peso (Kg)", "Intervalo", "Objetivo", "Nivel", "Editar", "Ecluir"};
            Object[][] dados = new Object[lista.size()][9];
            for (int i = 0; i < lista.size(); i++) {

                Exercicio e = lista.get(i);
                dados[i][0] = e.getDescricao();
                dados[i][1] = e.getSerie();
                dados[i][2] = e.getRepeticao();
                dados[i][3] = e.getPeso();
                dados[i][4] = e.getIntervalo();
                dados[i][5] = e.getTreino();
                dados[i][6] = e.getNivel();
                dados[i][7] = principal.getExercicio().getBtnEd();
                dados[i][8] = principal.getExercicio().getBtnEx();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getExercicio().getTabelaExercico().getColumnModel();
            principal.getExercicio().getTabelaExercico().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void EditarExercicio(Exercicio ex) {

        try {
            u = fachada.buscaUltimoRegistro();

            ex.setDescricao(principal.getExercicio().getTxttipo().getText());

            String peso = principal.getExercicio().getTxtpeso().getText();
            String repeticao = principal.getExercicio().getTxtrepeticao().getText();
            String serie = principal.getExercicio().getTxtserie().getText();
            int repetica = 0, seri = 0;
            Double pes = 0.0;

            repetica = Integer.parseInt(repeticao);
            seri = Integer.parseInt(serie);
            pes = Double.parseDouble(peso);

            ex.setPeso(pes);
            ex.setRepeticao(repetica);
            ex.setSerie(seri);
            ex.setIntervalo(principal.getExercicio().getTxtintervalo().getText());

            ex.setTreino(principal.getExercicio().getCombotreino().getSelectedItem().toString());
            ex.setAcademia(u);
            fachada.salvar(ex);
            mensagens.mensagens("Editado com Sucesso", "info");
            exercicios = fachada.getAllE();
            preencherTabela(exercicios);
            principal.getExercicio().getTabelaExercico().setVisible(true);
            principal.getExercicio().getjScrollPane2().setVisible(true);
            principal.getExercicio().getTxtPesquisa().setVisible(true);
            principal.getExercicio().getLabel6().setVisible(true);
            principal.getExercicio().getPanellist().setVisible(true);
            principal.getExercicio().Limpar();
            principal.getExercicio().getLabelcadastro().setText("EXERCICIO");
            principal.getExercicio().getBotaoadicionar().setVisible(true);
            principal.getExercicio().getBotaoFechar().setVisible(true);
            principal.getExercicio().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getExercicio().getPainelCadastro().getComponents()) {
                cp.setEnabled(false);
            }

        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Valores Invalido !!!", "erro");
        } catch (NoResultException uy) {
            mensagens.mensagens("Erro !!!", "erro");
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
