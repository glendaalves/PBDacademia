/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoFornecedor;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.Fornecedor;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessFornecedor implements IBusinessFornecedor {

    @Override
    public void salvar(Fornecedor fornecedor) {
        new DaoGenerico<Fornecedor>().salvar_ou_atualizar(fornecedor);
    }

    @Override
    public List<Fornecedor> getAll() {
        return new DaoGenerico<Fornecedor>().getAll(Fornecedor.class);
    }

    @Override
    public void ativarDesativar(Fornecedor fornecedor) {
        new DaoGenerico<Fornecedor>().salvar_ou_atualizar(fornecedor);
    }

    @Override
    public List<Fornecedor> Busca(String nome) {
        return new DaoFornecedor().Busca(nome);
    }

}
