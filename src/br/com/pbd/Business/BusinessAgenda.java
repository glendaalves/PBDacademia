/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoAgenda;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.Agenda;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Professor;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessAgenda implements IBusinessAgenda {

    @Override
    public void salvar(Agenda agenda) {
        new DaoGenerico<Agenda>().salvar_ou_atualizar(agenda);
    }

    @Override
    public List<Agenda> usandoID(Aluno aluno) {
        return new DaoAgenda().usandoID(aluno);
    }

    @Override
    public List<Agenda> usandoID(Professor professor, String dia) {
        return new DaoAgenda().usandoAgenda(professor, dia);
    }

    @Override
    public void ativarDesativar(Agenda agenda) {
        new DaoGenerico<Agenda>().salvar_ou_atualizar(agenda);
    }

    @Override
    public List<Agenda> getAll() {
        return(new DaoGenerico<Agenda>().getAll(Agenda.class));
    }

    @Override
    public List<Agenda> usandoID(Professor professor) {
   return new DaoAgenda().usandoID(professor);
    }

}
