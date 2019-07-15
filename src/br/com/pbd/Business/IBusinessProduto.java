/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Produto;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessProduto {
    
    public void salvar(Produto produto);
    public List<Produto> getAll();
    public boolean ativarDesativar(Produto produto);
    public List<Produto> Busca(String nome);
    public List<Produto> BuscaP(String nome) ;
    public List<Produto> BuscarQuantidade() ;
    
}
