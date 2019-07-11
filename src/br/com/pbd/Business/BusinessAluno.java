/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoAluno;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.Aluno;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessAluno implements IBusinessAluno {

    @Override
    public void salvar(Aluno aluno) {
        new DaoGenerico<Aluno>().salvar_ou_atualizar(aluno);
    }

    @Override
    public List<Aluno> getAll() {
        return (new DaoGenerico<Aluno>().getAll(Aluno.class));
    }

    @Override
    public void ativarDesativar(Aluno aluno) {
        new DaoGenerico<Aluno>().salvar_ou_atualizar(aluno);
    }

    @Override
    public List<Aluno> busca(String nome) {
      return (new DaoAluno().Busca(nome));
   }

}
