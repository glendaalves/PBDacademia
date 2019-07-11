/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoExercicio;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Exercicio;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessExercicio implements IBusinessExercicio {

    @Override
    public void salvar(Exercicio exercicio) {
        new DaoGenerico<Exercicio>().salvar_ou_atualizar(exercicio);
    }

    @Override
    public List<Exercicio> getAll() {
        return new DaoGenerico<Exercicio>().getAll(Exercicio.class);
    }

    @Override
    public void ativarDesativar(Exercicio exercicio) {
        new DaoGenerico<Exercicio>().salvar_ou_atualizar(exercicio);
    }

    @Override
    public List<Exercicio> Busca(String nome) {
        return new DaoExercicio().Busca(nome);
    }

    @Override
    public List<Exercicio> usandoAluno(Aluno aluno) {
        return new DaoExercicio().usandoAluno(aluno);
    }

    @Override
    public List<Exercicio> usandoID(Aluno aluno) {
        return new DaoExercicio().usandoID(aluno);
    }

}
