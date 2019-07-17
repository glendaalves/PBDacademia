/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.DaoView.DaoViewAgenda;
import br.com.pbd.Daos.DaoAgenda;
import br.com.pbd.Fachada.Fachada;
import br.com.pbd.Visoes.ViewAgenda;
import br.com.pbd.modelos.Agenda;
import br.com.pbd.modelos.Dados;
import br.com.pbd.modelos.Login;
import br.com.pbd.modelos.Professor;
import br.com.pbd.modelos.Render;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.NovoProfessor;
import br.com.pbd.view.Principal;
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
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleProfessor extends MouseAdapter implements ActionListener {

    private Principal principal;
    private List<Professor> professors;
    private Professor p;
    private List<ViewAgenda> viewagendas;
    private Agenda agenda;
    private int escolha;
    private final int salvar = 0, editar = 1, excluir = 2, agende = 3;
    private ControleLogin controleLogin;
    private Fachada fachada;
    private NovoProfessor novoProfessor;
    private int ro;

    private Mensagens mensagens;

    public ControleProfessor (Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;

        professors = new ArrayList<Professor>();

        principal.getCadastroProfessor().getBotaoSalvar().addActionListener(this);
        principal.getCadastroProfessor().getBotaoCancelar().addActionListener(this);
        principal.getBotaoProfessor().addActionListener(this);
        principal.getAgendaprofessor().getCombodia1().addActionListener(this);
        principal.getAgendaprofessor().getBotaoFechar().addActionListener(this);
        principal.getBuscarProfessor().getTabelaProfessores().addMouseListener(this);
        principal.getBuscarProfessor().getBotaoFechar().addActionListener(this);
        principal.getAgendaprofessor().getTabelaAgenda().addMouseListener(this);
        principal.getBuscarProfessor().getBotaoAdicionar().addActionListener(this);
        mensagens = new Mensagens(principal, true);
        novoProfessor = new NovoProfessor(principal, true);
        novoProfessor.getBotaook().addActionListener(this);

        principal.getBuscarProfessor().getTxtPesquisa().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                professors = fachada.buscaP(principal.getBuscarProfessor().getTxtPesquisa().getText());
                preencherTabela(professors);
            }

        });

    }

    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == principal.getAgendaprofessor().getTabelaAgenda()) {
            ro = retornaIndice(principal.getAgendaprofessor().getTabelaAgenda(), e);
            int id = viewagendas.get(ro).getId();
            agenda = new DaoAgenda().bucarPorId(id);
            if (escolha == excluir) {
                preencherProfessor();
                professors = fachada.getAllPro();
                if (professors.size() <= 1) {
                    mensagens.mensagens("Exclusão Não Permitida. Não ha Substituto", "advertencia");
                } else {
                    mensagens.mensagens("Esccolha seu Substituto", "info");
                    novoProfessor.setVisible(true);
                }

            }

        }
        if (e.getSource() == principal.getBuscarProfessor().getTabelaProfessores()) {
            int ro = retornaIndice(principal.getBuscarProfessor().getTabelaProfessores(), e);
            p = professors.get(ro);

            if (escolha == editar) {
                principal.getBuscarProfessor().getTxtPesquisa().setText("");
                professors = fachada.getAllPro();
                preencherTabela(professors);
                principal.getCadastroProfessor().setVisible(true);
                principal.getCadastroProfessor().getPainelLogin().setVisible(false);
                principal.getCadastroProfessor().getLabelcadastro().setText("ATUALIZAR PROFESSOR");
                principal.getCadastroProfessor().preencherCadastro(p);

            }
            if (escolha == excluir) {
                if (fachada.ativarDesativar(p)) {
                    professors = fachada.getAllPro();
                    preencherTabela(professors);
                    mensagens.mensagens("Exclusão Realizada", "info");
                } else {
                    mensagens.mensagens("Exclusão Não Permitida ", "advertencia");
                }

            }
            if (escolha == agende) {

                principal.getBuscarProfessor().getTxtPesquisa().setText("");
                professors = fachada.getAllPro();
                preencherTabela(professors);
                principal.getAgendaprofessor().getBotaoadicionar().setVisible(false);
                principal.getAgendaprofessor().setVisible(true);
                principal.getAgendaprofessor().getLabelAgenda().setText("Professor :");
                p = professors.get(ro);
                principal.getAgendaprofessor().getTxtnome().setText(p.getNome());
                principal.getAgendaprofessor().getCombodia().setVisible(false);
                agenda();
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == novoProfessor.getBotaook()) {
            int indice = novoProfessor.getComboprofessor().getSelectedIndex();
            Professor p = professors.get(indice);
            int id = viewagendas.get(ro).getId();
            agenda = new DaoAgenda().bucarPorId(id);
            agenda.setProfessor(p);
            fachada.salvar(agenda);
            agenda();
            novoProfessor.setVisible(false);

        }
        if (e.getSource() == principal.getBotaoProfessor()) {
            professors = fachada.getAllPro();
            preencherTabela(professors);
            principal.Desativar();
            principal.getBuscarProfessor().getTxtPesquisa().setText("");

        }
        if (e.getSource() == principal.getBuscarProfessor().getBotaoFechar()) {

            if (controleLogin.getProfessor() != null) {
                principal.AtivarP();

            } else {
                principal.Ativar();
            }
        }
        if (e.getSource() == principal.getAgendaprofessor().getCombodia1()) {

            agenda();

        }
        if (e.getSource() == principal.getBuscarProfessor().getBotaoAdicionar()) {

            escolha = salvar;
            principal.getCadastroProfessor().getPainelLogin().setVisible(true);

        }

        if (e.getSource() == principal.getCadastroProfessor().getBotaoCancelar()) {
            principal.getCadastroProfessor().Limpar();
            principal.getCadastroProfessor().getLabelcadastro().setText("CADASTRAR PROFESSOR");
            principal.getBuscarProfessor().getTxtPesquisa().grabFocus();
            professors = fachada.getAllPro();
            preencherTabela(professors);
            principal.getBuscarProfessor().getTxtPesquisa().setText("");

        }
        if (e.getSource() == principal.getAgendaprofessor().getBotaoFechar()) {
            principal.getBuscarProfessor().getTxtPesquisa().grabFocus();
        }
        if (e.getSource() == principal.getCadastroProfessor().getBotaoSalvar()) {
            if (escolha == salvar) {
                SalvarProfessor();
                principal.getBuscarProfessor().getTxtPesquisa().grabFocus();
                principal.getBuscarProfessor().getTxtPesquisa().setText("");

            }
            if (escolha == editar) {
                EditarProfessor(p);
                principal.getBuscarProfessor().getTxtPesquisa().grabFocus();
                principal.getBuscarProfessor().getTxtPesquisa().setText("");
            }

        }

    }

    public void agenda() {

        if (principal.getAgendaprofessor().getCombodia1().getSelectedIndex() > -1) {

            String dia = principal.getAgendaprofessor().getCombodia1().getSelectedItem().toString();
            viewagendas = new DaoViewAgenda().BuscaPorProfessorDia(p, dia);
            preencherTabelaAgenda();

            principal.getAgendaprofessor().getLabeldia_semana().setText(dia);
        }
    }

    public void SalvarProfessor() {

        Professor professor = new Professor();
        Dados dados = new Dados();

        try {
            dados.setBairro(principal.getCadastroProfessor().getTxtbairro().getText());
            dados.setRua(principal.getCadastroProfessor().getTxtrua().getText());
            dados.setCep(principal.getCadastroProfessor().getTxtCep().getText());
            String q = principal.getCadastroProfessor().getTxtnumero().getText();
            int numero = 0;

            numero = Integer.parseInt(q);

            dados.setNumero(numero);

            dados.setUf(principal.getCadastroProfessor().getTxtUf().getSelectedItem().toString());
            dados.setCidade(principal.getCadastroProfessor().getTxtcidade().getText());

            dados.setEmail(principal.getCadastroProfessor().getTxtemail().getText());
            dados.setCelular(principal.getCadastroProfessor().getTxtcelular().getText());
            dados.setTelefone(principal.getCadastroProfessor().getTxttelefone().getText());
            professor.setDados(dados);

            Login login = new Login();
            String pwd = new String(principal.getCadastroProfessor().getTxtsenha().getPassword());
            login.setUsuario(principal.getCadastroProfessor().getTxtusuario().getText());
            String confirmar = new String(principal.getCadastroProfessor().getTxtconfirmasenha().getPassword());

            professor.setLogin(login);

            professor.setCarteira_trabalho(principal.getCadastroProfessor().getTxtcarteiratrabalho().getText());
            professor.setCpf(principal.getCadastroProfessor().getTxtCpf().getText());
            Date d = new Date(System.currentTimeMillis());
            professor.setData_cadastro(d);

            java.sql.Date data = ConverterData(principal.getCadastroProfessor().getDataNascimento().getDate());
            professor.setData_nascimento(data);

            professor.setNome(principal.getCadastroProfessor().getTxtNome().getText());
            professor.setRg(principal.getCadastroProfessor().getTxtrg().getText());
            String salario = principal.getCadastroProfessor().getTxtsalario().getText();

            Double salari = 0.0;

            salari = Double.parseDouble(salario);

            professor.setSalario(salari);
            professor.setSexo(principal.getCadastroProfessor().getCombosexo().getSelectedItem().toString());

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
            login.setSenha(senhaHex);

            if (confirmar.equals(pwd)) {
                fachada.salvar(professor);
                mensagens.mensagens("Cadastrado com Sucesso", "info");
                professors = fachada.getAllPro();
                preencherTabela(professors);
                principal.getCadastroProfessor().setVisible(false);
                principal.getCadastroProfessor().Limpar();
            } else {
                mensagens.mensagens("Senhas Diferentes", "advertencia");
            }
        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("voce precisa preencher todos os campos!", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Erro !!! Numeros Invalidos ", "erro");
        } catch (java.lang.NullPointerException e) {
            mensagens.mensagens("Erro!!! Data Invalida", "erro");
        }

    }

    public void preencherProfessor() {
        professors = fachada.getAllPro();
        novoProfessor.getComboprofessor().removeAllItems();
        for (Professor pro : professors) {
            novoProfessor.getComboprofessor().addItem(pro.getNome());

        }

    }

    public void preencherTabela(List<Professor> lista) {

        professors = fachada.getAllPro();

        principal.getBuscarProfessor().getTabelaProfessores().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Nome", "CPF", "RG", "sexo", "Editar", "Ecluir", "Agenda"};
            Object[][] dados = new Object[lista.size()][7];
            for (int i = 0; i < lista.size(); i++) {

                Professor professor = lista.get(i);
                dados[i][0] = professor.getNome();
                dados[i][1] = professor.getCpf();
                dados[i][2] = professor.getRg();
                dados[i][3] = professor.getSexo();
                dados[i][4] = principal.getBuscarProfessor().getBtnEd();
                dados[i][5] = principal.getBuscarProfessor().getBtnEx();
                dados[i][6] = principal.getBuscarProfessor().getBtnAgen();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getBuscarProfessor().getTabelaProfessores().getColumnModel();
            principal.getBuscarProfessor().getTabelaProfessores().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void EditarProfessor(Professor pro) {

        try {
            pro.getDados().setBairro(principal.getCadastroProfessor().getTxtbairro().getText());
            pro.getDados().setRua(principal.getCadastroProfessor().getTxtrua().getText());
            pro.getDados().setCep(principal.getCadastroProfessor().getTxtCep().getText());
            String q = principal.getCadastroProfessor().getTxtnumero().getText();
            int numero = 0;

            numero = Integer.parseInt(q);

            pro.getDados().setNumero(numero);
            pro.getDados().setUf(principal.getCadastroProfessor().getTxtUf().getSelectedItem().toString());
            pro.getDados().setCidade(principal.getCadastroProfessor().getTxtcidade().getText());
            pro.getDados().setEmail(principal.getCadastroProfessor().getTxtemail().getText());
            pro.getDados().setCelular(principal.getCadastroProfessor().getTxtcelular().getText());
            pro.getDados().setTelefone(principal.getCadastroProfessor().getTxttelefone().getText());

            pro.setCarteira_trabalho(principal.getCadastroProfessor().getTxtcarteiratrabalho().getText());
            pro.setCpf(principal.getCadastroProfessor().getTxtCpf().getText());
            Date d = new Date(System.currentTimeMillis());
            pro.setData_cadastro(d);

            java.sql.Date data = ConverterData(principal.getCadastroProfessor().getDataNascimento().getDate());
            pro.setData_nascimento(data);

            pro.setNome(principal.getCadastroProfessor().getTxtNome().getText());
            pro.setRg(principal.getCadastroProfessor().getTxtrg().getText());
            String salario = principal.getCadastroProfessor().getTxtsalario().getText();
            Double salari = 0.0;

            salari = Double.parseDouble(salario);

            pro.setSalario(salari);
            pro.setSexo(principal.getCadastroProfessor().getCombosexo().getSelectedItem().toString());

            fachada.salvar(pro);
            mensagens.mensagens("Editado com Sucesso", "info");
            principal.getBuscarProfessor().getTxtPesquisa().setText("");
            professors = fachada.getAllPro();
            preencherTabela(professors);
            principal.getCadastroProfessor().setVisible(false);;
            principal.getCadastroProfessor().Limpar();
            principal.getCadastroProfessor().getLabelcadastro().setText("CADASTRAR PROFESSOR");

        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("voce precisa preencher todos os campos!", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Erro !!! Numero Invalido", "erro");
        } catch (java.lang.NullPointerException e) {
            mensagens.mensagens("Erro !!! Data Invalida", "erro");
        }

    }

    public java.sql.Date ConverterData(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public void preencherTabelaAgenda() {

        principal.getAgendaprofessor().getTabelaAgenda().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Aluno", "Situação", "Turno", "Horario", "Excluir"};
            Object[][] dados = new Object[viewagendas.size()][5];
            for (int i = 0; i < viewagendas.size(); i++) {

                ViewAgenda ag = viewagendas.get(i);
                dados[i][0] = ag.getNome();
                dados[i][1] = ag.getSituacao();
                dados[i][2] = ag.getTurno();
                dados[i][3] = ag.getHorario();
                dados[i][4] = principal.getBuscarProfessor().getBtnEx();

            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getAgendaprofessor().getTabelaAgenda().getColumnModel();

            principal.getAgendaprofessor().getTabelaAgenda().setModel(dataModel);

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
                if (boton.getName().equals("agenda")) {
                    escolha = agende;

                }

            }
        }
        return ro;
    }

}
