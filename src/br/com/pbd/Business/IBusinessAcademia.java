/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Academia;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessAcademia {
    
    public void salvar(Academia academia);
    public Academia  buscaUltimoRegistro();
    
}
