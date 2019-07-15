/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoDespesas;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.ContaaPagar;
import br.com.pbd.view.Despesas;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessDespesas extends DaoGenerico<ContaaPagar> implements IBusinessDespesas {

    @Override
    public void salvar(ContaaPagar contaaPagar) {
        salvar_ou_atualizar(contaaPagar);
    }

    @Override
    public List<ContaaPagar> getAll() {
        return getAll(ContaaPagar.class);
    }

    @Override
    public void ativarDesativar(ContaaPagar contaaPagar) {
        remover(ContaaPagar.class, contaaPagar.getId());

    }

    @Override
    public List<ContaaPagar> busca(String nome) {
        return (new DaoDespesas().Busca(nome));
    }

}
