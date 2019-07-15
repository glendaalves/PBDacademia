/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Venda;
import br.com.pbd.sql.SQLconexao;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoVenda {
    
    private static final EntityManager manager = SQLconexao.getEntityManager();
    
        public List<Venda> BuscaVendasDia (Date data) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  venda FROM Venda venda where venda.data_venda =:obj ");
            query.setParameter("obj", data);
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }
    
}
