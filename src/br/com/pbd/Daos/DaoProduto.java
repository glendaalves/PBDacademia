/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Produto;
import br.com.pbd.sql.SQLconexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoProduto {

    private static final EntityManager manager = SQLconexao.getEntityManager();

    public List<Produto> Busca(String nome) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  produto FROM Produto produto where produto.descricao like '%" + nome + "%' or produto.estoque.grupo like '%" + nome + "%' or produto.fornecedor.razao_social like '%" + nome + "%' ");

        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }

    public List<Produto> BuscaP(String nome) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  produto FROM Produto produto where produto.descricao like '%" + nome + "%' ");

        } catch (IllegalStateException e) {
           System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }

    public List<Produto> BuscarQuantidade() {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  produto FROM Produto produto where produto.estoque_atual > 0 ");
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }

}
