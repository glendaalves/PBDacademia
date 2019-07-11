/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Agenda;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Professor;
import br.com.pbd.sql.SQLconexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoAgenda {

    private static final EntityManager manager = SQLconexao.getEntityManager();

    public List<Agenda> usandoID(Aluno aluno) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  agenda FROM Agenda agenda where agenda.aluno =:obj ");
            query.setParameter("obj", aluno);
        } catch (IllegalStateException e) {
            System.out.println("erro ao buscar agenda");
        }
        return query.getResultList();
    }

    public List<Agenda> usandoAgenda(Professor professor, String dia) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  agenda FROM Agenda agenda where agenda.professor =:obj and agenda.dia_semana =:dia ");
            query.setParameter("obj", professor);
            query.setParameter("dia", dia);
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }

    public List<Agenda> usandoID(Professor professor) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  agenda FROM Agenda agenda where agenda.professor =:obj ");
            query.setParameter("obj", professor);
        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }
}
