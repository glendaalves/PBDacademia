/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoAgenda;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.Daos.DaoProfessor;
import br.com.pbd.modelos.Agenda;
import br.com.pbd.modelos.Produto;
import br.com.pbd.modelos.Professor;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessProfessor extends DaoGenerico<Professor>implements IBusinessProfessor {

    @Override
    public void salvar(Professor professor) {
       salvar_ou_atualizar(professor);
    }

    @Override
    public List<Professor> getAll() {
        return getAll(Professor.class);
    }

    @Override
    public boolean ativarDesativar(Professor professor) {
      List<Agenda> agendas = new DaoAgenda().usandoID(professor);
        
        if (agendas.isEmpty()) {
            
            remover( Professor.class, professor.getId());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Professor> busca(String nome) {
        return new DaoProfessor().Busca(nome);
    }

}
