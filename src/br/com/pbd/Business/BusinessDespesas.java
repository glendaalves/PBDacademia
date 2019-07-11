/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoDespesas;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.ContaaPagar;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessDespesas implements IBusinessDespesas {

    @Override
    public void salvar(ContaaPagar contaaPagar) {
        new DaoGenerico<ContaaPagar>().salvar_ou_atualizar(contaaPagar);
    }

    @Override
    public List<ContaaPagar> getAll() {
        return (new DaoGenerico<ContaaPagar>().getAll(ContaaPagar.class));
    }

    @Override
    public void ativarDesativar(ContaaPagar contaaPagar) {
        new DaoGenerico<ContaaPagar>().salvar_ou_atualizar(contaaPagar);
    }

    @Override
    public List<ContaaPagar> busca(String nome) {
        return (new DaoDespesas().Busca(nome));
    }

}
