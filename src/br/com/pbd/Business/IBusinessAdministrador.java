/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Administrador;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessAdministrador {
    
    
    public Administrador buscaUltimoRegistro();
    public void salvar(Administrador administrador);
    
}
