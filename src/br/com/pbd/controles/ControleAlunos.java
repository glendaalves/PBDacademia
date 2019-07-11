package br.com.pbd.controles;

import br.com.pbd.Daos.DaoMensalidade;
import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Acompanhamento;
import br.com.pbd.modelos.Agenda;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Dados;
import br.com.pbd.modelos.Exercicio;
import br.com.pbd.modelos.Mensalidade;
import br.com.pbd.modelos.Render;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class ControleAlunos extends MouseAdapter implements ActionListener {

    private Fachada fachada;
    private Principal principal;
    private List<Aluno> alunos;
    private Aluno a;
    private List<Acompanhamento> acompanhamentos;
    private Acompanhamento acom;
    private Mensalidade m;
    private List<Mensalidade> mensalidades;
    private List<Agenda> agendas;
    private Agenda agenda;
    private List<Exercicio> exercicios, Edicaoexercicio, AllExercicio;
    private Calendar ca = new GregorianCalendar();
    private java.util.Date data2 = new java.util.Date();
    private java.sql.Date dataN;
    private int escolha;
    private final int salvar = 0, editar = 1, excluir = 2, mensalidade = 3, agende = 4, acompanhamento = 5, pagar = 6, selecionar = 7;
    private ControleLogin controleLogin;
    private Mensagens mensagens;

    public ControleAlunos(Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;

        principal.getCadastroAlunos().getBotaoSalvar().addActionListener(this);
        principal.getBotaoAluno().addActionListener(this);
        principal.getListaAcompanhamento().getBotaoatualizar().addActionListener(this);
        principal.getCadastroAlunos().getBotaoCancelar().addActionListener(this);
        principal.getListaAcompanhamento().getBotaoAdicionar().addActionListener(this);
        principal.getMensalidade().getBotaosalvar().addActionListener(this);
        principal.getListaExercicio().getBotaocomfirmar().addActionListener(this);
        principal.getListaExercicio().getBotaoFechar().addActionListener(this);
        principal.getAgendaAluno().getCombodia().addActionListener(this);
        principal.getAgendaAluno().getBotaoadicionar().addActionListener(this);
        principal.getAcompanhamento().getBotaoSalvar().addActionListener(this);
        principal.getExercicio().getCombotreino().addActionListener(this);
        principal.getBuscarAlunos().getTabelaAlunos().addMouseListener(this);
        principal.getListaAcompanhamento().getTabelaAcompanhamento().addMouseListener(this);
        principal.getListaExercicio().getTabelaexercicio().addMouseListener(this);
        principal.getListaExercicio().getTabelaadicionados().addMouseListener(this);
        principal.getListaMensalidades().getTabelamensalidade().addMouseListener(this);
        principal.getBuscarAlunos().getBotaoAdicionar().addActionListener(this);
        principal.getAgendaAluno().getBotaoFechar().addActionListener(this);
        principal.getMensalidade().getBotaoFechar().addActionListener(this);
        principal.getBuscarAlunos().getBotaoFechar().addActionListener(this);
        principal.getListaMensalidades().getBotaoFechar().addActionListener(this);
        principal.getListaAcompanhamento().getBotaoFechar().addActionListener(this);

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

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == principal.getListaMensalidades().getTabelamensalidade()) {
            int ro = retornaIndice(principal.getListaMensalidades().getTabelamensalidade(), e);
            if (escolha == pagar) {
                try {
                    Date d = new Date(System.currentTimeMillis());
                    mensalidades.get(ro).setPagamento(d);
                    mensalidades.get(ro).setStatus("Pago");
                    a.setMensalidades(mensalidades);
                    fachada.salvar(a);
                    preencherTabelaMensalidade();
                    mensagens.mensagens("Pago com Sucesso", "info");
                } catch (java.lang.IllegalStateException n) {
                    mensagens.mensagens("Voce precisa preencher todos os campos !", "advertencia");
                } catch (javax.persistence.RollbackException roll) {
                    mensagens.mensagens("Erro !!!", "erro");
                }
            }

        }
        if (e.getSource() == principal.getListaExercicio().getTabelaadicionados()) {
            int ro = retornaIndice(principal.getListaExercicio().getTabelaadicionados(), e);
            if (escolha == excluir) {
                Exercicio u = Edicaoexercicio.get(ro);
                exercicios.add(u);
                Edicaoexercicio.remove(u);
                preencherTabelaExercicios(exercicios);
                preencherTabelaExercicioAdicionado();

            }

        }

        if (e.getSource() == principal.getListaExercicio().getTabelaexercicio()) {
            int ro = retornaIndice(principal.getListaExercicio().getTabelaexercicio(), e);
            if (escolha == selecionar) {
                Exercicio u = exercicios.get(ro);
                removerExercicio(u);
                preencherTabelaExercicios(exercicios);
                Edicaoexercicio.add(u);
                preencherTabelaExercicioAdicionado();

            }
        }

        if (e.getSource() == principal.getListaAcompanhamento().getTabelaAcompanhamento()) {
            int ro = retornaIndice(principal.getListaAcompanhamento().getTabelaAcompanhamento(), e);
            if (escolha == editar) {
                principal.getListaAcompanhamento().getPanelEdicao().setVisible(true);
                acom = acompanhamentos.get(ro);
                principal.getListaAcompanhamento().preencherAconpanhamento(acom);

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
                principal.getListaAcompanhamento().getPanelEdicao().setVisible(false);
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

        if (e.getSource() == principal.getListaExercicio().getBotaocomfirmar()) {
            agenda.setExercicios(Edicaoexercicio);
            fachada.salvar(agenda);
            principal.getListaExercicio().setVisible(false);
            preencherTabelaExercicio();

        }
        if (e.getSource() == principal.getBuscarAlunos().getBotaoFechar()) {

            principal.getBuscarAlunos().getTxtpesquisa().setText("");

            if (controleLogin.getProfessor() != null) {
                principal.AtivarP();
              
            }else
                principal.Ativar();
   
        }

        if (e.getSource() == principal.getAgendaAluno().getBotaoadicionar()) {

            if (!agendas.isEmpty()) {

                int indice = principal.getAgendaAluno().getCombodia().getSelectedIndex();

                agenda = agendas.get(indice);
                if (agenda.getProfessor() != null) {
                    principal.getListaExercicio().setVisible(true);
                    AllExercicio = fachada.getAllE();
                    Edicaoexercicio = agenda.getExercicios();
                    preencherTabelaExercicios(separarExercicio());
                    preencherTabelaExercicioAdicionado();
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
        if (e.getSource() == principal.getListaAcompanhamento().getBotaoatualizar()) {
            EditarAcompanahemento(acom);

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
            Double peit = 0.0, ombr = 0.0, cintur = 0.0, quadri = 0.0, cox = 0.0, panturrilh = 0.0, brac = 0.0, antebrac = 0.0;

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

            acompanhamento.setPeito(peit);
            acompanhamento.setOmbro(ombr);
            acompanhamento.setCintura(cintur);
            acompanhamento.setQuadril(quadri);
            acompanhamento.setCoxa(cox);
            acompanhamento.setPanturrilha(panturrilh);
            acompanhamento.setBraco(brac);
            acompanhamento.setAntebraco(antebrac);

            fachada.salvar(acompanhamento);
            mensagens.mensagens("Cadastrado com Sucesso", "info");
            principal.getAcompanhamento().setVisible(false);
            preencherTabelaAcompanhamento();
            principal.getAcompanhamento().limpar();
            exercicios = fachada.usandoAluno(a);
            preencherTabelaExercicioSugeridos(exercicios);
            principal.getExerciciosTreino().setVisible(true);

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
                String[] colunas = new String[]{"Data", "Peito", "Ombro", "Cintura", "Quadril", "Coxa", "Panturrilha", "Braco", "AnteBraco", "Editar"};
                Object[][] dados = new Object[acompanhamentos.size()][10];
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
                    dados[i][9] = principal.getListaAcompanhamento().getBtnEd();

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

    public void EditarAcompanahemento(Acompanhamento acom) {

        try {
            String peito = principal.getListaAcompanhamento().getTxtpeito().getText();
            String ombro = principal.getListaAcompanhamento().getTxtombro().getText();
            String cintura = principal.getListaAcompanhamento().getTxtcintura().getText();
            String quadril = principal.getListaAcompanhamento().getTxtquadril().getText();
            String coxa = principal.getListaAcompanhamento().getTxtcoxa().getText();
            String panturrilha = principal.getListaAcompanhamento().getTxtpanturrilha().getText();
            String braco = principal.getListaAcompanhamento().getTxtbraco().getText();
            String antebraco = principal.getListaAcompanhamento().getTxtantebraco().getText();
            Double peit = 0.0, ombr = 0.0, cintur = 0.0, quadri = 0.0, cox = 0.0, panturrilh = 0.0, brac = 0.0, antebrac = 0.0;

            peit = Double.parseDouble(peito);
            ombr = Double.parseDouble(ombro);
            cintur = Double.parseDouble(cintura);
            quadri = Double.parseDouble(quadril);
            cox = Double.parseDouble(coxa);
            panturrilh = Double.parseDouble(panturrilha);
            brac = Double.parseDouble(braco);
            antebrac = Double.parseDouble(antebraco);

            acom.setPeito(peit);
            acom.setOmbro(ombr);
            acom.setCintura(cintur);
            acom.setQuadril(quadri);
            acom.setCoxa(cox);
            acom.setPanturrilha(panturrilh);
            acom.setBraco(brac);
            acom.setAntebraco(antebrac);
            Date d = new Date(System.currentTimeMillis());
            acom.setData(d);
            fachada.salvar(acom);
            mensagens.mensagens("Editado com Sucesso", "info");
            principal.getListaAcompanhamento().getPanelEdicao().setVisible(false);
            preencherTabelaAcompanhamento();
            principal.getAcompanhamento().limpar();

        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("Voce precisa preencher todos os campos ", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Erro!!! Valores Invalidos", "erro");
        }

    }

    public void preencherTabelaMensalidade() {

        mensalidades = fachada.usandoIDM(a);

        principal.getListaMensalidades().getTabelamensalidade().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Numero", "Valor", "Data Vencimento", "Forma Pagamento", "Tipo", "Plano", "Data Pagamento", "Status", "Pagar"};
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
                dados[i][7] = m.getStatus();
                dados[i][8] = principal.getListaMensalidades().getBtnPag();

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
        agendas = fachada.usandoID(a);
        principal.getAgendaAluno().getCombodia().removeAllItems();
        for (Agenda p : agendas) {

            principal.getAgendaAluno().getCombodia().addItem(p.getDia_semana());

        }

    }

    public void preencherTabelaExercicio() {

        int indice = principal.getAgendaAluno().getCombodia().getSelectedIndex();
        if (!agendas.isEmpty() && indice > -1) {
            agenda = agendas.get(indice);
            principal.getAgendaAluno().getLabeldia_semana().setText(agenda.getDia_semana());
            exercicios = agenda.getExercicios();
            principal.getAgendaAluno().getTabelaAgenda().setDefaultRenderer(Object.class, new Render());

            int i = 0;
            try {
                String[] colunas = new String[]{"Descricao", "Peso (Kg)", "Serie", "Repetiçao", "Intervalo", "Objetivo", "Nivel"};
                Object[][] dados = new Object[exercicios.size()][7];
                for (Exercicio m : exercicios) {
                    dados[i][0] = m.getDescricao();
                    dados[i][1] = m.getPeso();
                    dados[i][2] = m.getSerie();
                    dados[i][3] = m.getRepeticao();
                    dados[i][4] = m.getIntervalo();
                    dados[i][5] = m.getTreino();
                    dados[i][6] = m.getNivel();
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

    public void preencherTabelaExercicioAdicionado() {

        principal.getListaExercicio().getTabelaadicionados().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Descricao", "Serie", "Repeticao", "Intervalo", "Peso (Kg)", "Objetivo", "Nivel", "Excluir"};
            Object[][] dados = new Object[Edicaoexercicio.size()][8];
            for (int i = 0; i < Edicaoexercicio.size(); i++) {

                Exercicio e = Edicaoexercicio.get(i);
                dados[i][0] = e.getDescricao();
                dados[i][1] = e.getSerie();
                dados[i][2] = e.getRepeticao();
                dados[i][3] = e.getIntervalo();
                dados[i][4] = e.getPeso();
                dados[i][5] = e.getTreino();
                dados[i][6] = e.getNivel();
                dados[i][7] = principal.getListaExercicio().getBtnEx();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = principal.getListaExercicio().getTabelaadicionados().getColumnModel();
            principal.getListaExercicio().getTabelaadicionados().setModel(dataModel);

        } catch (Exception ex) {

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

    public void preencherTabelaExercicioSugeridos(List<Exercicio> ex) {

        principal.getExerciciosTreino().getTabelaexercicio().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Descricao", "Serie", "Repeticao", "Intervalo", "Peso (Kg)"};
            Object[][] dados = new Object[ex.size()][5];
            for (int i = 0; i < ex.size(); i++) {

                Exercicio e = ex.get(i);
                dados[i][0] = e.getDescricao();
                dados[i][1] = e.getSerie();
                dados[i][2] = e.getRepeticao();
                dados[i][3] = e.getIntervalo();
                dados[i][4] = e.getPeso();

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

}
