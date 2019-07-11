/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoAcompanhamento;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.Acompanhamento;
import br.com.pbd.modelos.Aluno;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessAcompanhamento implements IBusinessAcompanhamento {

    @Override
    public void salvar(Acompanhamento acompanhamento) {
        new DaoGenerico<Acompanhamento>().salvar_ou_atualizar(acompanhamento);
    }

    @Override
    public void ativarDesativar(Acompanhamento acompanhamento) {
        new DaoGenerico<Acompanhamento>().salvar_ou_atualizar(acompanhamento);
    }

    @Override
    public List<Acompanhamento> getAll() {
        return new DaoGenerico<Acompanhamento>().getAll(Acompanhamento.class);
    }

    @Override
    public List<Acompanhamento> usandoID(Aluno aluno) {
    return new DaoAcompanhamento().usandoID(aluno);
    }

}
