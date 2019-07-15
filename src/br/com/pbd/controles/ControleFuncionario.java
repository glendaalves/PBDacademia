/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Dados;
import br.com.pbd.modelos.Funcionario;
import br.com.pbd.modelos.Login;
import br.com.pbd.modelos.Render;
import br.com.pbd.modelos.Tarefa;
import br.com.pbd.view.CadastroFuncionario;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.Principal;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleFuncionario extends MouseAdapter implements ActionListener {

    private Principal principal;
    private List<Funcionario> funcionarios;
    private Funcionario f;
    private int escolha;
    private final int salvar = 0, editar = 1, excluir = 2;
    private ControleLogin controleLogin;
    private Mensagens mensagens;
    private Fachada fachada;

    public ControleFuncionario(Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;

        mensagens = new Mensagens(principal, true);
        principal.getCadastroFuncionario().getBotaoSalvar().addActionListener(this);
        principal.getBotaoFuncionario().addActionListener(this);
        principal.getCadastroFuncionario().getBotaoCancelar().addActionListener(this);
        principal.getBuscarFuncionario().getBotaoFechar().addActionListener(this);
        principal.getBuscarFuncionario().getTabelafuncionario().addMouseListener(this);
        principal.getBuscarFuncionario().getBotaoAdicionar().addActionListener(this);

        principal.getBuscarFuncionario().getTxtPesquisa().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                funcionarios = fachada.BuscaFun(principal.getBuscarFuncionario().getTxtPesquisa().getText());
                preencherTabela(funcionarios);
            }

        });
    }

    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == principal.getBuscarFuncionario().getTabelafuncionario()) {
            int ro = retornaIndice(principal.getBuscarFuncionario().getTabelafuncionario(), e);
            f = funcionarios.get(ro);
            if (escolha == editar) {

                principal.getBuscarFuncionario().getTxtPesquisa().setText("");
                funcionarios = fachada.getAllFun();
                preencherTabela(funcionarios);
                principal.getCadastroFuncionario().setVisible(true);
                principal.getCadastroFuncionario().preencherCadastro(f);
                principal.getCadastroFuncionario().getPanelLogin().setVisible(false);

            }
            if (escolha == excluir) {
                fachada.ativarDesativar(f);
                mensagens.mensagens("Exclusão Realizada", "info");
                funcionarios = fachada.getAllFun();
                preencherTabela(funcionarios);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == principal.getBotaoFuncionario()) {
            funcionarios = fachada.getAllFun();
            preencherTabela(funcionarios);
            principal.Desativar();
            principal.getBuscarFuncionario().getTxtPesquisa().setText("");
            principal.getBuscarFuncionario().getTxtPesquisa().grabFocus();

        }

        if (e.getSource() == principal.getBuscarFuncionario().getBotaoAdicionar()) {
            escolha = salvar;
        }
        if (e.getSource() == principal.getBuscarFuncionario().getBotaoFechar()) {
            principal.Ativar();
        }
        if (e.getSource() == principal.getCadastroFuncionario().getBotaoCancelar()) {
            principal.getCadastroFuncionario().Limpar();
            principal.getCadastroFuncionario().getLabelcadastro().setText("CADASTRAR FUNCIONARIO");
            principal.getBuscarFuncionario().getTxtPesquisa().setText("");
            principal.getBuscarFuncionario().getTxtPesquisa().grabFocus();
            funcionarios = fachada.getAllFun();
            preencherTabela(funcionarios);

        }

        if (e.getSource() == principal.getCadastroFuncionario().getBotaoSalvar()) {
            if (escolha == salvar) {
                salvarFuncionario();
                principal.getBuscarFuncionario().getTxtPesquisa().setText("");
                principal.getBuscarFuncionario().getTxtPesquisa().grabFocus();
            }
            if (escolha == editar) {
                EditarFuncionario(f);
                principal.getBuscarFuncionario().getTxtPesquisa().setText("");
                principal.getBuscarFuncionario().getTxtPesquisa().grabFocus();
            }

        }
    }

    public void salvarFuncionario() {

        Funcionario funcionario = new Funcionario();

        try {
            funcionario.setCarteira_trabalho(principal.getCadastroFuncionario().getTxtCarteiraTrabalho().getText());
            funcionario.setCpf(principal.getCadastroFuncionario().getTxtCpf().getText());

            java.sql.Date dataN = ConverterData(principal.getCadastroFuncionario().getDatanascimento().getDate());
            funcionario.setData_nascimento(dataN);

            Date d = new Date(System.currentTimeMillis());
            funcionario.setData_cadastro(d);

            funcionario.setFuncao(principal.getCadastroFuncionario().getTxtfuncao().getSelectedItem().toString());
            funcionario.setNome(principal.getCadastroFuncionario().getTxtNome().getText());
            funcionario.setRg(principal.getCadastroFuncionario().getTxtrg().getText());
            String s = (principal.getCadastroFuncionario().getTxtsalario().getText());
            Double salario = null;

            salario = Double.parseDouble(s);

            funcionario.setSalario(salario);
            funcionario.setSexo(principal.getCadastroFuncionario().getCombosexo().getSelectedItem().toString());
            Dados dados = new Dados();

            dados.setBairro(principal.getCadastroFuncionario().getTxtbairro().getText());
            dados.setRua(principal.getCadastroFuncionario().getTxtrua().getText());
            dados.setCep(principal.getCadastroFuncionario().getTxtCep().getText());
            String q = principal.getCadastroFuncionario().getTxtnumero().getText();
            q = q.replaceAll("[^0-9]", "");
            int numero = 0;

            numero = Integer.parseInt(q);

            dados.setNumero(numero);

            dados.setUf(principal.getCadastroFuncionario().getTxtUf().getSelectedItem().toString());
            dados.setCidade(principal.getCadastroFuncionario().getTxtcidade().getText());

            dados.setEmail(principal.getCadastroFuncionario().getTxtemail().getText());
            dados.setCelular(principal.getCadastroFuncionario().getTxtcelular().getText());
            dados.setTelefone(principal.getCadastroFuncionario().getTxttelefone().getText());

            funcionario.setDados(dados);
            funcionario.setTarefas(new ArrayList<Tarefa>());

            Login login = new Login();
            String pwd = new String(principal.getCadastroFuncionario().getTxtsenha().getPassword());
            login.setUsuario(principal.getCadastroFuncionario().getTxtlogin().getText());
            String confirmar = new String(principal.getCadastroFuncionario().getTxtcomfirmarsenha().getPassword());

            funcionario.setLogin(login);

            String senhaHex = "";
            StringBuilder ab = null;

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(pwd.getBytes("UTF-8"));

            ab = new StringBuilder();

            for (byte b : messageDigest) {
                ab.append(String.format("%02X", 0xFF & b));

            }

            senhaHex = ab.toString();
            login.setSenha(senhaHex);

            if (confirmar.equals(pwd)) {
                fachada.salvar(funcionario);
                mensagens.mensagens("Cadastrado com Sucesso", "info");
                funcionarios = fachada.getAllFun();
                preencherTabela(funcionarios);
                principal.getCadastroFuncionario().Limpar();
                principal.getCadastroFuncionario().setVisible(false);
            } else {
                mensagens.mensagens("Senhas Diferentes", "advertencia");
            }
        } catch (java.lang.IllegalStateException n) {

            mensagens.mensagens("voce precisa preencher todos os campos!", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.lang.NullPointerException e) {
            mensagens.mensagens("Data Invalida", "advertencia");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Numero ou Salario Invalido", "erro");
        }

    }

    public java.sql.Date ConverterData(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public void preencherTabela(List<Funcionario> lista) {

        principal.getBuscarFuncionario().getTabelafuncionario().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Nome", "Salario", "Função", "CPF", "RG", "Celular", "Editar", "Ecluir"};
            Object[][] dados = new Object[lista.size()][8];
            for (int i = 0; i < lista.size(); i++) {

                Funcionario funcionario = lista.get(i);
                dados[i][0] = funcionario.getNome();
                dados[i][1] = funcionario.getSalario();
                dados[i][2] = funcionario.getFuncao();
                dados[i][3] = funcionario.getCpf();
                dados[i][4] = funcionario.getRg();
                dados[i][5] = funcionario.getDados().getCelular();
                dados[i][6] = principal.getBuscarFuncionario().getBtnEd();
                dados[i][7] = principal.getBuscarFuncionario().getBtnEx();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getBuscarFuncionario().getTabelafuncionario().getColumnModel();
            principal.getBuscarFuncionario().getTabelafuncionario().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void EditarFuncionario(Funcionario fun) {

        try {
            fun.getDados().setBairro(principal.getCadastroFuncionario().getTxtbairro().getText());
            fun.getDados().setRua(principal.getCadastroFuncionario().getTxtrua().getText());
            fun.getDados().setCep(principal.getCadastroFuncionario().getTxtCep().getText());
            String q = principal.getCadastroFuncionario().getTxtnumero().getText();
            int numero = 0;

            numero = Integer.parseInt(q);

            fun.getDados().setNumero(numero);

            fun.getDados().setUf(principal.getCadastroFuncionario().getTxtUf().getSelectedItem().toString());
            fun.getDados().setCidade(principal.getCadastroFuncionario().getTxtcidade().getText());

            fun.getDados().setEmail(principal.getCadastroFuncionario().getTxtemail().getText());
            fun.getDados().setCelular(principal.getCadastroFuncionario().getTxtcelular().getText());
            fun.getDados().setTelefone(principal.getCadastroFuncionario().getTxttelefone().getText());
            
            fun.setCarteira_trabalho(principal.getCadastroFuncionario().getTxtCarteiraTrabalho().getText());
            fun.setCpf(principal.getCadastroFuncionario().getTxtCpf().getText());
            Date d = new Date(System.currentTimeMillis());
            fun.setData_cadastro(d);

            java.sql.Date data = ConverterData(principal.getCadastroFuncionario().getDatanascimento().getDate());
            fun.setData_nascimento(data);

            fun.setNome(principal.getCadastroFuncionario().getTxtNome().getText());
            fun.setRg(principal.getCadastroFuncionario().getTxtrg().getText());
            String salario = principal.getCadastroFuncionario().getTxtsalario().getText();
            Double salari = 0.0;

            salari = Double.parseDouble(salario);

            fun.setSalario(salari);
            fun.setSexo(principal.getCadastroFuncionario().getCombosexo().getSelectedItem().toString());
            fun.setFuncao(principal.getCadastroFuncionario().getTxtfuncao().getSelectedItem().toString());

            fachada.salvar(fun);
            mensagens.mensagens("Editado com Sucesso", "info");
            funcionarios = fachada.getAllFun();
            preencherTabela(funcionarios);
            principal.getCadastroFuncionario().setVisible(false);
            principal.getBuscarFuncionario().getTxtPesquisa().setText("");
            principal.getCadastroFuncionario().Limpar();
            principal.getCadastroFuncionario().getLabelcadastro().setText("CADASTRAR FUNCIONARIO");

        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("voce precisa preencher todos os campos!", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Numero ou salario Invalido !!!", "erro");
        } catch (java.lang.NullPointerException e) {
            mensagens.mensagens("Data Invalido !!!", "erro");
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
