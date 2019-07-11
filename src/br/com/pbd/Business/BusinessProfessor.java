/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.Daos.DaoProfessor;
import br.com.pbd.modelos.Produto;
import br.com.pbd.modelos.Professor;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessProfessor implements IBusinessProfessor {

    @Override
    public void salvar(Professor professor) {
        new DaoGenerico<Professor>().salvar_ou_atualizar(professor);
    }

    @Override
    public List<Professor> getAll() {
        return new DaoGenerico<Professor>().getAll(Professor.class);
    }

    @Override
    public void ativarDesativar(Professor professor) {
        new DaoGenerico<Professor>().salvar_ou_atualizar(professor);
    }

    @Override
    public List<Professor> busca(String nome) {
        return new DaoProfessor().Busca(nome);
    }

}
