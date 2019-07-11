/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.Daos.DaoProduto;
import br.com.pbd.modelos.Produto;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessProduto implements IBusinessProduto {

    @Override
    public void salvar(Produto produto) {
        new DaoGenerico<Produto>().salvar_ou_atualizar(produto);
    }

    @Override
    public List<Produto> getAll() {
        return new DaoGenerico<Produto>().getAll(Produto.class);
    }

    @Override
    public void ativarDesativar(Produto produto) {
        new DaoGenerico<Produto>().salvar_ou_atualizar(produto);
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
