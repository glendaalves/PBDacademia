/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Acompanhamento;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.EntidadeBase;
import br.com.pbd.sql.SQLconexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoAcompanhamento {
    private static final EntityManager manager = SQLconexao.getEntityManager();
    
     public List<Acompanhamento> usandoID(Aluno aluno) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  a FROM Acompanhamento a where a.aluno=:obj");
            query.setParameter("obj", aluno);
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }
    
}
