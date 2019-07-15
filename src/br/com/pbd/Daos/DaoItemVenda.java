/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.ItemVenda;
import br.com.pbd.modelos.Mensalidade;
import br.com.pbd.modelos.Produto;
import br.com.pbd.sql.SQLconexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoItemVenda {
    
      private static final EntityManager manager = SQLconexao.getEntityManager();

        public List<ItemVenda> BuscaItemvenda(Produto produto) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  i FROM ItemVenda i where i.produto =:obj ");
            query.setParameter("obj", produto);
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }
}
