/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Exercicio;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessExercicio {
    
    public void salvar(Exercicio exercicio);
    public List<Exercicio> getAll();
    public void ativarDesativar(Exercicio exercicio);
    public List<Exercicio> Busca(String nome);
    public List<Exercicio> usandoAluno(Aluno aluno);
    public List<Exercicio> usandoID(Aluno aluno) ;
    public List<Exercicio> BuscaImc(String nome);

}
