/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.Daos.DaoCaixa;
import br.com.pbd.Daos.DaoDespesas;
import br.com.pbd.Daos.DaoMensalidade;
import br.com.pbd.Daos.DaoVenda;
import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Caixa;
import br.com.pbd.modelos.ContaaPagar;
import br.com.pbd.modelos.Mensalidade;
import br.com.pbd.modelos.Render;
import br.com.pbd.modelos.Venda;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.Principal;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;
import javax.persistence.NoResultException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleCaixa implements ActionListener {

    private Principal principal;
    private Caixa caixa;
    private Fachada fachada;
    private List<Mensalidade> mensalidades;
    private List<Venda> vendas;
    private List<ContaaPagar> contaaPagars;
    private Mensagens mensagens;

    public ControleCaixa(Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;
        caixa = new Caixa();
        principal.getBotaoCaixa().addActionListener(this);
        principal.getCaixa().getBotaofechar().addActionListener(this);
        principal.getCaixa().getBotaoFecharcaixa().addActionListener(this);
        principal.getCaixa().getBotaoAbrirCaixa().addActionListener(this);
        mensagens = new Mensagens(principal, true);

        principal.getCaixa().getCalendario().getDateEditor().getUiComponent().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                java.util.Date d = principal.getCaixa().getCalendario().getDate();
                if (d != null) {;
                    mensalidades = new DaoMensalidade().BuscaMensalidadesDia(d, "Pago");
                    preencherTabelaMensalidade(mensalidades);
                    vendas = new DaoVenda().BuscaVendasDia(d);
                    preencherTabelaVenda(vendas);
                    contaaPagars = new DaoDespesas().BuscaContaDia(d, "Pago");
                    preencherTabelaConta(contaaPagars);

                }

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.getBotaoCaixa()) {
            principal.Desativar();
            java.util.Date d = new java.util.Date();
            principal.getCaixa().getCalendario().setDate(d);
            mensalidades = new DaoMensalidade().BuscaMensalidadesDia(d, "Pago");
            preencherTabelaMensalidade(mensalidades);
            vendas = new DaoVenda().BuscaVendasDia(d);
            preencherTabelaVenda(vendas);
            contaaPagars = new DaoDespesas().BuscaContaDia(d, "Pago");
            preencherTabelaConta(contaaPagars);
            dinhiroNoCaixa();
            principal.getCaixa().getTxtlucro().setText(caixa.getValor_fechamento() - caixa.getValor_abertura() + "");
        }
        if (e.getSource() == principal.getCaixa().getBotaoAbrirCaixa()) {
            abrirCaixa();
            mensagens.mensagens("Caixa Aberto", "info");
        }
        if (e.getSource() == principal.getCaixa().getBotaofechar()) {
            principal.Ativar();
        }
        if (e.getSource() == principal.getCaixa().getBotaoFecharcaixa()) {
            fecharCaixa();
        }

    }

    public void abrirCaixa() {
        Date data = new Date(System.currentTimeMillis());
        Caixa caixaAnterior = null;
        try {
            caixaAnterior = fachada.buscaUltimoRegistroC();
        } catch (NoResultException n) {
            System.out.println("Caixa anterior nao encontrado");
        }
        try {
            caixa = fachada.BuscarCaixa(data);
        } catch (NoResultException n) {
            System.out.println("Caixa do dia nao encontrado");
        }

        if (caixa == null) {
            caixa = new Caixa();
            caixa.setData(data);
            caixa.setStatus(Boolean.TRUE);
            caixa.setLucro(0.0);
            if (caixaAnterior != null) {
                caixa.setValor_abertura(caixaAnterior.getValor_fechamento());
                caixa.setValor_fechamento(caixaAnterior.getValor_fechamento());
            } else {
                caixa.setValor_abertura(0.0);
                caixa.setValor_fechamento(0.0);
            }
            fachada.salvar(caixa);

        } else {
            caixa.setStatus(Boolean.TRUE);
            fachada.salvar(caixa);
        }

    }

    public void preencherTabelaMensalidade(List<Mensalidade> mensalidades) {

        principal.getCaixa().getTabelamensalidade().setDefaultRenderer(Object.class, new Render());
        try {
            String[] colunas = new String[]{"Aluno", "Numero", "Valor", "Data Vencimento", "Forma Pagamento", "Tipo", "Plano"};
            Object[][] dados = new Object[mensalidades.size()][9];
            for (int i = 0; i < mensalidades.size(); i++) {

                Mensalidade m = mensalidades.get(i);
                dados[i][0] = m.getAluno().getNome();
                dados[i][1] = m.getNumero();
                dados[i][2] = m.getValor();
                dados[i][3] = m.getVencimento();
                dados[i][4] = m.getForma_pagamento();
                dados[i][5] = m.getTipo();
                dados[i][6] = m.getPlano();
                dados[i][7] = m.getPagamento();
                dados[i][8] = m.getStatus();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getCaixa().getTabelamensalidade().getColumnModel();
            principal.getCaixa().getTabelamensalidade().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void preencherTabelaVenda(List<Venda> vendas) {

        principal.getCaixa().getTabelavenda().setDefaultRenderer(Object.class, new Render());
        try {
            String[] colunas = new String[]{"Funcionario", "Pagamento", "SubTotal", "Desconto", "Valor Total"};
            Object[][] dados = new Object[vendas.size()][5];
            for (int i = 0; i < vendas.size(); i++) {

                Venda m = vendas.get(i);
                dados[i][0] = m.getFuncionario().getNome();
                dados[i][1] = m.getForma_pagamento();
                dados[i][2] = m.getSubtotal();
                dados[i][3] = m.getDesconto();
                dados[i][4] = m.getTotal();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getCaixa().getTabelavenda().getColumnModel();
            principal.getCaixa().getTabelavenda().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void preencherTabelaConta(List<ContaaPagar> lista) {
        principal.getCaixa().getTabeladespesas().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Descricao", "Valor", "Pagamento", "Tipo", "Data Vencimento"};
            Object[][] dados = new Object[lista.size()][5];
            for (int i = 0; i < lista.size(); i++) {

                ContaaPagar p = lista.get(i);
                dados[i][0] = p.getDescricao();
                dados[i][1] = p.getValor();
                dados[i][2] = p.getForma_pagamento();
                dados[i][3] = p.getTipo();
                dados[i][4] = p.getData_vencimento();
            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getCaixa().getTabeladespesas().getColumnModel();
            principal.getCaixa().getTabeladespesas().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void dinhiroNoCaixa() {

        java.util.Date d = new java.util.Date();

        caixa = new DaoCaixa().BuscarCaixa(ConverterData(d));
        double valor = caixa.getValor_fechamento();
        principal.getCaixa().getTxttotal().setText(valor + "");
    }

    public void fecharCaixa() {
        double lucro = caixa.getValor_fechamento() - caixa.getValor_abertura();
        caixa.setLucro(lucro);
        caixa.setStatus(false);
        fachada.salvar(caixa);
        mensagens.mensagens("Caixa Fechado", "info");

    }

    public java.sql.Date ConverterData(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
}
