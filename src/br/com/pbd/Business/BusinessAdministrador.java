/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoAdministrador;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.Administrador;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessAdministrador implements IBusinessAdministrador {

    @Override
    public Administrador buscaUltimoRegistro() {
        return new DaoAdministrador().buscaUltimoRegistro();
    }

    @Override
    public void salvar(Administrador administrador) {
         new DaoGenerico<Administrador>().salvar_ou_atualizar(administrador);
    }

}
