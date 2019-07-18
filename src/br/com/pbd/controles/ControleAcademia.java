package br.com.pbd.controles;

import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Academia;
import br.com.pbd.modelos.Dados;
import br.com.pbd.modelos.Funcionario;
import br.com.pbd.modelos.Professor;
import br.com.pbd.modelos.Render;
import br.com.pbd.view.Acesso;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleAcademia extends MouseAdapter implements ActionListener {

    private final Principal principal;
    private Funcionario funcionario;
    private Professor professor;
    private Academia academia;
    private ControleLogin controleLogin;
    private Mensagens mensagems;
    private Fachada fachada;
    private List<Funcionario> funcionarios;
    private List<Professor> professors;
    private final int pro = 1, func = 2, editar = 3, resetar = 4;
    private int opcao = 0;
    private Acesso acesso;
    private int escolha;

    public ControleAcademia(Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;

        acesso = new Acesso(principal, true);
        acesso.getBotaosalvar().addActionListener(this);
        principal.getAcademia().getBotaoSalvar().addActionListener(this);
        principal.getAcademia().getBotaoCancelar().addActionListener(this);
        principal.getBotaoAcesso().addActionListener(this);
        principal.getBotaoAcademia().addActionListener(this);
        principal.getTelaSobre().getBotaoCancelar().addActionListener(this);
        mensagems = new Mensagens(principal, true);
        principal.getGerencia().getConbousuario().addActionListener(this);
        principal.getGerencia().getTabelausuario().addMouseListener(this);
        principal.getGerencia().getBotaoFechar().addActionListener(this);
      

    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == principal.getGerencia().getTabelausuario()) {
            int ro = retornaIndice(principal.getGerencia().getTabelausuario(), e);

            if (escolha == resetar) {
                if (opcao == func) {
                    funcionario = funcionarios.get(ro);
                    funcionario.getLogin().setReset(true);
                    fachada.salvar(funcionario);
                    mensagems.mnsReset();

                } else if (opcao == pro) {
                    professor = professors.get(ro);
                    professor.getLogin().setReset(true);
                    fachada.salvar(professor);
                    mensagems.mnsReset();

                }

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == principal.getGerencia().getConbousuario()) {
            escolherUsuario();
        }
        if (e.getSource() == principal.getGerencia().getBotaoFechar()) {
            principal.Ativar();
        }
        if (e.getSource() == principal.getBotaoAcesso()) {

            if (controleLogin.getProfessor() != null) {
                opcao = pro;
                acesso.getTxtnome().setText(controleLogin.getProfessor().getLogin().getUsuario());
                acesso.limpa();
                acesso.setVisible(true);

            } else if (controleLogin.getFuncionario() != null) {
                opcao = func;
                acesso.getTxtnome().setText(controleLogin.getFuncionario().getLogin().getUsuario());
                acesso.limpa();
                acesso.setVisible(true);
                

            } else {
                escolherUsuario();
                principal.getGerencia().setVisible(true);
                principal.Desativar();
            }

        }
        if (e.getSource() == acesso.getBotaosalvar()) {
            if (opcao == func) {
                EditarLoginFuncionario();
            } else if (opcao == pro) {
                EditarLoginProfessor();
            }
        }

        if (e.getSource() == principal.getBotaoAcademia()) {
            principal.Desativar();
            try {

                academia = fachada.buscaUltimoRegistro();
                principal.getAcademia().preencherCadastro(academia);

            } catch (NoResultException n) {

            }

        }
        if (e.getSource() == principal.getAcademia().getBotaoCancelar()) {
            principal.Ativar();
        }
        if (e.getSource() == principal.getTelaSobre().getBotaoCancelar()) {
            if (controleLogin.getProfessor() != null) {
                principal.AtivarP();

            } else {
                principal.Ativar();
            }
        }
        if (e.getSource() == principal.getAcademia().getBotaoSalvar()) {

            if (academia == null) {
                criarAcademia();
            } else {
                editar();
            }

        }

    }

    public void criarAcademia() {

        Academia academia = new Academia();
        Dados dados = new Dados();

        try {
            dados.setBairro(principal.getAcademia().getTxtbairro().getText());
            dados.setRua(principal.getAcademia().getTxtrua().getText());
            dados.setCep(principal.getAcademia().getTxtCep().getText());
            String q = principal.getAcademia().getTxtnumero().getText();
            int numero = 0;

            numero = Integer.parseInt(q);

            dados.setUf(principal.getAcademia().getTxtUf().getSelectedItem().toString());
            dados.setCidade(principal.getAcademia().getTxtcidade().getText());

            dados.setEmail(principal.getAcademia().getTxtemail().getText());
            dados.setCelular(principal.getAcademia().getTxtcelular().getText());
            dados.setTelefone(principal.getAcademia().getTxttelefone().getText());
            academia.setDados(dados);
            academia.setCnpj(principal.getAcademia().getTxtcnpj().getText());
            academia.setNome_fantasia(principal.getAcademia().getTxtNome().getText());
            academia.setRazao_social(principal.getAcademia().getTxtrazao().getText());

            dados.setNumero(numero);
            fachada.salvar(academia);
            mensagems.mensagens("Cadastrado com Sucesso", "info");
            principal.getAcademia().setVisible(false);
            principal.Ativar();
        } catch (java.lang.IllegalStateException n) {
            mensagems.mensagens("Voce precisa preencher todos os campos !", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagems.mensagens("Erro !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagems.mensagens("Numero Invalido", "advertencia");
        }

    }

    public void editar() {
        try {
            academia.getDados().setBairro(principal.getAcademia().getTxtbairro().getText());
            academia.getDados().setRua(principal.getAcademia().getTxtrua().getText());
            academia.getDados().setCep(principal.getAcademia().getTxtCep().getText());
            String q = principal.getAcademia().getTxtnumero().getText();
            int numero = 0;
            numero = Integer.parseInt(q);

            academia.getDados().setUf(principal.getAcademia().getTxtUf().getSelectedItem().toString());
            academia.getDados().setCidade(principal.getAcademia().getTxtcidade().getText());

            academia.getDados().setEmail(principal.getAcademia().getTxtemail().getText());
            academia.getDados().setCelular(principal.getAcademia().getTxtcelular().getText());
            academia.getDados().setTelefone(principal.getAcademia().getTxttelefone().getText());
            academia.setCnpj(principal.getAcademia().getTxtcnpj().getText());
            academia.setNome_fantasia(principal.getAcademia().getTxtNome().getText());
            academia.setRazao_social(principal.getAcademia().getTxtrazao().getText());
            academia.getDados().setNumero(numero);

            fachada.salvar(academia);
            mensagems.mensagens("Editado com Sucesso", "info");
            principal.getAcademia().setVisible(false);
            principal.Ativar();

        } catch (java.lang.IllegalStateException n) {
            mensagems.mensagens("Voce precisa preencher todos os campos !", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagems.mensagens("Erro !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagems.mensagens("Numero Invalido", "advertencia");
        }
    }

    public void preencherTabelaProfessor(List<Professor> lista) {

        principal.getGerencia().getTabelausuario().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Nome", "CPF", "RG", "Carteira trabalho", "Editar"};
            Object[][] dados = new Object[lista.size()][6];
            for (int i = 0; i < lista.size(); i++) {

                Professor professor = lista.get(i);
                dados[i][0] = professor.getNome();
                dados[i][1] = professor.getCpf();
                dados[i][2] = professor.getRg();
                dados[i][3] = professor.getCarteira_trabalho();
                dados[i][4] = acesso.getBtnRe();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            principal.getGerencia().getTabelausuario().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void preencherTabelaFuncionario(List<Funcionario> lista) {

        principal.getGerencia().getTabelausuario().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Nome", "CPF", "RG", "Carteira trabalho", "Editar"};
            Object[][] dados = new Object[lista.size()][5];
            for (int i = 0; i < lista.size(); i++) {

                Funcionario funcionario = lista.get(i);
                dados[i][0] = funcionario.getNome();
                dados[i][1] = funcionario.getCpf();
                dados[i][2] = funcionario.getRg();
                dados[i][3] = funcionario.getCarteira_trabalho();
                dados[i][4] = acesso.getBtnRe();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            principal.getGerencia().getTabelausuario().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void escolherUsuario() {
        String usuario = principal.getGerencia().getConbousuario().getSelectedItem().toString();
        if (usuario.equals("FUNCIONARIO")) {
            funcionarios = fachada.getAllFun();
            preencherTabelaFuncionario(funcionarios);
            opcao = func;
        } else {
            professors = fachada.getAllPro();
            preencherTabelaProfessor(professors);
            opcao = pro;
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
                    ro = tabela.getSelectedRow();
                    escolha = editar;
                }
                if (boton.getName().equals("reset")) {
                    ro = tabela.getSelectedRow();
                    escolha = resetar;

                }

            }
        }
        return ro;
    }

    public void EditarLoginProfessor() {
        try {

            String senhaHex = "";
            StringBuilder ab = null;
            String pwd = acesso.getSenha().getText();
            String confirmar = acesso.getConfirmar().getText();

            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte messageDigest[] = md.digest(pwd.getBytes("UTF-8"));

                ab = new StringBuilder();

                for (byte b : messageDigest) {
                    ab.append(String.format("%02X", 0xFF & b));

                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);

            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

            senhaHex = ab.toString();

            if (confirmar.equals(pwd)) {
                controleLogin.getProfessor().getLogin().setSenha(senhaHex);
                fachada.salvar(controleLogin.getProfessor());
                mensagems.mensagens("Senha alterada com Sucesso", "info");
                acesso.setVisible(false);
            } else {
                mensagems.mensagens("Senhas Diferentes", "advertencia");
            }

        } catch (java.lang.IllegalStateException n) {
            mensagems.mensagens("Voce precisa preencher todos os campos !", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagems.mensagens("Erro !!!", "erro");
        }
    }

    public void EditarLoginFuncionario() {
        try {
            String senhaHex = "";
            StringBuilder ab = null;
            String pwd = acesso.getSenha().getText();
            String confirmar = acesso.getConfirmar().getText();

            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte messageDigest[] = md.digest(pwd.getBytes("UTF-8"));

                ab = new StringBuilder();

                for (byte b : messageDigest) {
                    ab.append(String.format("%02X", 0xFF & b));

                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);

            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

            senhaHex = ab.toString();

            if (confirmar.equals(pwd)) {
                controleLogin.getFuncionario().getLogin().setSenha(senhaHex);
                fachada.salvar(controleLogin.getFuncionario());
                mensagems.mensagens("Senha alterada com Sucesso", "info");
                acesso.setVisible(false);
            } else {
                mensagems.mensagens("Senhas Diferentes", "advertencia");
            }

        } catch (java.lang.IllegalStateException n) {
            mensagems.mensagens("Voce precisa preencher todos os campos !", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagems.mensagens("Erro !!!", "erro");
        }
    }

}
