/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.DaoView;

import br.com.pbd.Visoes.ViewAgenda;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Professor;
import br.com.pbd.sql.SQLconexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoViewAgenda {

    private static final EntityManager manager = SQLconexao.getEntityManager();

    public List<ViewAgenda> Getall() {

        manager.getTransaction().begin();
        TypedQuery<ViewAgenda> vp = (TypedQuery<ViewAgenda>) manager.createNativeQuery("select * from public.ViewAgenda", ViewAgenda.class);
        manager.getTransaction().commit();
        return vp.getResultList();
    }

    public List<ViewAgenda> BuscaPorAluno(Aluno aluno) {

        manager.getTransaction().begin();
        TypedQuery<ViewAgenda> vp = (TypedQuery<ViewAgenda>) manager.createNativeQuery("select * from ViewAgenda  where aluno_id=" + aluno.getId(), ViewAgenda.class);
        manager.getTransaction().commit();
        return vp.getResultList();
    }

    public List<ViewAgenda> BuscaPorProfessor(Professor professor) {
        manager.getTransaction().begin();
        TypedQuery<ViewAgenda> vp = (TypedQuery<ViewAgenda>) manager.createNativeQuery("select * from ViewAgenda  where professor_id=" + professor.getId(), ViewAgenda.class);
        manager.getTransaction().commit();
        return vp.getResultList();
    }

    public List<ViewAgenda> BuscaPorProfessorDia(Professor professor,String dia) {
        manager.getTransaction().begin();
        TypedQuery<ViewAgenda> vp = (TypedQuery<ViewAgenda>) manager.createNativeQuery("select * from ViewAgenda  where professor_id=" + professor.getId() +"and dia_semana='"+dia+"'", ViewAgenda.class);
        manager.getTransaction().commit();
        return vp.getResultList();
    }

}
