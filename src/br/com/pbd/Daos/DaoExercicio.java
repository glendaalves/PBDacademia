/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Agenda;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Exercicio;
import br.com.pbd.modelos.Fornecedor;
import br.com.pbd.modelos.Login;
import br.com.pbd.sql.SQLconexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoExercicio {

    private static final EntityManager manager = SQLconexao.getEntityManager();

    public List<Exercicio> Busca(String nome) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  exercicio FROM Exercicio exercicio where exercicio.descricao like '%" + nome + "%' or exercicio.Treino like '%" + nome + "%' or exercicio.nivel like '%" + nome + "%'");

        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }


    public List<Exercicio> usandoID(Aluno aluno) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  a FROM Exercicio a where a.aluno:obj");
            query.setParameter("obj", aluno);
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }

    public List<Exercicio> BuscaImc(String nome) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  exercicio FROM Exercicio exercicio where exercicio.Treino like '%" + nome + "%'");

        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }

}
