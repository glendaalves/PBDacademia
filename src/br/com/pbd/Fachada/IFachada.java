/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Fachada;

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
public interface IFachada {
    
    public void salvar(Aluno aluno);
    public List<Aluno> getAll();
    public void ativarDesativar(Aluno aluno);
    public List<Aluno> busca(String nome);
    
    public void salvar(Academia academia);
    public Academia  buscaUltimoRegistro();
    public void ativarDesativar(Agenda agenda);
    
    public void salvar(Agenda agenda);
    public List<Agenda> usandoID(Aluno aluno);
    public List<Agenda> usandoID(Professor professor, String dia); 
    public List<Agenda> getAllA();
    public List<Agenda> usandoID(Professor professor);
    
    public void salvar(Exercicio exercicio);
    public List<Exercicio> getAllE();
    public void ativarDesativar(Exercicio exercicio);
    public List<Exercicio> Busca(String nome);
    public List<Exercicio> usandoIDE(Aluno aluno);
    public List<Exercicio> BuscaImc(String nome);
    
    public void salvar(Acompanhamento acompanhamento);
    public void ativarDesativar(Acompanhamento acompanhamento);
    public List<Acompanhamento> getAllAc();
    public List<Acompanhamento> usandoIDA(Aluno aluno);
    
    public void salvar(Mensalidade mensalidade);
    public List<Mensalidade> getAllM();
    public List<Mensalidade> BuscaMensalidades(Aluno aluno, String status);
    public List<Mensalidade> usandoIDM(Aluno aluno);
    
    public void salvar(Fornecedor fornecedor);
    public List<Fornecedor> getAllFor();
    public boolean ativarDesativar(Fornecedor fornecedor);
    public List<Fornecedor> BuscaFor(String nome);
    
    public void salvar(Funcionario funcionario);
    public List<Funcionario> getAllFun();
    public void ativarDesativar(Funcionario funcionario);
    public List<Funcionario> BuscaFun(String nome);
    
      
    public Administrador buscaUltimoRegistroA();
    public void salvar(Administrador administrador);
    
    public Funcionario BuscarLoginFuncionario(Login obj);
    public Professor BuscarLoginProfessor(Login obj);
    public Administrador BuscarLoginAdministrador(Login obj);
    
    public void salvar(Produto produto);
    public List<Produto> getAllP();
    public boolean ativarDesativar(Produto produto);
    public List<Produto> Buscapro(String nome);
    public List<Produto> BuscaP(String nome) ;
    public List<Produto> BuscarQuantidade() ;
    
    public void salvar(Estoque estoque);
    public List<Estoque> getAllEs();
    
    public void salvar(Professor professor);
    public List<Professor> getAllPro();
    public boolean ativarDesativar(Professor professor);
    public List<Professor> buscaP(String nome); 
    
    public void salvar(Tarefa tarefa);
    public List<Tarefa> getAllT();
    public void ativarDesativar(Tarefa tarefa);
    public List<Tarefa> buscaT(String nome);
    
    public Caixa BuscarCaixa(Date date);
    public Caixa buscaUltimoRegistroC();
    public void salvar(Caixa caixa);
    
     public void salvar(Venda venda);
     
    public void salvar(ContaaPagar contaaPagar);
    public List<ContaaPagar> getAllC();
    public void ativarDesativar(ContaaPagar contaaPagar);
    public List<ContaaPagar> buscaC(String nome);
}
