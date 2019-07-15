/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.Daos.DaoItemVenda;
import br.com.pbd.Daos.DaoProduto;
import br.com.pbd.modelos.EntidadeBase;
import br.com.pbd.modelos.ItemVenda;
import br.com.pbd.modelos.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessProduto extends DaoGenerico<Produto> implements IBusinessProduto {

    @Override
    public void salvar(Produto produto) {
        salvar_ou_atualizar(produto);
    }

    @Override
    public List<Produto> getAll() {
        return getAll(Produto.class);
    }

    @Override
    public boolean ativarDesativar(Produto produto) {

        List<ItemVenda> itemVendas = new DaoItemVenda().BuscaItemvenda(produto);
        
        if (itemVendas.isEmpty()) {
            
            remover(Produto.class, produto.getId());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Produto> Busca(String nome) {
        return new DaoProduto().Busca(nome);
    }

    @Override
    public List<Produto> BuscaP(String nome) {
        return new DaoProduto().BuscaP(nome);
    }

    @Override
    public List<Produto> BuscarQuantidade() {
        return new DaoProduto().BuscarQuantidade();
    }

}
