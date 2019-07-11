/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.Daos.DaoTarefa;
import br.com.pbd.modelos.Tarefa;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessTarefa implements IBusinessTarefa {

    @Override
    public void salvar(Tarefa tarefa) {
        new DaoGenerico<Tarefa>().salvar_ou_atualizar(tarefa);
    }

    @Override
    public List<Tarefa> getAll() {
        return new DaoGenerico<Tarefa>().getAll(Tarefa.class);
    }

    @Override
    public void ativarDesativar(Tarefa tarefa) {
        new DaoGenerico<Tarefa>().salvar_ou_atualizar(tarefa);
    }

    @Override
    public List<Tarefa> busca(String nome) {
        return new DaoTarefa().Busca(nome);
    }

}
