/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.Daos.DaoFuncionario;
import br.com.pbd.Daos.DaoLogin;
import br.com.pbd.Daos.DaoProfessor;
import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Administrador;
import br.com.pbd.modelos.Funcionario;
import br.com.pbd.modelos.Login;
import br.com.pbd.modelos.Professor;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.NovaSenha;
import br.com.pbd.view.Principal;
import br.com.pbd.view.TelaAdministrador;
import br.com.pbd.view.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;

/**
 * '
 *
 * @author Glenda Alves de Lima
 */
public class ControleLogin implements ActionListener, KeyListener {

    private Principal principal;
    private TelaLogin login;
    private static Funcionario funcionario;
    private static Professor professor;
    private TelaAdministrador administrador;
    private Administrador Adm;
    private HashMap<Integer, Boolean> keyEventos;
    private Mensagens mensagems;
    private Fachada fachada;
    private NovaSenha novaSenha;

    public ControleLogin(Principal principal, TelaLogin login, TelaAdministrador administrador, Fachada fachada) {
        this.principal = principal;
        this.login = login;
        this.administrador = administrador;
        this.fachada = fachada;
        novaSenha = new NovaSenha(login, true);

        getLogin().getSenhaField().addKeyListener(this);
        getLogin().getUsuarioField().addKeyListener(this);
        getLogin().addKeyListener(this);
        getPrincipal().getBotaologoff().addActionListener(this);
        login.getBotaoEntrar().addActionListener(this);
        administrador.getBotaoEntrar().addActionListener(this);
        login.getEsqueceusenha().addActionListener(this);
        keyEventos = new HashMap<Integer, Boolean>();
        verificar();
        mensagems = new Mensagens(login, true);
      


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login.getEsqueceusenha()) {
            novaSenha.limpar();
        //    novaSenha.setLocationRelativeTo(null);
            novaSenha.setVisible(true);
        }
        if (e.getSource() == novaSenha.getBotaosalvar()) {
            if (novaSenha.getFuncionariobox().isSelected()) {

                Funcionario();
            } else {
                Professor();
            }
        }

        if (e.getSource() == getLogin().getBotaoEntrar()) {
            buscarLogin();
        }
        if (e.getSource() == getPrincipal().getBotaologoff()) {
            getPrincipal().setVisible(false);
            Adm = null;
            professor = null;
            funcionario = null;
            getLogin().getUsuarioField().setText("");
            getLogin().getSenhaField().setText("");
            getLogin().setVisible(true);
            getLogin().getUsuarioField().grabFocus();
        }
        if (e.getSource() == getAdministrador().getBotaoEntrar()) {
            Administrador administrado = new Administrador();
            Login login = new Login();
            String pwd = new String(getAdministrador().getSenhaField().getPassword());
            login.setUsuario(getAdministrador().getUsuarioField().getText());
            String confirmar = new String(getAdministrador().getConfirmarField().getPassword());
            administrado.setLogin(login);

            try {

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
                    getFachada().salvar(administrado);
                    getAdministrador().setVisible(false);
                    this.getLogin().setVisible(true);

                } else {
                    getMensagems().setLocationRelativeTo(null);
                    getMensagems().mensagens("Senhas Diferentes", "info");
                }
            } catch (java.lang.IllegalStateException n) {
                getMensagems().mensagens("Voce precisa preencher todos os campos ", "advertencia");
            } catch (javax.persistence.RollbackException roll) {
                getMensagems().mensagens("Erro !!!", "erro");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void verificar() {
        try {
            Administrador a = getFachada().buscaUltimoRegistroA();
            getLogin().setVisible(true);
        } catch (NoResultException n) {
            getAdministrador().setVisible(true);
        }
    }

    public void buscarLogin() {

        Login o = new Login();
        String pwd = new String(getLogin().getSenhaField().getPassword());
        String usuario = getLogin().getUsuarioField().getText();
        o.setUsuario(usuario);

        String senhaHex = "";
        StringBuilder ab = null;

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

        o.setSenha(senhaHex);

        ativarComponentesAdmin(o);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        getKeyEventos().put(e.getKeyCode(), true);

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarLogin();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            getLogin().getUsuarioField().grabFocus();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            getLogin().getSenhaField().grabFocus();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        getKeyEventos().remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void ativarComponentesProfessor(Login o) {

        try {
            professor = getFachada().BuscarLoginProfessor(o);
            if (professor != null) {
                if (professor.getLogin().isReset() == false) {
                    getLogin().setVisible(false);
                    getPrincipal().getLabelnome().setText("Bem vindo " + o.getUsuario());
                    getPrincipal().getListaAcompanhamento().getBotaoAdicionar().setEnabled(true);
                    getPrincipal().getAgendaAluno().getBotaoadicionar().setEnabled(true);
                    getPrincipal().getLabelfuncao().setText("Professor");
                    getPrincipal().setVisible(true);
                    getPrincipal().getBotaoTarefa().setEnabled(false);
                    getPrincipal().getBotaoFornecedor().setEnabled(false);
                    getPrincipal().getBotaoProduto().setEnabled(false);
                    getPrincipal().getBotaoFuncionario().setEnabled(false);
                    getPrincipal().getBotaoCaixa().setEnabled(false);
                    getPrincipal().getBotaoVenda().setEnabled(false);
                    getPrincipal().getBotaoRelatorios().setEnabled(false);
                    getPrincipal().getBotaoDespesas().setEnabled(false);
                    getPrincipal().getBotaoAcademia().setEnabled(false);
                    getPrincipal().getBotaoAluno().setEnabled(true);
                    getPrincipal().getBotaoProfessor().setEnabled(true);
                    getPrincipal().getBotaoAgenda().setEnabled(true);
                    getPrincipal().getBotaoExercicio().setEnabled(true);
                    getPrincipal().getBotaoAcesso().setEnabled(true);
                    getPrincipal().getBotaologoff().setEnabled(true);
                    getPrincipal().getBotaoSair().setEnabled(true);
                } else {
                    mensagems.mensagens("Crie nova senha", "info");
                }
            } else {
                getMensagems().setLocationRelativeTo(null);
                getMensagems().mensagens("Login ou senha invalido", "info");
            }
        } catch (java.lang.NullPointerException e) {

        }

    }

    public void ativarComponentesAdmin(Login o) {
        try {
            Adm = getFachada().BuscarLoginAdministrador(o);
            if (Adm != null) {
                getLogin().setVisible(false);
                getPrincipal().getLabelnome().setText("Bem vindo " + o.getUsuario());
                getPrincipal().getLabelfuncao().setText("Administrador");
                getPrincipal().setVisible(true);
                getPrincipal().getTarefa().getBotaoAdiciona().setEnabled(false);
                getPrincipal().getBotaoTarefa().setEnabled(true);
                getPrincipal().getBotaoFornecedor().setEnabled(true);
                getPrincipal().getBotaoProduto().setEnabled(true);
                getPrincipal().getBotaoFuncionario().setEnabled(true);
                getPrincipal().getBotaoCaixa().setEnabled(true);
                getPrincipal().getBotaoVenda().setEnabled(true);
                getPrincipal().getBotaoRelatorios().setEnabled(true);
                getPrincipal().getBotaoDespesas().setEnabled(true);
                getPrincipal().getBotaoAcademia().setEnabled(true);
                getPrincipal().getBotaoAluno().setEnabled(true);
                getPrincipal().getBotaoProfessor().setEnabled(true);
                getPrincipal().getBotaoAgenda().setEnabled(true);
                getPrincipal().getBotaoExercicio().setEnabled(true);
                getPrincipal().getBotaoAcesso().setEnabled(true);
                getPrincipal().getBotaologoff().setEnabled(true);
                getPrincipal().getBotaoSair().setEnabled(true);
            } else {
                ativarComponentesFuncionario(o);
            }
        } catch (java.lang.NullPointerException e) {

        }

    }

    public void ativarComponentesFuncionario(Login o) {
        try {
            funcionario = (getFachada().BuscarLoginFuncionario(o));
            if (funcionario != null) {
                if (funcionario.getLogin().isReset() == false) {
                    getLogin().setVisible(false);
                    getPrincipal().getLabelnome().setText("Bem vindo " + o.getUsuario());
                    getPrincipal().getLabelfuncao().setText("Funcionario");
                    getPrincipal().setVisible(true);
                    getPrincipal().getTarefa().getBotaoAdiciona().setEnabled(true);
                    getPrincipal().getListaAcompanhamento().getBotaoAdicionar().setEnabled(false);
                    getPrincipal().getAgendaAluno().getBotaoadicionar().setEnabled(false);
                    getPrincipal().getBotaoTarefa().setEnabled(true);
                    getPrincipal().getBotaoFornecedor().setEnabled(true);
                    getPrincipal().getBotaoProduto().setEnabled(true);
                    getPrincipal().getBotaoFuncionario().setEnabled(true);
                    getPrincipal().getBotaoCaixa().setEnabled(true);
                    getPrincipal().getBotaoVenda().setEnabled(true);
                    getPrincipal().getBotaoRelatorios().setEnabled(true);
                    getPrincipal().getBotaoDespesas().setEnabled(true);
                    getPrincipal().getBotaoAcademia().setEnabled(true);
                    getPrincipal().getBotaoAluno().setEnabled(true);
                    getPrincipal().getBotaoProfessor().setEnabled(true);
                    getPrincipal().getBotaoAgenda().setEnabled(true);
                    getPrincipal().getBotaoExercicio().setEnabled(true);
                    getPrincipal().getBotaoAcesso().setEnabled(true);
                    getPrincipal().getBotaologoff().setEnabled(true);
                    getPrincipal().getBotaoSair().setEnabled(true);
                } else {
                    mensagems.mensagens("Crie nova senha", "info");
                }
            } else {
                ativarComponentesProfessor(o);
            }
        } catch (java.lang.NullPointerException e) {

        }

    }

    public void Funcionario() {

        try {
            Funcionario f = new DaoFuncionario().BuscaPorCpf(novaSenha.getTxtCpf().getText());
            if (f.getLogin().isReset()) {

                String pwd = novaSenha.getSenha().getText();
                String confirmar = novaSenha.getConfirmar().getText();

                String senhaHex = "";
                StringBuilder ab = null;
                MessageDigest md;
                md = MessageDigest.getInstance("SHA-256");
                byte messageDigest[] = md.digest(pwd.getBytes("UTF-8"));
                ab = new StringBuilder();
                for (byte b : messageDigest) {
                    ab.append(String.format("%02X", 0xFF & b));
                }
                senhaHex = ab.toString();
                f.getLogin().setSenha(senhaHex);
                f.getLogin().setReset(false);
                if (confirmar.equals(pwd)) {
                    getFachada().salvar(f);
                    novaSenha.setVisible(false);
                   

                } else {
                    getMensagems().setLocationRelativeTo(null);
                    getMensagems().mensagens("Senhas Diferentes", "info");
                }

            } else {
                getMensagems().mensagens("Solicite o Reset ao Administrador", "info");
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
        }catch (javax.persistence.NoResultException ex) {
            getMensagems().mensagens("CPF ou Opção de Usuario Invalida", "info");
        }

    }

    public void Professor() {

        try {
            Professor p = new DaoProfessor().BuscaPorCpf(novaSenha.getTxtCpf().getText());
            if (p.getLogin().isReset()) {

                String pwd = novaSenha.getSenha().getText();
                String confirmar = novaSenha.getConfirmar().getText();

                String senhaHex = "";
                StringBuilder ab = null;
                MessageDigest md;
                md = MessageDigest.getInstance("SHA-256");
                byte messageDigest[] = md.digest(pwd.getBytes("UTF-8"));
                ab = new StringBuilder();
                for (byte b : messageDigest) {
                    ab.append(String.format("%02X", 0xFF & b));
                }
                senhaHex = ab.toString();
                p.getLogin().setSenha(senhaHex);
                p.getLogin().setReset(false);
                if (confirmar.equals(pwd)) {
                    getFachada().salvar(p);
                    novaSenha.setVisible(false);
                   

                } else {
                    getMensagems().setLocationRelativeTo(null);
                    getMensagems().mensagens("Senhas Diferentes", "info");
                }

            } else {
                getMensagems().mensagens("Solicite o Reset ao Administrador", "info");
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.persistence.NoResultException ex) {
            getMensagems().mensagens("CPF ou Opção de Usuario Invalida", "info");
        }

    }

    /**
     * @return the principal
     */
    public Principal getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    /**
     * @return the login
     */
    public TelaLogin getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(TelaLogin login) {
        this.login = login;
    }

    /**
     * @return the funcionario
     */
    public static Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param aFuncionario the funcionario to set
     */
    public static void setFuncionario(Funcionario aFuncionario) {
        funcionario = aFuncionario;
    }

    /**
     * @return the professor
     */
    public static Professor getProfessor() {
        return professor;
    }

    /**
     * @param aProfessor the professor to set
     */
    public static void setProfessor(Professor aProfessor) {
        professor = aProfessor;
    }

    /**
     * @return the administrador
     */
    public TelaAdministrador getAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(TelaAdministrador administrador) {
        this.administrador = administrador;
    }

    /**
     * @return the keyEventos
     */
    public HashMap<Integer, Boolean> getKeyEventos() {
        return keyEventos;
    }

    /**
     * @param keyEventos the keyEventos to set
     */
    public void setKeyEventos(HashMap<Integer, Boolean> keyEventos) {
        this.keyEventos = keyEventos;
    }

    /**
     * @return the mensagems
     */
    public Mensagens getMensagems() {
        return mensagems;
    }

    /**
     * @param mensagems the mensagems to set
     */
    public void setMensagems(Mensagens mensagems) {
        this.mensagems = mensagems;
    }

    /**
     * @return the fachada
     */
    public Fachada getFachada() {
        return fachada;
    }

    /**
     * @param fachada the fachada to set
     */
    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }

    /**
     * @return the Adm
     */
    public Administrador getAdm() {
        return Adm;
    }

    /**
     * @param Adm the Adm to set
     */
    public void setAdm(Administrador Adm) {
        this.Adm = Adm;
    }

}
