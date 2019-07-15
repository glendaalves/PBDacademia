/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.DaoView;

import br.com.pbd.Visoes.ViewFornecedor;
import br.com.pbd.sql.SQLconexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoViewFornecedor {

    private static final EntityManager manager = SQLconexao.getEntityManager();

    public List<ViewFornecedor> BuscaP(String nome) {

        manager.getTransaction().begin();
        TypedQuery<ViewFornecedor> vp = (TypedQuery<ViewFornecedor>) manager.createNativeQuery("select * from ViewFornecedor where nome_fantasia like '%" + nome + "%' or razao_social like '%" + nome + "%' or cnpj like '%" + nome + "%' " ,ViewFornecedor.class);

        manager.getTransaction().commit();

        return vp.getResultList();
    }
     public List<ViewFornecedor> Getall() {

        manager.getTransaction().begin();
        TypedQuery<ViewFornecedor> vp = (TypedQuery<ViewFornecedor>) manager.createNativeQuery("select * from public.ViewFornecedor", ViewFornecedor.class);
        manager.getTransaction().commit();
        return vp.getResultList();
    }
}
