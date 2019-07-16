/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Estoque;
import br.com.pbd.modelos.Fornecedor;
import br.com.pbd.view.Principal;
import br.com.pbd.modelos.Produto;
import br.com.pbd.modelos.Render;
import br.com.pbd.view.EntradaProdut;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.TelaAdministrador;
import br.com.pbd.view.TelaProduto;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleProdutoo extends MouseAdapter implements ActionListener {

    private Principal principal;
    private List<Fornecedor> fornecedores;
    private List<Estoque> estoques;
    private List<Produto> produtos;
    private Produto p;
    private int escolha;
    private final int salvar = 0, editar = 1, excluir = 2;
    private EntradaProdut dia;
    private Mensagens mensagens;
    private Fachada fachada;

    public ControleProdutoo(Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;
        principal.getProduto().getBotaoSalvar().addActionListener(this);
        principal.getProduto().getBotaosalvarestoque().addActionListener(this);
        principal.getBotaoProduto().addActionListener(this);
        principal.getProduto().getBotaoEntradaProduto().addActionListener(this);
        principal.getProduto().getTabelaproduto().addMouseListener(this);
        principal.getProduto().getBotaoCancelarProduto().addActionListener(this);
        principal.getProduto().getBotaoFechar().addActionListener(this);
        principal.getProduto().getBotaoadicionar().addActionListener(this);
        mensagens = new Mensagens(principal, true);

        fornecedores = new ArrayList<Fornecedor>();
        estoques = new ArrayList<Estoque>();
        dia = new EntradaProdut(principal, true);
        dia.getBotaosalvar().addActionListener(this);

        dia.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                principal.getProduto().getTxtPesquisa().grabFocus();
            }
        });

        principal.getProduto().getTxtPesquisa().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                produtos = fachada.Buscapro(principal.getProduto().getTxtPesquisa().getText());
                preencherTabela(produtos);
            }

        });

    }

    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == principal.getProduto().getTabelaproduto()) {
            int ro = retornaIndice(principal.getProduto().getTabelaproduto(), e);
            p = produtos.get(ro);
            if (escolha == editar) {
                for (Component cp : principal.getProduto().getPanelCadastro().getComponents()) {
                    cp.setEnabled(true);
                }
                principal.getProduto().preencherCadastro(p);
                principal.getProduto().getBotaoFechar().setVisible(false);
                principal.getProduto().getBotaoadicionar().setVisible(false);
                principal.getProduto().getLabelcadastro2().setText("ATUALIZAR PRODUTO");
                principal.getProduto().getTabelaproduto().setVisible(false);
                principal.getProduto().getjScrollPane2().setVisible(false);
                principal.getProduto().getTxtPesquisa().setVisible(false);
                principal.getProduto().getLabel6().setVisible(false);
                principal.getProduto().getPanellist().setVisible(false);
                principal.getProduto().getPanelEstoque().setVisible(false);
                principal.getProduto().getBotaoEstoque().setVisible(false);
                principal.getProduto().getBotaoEntradaProduto().setVisible(false);
                produtos = fachada.getAllP();
                preencherTabela(produtos);
                principal.getProduto().getTxtPesquisa().setText("");

            }
            if (escolha == excluir) {
                if (fachada.ativarDesativar(p)) {
                    produtos = fachada.getAllP();
                    preencherTabela(produtos);
                    mensagens.mensagens("Exclusão Realizada", "info");
                } else {
                    mensagens.mensagens("Exclusão Não Permitida ", "advertencia");
                }

            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == principal.getBotaoProduto()) {
            principal.getProduto().setVisible(true);
            principal.getProduto().getPanelEstoque().setVisible(false);
            produtos = fachada.getAllP();
            preencherTabela(produtos);
            preencherEstoque();
            preencherFornecedor();
            principal.Desativar();
            principal.getProduto().getTxtPesquisa().setText("");
            principal.getProduto().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getProduto().getPanelCadastro().getComponents()) {
                cp.setEnabled(false);
            }
        }
        if (e.getSource() == principal.getProduto().getBotaoadicionar()) {
            escolha = salvar;
            produtos = fachada.getAllP();
            preencherTabela(produtos);
            principal.getProduto().getTxtPesquisa().setText("");
            for (Component cp : principal.getProduto().getPanelCadastro().getComponents()) {
                cp.setEnabled(true);
            }
        }
        if (e.getSource() == principal.getProduto().getBotaoFechar()) {
            principal.getProduto().setVisible(false);
            principal.getProduto().getLabelcadastro2().setText("PRODUTO");
            principal.Ativar();
            dia.setVisible(false);
        }
        if (e.getSource() == principal.getProduto().getBotaoCancelarProduto()) {

            principal.getProduto().getBotaoFechar().setVisible(true);
            principal.getProduto().getBotaoadicionar().setVisible(true);
            principal.getProduto().getTabelaproduto().setVisible(true);
            principal.getProduto().getjScrollPane2().setVisible(true);
            principal.getProduto().getTxtPesquisa().setVisible(true);
            principal.getProduto().getLabel6().setVisible(true);
            principal.getProduto().getPanellist().setVisible(true);
            principal.getProduto().getPanelEstoque().setVisible(false);
            principal.getProduto().getBotaoEstoque().setVisible(true);
            principal.getProduto().getBotaoEntradaProduto().setVisible(true);
            principal.getProduto().Limpar();
            principal.getProduto().getLabelcadastro2().setText("PRODUTO");
            principal.getProduto().getTxtPesquisa().setText("");
            principal.getProduto().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getProduto().getPanelCadastro().getComponents()) {
                cp.setEnabled(false);
            }

        }
        if (e.getSource() == principal.getProduto().getBotaoEntradaProduto()) {
            principal.Apenasnumero(dia.getTxtquantidade());
            dia.getTxtquantidade().setText("");
            principal.getProduto().getTxtPesquisa().setText("");
            produtos = fachada.getAllP();
            preencherTabela(produtos);
            preencherEntradaProduto();
            dia.setVisible(true);

        }
        if (e.getSource() == dia.getBotaosalvar()) {
            entradaProduto();

            produtos = fachada.getAllP();
            preencherTabela(produtos);
            principal.getProduto().getTxtPesquisa().setText("");
            principal.getProduto().getTxtPesquisa().grabFocus();

        }
        if (e.getSource() == principal.getProduto().getBotaoSalvar()) {
            if (escolha == salvar) {
                salvarProduto();

            }
            if (escolha == editar) {
                EditarProduto(p);

            }
        }

        if (e.getSource() == principal.getProduto().getBotaosalvarestoque()) {
            SalvarEstoque();
            for (Component cp : principal.getProduto().getPainelprincipal().getComponents()) {
                cp.setEnabled(false);
            }
        }
    }

    public void entradaProduto() {

        try {
            String q = dia.getTxtquantidade().getText();
            q = q.replaceAll("[^0-9]", "");
            int quantidade = 0;

            quantidade = Integer.parseInt(q);
            int indice = dia.getComboProduto().getSelectedIndex();
            p = produtos.get(indice);
            int estoque_atual = quantidade + p.getEstoque_atual();
            p.setEstoque_atual(estoque_atual);

            fachada.salvar(p);
            mensagens.mensagens("Produto Atualizado", "info");
            dia.getTxtquantidade().setText("");
            produtos = fachada.getAllP();
            preencherTabela(produtos);

            dia.setVisible(false);

        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (java.lang.ArrayIndexOutOfBoundsException erro) {
            mensagens.mensagens("Erro Produto Invalido! !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Erro!!! Valor Invalido", "erro");
        }

    }

    public void SalvarEstoque() {

        Estoque estoque = new Estoque();
        estoque.setGrupo(principal.getProduto().getTxtestoque().getText());

        try {
            fachada.salvar(estoque);
            mensagens.mensagens("Cadastrado com Sucesso", "info");
            preencherEstoque();
            principal.getProduto().getPanelEstoque().setVisible(false);
        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        }
    }

    public void salvarProduto() {

        int indiceF = principal.getProduto().getCombofornecedor().getSelectedIndex();
        int indiceE = principal.getProduto().getConbogrupo().getSelectedIndex();

        try {

            Estoque estoque = estoques.get(indiceE);
            Fornecedor fornecedor = fornecedores.get(indiceF);

            Produto produto = new Produto();

            produto.setFornecedor(fornecedor);
            produto.setEstoque(estoque);

            produto.setDescricao(principal.getProduto().getTxtNome().getText());
            Date d = new Date(System.currentTimeMillis());
            produto.setData_cadastro(d);

            String q = principal.getProduto().getTxtestoqueatual().getText();
            int estoqueatual = 0;

            estoqueatual = Integer.parseInt(q);

            produto.setEstoque_atual(estoqueatual);

            produto.setEstoque_atual(estoqueatual);

            String v = principal.getProduto().getTxtvenda().getText();
            Double venda = 0.0;

            venda = Double.parseDouble(v);

            produto.setValor_venda(venda);
            produto.setTamanho_peso(principal.getProduto().getTxttamanha_peso().getText());

            fachada.salvar(produto);
            mensagens.mensagens("Cadastrado com Sucesso", "info");
            produtos = fachada.getAllP();
            principal.getProduto().Limpar();
            preencherTabela(produtos);
            principal.getProduto().getTxtPesquisa().grabFocus();
            for (Component cp : principal.getProduto().getPanelCadastro().getComponents()) {
                cp.setEnabled(false);
            }
        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Erro!!! Valores Invalidos ", "erro");
        } catch (java.lang.ArrayIndexOutOfBoundsException erro) {
            mensagens.mensagens("Erro Produto ou Estoque Invalido! !!!", "erro");
        }
    }

    public void preencherFornecedor() {

        fornecedores = fachada.getAllFor();
        principal.getProduto().getCombofornecedor().removeAllItems();
        for (Fornecedor f : fornecedores) {
            principal.getProduto().getCombofornecedor().addItem(f.getNome_fantasia());
        }

    }

    public void preencherEstoque() {

        estoques = fachada.getAllEs();
        principal.getProduto().getConbogrupo().removeAllItems();
        for (Estoque es : estoques) {
            principal.getProduto().getConbogrupo().addItem(es.getGrupo());

        }

    }

    public void preencherTabela(List<Produto> lista) {
        principal.getProduto().getTabelaproduto().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Fornecedor", "Estoque", "Nome", "Tamanho/Peso", "Valor", "Estoque Atual", "Editar", "Ecluir"};
            Object[][] dados = new Object[lista.size()][8];
            for (int i = 0; i < lista.size(); i++) {

                Produto p = lista.get(i);
                dados[i][0] = p.getFornecedor().getNome_fantasia();
                dados[i][1] = p.getEstoque().getGrupo();
                dados[i][2] = p.getDescricao();
                dados[i][3] = p.getTamanho_peso();
                dados[i][4] = p.getValor_venda();
                dados[i][5] = p.getEstoque_atual();
                dados[i][6] = principal.getProduto().getBtnEd();
                dados[i][7] = principal.getProduto().getBtnEx();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getProduto().getTabelaproduto().getColumnModel();
            principal.getProduto().getTabelaproduto().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void EditarProduto(Produto p) {

        int indiceF = principal.getProduto().getCombofornecedor().getSelectedIndex();
        int indiceE = principal.getProduto().getConbogrupo().getSelectedIndex();

        try {
            Estoque estoque = estoques.get(indiceE);
            Fornecedor fornecedor = fornecedores.get(indiceF);

            p.setFornecedor(fornecedor);
            p.setEstoque(estoque);

            p.setDescricao(principal.getProduto().getTxtNome().getText());
            p.setTamanho_peso(principal.getProduto().getTxttamanha_peso().getText());
            Date d = new Date(System.currentTimeMillis());
            p.setData_cadastro(d);

            String q = principal.getProduto().getTxtestoqueatual().getText();
            int estoqueatual = 0;

            estoqueatual = Integer.parseInt(q);

            p.setEstoque_atual(estoqueatual);

            String v = principal.getProduto().getTxtvenda().getText();
            Double venda = 0.0;

            venda = Double.parseDouble(v);

            p.setValor_venda(venda);
            fachada.salvar(p);
            mensagens.mensagens("Editado com Sucesso", "info");
            principal.getProduto().getTxtPesquisa().setText("");
            produtos = fachada.getAllP();
            preencherTabela(produtos);
            principal.getProduto().setVisible(true);
            principal.getProduto().ativarComponente();

            for (Component cp : principal.getProduto().getPanelCadastro().getComponents()) {
                cp.setEnabled(false);
            }

        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (java.lang.ArrayIndexOutOfBoundsException erro) {
            mensagens.mensagens("Erro Produto ou Estoque Invalido! !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Erro !!! Valores Invalidos", "erro");
        }

    }

    public void preencherEntradaProduto() {

        produtos = fachada.getAllP();
        dia.getComboProduto().removeAllItems();
        for (Produto es : produtos) {
            dia.getComboProduto().addItem(es.getDescricao());

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
