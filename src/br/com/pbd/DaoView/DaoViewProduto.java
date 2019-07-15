/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.DaoView;

import br.com.pbd.Visoes.ViewProduto;
import br.com.pbd.sql.SQLconexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Andre-Coude
 */
public class DaoViewProduto {

    private static final EntityManager manager = SQLconexao.getEntityManager();

    public List<ViewProduto> Getall() {

        manager.getTransaction().begin();
        TypedQuery<ViewProduto> vp = (TypedQuery<ViewProduto>) manager.createNativeQuery("select * from public.viewprodutos", ViewProduto.class);
        manager.getTransaction().commit();
        return vp.getResultList();
    }

    public List<ViewProduto> BuscaP(String nome) {

        manager.getTransaction().begin();
        TypedQuery<ViewProduto> vp = (TypedQuery<ViewProduto>) manager.createNativeQuery("select * from viewprodutos  where descricao like '%" + nome + "%'",
                ViewProduto.class);

        manager.getTransaction().commit();

        return vp.getResultList();
    }
        public List<ViewProduto> BuscaPQ() {

        manager.getTransaction().begin();
        TypedQuery<ViewProduto> vp = (TypedQuery<ViewProduto>) manager.createNativeQuery("select * from viewprodutos  where estoque_atual > 0 ",
                ViewProduto.class);

        manager.getTransaction().commit();

        return vp.getResultList();
    }
}
