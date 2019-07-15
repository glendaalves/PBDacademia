/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Fornecedor;
import br.com.pbd.sql.SQLconexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoFornecedor {
    
    private static final EntityManager manager = SQLconexao.getEntityManager();
    
    public List<Fornecedor> Busca(String nome) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  fornecedor FROM Fornecedor fornecedor where fornecedor.nome_fantasia like '%" + nome + "%' or fornecedor.razao_social like '%" + nome + "%' or fornecedor.cnpj like '%" + nome + "%' ");

        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }
    public Fornecedor bucarPorId(int id) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT p FROM Fornecedor p where p.id=:obj");
            query.setParameter("obj", id);
        } catch (IllegalStateException e) {
            System.out.println("erro ao buscar produtos");
        }
        return (Fornecedor) query.getSingleResult();
    }

    
}
