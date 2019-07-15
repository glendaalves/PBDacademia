/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.DaoView.DaoViewFornecedor;
import br.com.pbd.Daos.DaoFornecedor;
import br.com.pbd.Fachada.Fachada;
import br.com.pbd.Visoes.ViewFornecedor;
import br.com.pbd.modelos.Dados;
import br.com.pbd.modelos.Fornecedor;
import br.com.pbd.modelos.Produto;
import br.com.pbd.modelos.Render;
import br.com.pbd.view.CadastroFornecedor;
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
import java.util.ArrayList;
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
public class ControleFornecedor extends MouseAdapter implements ActionListener {

    private Principal principal;
    private Fornecedor f;
    private List<ViewFornecedor> viewFornecedors;
    private int escolha;
    private final int salvar = 0, editar = 1, excluir = 2;
    private Mensagens mensagens;
    private Fachada fachada;

    public ControleFornecedor(Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;
        principal.getCadastroFornecedor().getBotaoSalvar().addActionListener(this);
        principal.getBotaoFornecedor().addActionListener(this);
        principal.getCadastroFornecedor().getBotaoCancelar().addActionListener(this);
        principal.getBuscarFornecedor().getTabelaFornecedor().addMouseListener(this);
        principal.getBuscarFornecedor().getBotaoFechar().addActionListener(this);
        principal.getBuscarFornecedor().getBotaoAdicionar().addActionListener(this);

        mensagens = new Mensagens(principal, true);

        principal.getBuscarFornecedor().getTxtPesquisa().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
              
                viewFornecedors = new DaoViewFornecedor().BuscaP(principal.getBuscarFornecedor().getTxtPesquisa().getText());
                preencherTabela(viewFornecedors);
            }

        });

    }

    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == principal.getBuscarFornecedor().getTabelaFornecedor()) {

            int ro = retornaIndice(principal.getBuscarFornecedor().getTabelaFornecedor(), e);
            int id = viewFornecedors.get(ro).getId();
            f = new DaoFornecedor().bucarPorId(id);
            if (escolha == editar) {

                viewFornecedors = new DaoViewFornecedor().Getall();
                preencherTabela(viewFornecedors);
                principal.getBuscarFornecedor().getTxtPesquisa().setText("");
                principal.getCadastroFornecedor().setVisible(true);
                principal.getCadastroFornecedor().getLabelcadastro().setText("ATUALIZAR FORNECEDOR");
                principal.getCadastroFornecedor().preencherCadastro(f);
            }
            if (escolha == excluir) {
                if (fachada.ativarDesativar(f)) {
                    viewFornecedors = new DaoViewFornecedor().Getall();
                    preencherTabela(viewFornecedors);
                    mensagens.mensagens("Exclusão Realizada", "info");
                } else {
                    mensagens.mensagens("Exclusão Não Permitida ", "advertencia");
                }
                principal.getBuscarFornecedor().getTxtPesquisa().setText("");
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == principal.getBuscarFornecedor().getBotaoAdicionar()) {
            escolha = salvar;
        }
        if (e.getSource() == principal.getBotaoFornecedor()) {
            viewFornecedors = new DaoViewFornecedor().Getall();
            preencherTabela(viewFornecedors);
            principal.Desativar();
            principal.getBuscarFornecedor().getTxtPesquisa().setText("");
            principal.getBuscarFornecedor().getTxtPesquisa().grabFocus();
        }
        if (e.getSource() == principal.getBuscarFornecedor().getBotaoFechar()) {
            principal.Ativar();
        }
        if (e.getSource() == principal.getCadastroFornecedor().getBotaoCancelar()) {
            principal.getCadastroFornecedor().Limpar();
            principal.getCadastroFornecedor().getLabelcadastro().setText("CADASTRAR FORNECEDOR");
            viewFornecedors = new DaoViewFornecedor().Getall();
            preencherTabela(viewFornecedors);
            principal.getBuscarFornecedor().getTxtPesquisa().setText("");
            principal.getBuscarFornecedor().getTxtPesquisa().grabFocus();
        }
        if (e.getSource() == principal.getCadastroFornecedor().getBotaoSalvar()) {
            if (escolha == salvar) {
                salvarFornecedor();
                principal.getBuscarFornecedor().getTxtPesquisa().setText("");
                principal.getBuscarFornecedor().getTxtPesquisa().grabFocus();
            }
            if (escolha == editar) {
                EditarFornecedor(f);
                principal.getBuscarFornecedor().getTxtPesquisa().setText("");
                principal.getBuscarFornecedor().getTxtPesquisa().grabFocus();
            }
        }
    }

    public void salvarFornecedor() {

        Fornecedor fornecedor = new Fornecedor();
        Dados dados = new Dados();

        try {
            dados.setBairro(principal.getCadastroFornecedor().getTxtbairro().getText());
            dados.setRua(principal.getCadastroFornecedor().getTxtrua().getText());
            dados.setCep(principal.getCadastroFornecedor().getTxtCep().getText());
            String q = principal.getCadastroFornecedor().getTxtnumero().getText();
            int numero = 0;

            numero = Integer.parseInt(q);

            dados.setNumero(numero);

            dados.setUf(principal.getCadastroFornecedor().getTxtUf().getSelectedItem().toString());
            dados.setCidade(principal.getCadastroFornecedor().getTxtcidade().getText());

            dados.setEmail(principal.getCadastroFornecedor().getTxtemail().getText());
            dados.setCelular(principal.getCadastroFornecedor().getTxtcelular().getText());
            dados.setTelefone(principal.getCadastroFornecedor().getTxttelefone().getText());
            fornecedor.setDados(dados);
            fornecedor.setCnpj(principal.getCadastroFornecedor().getTxtcnpj().getText());
            fornecedor.setNome_fantasia(principal.getCadastroFornecedor().getTxtNome().getText());
            fornecedor.setRazao_social(principal.getCadastroFornecedor().getTxtrazao().getText());
            fornecedor.setLinha_produto(principal.getCadastroFornecedor().getTxtlinhaproduto().getText());
            Date d = new Date(System.currentTimeMillis());
            fornecedor.setData_cadastro(d);
            fornecedor.setProdutos(new ArrayList<Produto>());
            mensagens.mensagens("Cadastrado com Sucesso", "info");
            fachada.salvar(fornecedor);
            viewFornecedors = new DaoViewFornecedor().Getall();
            preencherTabela(viewFornecedors);
            principal.getCadastroFornecedor().setVisible(false);
            principal.getCadastroFornecedor().Limpar();

        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Numero Invalido !!!", "erro");
        }

    }

    public void preencherTabela(List<ViewFornecedor> lista) {

        principal.getBuscarFornecedor().getTabelaFornecedor().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Nome Fantasia", "Razão Social", "Cnpj", "Celular", "Editar", "Ecluir"};
            Object[][] dados = new Object[lista.size()][7];
            for (int i = 0; i < lista.size(); i++) {

                ViewFornecedor f = lista.get(i);
                dados[i][0] = f.getNome_fantasia();
                dados[i][1] = f.getRazao_social();
                dados[i][2] = f.getCnpj();
                dados[i][3] = f.getCelular();
                dados[i][4] = principal.getBuscarFornecedor().getBtnEd();
                dados[i][5] = principal.getBuscarFornecedor().getBtnEx();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getBuscarFornecedor().getTabelaFornecedor().getColumnModel();
            principal.getBuscarFornecedor().getTabelaFornecedor().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void EditarFornecedor(Fornecedor fo) {

        try {

            fo.getDados().setBairro(principal.getCadastroFornecedor().getTxtbairro().getText());
            fo.getDados().setRua(principal.getCadastroFornecedor().getTxtrua().getText());
            fo.getDados().setCep(principal.getCadastroFornecedor().getTxtCep().getText());
            String q = principal.getCadastroFornecedor().getTxtnumero().getText();
            int numero = 0;

            numero = Integer.parseInt(q);

            fo.getDados().setNumero(numero);

            fo.getDados().setUf(principal.getCadastroFornecedor().getTxtUf().getSelectedItem().toString());
            fo.getDados().setCidade(principal.getCadastroFornecedor().getTxtcidade().getText());

            fo.getDados().setEmail(principal.getCadastroFornecedor().getTxtemail().getText());
            fo.getDados().setCelular(principal.getCadastroFornecedor().getTxtcelular().getText());
            fo.getDados().setTelefone(principal.getCadastroFornecedor().getTxttelefone().getText());

            Date d = new Date(System.currentTimeMillis());
            f.setData_cadastro(d);

            fo.setNome_fantasia(principal.getCadastroFornecedor().getTxtNome().getText());
            fo.setRazao_social(principal.getCadastroFornecedor().getTxtrazao().getText());
            fo.setCnpj(principal.getCadastroFornecedor().getTxtcnpj().getText());
            fo.setLinha_produto(principal.getCadastroFornecedor().getTxtlinhaproduto().getText());

            fachada.salvar(fo);
            mensagens.mensagens("Editado com Sucesso", "info");
            principal.getBuscarFornecedor().getTxtPesquisa().setText("");
            viewFornecedors = new DaoViewFornecedor().Getall();
            preencherTabela(viewFornecedors);
            principal.getCadastroFornecedor().setVisible(false);
            principal.getCadastroFornecedor().Limpar();
            principal.getCadastroFornecedor().getLabelcadastro().setText("CADASTRAR FORNECEDOR");

        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Numero Invalido !!!", "erro");
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
