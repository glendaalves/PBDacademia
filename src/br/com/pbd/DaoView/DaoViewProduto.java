/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.DaoView;

import br.com.pbd.modelos.Produto;
import br.com.pbd.sql.SQLconexao;
import br.com.pbd.modelos.ViewProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoViewProduto {
    
    
    private static final EntityManager manager = SQLconexao.getEntityManager();
    
    public List<ViewProduto> Busca(String nome) {

        manager.getTransaction().begin();
	TypedQuery<ViewProduto> vp = (TypedQuery<ViewProduto>) manager.createNativeQuery("select * from public.viewprodutos",Produto.class);
	manager.getTransaction().commit();
       
        return vp.getResultList();
    }
    
     public List<ViewProduto> Buscaa(String nome) {

        manager.getTransaction().begin();
	TypedQuery<ViewProduto> vp = (TypedQuery<ViewProduto>) manager.createNativeQuery("select * from public.viewprodutos v where v.descricao like '%" + nome + "%' ");
	manager.getTransaction().commit();
       
        return vp.getResultList();
    }
}
