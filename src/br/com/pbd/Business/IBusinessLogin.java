/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Administrador;
import br.com.pbd.modelos.Funcionario;
import br.com.pbd.modelos.Login;
import br.com.pbd.modelos.Professor;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessLogin {
    
    public Funcionario BuscarLoginFuncionario(Login obj);
    public Professor BuscarLoginProfessor(Login obj);
    public Administrador BuscarLoginAdministrador(Login obj);
    
    
}
