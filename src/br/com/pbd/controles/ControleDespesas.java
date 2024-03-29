/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.Daos.DaoCaixa;
import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Academia;
import br.com.pbd.modelos.Caixa;
import br.com.pbd.modelos.ContaaPagar;
import br.com.pbd.modelos.Render;
import br.com.pbd.view.Conta;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.Principal;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;
import javax.persistence.NoResultException;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleDespesas extends MouseAdapter implements ActionListener {

    private Principal principal;
    private ContaaPagar contaaPagar;
    private List<ContaaPagar> contaaPagars;
    private Academia u;
    private Fachada fachada;
    private Mensagens mensagens;
    private Caixa caixa;
    private int ro;
    private Conta conta;
    private int escolha;
    private final int salvar = 0, editar = 1, excluir = 2, pagar = 3;
    private double soma = 0.0;

    public ControleDespesas(Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;

        mensagens = new Mensagens(principal, true);
        principal.getBotaoDespesas().addActionListener(this);
        principal.getDespesas().getBotaoSalvarconta().addActionListener(this);
        principal.getDespesas().getBotaoFechar().addActionListener(this);
        principal.getDespesas().getBotaoadicionar().addActionListener(this);
        principal.getDespesas().getBotaoCancelar().addActionListener(this);
        principal.getDespesas().getTabelaconta().addMouseListener(this);
        conta = new Conta(principal, true);
        conta.getBotaook().addActionListener(this);

        principal.getDespesas().getTxtPesquisa().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                contaaPagars = fachada.buscaC(principal.getDespesas().getTxtPesquisa().getText());
                preencherTabela(contaaPagars);
            }

        });

        conta.getCombopagamento().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (conta.getCombopagamento().getSelectedItem().equals("cartâo")) {
                    conta.getLabel14().setVisible(true);
                    conta.getCombotipo().setVisible(true);
                } else {
                    conta.getLabel14().setVisible(false);
                    conta.getCombotipo().setVisible(false);
                }
            }
        });
    }

    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == principal.getDespesas().getTabelaconta()) {
            ro = retornaIndice(principal.getDespesas().getTabelaconta(), e);
            contaaPagar = contaaPagars.get(ro);
            if (escolha == editar) {
                for (Component cp : principal.getDespesas().getPanelContas().getComponents()) {
                    cp.setEnabled(true);
                }
                principal.getDespesas().preencherCadastro(contaaPagar);
                principal.getDespesas().getBotaoFechar().setVisible(false);
                principal.getDespesas().getBotaoadicionar().setVisible(false);
                principal.getDespesas().getLabelcadastro2().setText("ATUALIZAR DESPESA");
                principal.getDespesas().getTabelaconta().setVisible(false);
                principal.getDespesas().getjScrollPane2().setVisible(false);
                principal.getDespesas().getTxtPesquisa().setVisible(false);
                principal.getDespesas().getLabel6().setVisible(false);
                principal.getDespesas().getjPanel3().setVisible(false);
                contaaPagars = fachada.getAllC();
                preencherTabela(contaaPagars);
                principal.getDespesas().getTxtPesquisa().setText("");
            }
            if (escolha == excluir) {
                fachada.ativarDesativar(contaaPagar);
                mensagens.mensagens("Exclusão Realizada", "info");
                contaaPagars = fachada.getAllC();
                preencherTabela(contaaPagars);

            }
            if (escolha == pagar) {
                java.util.Date d = new java.util.Date();
                caixa = new DaoCaixa().BuscarCaixa(ConverterData(d));
                if (caixa.isStatus()) {
                    if (caixa.getValor_fechamento() > contaaPagar.getValor()) {
                        conta.getLabel14().setVisible(false);
                        conta.getCombotipo().setVisible(false);
                        conta.setVisible(true);
                    } else {
                        mensagens.mensagens("Dinheiro indisponivel ", "advertencia");
                    }
                } else {
                    mensagens.mensagens("Caixa Fechado", "info");
                }
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.getBotaoDespesas()) {
            principal.getDespesas().setVisible(true);
            contaaPagars = fachada.getAllC();
            preencherTabela(contaaPagars);
            principal.Desativar();
            principal.getDespesas().getTxtPesquisa().setText("");
            principal.getDespesas().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getDespesas().getPanelContas().getComponents()) {
                cp.setEnabled(false);
            }
        }
        if (e.getSource() == principal.getDespesas().getBotaoSalvarconta()) {
            if (escolha == salvar) {
                SalvarConta();

            }
            if (escolha == editar) {
                EditarConta(contaaPagar);
            }

        }
        if (e.getSource() == conta.getBotaook()) {
            pagarConta();
        }
        if (e.getSource() == principal.getDespesas().getBotaoFechar()) {
            principal.getDespesas().setVisible(false);
            principal.getDespesas().Limpar();
            principal.Ativar();
            principal.getDespesas().getLabelcadastro2().setText("DESPESAS");
        }
        if (e.getSource() == principal.getDespesas().getBotaoadicionar()) {
            escolha = salvar;
            principal.getDespesas().getTxtPesquisa().setText("");
            for (Component cp : principal.getDespesas().getPanelContas().getComponents()) {
                cp.setEnabled(true);
            }
        }
        if (e.getSource() == principal.getDespesas().getBotaoCancelar()) {
            principal.getDespesas().Limpar();
            principal.getDespesas().getBotaoFechar().setVisible(true);
            principal.getDespesas().getBotaoadicionar().setVisible(true);
            principal.getDespesas().getLabelcadastro2().setText("DESPESAS");
            principal.getDespesas().getTabelaconta().setVisible(true);
            principal.getDespesas().getjScrollPane2().setVisible(true);
            principal.getDespesas().getTxtPesquisa().setVisible(true);
            principal.getDespesas().getLabel6().setVisible(true);
            principal.getDespesas().getjPanel3().setVisible(true);
            principal.getDespesas().getTxtPesquisa().setText("");
            principal.getDespesas().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getDespesas().getPanelContas().getComponents()) {
                cp.setEnabled(false);
            }

        }

    }

    public void SalvarConta() {

        ContaaPagar contaaPagar = new ContaaPagar();

        try {
            u = fachada.buscaUltimoRegistro();
            contaaPagar.setAcademia(u);
            contaaPagar.setDescricao(principal.getDespesas().getDescricaoConta().getText());
            java.sql.Date dataV = ConverterData(principal.getDespesas().getDatavencimentoconta().getDate());
            contaaPagar.setData_vencimento(dataV);
            Double numero = 0.00;
            numero = Double.parseDouble(principal.getDespesas().getValorconta().getText());
            contaaPagar.setValor(numero);
            contaaPagar.setStatus("Debito");
            contaaPagar.setForma_pagamento("-----");
            contaaPagar.setTipo("-----");
            fachada.salvar(contaaPagar);
            mensagens.mensagens("Cadastrado com Sucesso", "info");
            for (Component cp : principal.getDespesas().getPanelContas().getComponents()) {
                cp.setEnabled(false);
            }
            contaaPagars = fachada.getAllC();
            preencherTabela(contaaPagars);
            principal.getDespesas().Limpar();
        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NoResultException uy) {
            mensagens.mensagens("Cadastre a Academia ", "advertencia");
        } catch (java.lang.NullPointerException e) {
            mensagens.mensagens("Erro!!! Data Invalida", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Erro!!! Valor Invalido ", "erro");
        }

    }

    public void EditarConta(ContaaPagar p) {

        try {

            p.setDescricao(principal.getDespesas().getDescricaoConta().getText());

            java.sql.Date dataV = ConverterData(principal.getDespesas().getDatavencimentoconta().getDate());
            p.setData_vencimento(dataV);
            Double numero = 0.00;
            numero = Double.parseDouble(principal.getDespesas().getValorconta().getText());
            p.setValor(numero);
            fachada.salvar(contaaPagar);
            mensagens.mensagens("Editado com Sucesso", "info");
            contaaPagars = fachada.getAllC();
            preencherTabela(contaaPagars);
            principal.getDespesas().Limpar();
            principal.getDespesas().getBotaoFechar().setVisible(true);
            principal.getDespesas().getBotaoadicionar().setVisible(true);
            principal.getDespesas().getLabelcadastro2().setText("DESPESAS");
            principal.getDespesas().getTabelaconta().setVisible(true);
            principal.getDespesas().getjScrollPane2().setVisible(true);
            principal.getDespesas().getTxtPesquisa().setVisible(true);
            principal.getDespesas().getLabel6().setVisible(true);
            principal.getDespesas().getjPanel3().setVisible(true);
            principal.getDespesas().getTxtPesquisa().setText("");
            principal.getDespesas().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getDespesas().getPanelContas().getComponents()) {
                cp.setEnabled(false);
            }
        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NoResultException uy) {
            mensagens.mensagens("Cadastre a Academia ", "advertencia");
        } catch (java.lang.NullPointerException e) {
            mensagens.mensagens("Erro!!! Data Invalida", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Erro!!! Valor Invalido ", "erro");
        }

    }

    public java.sql.Date ConverterData(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public void preencherTabela(List<ContaaPagar> lista) {
        principal.getDespesas().getTabelaconta().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Descricao", "Data Pagamento", "Data Vencimento", "Valor", "Pagar", "Editar", "Ecluir"};
            Object[][] dados = new Object[lista.size()][7];
            for (int i = 0; i < lista.size(); i++) {

                ContaaPagar p = lista.get(i);
                dados[i][0] = p.getDescricao();
                dados[i][1] = p.getData_pagamento();
                dados[i][2] = p.getData_vencimento();
                dados[i][3] = p.getValor();
                if (lista.get(i).getStatus().equals("Pago")) {
                    dados[i][4] = p.getStatus();
                } else {
                    dados[i][4] = principal.getDespesas().getBtnPag();
                }
                dados[i][5] = principal.getDespesas().getBtnEd();
                dados[i][6] = principal.getDespesas().getBtnEx();
            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getDespesas().getTabelaconta().getColumnModel();
            principal.getDespesas().getTabelaconta().setModel(dataModel);

        } catch (Exception ex) {

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
                if (boton.getName().equals("pagar")) {
                    escolha = pagar;

                }

            }
        }
        return ro;
    }

    public void pagarConta() {
        double soma = caixa.getValor_fechamento() - contaaPagar.getValor();
        caixa.setValor_fechamento(soma);
        contaaPagar = contaaPagars.get(ro);
        if (conta.getCombopagamento().getSelectedItem().equals("cartâo")) {
            contaaPagar.setForma_pagamento(conta.getCombopagamento().getSelectedItem().toString());
            contaaPagar.setTipo(conta.getCombotipo().getSelectedItem().toString());
        } else {
            contaaPagar.setForma_pagamento(conta.getCombopagamento().getSelectedItem().toString());
        }
        contaaPagar.setStatus("Pago");
        Date dt = new Date(System.currentTimeMillis());
        contaaPagar.setData_pagamento(dt);
        fachada.salvar(contaaPagar);
        conta.setVisible(false);
        contaaPagars = fachada.getAllC();
        preencherTabela(contaaPagars);
        fachada.salvar(caixa);

    }

}
