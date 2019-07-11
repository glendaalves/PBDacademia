/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Daos;

import br.com.pbd.modelos.Administrador;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Dados;
import br.com.pbd.modelos.Funcionario;
import br.com.pbd.modelos.Login;
import br.com.pbd.modelos.Professor;
import br.com.pbd.sql.SQLconexao;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoLogin {
           private static final EntityManager manager = SQLconexao.getEntityManager();

    public Administrador BuscarLoginAdministrador(Login obj) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  m FROM Administrador m where( m.login.usuario =:usuario and m.login.senha =:senha)");
            query.setParameter("usuario", obj.getUsuario());
            query.setParameter("senha", obj.getSenha());
            return (Administrador) query.getSingleResult();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (NoResultException noResultException) {
            
        }
 return null;
        
    }
    public Professor BuscarLoginProfessor(Login obj) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  m FROM Professor m where (m.login.usuario =:usuario and m.login.senha =:senha)");
            query.setParameter("usuario", obj.getUsuario());
            query.setParameter("senha", obj.getSenha());
            return (Professor) query.getSingleResult();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (NoResultException noResultException) {
        }
               return null;
        
    }
    public Funcionario BuscarLoginFuncionario(Login obj) {
        Query query = null;
        try {
            query = manager.createQuery("SELECT  m FROM Funcionario m where (m.login.usuario =:usuario and m.login.senha =:senha)");
            query.setParameter("usuario", obj.getUsuario());
            query.setParameter("senha", obj.getSenha());
            return (Funcionario) query.getSingleResult();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (NoResultException noResultException) {
        }
               return null;
        
    }

}
