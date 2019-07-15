/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Mensalidade;
import br.com.pbd.sql.SQLconexao;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoMensalidade {

    private static final EntityManager manager = SQLconexao.getEntityManager();

    public List<Mensalidade> BuscaMensalidades(Aluno aluno, String status) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  mensalidade FROM Mensalidade mensalidade where mensalidade.aluno =:obj and mensalidade.status =:status ");
            query.setParameter("obj", aluno);
            query.setParameter("status", status);
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }

    public List<Mensalidade> BuscarporAluno(Aluno aluno) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  a FROM Mensalidade a where a.aluno=:obj");
            query.setParameter("obj", aluno);
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }

    public List<Mensalidade> BuscaMensalidadesDia(Date data, String status) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  mensalidade FROM Mensalidade mensalidade where mensalidade.pagamento =:obj and mensalidade.status =:status ");
            query.setParameter("obj", data);
            query.setParameter("status", status);
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }

}
