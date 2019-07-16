/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Caixa;
import br.com.pbd.sql.SQLconexao;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoCaixa {

    EntityManager manager = SQLconexao.getEntityManager();

    public Caixa BuscarCaixa(Date date) {
        Query query = null;
        Caixa c = null;
        try {
            query = manager.createQuery("SELECT  m FROM Caixa m where m.data =:obj");
            query.setParameter("obj", date);
            c = (Caixa) query.getSingleResult();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (NoResultException noResultException) {
        }
        return c;
    }

    public Caixa buscaUltimoRegistro() {

        Query query = null;
        try {
            query = manager.createQuery("SELECT obj FROM Caixa obj  ORDER BY obj.id desc");
            query.setMaxResults(1);
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return (Caixa) query.getSingleResult();

    }
 
  
     public void Busca(Long id) {

        manager.getTransaction().begin();
        TypedQuery<Double> vp = (TypedQuery<Double>)manager.createNativeQuery("SELECT lucro("+id+")", Double.class);
        manager.getTransaction().commit();

    }

}
