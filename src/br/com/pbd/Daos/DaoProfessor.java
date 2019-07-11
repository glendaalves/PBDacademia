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
public class DaoProfessor {

    private static final EntityManager manager = SQLconexao.getEntityManager();

    public List<Professor> Busca(String nome) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  professor FROM Professor professor where professor.nome like '%" + nome + "%' or professor.cpf like '%" + nome + "%' or professor.rg like '%" + nome + "%' ");

        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }

}
