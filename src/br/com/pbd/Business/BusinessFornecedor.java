/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoFornecedor;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.Daos.DaoProduto;
import br.com.pbd.modelos.Fornecedor;
import br.com.pbd.modelos.Produto;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessFornecedor extends DaoGenerico<Fornecedor> implements IBusinessFornecedor {

    @Override
    public void salvar(Fornecedor fornecedor) {
        salvar_ou_atualizar(fornecedor);
    }

    @Override
    public List<Fornecedor> getAll() {
        return getAll(Fornecedor.class);
    }

    @Override
    public boolean ativarDesativar(Fornecedor fornecedor) {
        List<Produto> produtos = new DaoProduto().BuscaProdutoFornecedor(fornecedor);

        if (produtos.isEmpty()) {

            remover(Fornecedor.class, fornecedor.getId());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Fornecedor> Busca(String nome) {
        return new DaoFornecedor().Busca(nome);
    }

}
