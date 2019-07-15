package br.com.pbd.controles;

import br.com.pbd.DaoView.DaoViewAgenda;
import br.com.pbd.Daos.DaoAgenda;
import br.com.pbd.Daos.DaoCaixa;
import br.com.pbd.Daos.DaoMensalidade;
import br.com.pbd.Fachada.Fachada;
import br.com.pbd.Visoes.ViewAgenda;
import br.com.pbd.modelos.Acompanhamento;
import br.com.pbd.modelos.Agenda;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Caixa;
import br.com.pbd.modelos.Dados;
import br.com.pbd.modelos.Exercicio;
import br.com.pbd.modelos.Mensalidade;
import br.com.pbd.modelos.Professor;
import br.com.pbd.modelos.Render;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.Principal;
import br.com.pbd.view.QuantidadeExercicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleAlunos extends MouseAdapter implements ActionListener {

    private Fachada fachada;
    private Principal principal;
    private List<Aluno> alunos;
    private Aluno a;
    private List<Acompanhamento> acompanhamentos;
    private Acompanhamento acom;
    private Mensalidade m;
    private List<Mensalidade> mensalidades;
    private List<ViewAgenda> viewagendas;
    private Agenda agenda;
    private List<Exercicio> exercicios, Edicaoexercicio, AllExercicio;
    private Calendar ca = new GregorianCalendar();
    private java.util.Date data2 = new java.util.Date();
    private java.sql.Date dataN;
    private int escolha;
    private final int salvar = 0, editar = 1, excluir = 2, mensalidade = 3, agende = 4, acompanhamento = 5, pagar = 6, selecionar = 7;
    private ControleLogin controleLogin;
    private Mensagens mensagens;
    private final QuantidadeExercicio quantidadeExercicio;
    private List<Professor> professors;
    private Caixa caixa;

    public ControleAlunos(Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;

        principal.getCadastroAlunos().getBotaoSalvar().addActionListener(this);
        principal.getBotaoAluno().addActionListener(this);
        principal.getCadastroAlunos().getBotaoCancelar().addActionListener(this);
        principal.getListaAcompanhamento().getBotaoAdicionar().addActionListener(this);
        principal.getListaAcompanhamento().getTabelaAcompanhamento().addMouseListener(this);
        principal.getMensalidade().getBotaosalvar().addActionListener(this);
        principal.getListaExercicio().getBotaoFechar().addActionListener(this);
        principal.getAgendaAluno().getCombodia().addActionListener(this);
        principal.getAgendaAluno().getBotaoadicionar().addActionListener(this);
        principal.getAcompanhamento().getBotaoSalvar().addActionListener(this);
        principal.getExercicio().getCombotreino().addActionListener(this);
        principal.getBuscarAlunos().getTabelaAlunos().addMouseListener(this);
        principal.getListaExercicio().getTabelaexercicio().addMouseListener(this);
        principal.getAgendaAluno().getTabelaAgenda().addMouseListener(this);
        principal.getListaMensalidades().getTabelamensalidade().addMouseListener(this);
        principal.getBuscarAlunos().getBotaoAdicionar().addActionListener(this);
        principal.getAgendaAluno().getBotaoFechar().addActionListener(this);
        principal.getMensalidade().getBotaoFechar().addActionListener(this);
        principal.getBuscarAlunos().getBotaoFechar().addActionListener(this);
        principal.getListaMensalidades().getBotaoFechar().addActionListener(this);
        principal.getListaAcompanhamento().getBotaoFechar().addActionListener(this);
        principal.getExerciciosTreino().getBotaocomfirmar().addActionListener(this);
        principal.getListaExercicio().getBotaoFechar().addActionListener(this);
        principal.getAgendaAluno().getTabelaAgenda().addMouseListener(this);
        quantidadeExercicio = new QuantidadeExercicio(principal, true);
        quantidadeExercicio.getBotaook().addActionListener(this);

        mensagens = new Mensagens(principal, true);
        Edicaoexercicio = new ArrayList<Exercicio>();
        principal.getBuscarAlunos().getTxtpesquisa().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                alunos = fachada.busca(principal.getBuscarAlunos().getTxtpesquisa().getText());
                preencherTabelaAluno(alunos);
            }

        });
        principal.getListaExercicio().getPesquise().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                exercicios = fachada.Busca(principal.getListaExercicio().getPesquise().getText());
                preencherTabelaExercicios(exercicios);
            }

        });

        quantidadeExercicio.getComboturno1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantidadeExercicio.getComboHorario().removeAllItems();
                preencherHorario();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == principal.getListaMensalidades().getTabelamensalidade()) {
            int ro = retornaIndice(principal.getListaMensalidades().getTabelamensalidade(), e);
            if (escolha == pagar) {
                try {
                    java.util.Date dt = new java.util.Date();
                    caixa = new DaoCaixa().BuscarCaixa(ConverterData(dt));
                    Date d = new Date(System.currentTimeMillis());
                    mensalidades.get(ro).setPagamento(d);
                    mensalidades.get(ro).setStatus("Pago");
                    double soma = caixa.getValor_fechamento() +  mensalidades.get(ro).getValor();
                    a.setMensalidades(mensalidades);
                    fachada.salvar(a);
                    caixa.setValor_fechamento(soma);
                    fachada.salvar(caixa);
                    mensagens.mensagens("Pago com Sucesso", "info");
                    exibirRelatorio(a.getNome(), mensalidades.get(ro).getVencimento(), mensalidades.get(ro).getValor());
                    preencherTabelaMensalidade();
                } catch (java.lang.IllegalStateException n) {
                    mensagens.mensagens("Voce precisa preencher todos os campos !", "advertencia");
                } catch (javax.persistence.RollbackException roll) {
                    mensagens.mensagens("Erro !!!", "erro");
                } catch (SQLException ex) {
                    Logger.getLogger(ControleAlunos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(ControleAlunos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if (e.getSource() == principal.getAgendaAluno().getTabelaAgenda()) {
            int ro = retornaIndice(principal.getAgendaAluno().getTabelaAgenda(), e);
            if (escolha == excluir) {
                Exercicio u = Edicaoexercicio.get(ro);
                exercicios.add(u);
                Edicaoexercicio.remove(u);
                preencherTabelaExercicios(exercicios);

            }

        }
        if (e.getSource() == principal.getListaAcompanhamento().getTabelaAcompanhamento()) {
            int ro = retornaIndice(principal.getListaAcompanhamento().getTabelaAcompanhamento(), e);
            acom = acompanhamentos.get(ro);
            if (escolha == excluir) {
                fachada.ativarDesativar(acom);
                mensagens.mensagens("Exclusão Realizada", "info");
                preencherTabelaAcompanhamento();

            }

        }

        if (e.getSource() == principal.getListaExercicio().getTabelaexercicio()) {
            int ro = retornaIndice(principal.getListaExercicio().getTabelaexercicio(), e);
            if (escolha == selecionar) {
                Exercicio u = exercicios.get(ro);
                removerExercicio(u);
                preencherTabelaExercicios(exercicios);
                Edicaoexercicio.add(u);
                agenda.setExercicios(Edicaoexercicio);
                fachada.salvar(agenda);
                principal.getListaExercicio().setVisible(false);
                preencherTabelaExercicio();

            }
        }

        if (e.getSource() == principal.getBuscarAlunos().getTabelaAlunos()) {
            int ro = retornaIndice(principal.getBuscarAlunos().getTabelaAlunos(), e);
            a = alunos.get(ro);
            if (escolha == editar) {

                principal.getCadastroAlunos().setVisible(true);
                principal.getCadastroAlunos().getLabelcadastro().setText("ATUALIZAR ALUNO");
                principal.getCadastroAlunos().preencherCadastro(a);
                principal.getBuscarAlunos().getTxtpesquisa().setText("");
                alunos = fachada.getAll();
                preencherTabelaAluno(alunos);
            }
            if (escolha == excluir) {
                principal.getBuscarAlunos().getTxtpesquisa().grabFocus();
                fachada.ativarDesativar(a);
                mensagens.mensagens("Exclusão Realizada", "info");
                alunos = fachada.getAll();
                preencherTabelaAluno(alunos);

            }
            if (escolha == agende) {
                preencherDia();
                principal.getAgendaAluno().getCombodia1().setVisible(false);
                principal.getAgendaAluno().getTxtnome().setText(a.getNome());
                principal.getAgendaAluno().setVisible(true);
                preencherTabelaExercicio();
                principal.getBuscarAlunos().getTxtpesquisa().setText("");
                alunos = fachada.getAll();
                preencherTabelaAluno(alunos);
            }
            if (escolha == mensalidade) {
                principal.getBuscarAlunos().getTxtpesquisa().setText("");
                alunos = fachada.getAll();
                preencherTabelaAluno(alunos);
                if (a.getMensalidades().isEmpty()) {
                    principal.getMensalidade().setVisible(true);
                    principal.getMensalidade().getTxtaluno().setText(a.getNome());
                } else if (new DaoMensalidade().BuscaMensalidades(a, "Debito").isEmpty()) {
                    mensagens.mensagens("Plano expirado, Escolha um Novo Plano", "info");
                    principal.getMensalidade().setVisible(true);
                    principal.getMensalidade().getTxtaluno().setText(a.getNome());
                } else {
                    principal.getListaMensalidades().setVisible(true);
                    preencherTabelaMensalidade();
                    principal.getListaMensalidades().getTxtaluno().setText(a.getNome());
                }

            }
            if (escolha == acompanhamento) {

                principal.getListaAcompanhamento().setVisible(true);
                preencherTabelaAcompanhamento();
                principal.getListaAcompanhamento().getTxtaluno().setText(a.getNome());
                principal.getBuscarAlunos().getTxtpesquisa().setText("");
                alunos = fachada.getAll();
                preencherTabelaAluno(alunos);
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == principal.getBuscarAlunos().getBotaoAdicionar()) {
            escolha = salvar;

        }
        if (e.getSource() == principal.getListaExercicio().getBotaoFechar()) {
            principal.getListaExercicio().setVisible(false);

        }
        if (e.getSource() == principal.getExerciciosTreino().getBotaocomfirmar()) {
            preencherProfessor();
            preencherHorario();
            quantidadeExercicio.setVisible(true);

        }
        if (e.getSource() == quantidadeExercicio.getBotaook()) {
            salvarExercicioAgenda(a, exercicios);
        }

        if (e.getSource() == principal.getListaMensalidades().getBotaoFechar()) {
            principal.getBuscarAlunos().getTxtpesquisa().grabFocus();

        }
        if (e.getSource() == principal.getListaExercicio().getBotaoFechar()) {
            principal.getListaExercicio().getPesquise().setText("");

        }

        if (e.getSource() == principal.getListaAcompanhamento().getBotaoFechar()) {
            principal.getBuscarAlunos().getTxtpesquisa().grabFocus();

        }
        if (e.getSource() == principal.getAgendaAluno().getBotaoFechar()) {
            principal.getAgendaAluno().Limpar();
            principal.getBuscarAlunos().getTxtpesquisa().grabFocus();

        }
        if (e.getSource() == principal.getMensalidade().getBotaoFechar()) {
            principal.getMensalidade().Limpar();
            principal.getBuscarAlunos().getTxtpesquisa().grabFocus();

        }
        if (e.getSource() == principal.getAgendaAluno().getCombodia()) {
            preencherTabelaExercicio();

        }
        if (e.getSource() == principal.getBuscarAlunos().getBotaoFechar()) {

            principal.getBuscarAlunos().getTxtpesquisa().setText("");

            if (controleLogin.getProfessor() != null) {
                principal.AtivarP();

            } else {
                principal.Ativar();
            }

        }

        if (e.getSource() == principal.getAgendaAluno().getBotaoadicionar()) {

            if (!viewagendas.isEmpty()) {

                int indice = principal.getAgendaAluno().getCombodia().getSelectedIndex();

                agenda = new DaoAgenda().bucarPorId(viewagendas.get(indice).getId());
                if (agenda.getProfessor() != null) {
                    principal.getListaExercicio().setVisible(true);
                    AllExercicio = fachada.getAllE();
                    Edicaoexercicio = agenda.getExercicios();
                    preencherTabelaExercicios(separarExercicio());
                } else {
                    mensagens.mensagens("Realize o Agendamento", "info");
                }
            }

        }

        if (e.getSource() == principal.getBotaoAluno()) {
            alunos = fachada.getAll();
            preencherTabelaAluno(alunos);
            principal.Desativar();

        }
        if (e.getSource() == principal.getListaAcompanhamento().getBotaoAdicionar()) {
            escolha = salvar;
            principal.getAcompanhamento().getTxtaluno().setText(a.getNome());
        }
        if (e.getSource() == principal.getCadastroAlunos().getBotaoCancelar()) {
            principal.getCadastroAlunos().LimparAluno();
            principal.getCadastroAlunos().getLabelcadastro().setText("CADASTRAR ALUNO");
            alunos = fachada.getAll();
            preencherTabelaAluno(alunos);
            principal.getBuscarAlunos().getTxtpesquisa().grabFocus();
            principal.getBuscarAlunos().getTxtpesquisa().setText("");

        }
        if (e.getSource() == principal.getAcompanhamento().getBotaoSalvar()) {
            salvarAcompanhamento();

        }

        if (e.getSource() == principal.getCadastroAlunos().getBotaoSalvar()) {
            if (escolha == salvar) {
                salvarAluno();
                principal.getBuscarAlunos().getTxtpesquisa().grabFocus();
                principal.getBuscarAlunos().getTxtpesquisa().setText("");
            }
            if (escolha == editar) {
                editarAluno(a);
                principal.getBuscarAlunos().getTxtpesquisa().grabFocus();
                principal.getBuscarAlunos().getTxtpesquisa().setText("");
            }

        }

        if (e.getSource() == principal.getMensalidade().getBotaosalvar()) {

            String plano = principal.getMensalidade().getComboPlano().getSelectedItem().toString();

            if (plano.equals("anual")) {
                mensalidade(plano, 12, "anual");
            }
            if (plano.equals("semestral")) {
                mensalidade(plano, 6, "semestral");
            }
            if (plano.equals("trimestral")) {
                mensalidade(plano, 3, "trimestral");
            }
            if (plano.equals("bimestral")) {
                mensalidade(plano, 2, "bimestral");
            }
            if (plano.equals("mensal")) {
                mensalidade(plano, 1, "mensal");
            }
        }

    }

    public java.sql.Date ConverterData(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public void preencherTabelaAluno(List<Aluno> lista) {

        principal.getBuscarAlunos().getTabelaAlunos().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Nome", "Situacao", "CPF", "RG", "Editar", "Excluir", "Mensalidade", "Acompanhamento", "Agenda"};
            Object[][] dados = new Object[lista.size()][9];
            for (int i = 0; i < lista.size(); i++) {

                Aluno aluno = lista.get(i);
                dados[i][0] = aluno.getNome();
                dados[i][1] = aluno.getSituacao();
                dados[i][2] = aluno.getCpf();
                dados[i][3] = aluno.getRg();
                dados[i][4] = principal.getBuscarAlunos().getBtnEd();
                dados[i][5] = principal.getBuscarAlunos().getBtnEx();
                dados[i][6] = principal.getBuscarAlunos().getBtnMen();
                dados[i][7] = principal.getBuscarAlunos().getBtnAcom();
                dados[i][8] = principal.getBuscarAlunos().getBtnAgen();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getBuscarAlunos().getTabelaAlunos().getColumnModel();
            principal.getBuscarAlunos().getTabelaAlunos().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void salvarAluno() {

        Aluno aluno = new Aluno();
        Dados dados = new Dados();

        String Vetor[] = {"SEGUNDA-FEIRA", "TERÇA-FEIRA", "QUARTA-FEIRA", "QUINTA-FEIRA", "SEXTA-FEIRA", "SABADO", "DOMINGO"};

        List<Agenda> lista = new ArrayList<Agenda>();

        for (int j = 0; j < 7; j++) {
            Agenda a = new Agenda();
            a.setDia_semana(Vetor[j]);
            a.setAluno(aluno);
            lista.add(a);

        }

        try {
            dados.setBairro(principal.getCadastroAlunos().getTxtbairro().getText());
            dados.setRua(principal.getCadastroAlunos().getTxtrua().getText());
            dados.setCep(principal.getCadastroAlunos().getTxtCep().getText());
            String q = principal.getCadastroAlunos().getTxtnumero().getText();
            int numero = 0;

            numero = Integer.parseInt(q);

            dados.setNumero(numero);

            dados.setUf(principal.getCadastroAlunos().getTxtUf().getSelectedItem().toString());
            dados.setCidade(principal.getCadastroAlunos().getTxtcidade().getText());

            dados.setEmail(principal.getCadastroAlunos().getTxtemail().getText());
            dados.setCelular(principal.getCadastroAlunos().getTxtcelular().getText());
            dados.setTelefone(principal.getCadastroAlunos().getTxttelefone().getText());
            aluno.setDados(dados);
            aluno.setAcompanhamentos(new ArrayList<Acompanhamento>());
            aluno.setAgendas(new ArrayList<Agenda>());
            aluno.setMensalidades(new ArrayList<Mensalidade>());
            aluno.setCpf(principal.getCadastroAlunos().getTxtCpf().getText());

            java.sql.Date dataN = ConverterData(principal.getCadastroAlunos().getDatanascimento().getDate());
            aluno.setData_nascimento(dataN);

            Date d = new Date(System.currentTimeMillis());
            aluno.setData_matricula(d);

            aluno.setEstado_civil(principal.getCadastroAlunos().getComboEstadoCivil().getSelectedItem().toString());

            aluno.setNome(principal.getCadastroAlunos().getTxtNome().getText());
            aluno.setRg(principal.getCadastroAlunos().getTxtrg().getText());
            aluno.setSexo(principal.getCadastroAlunos().getCombosexo().getSelectedItem().toString());

            aluno.setSituacao(principal.getCadastroAlunos().getComboPosicao().getSelectedItem().toString());
            aluno.setPlano(principal.getCadastroAlunos().getCombotreino().getSelectedItem().toString());
            aluno.setSituacao(principal.getCadastroAlunos().getComboPosicao().getSelectedItem().toString());

            aluno.setAgendas(lista);
            aluno.setNivel(principal.getCadastroAlunos().getCombonivel().getSelectedItem().toString());
            fachada.salvar(aluno);
            alunos = fachada.getAll();
            preencherTabelaAluno(alunos);
            mensagens.mensagens("Cadastrado com Sucesso", "info");
            principal.getCadastroAlunos().setVisible(false);
            principal.getCadastroAlunos().LimparAluno();

        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos !", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (java.lang.NullPointerException e) {
            mensagens.mensagens("Erro!!! Data Invalida", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Erro!!! Numero Invalido", "erro");
        }
    }

    public void preencherProfessor() {
        professors = fachada.getAllPro();
        quantidadeExercicio.getComboprofessor().removeAllItems();
        for (Professor pro : professors) {
            quantidadeExercicio.getComboprofessor().addItem(pro.getNome());

        }

    }

    public void editarAluno(Aluno aluno) {

        try {
            aluno.getDados().setBairro(principal.getCadastroAlunos().getTxtbairro().getText());
            aluno.getDados().setRua(principal.getCadastroAlunos().getTxtrua().getText());
            aluno.getDados().setCep(principal.getCadastroAlunos().getTxtCep().getText());
            String q = principal.getCadastroAlunos().getTxtnumero().getText();
            int numero = 0;

            numero = Integer.parseInt(q);

            aluno.getDados().setNumero(numero);

            aluno.getDados().setUf(principal.getCadastroAlunos().getTxtUf().getSelectedItem().toString());
            aluno.getDados().setCidade(principal.getCadastroAlunos().getTxtcidade().getText());

            aluno.getDados().setEmail(principal.getCadastroAlunos().getTxtemail().getText());
            aluno.getDados().setCelular(principal.getCadastroAlunos().getTxtcelular().getText());
            aluno.getDados().setTelefone(principal.getCadastroAlunos().getTxttelefone().getText());

            aluno.setSituacao(principal.getCadastroAlunos().getComboPosicao().getSelectedItem().toString());
            aluno.setEstado_civil(principal.getCadastroAlunos().getComboEstadoCivil().getSelectedItem().toString());
            aluno.setCpf(principal.getCadastroAlunos().getTxtCpf().getText());
            Date d = new Date(System.currentTimeMillis());
            aluno.setData_matricula(d);
            aluno.setRg(principal.getCadastroAlunos().getTxtrg().getText());
            aluno.setNome(principal.getCadastroAlunos().getTxtNome().getText());

            dataN = ConverterData(principal.getCadastroAlunos().getDatanascimento().getDate());
            aluno.setData_nascimento(dataN);

            aluno.setSexo(principal.getCadastroAlunos().getCombosexo().getSelectedItem().toString());

            fachada.salvar(aluno);

            principal.getBuscarAlunos().getTxtpesquisa().setText("");
            alunos = fachada.getAll();
            preencherTabelaAluno(alunos);
            mensagens.mensagens("Editado com Sucesso", "info");
            principal.getCadastroAlunos().setVisible(false);;
            principal.getCadastroAlunos().LimparAluno();
            principal.getCadastroAlunos().getLabelcadastro().setText("CADASTRO DE ALUNO");

        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (java.lang.NullPointerException e) {
            mensagens.mensagens("Erro!!! Data Invalida", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Erro!!! Numero Invalido", "erro");
        }

    }

    public void salvarAcompanhamento() {

        Acompanhamento acompanhamento = new Acompanhamento();

        try {
            String peito = principal.getAcompanhamento().getPeito().getText();
            String ombro = principal.getAcompanhamento().getOmbro().getText();
            String cintura = principal.getAcompanhamento().getCintura().getText();
            String quadril = principal.getAcompanhamento().getQuadril().getText();
            String coxa = principal.getAcompanhamento().getCoxa().getText();
            String panturrilha = principal.getAcompanhamento().getPanturrilha().getText();
            String braco = principal.getAcompanhamento().getBraco().getText();
            String antebraco = principal.getAcompanhamento().getAntebraco().getText();
            String peso = principal.getAcompanhamento().getPeso().getText();
            String altura = principal.getAcompanhamento().getAltura().getText();
            Double altur = 0.0, pes = 0.0, peit = 0.0, ombr = 0.0, cintur = 0.0, quadri = 0.0, cox = 0.0, panturrilh = 0.0, brac = 0.0, antebrac = 0.0;

            acompanhamento.setAluno(a);
            Date d = new Date(System.currentTimeMillis());
            acompanhamento.setData(d);

            peit = Double.parseDouble(peito);
            ombr = Double.parseDouble(ombro);
            cintur = Double.parseDouble(cintura);
            quadri = Double.parseDouble(quadril);
            cox = Double.parseDouble(coxa);
            panturrilh = Double.parseDouble(panturrilha);
            brac = Double.parseDouble(braco);
            antebrac = Double.parseDouble(antebraco);

            pes = Double.parseDouble(peso);

            altur = Double.parseDouble(altura);

            acompanhamento.setPeito(peit);
            acompanhamento.setOmbro(ombr);
            acompanhamento.setCintura(cintur);
            acompanhamento.setQuadril(quadri);
            acompanhamento.setCoxa(cox);
            acompanhamento.setPanturrilha(panturrilh);
            acompanhamento.setBraco(brac);
            acompanhamento.setAntebraco(antebrac);
            acompanhamento.setPeso(pes);
            acompanhamento.setAltura(altur);

            fachada.salvar(acompanhamento);
            mensagens.mensagens("Cadastrado com Sucesso", "info");
            principal.getAcompanhamento().setVisible(false);
            preencherTabelaAcompanhamento();
            principal.getAcompanhamento().limpar();
            ExerciciosRecomendados(acompanhamento);

        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Erro !!! Valores Invalidos", "erro");
        }

    }

    public void preencherTabelaAcompanhamento() {

        if (a != null) {

            acompanhamentos = fachada.usandoIDA(a);

            principal.getListaAcompanhamento().getTabelaAcompanhamento().setDefaultRenderer(Object.class, new Render());

            try {
                String[] colunas = new String[]{"Data", "Peito", "Ombro", "Cintura", "Quadril", "Coxa", "Panturrilha", "Braco", "AnteBraco", "Peso", "altura", "Excluir"};
                Object[][] dados = new Object[acompanhamentos.size()][12];
                for (int i = 0; i < acompanhamentos.size(); i++) {

                    Acompanhamento acompanhamento = acompanhamentos.get(i);
                    dados[i][0] = acompanhamento.getData();
                    dados[i][1] = acompanhamento.getPeito();
                    dados[i][2] = acompanhamento.getOmbro();
                    dados[i][3] = acompanhamento.getCintura();
                    dados[i][4] = acompanhamento.getQuadril();
                    dados[i][5] = acompanhamento.getCoxa();
                    dados[i][6] = acompanhamento.getPanturrilha();
                    dados[i][7] = acompanhamento.getBraco();
                    dados[i][8] = acompanhamento.getAntebraco();
                    dados[i][9] = acompanhamento.getPeso();
                    dados[i][10] = acompanhamento.getAltura();
                    dados[i][11] = principal.getAcompanhamento().getBtnEx();

                }
                DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                TableColumnModel columnModel = principal.getListaAcompanhamento().getTabelaAcompanhamento().getColumnModel();
                principal.getListaAcompanhamento().getTabelaAcompanhamento().setModel(dataModel);

            } catch (Exception ex) {

            }
        }

    }

    public void preencherTabelaMensalidade() {

        mensalidades = fachada.usandoIDM(a);

        principal.getListaMensalidades().getTabelamensalidade().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Numero", "Valor", "Data Vencimento", "Forma Pagamento", "Tipo", "Plano", "Data Pagamento", "Paga"};
            Object[][] dados = new Object[mensalidades.size()][9];
            for (int i = 0; i < mensalidades.size(); i++) {

                Mensalidade m = mensalidades.get(i);
                dados[i][0] = m.getNumero();
                dados[i][1] = m.getValor();
                dados[i][2] = m.getVencimento();
                dados[i][3] = m.getForma_pagamento();
                dados[i][4] = m.getTipo();
                dados[i][5] = m.getPlano();
                dados[i][6] = m.getPagamento();
                if (mensalidades.get(i).getStatus().equals("Pago")) {
                    dados[i][7] = m.getStatus();
                } else {
                    dados[i][7] = principal.getListaMensalidades().getBtnPag();
                }

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getListaMensalidades().getTabelamensalidade().getColumnModel();
            principal.getListaMensalidades().getTabelamensalidade().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public java.sql.Time ConverterTime(String relogio) {
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
        java.util.Date data = null;
        try {
            data = formatador.parse(relogio);
        } catch (ParseException ex) {
            Logger.getLogger(ControleAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Time(data.getTime());

    }

    public void preencherDia() {
        viewagendas = new DaoViewAgenda().BuscaPorAluno(a);
        principal.getAgendaAluno().getCombodia().removeAllItems();
        for (ViewAgenda p : viewagendas) {
            principal.getAgendaAluno().getCombodia().addItem(p.getDia_semana());

        }

    }

    public void preencherTabelaExercicio() {

        int indice = principal.getAgendaAluno().getCombodia().getSelectedIndex();
        if (!viewagendas.isEmpty() && indice > -1) {
            agenda = new DaoAgenda().bucarPorId(viewagendas.get(indice).getId());
            principal.getAgendaAluno().getLabeldia_semana().setText(agenda.getDia_semana());
            exercicios = agenda.getExercicios();
            principal.getAgendaAluno().getTabelaAgenda().setDefaultRenderer(Object.class, new Render());

            int i = 0;
            try {
                String[] colunas = new String[]{"Descricao", "Peso (Kg)", "Serie", "Repetiçao", "Intervalo", "Objetivo", "Nivel", "Excluir"};
                Object[][] dados = new Object[exercicios.size()][8];
                for (Exercicio m : exercicios) {
                    dados[i][0] = m.getDescricao();
                    dados[i][1] = m.getPeso();
                    dados[i][2] = m.getSerie();
                    dados[i][3] = m.getRepeticao();
                    dados[i][4] = m.getIntervalo();
                    dados[i][5] = m.getTreino();
                    dados[i][6] = m.getNivel();
                    dados[i][7] = principal.getListaExercicio().getBtnEx();
                    i++;

                }
                DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                TableColumnModel columnModel = principal.getAgendaAluno().getTabelaAgenda().getColumnModel();
                principal.getAgendaAluno().getTabelaAgenda().setModel(dataModel);

            } catch (Exception ex) {

            }
        }
    }

    public void preencherTabelaExercicios(List<Exercicio> ex) {

        principal.getListaExercicio().getTabelaexercicio().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Descricao", "Serie", "Repeticao", "Intervalo", "Peso (Kg)", "Objetivo", "Nivel", "Selecionar"};
            Object[][] dados = new Object[ex.size()][8];
            for (int i = 0; i < ex.size(); i++) {

                Exercicio e = ex.get(i);
                dados[i][0] = e.getDescricao();
                dados[i][1] = e.getSerie();
                dados[i][2] = e.getRepeticao();
                dados[i][3] = e.getIntervalo();
                dados[i][4] = e.getPeso();
                dados[i][5] = e.getTreino();
                dados[i][6] = e.getNivel();
                dados[i][7] = principal.getListaExercicio().getBtnSelecio();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getListaExercicio().getTabelaexercicio().getColumnModel();
            principal.getListaExercicio().getTabelaexercicio().setModel(dataModel);

        } catch (Exception erro) {

        }

    }

    public void removerExercicio(Exercicio e) {
        for (int i = 0; i < exercicios.size(); i++) {
            Exercicio ex = exercicios.get(i);

            if (ex == e) {
                exercicios.remove(i);
            }
        }
    }

    public List<Exercicio> separarExercicio() {

        exercicios = AllExercicio;

        for (int j = 0; j < Edicaoexercicio.size(); j++) {

            Exercicio ex1 = Edicaoexercicio.get(j);

            for (int i = 0; i < exercicios.size(); i++) {

                Exercicio ex2 = exercicios.get(i);

                if (ex2.getId() == ex1.getId()) {
                    exercicios.remove(ex2);
                }

            }
        }
        return exercicios;
    }

    public void mensalidade(String plano, int tamanho, String comparar) {
        List<Mensalidade> list = a.getMensalidades();
        Mensalidade m = null;
        if (plano.equals(comparar)) {

            try {
                for (int j = 1; j <= tamanho; j++) {
                    m = new Mensalidade();

                    m.setForma_pagamento(principal.getMensalidade().getCombopagamento().getSelectedItem().toString());
                    m.setStatus("Debito");
                    String valor = principal.getMensalidade().getTxtvalor().getText();
                    Double valo = 0.0;

                    valo = Double.parseDouble(valor);

                    m.setValor(valo);
                    m.setTipo(principal.getMensalidade().getCombotipo().getSelectedItem().toString());
                    m.setPlano(plano);
                    m.setNumero(j);
                    ca.setTime(data2);
                    ca.set(Calendar.MONTH, ca.get(Calendar.MONTH) + j);
                    ca.set(Calendar.YEAR, ca.get(Calendar.YEAR));
                    m.setVencimento(ConverterData(ca.getTime()));
                    list.add(m);
                    a.setMensalidades(list);
                    m.setAluno(a);
                }
                fachada.salvar(m);
                mensagens.mensagens("Cadastrado com Sucesso", "info");
                principal.getMensalidade().setVisible(false);
                preencherTabelaMensalidade();
                principal.getListaMensalidades().setVisible(true);
                principal.getMensalidade().Limpar();
            } catch (java.lang.IllegalStateException n) {
                mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
            } catch (javax.persistence.RollbackException roll) {
                mensagens.mensagens("Erro !!!", "erro");
            } catch (NumberFormatException erro) {
                mensagens.mensagens("Erro!!! Numero Invalido", "erro");
            } catch (java.lang.NullPointerException erro) {
                mensagens.mensagens("Erro !!!", "erro");

            }
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
                if (boton.getName().equals("Excluir")) {
                    escolha = excluir;

                }
                if (boton.getName().equals("mensalidade")) {
                    escolha = mensalidade;

                }

                if (boton.getName().equals("agenda")) {
                    escolha = agende;

                }
                if (boton.getName().equals("acompanhamento")) {
                    escolha = acompanhamento;

                }
                if (boton.getName().equals("pagar")) {
                    escolha = pagar;

                }
                if (boton.getName().equals("Selecionar")) {
                    escolha = selecionar;
                }
            }
        }
        return ro;
    }

    public void preencherHorario() {

        if (quantidadeExercicio.getComboturno1().getSelectedItem().equals("MANHÃ")) {
            manha();

        } else if (quantidadeExercicio.getComboturno1().getSelectedItem().equals("TARDE")) {
            tarde();

        } else if (quantidadeExercicio.getComboturno1().getSelectedItem().equals("NOITE")) {
            noite();

        }

    }

    public void manha() {

        quantidadeExercicio.getComboHorario().addItem("05:00");
        quantidadeExercicio.getComboHorario().addItem("06:00");
        quantidadeExercicio.getComboHorario().addItem("07:00");
        quantidadeExercicio.getComboHorario().addItem("08:00");
        quantidadeExercicio.getComboHorario().addItem("09:00");
        quantidadeExercicio.getComboHorario().addItem("10:00");
        quantidadeExercicio.getComboHorario().addItem("11:00");

    }

    public void tarde() {
        quantidadeExercicio.getComboHorario().addItem("12:00");
        quantidadeExercicio.getComboHorario().addItem("13:00");
        quantidadeExercicio.getComboHorario().addItem("14:00");
        quantidadeExercicio.getComboHorario().addItem("15:00");
        quantidadeExercicio.getComboHorario().addItem("16:00");
        quantidadeExercicio.getComboHorario().addItem("17:00");

    }

    public void noite() {

        quantidadeExercicio.getComboHorario().addItem("18:00");
        quantidadeExercicio.getComboHorario().addItem("19:00");
        quantidadeExercicio.getComboHorario().addItem("20:00");
        quantidadeExercicio.getComboHorario().addItem("21:00");
        quantidadeExercicio.getComboHorario().addItem("22:00");
        quantidadeExercicio.getComboHorario().addItem("23:00");
        quantidadeExercicio.getComboHorario().addItem("00:00");

    }

    public void preencherTabelaExercicioSugeridos(List<Exercicio> ex) {

        principal.getExerciciosTreino().getTabelaexercicio().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Descricao", "Serie", "Repeticao", "Intervalo", "Peso (Kg)", "Avaliação"};
            Object[][] dados = new Object[ex.size()][6];
            for (int i = 0; i < ex.size(); i++) {

                Exercicio e = ex.get(i);
                dados[i][0] = e.getDescricao();
                dados[i][1] = e.getSerie();
                dados[i][2] = e.getRepeticao();
                dados[i][3] = e.getIntervalo();
                dados[i][4] = e.getPeso();
                dados[i][5] = e.getTreino();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getExerciciosTreino().getTabelaexercicio().getColumnModel();
            principal.getExerciciosTreino().getTabelaexercicio().setModel(dataModel);

        } catch (Exception erro) {

        }

    }

    private void ExerciciosRecomendados(Acompanhamento a) {

        Double imc = a.getPeso() / (a.getAltura() * a.getAltura());

        if (imc < 18.5) {
            exercicios = fachada.BuscaImc("BAIXO PESO");
        }
        if (imc > 18.4 && imc < 24.9) {
            exercicios = fachada.BuscaImc("NORMAL");
        }
        if (imc > 24.8 && imc < 29.9) {
            exercicios = fachada.BuscaImc("SOBREPESO");
        }
        if (imc > 29.8 && imc < 34.9) {
            exercicios = fachada.BuscaImc("OBESO I");
        }

        if (imc > 34.8 && imc < 39.9) {
            exercicios = fachada.BuscaImc("OBESO II");
        }

        if (imc > 39.8) {
            exercicios = fachada.BuscaImc("OBESO III");
        }

        preencherTabelaExercicioSugeridos(exercicios);
        principal.getExerciciosTreino().setVisible(true);

    }

    private void salvarExercicioAgenda(Aluno a, List<Exercicio> list) {
        try {

            String quantidadeExer = quantidadeExercicio.getTxtquantidade().getText();
            int quanti = 0;
            quanti = Integer.parseInt(quantidadeExer);
            int tamanho = list.size();

            int indicep = quantidadeExercicio.getComboprofessor().getSelectedIndex();
            Professor professor = professors.get(indicep);
            Time time = ConverterTime(quantidadeExercicio.getComboHorario().getSelectedItem().toString());
            List<Exercicio> aux = new ArrayList<Exercicio>();
            int i = 0, j = 0;
            if (tamanho >= (quanti * 7)) {
                for (Exercicio e : list) {
                    aux.add(e);
                    i++;
                    if (i == quanti) {
                        a.getAgendas().get(j).setExercicios(aux);
                        a.getAgendas().get(j).setAluno(a);
                        a.getAgendas().get(j).setProfessor(professor);
                        a.getAgendas().get(j).setTurno(quantidadeExercicio.getComboturno().getSelectedItem().toString());
                        a.getAgendas().get(j).setHorario(time);
                        fachada.salvar(a.getAgendas().get(j));

                        aux.clear();
                        j++;
                        i = 0;
                    }
                }
                quantidadeExercicio.setVisible(false);
                principal.getExerciciosTreino().setVisible(false);

            } else {
                int resto = tamanho % 7;
                int valor = tamanho - resto;
                int divisao = valor / 7;
                int sugestao = divisao;
                mensagens.mensagens(" So é permitido ate" + sugestao + " exercicio por dia", "advertencia");
            }
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Erro!!! Numero Invalido", "erro");
        } catch (java.lang.NullPointerException erro) {
            mensagens.mensagens("Erro !!!", "erro");

        }
    }

    public void exibirRelatorio(String nome, Date data, Double valor) throws SQLException, JRException {

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PBD", "postgres", "123");
            InputStream fonte = ControleRelatorios.class.getResourceAsStream("/br/com/pbd/RelatoriosView/Recibo.jasper");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("aluno", nome);
            map.put("data", data);
            map.put("valor", valor);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fonte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
            JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
            jrviewer.setVisible(true);
            jrviewer.toFront();

        } catch (SQLException | JRException e) {

        }

    }

    public void preencherVazio(JTable tabela) {

        String[] colunas = new String[]{"Descricao", "Serie", "Repeticao", "Intervalo", "Peso (Kg)", "Objetivo", "Nivel", "Excluir"};
        Object[][] dados = new Object[0][8];
        DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela.setModel(dataModel);
    }
}
