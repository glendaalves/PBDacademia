/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Fachada;

import br.com.pbd.Business.BusinessAcademia;
import br.com.pbd.Business.BusinessAcompanhamento;
import br.com.pbd.Business.BusinessAdministrador;
import br.com.pbd.Business.BusinessAgenda;
import br.com.pbd.Business.BusinessAluno;
import br.com.pbd.Business.BusinessCaixa;
import br.com.pbd.Business.BusinessDespesas;
import br.com.pbd.Business.BusinessEstoque;
import br.com.pbd.Business.BusinessExercicio;
import br.com.pbd.Business.BusinessFornecedor;
import br.com.pbd.Business.BusinessFuncionario;
import br.com.pbd.Business.BusinessLogin;
import br.com.pbd.Business.BusinessMensalidade;
import br.com.pbd.Business.BusinessProduto;
import br.com.pbd.Business.BusinessProfessor;
import br.com.pbd.Business.BusinessTarefa;
import br.com.pbd.Business.BusinessVenda;
import br.com.pbd.Business.IBusinessAcademia;
import br.com.pbd.Business.IBusinessAcompanhamento;
import br.com.pbd.Business.IBusinessAdministrador;
import br.com.pbd.Business.IBusinessAgenda;
import br.com.pbd.Business.IBusinessAluno;
import br.com.pbd.Business.IBusinessCaixa;
import br.com.pbd.Business.IBusinessDespesas;
import br.com.pbd.Business.IBusinessEstoque;
import br.com.pbd.Business.IBusinessExercicio;
import br.com.pbd.Business.IBusinessFornecedor;
import br.com.pbd.Business.IBusinessFuncionario;
import br.com.pbd.Business.IBusinessLogin;
import br.com.pbd.Business.IBusinessMensalidade;
import br.com.pbd.Business.IBusinessProduto;
import br.com.pbd.Business.IBusinessProfessor;
import br.com.pbd.Business.IBusinessTarefa;
import br.com.pbd.Business.IBusinessVenda;
import br.com.pbd.modelos.Academia;
import br.com.pbd.modelos.Acompanhamento;
import br.com.pbd.modelos.Administrador;
import br.com.pbd.modelos.Agenda;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Caixa;
import br.com.pbd.modelos.ContaaPagar;
import br.com.pbd.modelos.Estoque;
import br.com.pbd.modelos.Exercicio;
import br.com.pbd.modelos.Fornecedor;
import br.com.pbd.modelos.Funcionario;
import br.com.pbd.modelos.Login;
import br.com.pbd.modelos.Mensalidade;
import br.com.pbd.modelos.Produto;
import br.com.pbd.modelos.Professor;
import br.com.pbd.modelos.Tarefa;
import br.com.pbd.modelos.Venda;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class Fachada implements IFachada {

    private static Fachada instance;
    private IBusinessAluno iBusinessAluno;
    private IBusinessAcademia iBusinessAcademia;
    private IBusinessAgenda iBusinessAgenda;
    private IBusinessExercicio iBusinessExercicio;
    private IBusinessAcompanhamento iBusinessAcompanhamento;
    private IBusinessMensalidade iBusinessMensalidade;
    private IBusinessFornecedor iBusinessFornecedor;
    private IBusinessFuncionario iBusinessFuncionario;
    private IBusinessAdministrador iBusinessAdministrador;
    private IBusinessLogin iBusinessLogin;
    private IBusinessProduto iBusinessProduto;
    private IBusinessEstoque iBusinessEstoque;
    private IBusinessProfessor iBusinessProfessor;
    private IBusinessTarefa iBusinessTarefa;
    private IBusinessCaixa iBusinessCaixa;
    private IBusinessVenda iBusinessVenda;
    private IBusinessDespesas iBusinessDespesas;

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    private Fachada() {
        this.iBusinessAluno = new BusinessAluno();
        this.iBusinessAcademia = new BusinessAcademia();
        this.iBusinessAgenda = new BusinessAgenda();
        this.iBusinessExercicio = new BusinessExercicio();
        this.iBusinessAcompanhamento = new BusinessAcompanhamento();
        this.iBusinessMensalidade = new BusinessMensalidade();
        this.iBusinessFornecedor = new BusinessFornecedor();
        this.iBusinessFuncionario = new BusinessFuncionario();
        this.iBusinessAdministrador = new BusinessAdministrador();
        this.iBusinessProduto = new BusinessProduto();
        this.iBusinessEstoque = new BusinessEstoque();
        this.iBusinessProfessor = new BusinessProfessor();
        this.iBusinessTarefa = new BusinessTarefa();
        this.iBusinessCaixa = new BusinessCaixa();
        this.iBusinessVenda = new BusinessVenda();
        this.iBusinessLogin = new BusinessLogin();
        this.iBusinessDespesas = new BusinessDespesas();

    }

    @Override
    public void salvar(Aluno aluno) {
        this.iBusinessAluno.salvar(aluno);

    }

    @Override
    public List<Aluno> getAll() {
        return this.iBusinessAluno.getAll();
    }

    @Override
    public void ativarDesativar(Aluno aluno) {
        this.iBusinessAluno.salvar(aluno);
    }

    @Override
    public List<Aluno> busca(String nome) {
        return this.iBusinessAluno.busca(nome);
    }

    @Override
    public void salvar(Academia academia) {
        this.iBusinessAcademia.salvar(academia);
    }

    @Override
    public Academia buscaUltimoRegistro() {
        return this.iBusinessAcademia.buscaUltimoRegistro();
    }

    @Override
    public void salvar(Agenda agenda) {
        this.iBusinessAgenda.salvar(agenda);
    }

    @Override
    public List<Agenda> usandoID(Aluno aluno) {
        return this.iBusinessAgenda.usandoID(aluno);
    }

    @Override
    public List<Agenda> usandoID(Professor professor, String dia) {
        return this.iBusinessAgenda.usandoID(professor, dia);
    }

    @Override
    public void ativarDesativar(Agenda agenda) {
        this.iBusinessAgenda.salvar(agenda);
    }

    @Override
    public List<Agenda> getAllA() {
        return this.iBusinessAgenda.getAll();
    }

    @Override
    public List<Agenda> usandoID(Professor professor) {
        return this.iBusinessAgenda.usandoID(professor);
    }

    @Override
    public void salvar(Exercicio exercicio) {
        this.iBusinessExercicio.salvar(exercicio);
    }

    @Override
    public List<Exercicio> getAllE() {
        return this.iBusinessExercicio.getAll();
    }

    @Override
    public void ativarDesativar(Exercicio exercicio) {
        this.iBusinessExercicio.salvar(exercicio);
    }

    @Override
    public List<Exercicio> Busca(String nome) {
        return this.iBusinessExercicio.Busca(nome);
    }

    @Override
    public List<Exercicio> usandoAluno(Aluno aluno) {
        return this.iBusinessExercicio.usandoAluno(aluno);
    }

    @Override
    public void salvar(Acompanhamento acompanhamento) {
        this.iBusinessAcompanhamento.salvar(acompanhamento);
    }

    @Override
    public void ativarDesativar(Acompanhamento acompanhamento) {
        this.iBusinessAcompanhamento.salvar(acompanhamento);
    }

    @Override
    public List<Acompanhamento> getAllAc() {
        return this.iBusinessAcompanhamento.getAll();
    }

    @Override
    public List<Acompanhamento> usandoIDA(Aluno aluno) {
        return this.iBusinessAcompanhamento.usandoID(aluno);
    }

    @Override
    public void salvar(Mensalidade mensalidade) {
        this.iBusinessMensalidade.salvar(mensalidade);
    }

    @Override
    public List<Mensalidade> getAllM() {
        return this.iBusinessMensalidade.getAll();
    }

    @Override
    public List<Mensalidade> BuscaMensalidades(Aluno aluno, String status) {
        return this.iBusinessMensalidade.BuscaMensalidades(aluno, status);
    }

    @Override
    public List<Mensalidade> usandoIDM(Aluno aluno) {
        return this.iBusinessMensalidade.usandoID(aluno);
    }

    @Override
    public List<Exercicio> usandoIDE(Aluno aluno) {
        return this.iBusinessExercicio.usandoID(aluno);
    }

    @Override
    public void salvar(Fornecedor fornecedor) {
        this.iBusinessFornecedor.salvar(fornecedor);
    }

    @Override
    public List<Fornecedor> getAllFor() {
        return this.iBusinessFornecedor.getAll();
    }

    @Override
    public void ativarDesativar(Fornecedor fornecedor) {
        this.iBusinessFornecedor.salvar(fornecedor);
    }

    @Override
    public List<Fornecedor> BuscaFor(String nome) {
        return this.iBusinessFornecedor.Busca(nome);
    }

    @Override
    public void salvar(Funcionario funcionario) {
        this.iBusinessFuncionario.salvar(funcionario);
    }

    @Override
    public List<Funcionario> getAllFun() {
        return this.iBusinessFuncionario.getAllFor();
    }

    @Override
    public void ativarDesativar(Funcionario funcionario) {
        this.iBusinessFuncionario.salvar(funcionario);
    }

    @Override
    public List<Funcionario> BuscaFun(String nome) {
        return this.iBusinessFuncionario.BuscaFor(nome);
    }

    @Override
    public Administrador buscaUltimoRegistroA() {
        return this.iBusinessAdministrador.buscaUltimoRegistro();
    }

    @Override
    public void salvar(Administrador administrador) {
        this.iBusinessAdministrador.salvar(administrador);
    }

    @Override
    public void salvar(Produto produto) {
        this.iBusinessProduto.salvar(produto);
    }

    @Override
    public List<Produto> getAllP() {
        return this.iBusinessProduto.getAll();
    }

    @Override
    public void ativarDesativar(Produto produto) {
        this.iBusinessProduto.salvar(produto);
    }

    @Override
    public List<Produto> Buscapro(String nome) {
        return this.iBusinessProduto.Busca(nome);
    }

    @Override
    public List<Produto> BuscaP(String nome) {
        return this.iBusinessProduto.BuscaP(nome);
    }

    @Override
    public List<Produto> BuscarQuantidade() {
        return this.iBusinessProduto.BuscarQuantidade();
    }

    @Override
    public void salvar(Estoque estoque) {
        this.iBusinessEstoque.salvar(estoque);
    }

    @Override
    public List<Estoque> getAllEs() {
        return this.iBusinessEstoque.getAll();
    }

    @Override
    public void salvar(Professor professor) {
        this.iBusinessProfessor.salvar(professor);
    }

    @Override
    public List<Professor> getAllPro() {
        return this.iBusinessProfessor.getAll();
    }

    @Override
    public void ativarDesativar(Professor professor) {
        this.iBusinessProfessor.salvar(professor);
    }

    @Override
    public List<Professor> buscaP(String nome) {
        return this.iBusinessProfessor.busca(nome);
    }

    @Override
    public void salvar(Tarefa tarefa) {
        this.iBusinessTarefa.salvar(tarefa);
    }

    @Override
    public List<Tarefa> getAllT() {
        return this.iBusinessTarefa.getAll();
    }

    @Override
    public void ativarDesativar(Tarefa tarefa) {
        this.iBusinessTarefa.salvar(tarefa);
    }

    @Override
    public List<Tarefa> buscaT(String nome) {
        return this.iBusinessTarefa.busca(nome);
    }

    @Override
    public Caixa BuscarCaixa(Date date) {
        return this.iBusinessCaixa.BuscarCaixa(date);
    }

    @Override
    public Caixa buscaUltimoRegistroC() {
        return this.iBusinessCaixa.buscaUltimoRegistro();
    }

    @Override
    public void salvar(Caixa caixa) {
        this.iBusinessCaixa.salvar(caixa);
    }

    @Override
    public void salvar(Venda venda) {
        this.iBusinessVenda.salvar(venda);
    }

    @Override
    public Funcionario BuscarLoginFuncionario(Login obj) {
        return this.iBusinessLogin.BuscarLoginFuncionario(obj);
    }

    @Override
    public Professor BuscarLoginProfessor(Login obj) {
        return this.iBusinessLogin.BuscarLoginProfessor(obj);
    }

    @Override
    public Administrador BuscarLoginAdministrador(Login obj) {
        return this.iBusinessLogin.BuscarLoginAdministrador(obj);
    }

    @Override
    public void salvar(ContaaPagar contaaPagar) {
        this.iBusinessDespesas.salvar(contaaPagar);
    }

    @Override
    public List<ContaaPagar> getAllC() {
        return this.iBusinessDespesas.getAll();
    }

    @Override
    public void ativarDesativar(ContaaPagar contaaPagar) {
        this.iBusinessDespesas.salvar(contaaPagar);
    }

    @Override
    public List<ContaaPagar> buscaC(String nome) {
        return this.iBusinessDespesas.busca(nome);
    }
}
