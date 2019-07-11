/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Academia;
import br.com.pbd.modelos.EntidadeBase;
import br.com.pbd.modelos.Funcionario;
import br.com.pbd.modelos.Login;
import br.com.pbd.sql.SQLconexao;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DaoGenerico<A extends EntidadeBase> {

    private static EntityManager manager = SQLconexao.getEntityManager();
    

    public A BuscaPorId(Class<A> clazz, Long id) {
        return manager.find(clazz, id);
    }

    public Long salvar_ou_atualizar(A obj) {
        Object clazz = null;
        try {
            manager.getTransaction().begin();
            if (obj.getId() == null) {
                manager.persist(obj);
            } else {
                manager.merge(obj);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
        long id = obj.getId();
       
        return id;
    }

    public void remover(Class<A> clazz, Long id) {
        A t = BuscaPorId(clazz, id);
        try {
            manager.getTransaction().begin();
            manager.remove(t);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }

    public <A extends EntidadeBase> List<A> getAll(Class<A> clazz) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<A> cq = cb.createQuery(clazz);
        return manager.createQuery(cq).getResultList();

    }

    public <A extends EntidadeBase> List<A> usandoID(EntidadeBase clazz, String nome, String fk) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  a FROM " + nome + " a where a." + fk + "=:obj");
            query.setParameter("obj", clazz);
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }
            
     public Object  buscaUltimoRegistro(String classe) {

        Query query = null;
        try {
            query = manager.createQuery("SELECT obj FROM "+classe+" obj  ORDER BY obj.id desc");
            query.setMaxResults(1);
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return (Object) query.getSingleResult();

    }

//    	public <A extends EntidadeBase> List<A> BuscarNome(Class<A> clazz, String nome, Object value) {
//		CriteriaBuilder cb = manager.getCriteriaBuilder();
//		CriteriaQuery<A> cq = cb.createQuery(clazz);
//		Root<A> root = cq.from(clazz);
//		cq.where(cb.equal(root.get(nome), value));
//		return manager.createQuery(cq).getResultList();
//	}
}
