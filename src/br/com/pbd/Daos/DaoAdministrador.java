/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Administrador;
import br.com.pbd.sql.SQLconexao;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoAdministrador {
    
   private static final EntityManager manager = SQLconexao.getEntityManager();

    public Administrador buscaUltimoRegistro() {

        Query query = null;
        try {
            query = manager.createQuery("SELECT obj FROM Administrador obj  ORDER BY obj.id desc");
            query.setMaxResults(1);
        } catch (IllegalStateException e) {
            System.out.println("erro ao busca a academia");
        }
        return (Administrador) query.getSingleResult();

    }
    
}
