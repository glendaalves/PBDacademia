/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Funcionario;
import br.com.pbd.sql.SQLconexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoFuncionario {

    private static final EntityManager manager = SQLconexao.getEntityManager();

    public List<Funcionario> Busca(String nome) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  funcionario FROM Funcionario funcionario where funcionario.funcao like '%" + nome + "%' or funcionario.cpf like '%" + nome + "%' or funcionario.nome like '%" + nome + "%' ");

        } catch (IllegalStateException e) {
            System.out.println("erro ao realizar a buscar");
        }
        return query.getResultList();
    }

}
