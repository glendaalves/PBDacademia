/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.sql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Glenda Alves de Lima
 */
public class SQLconexao {
 
    private static EntityManagerFactory factory =  Persistence.createEntityManagerFactory("PBD2019");
 
 public static EntityManager getEntityManager(){
 return factory.createEntityManager();
 }
}
