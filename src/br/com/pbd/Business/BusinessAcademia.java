/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoAcademia;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.Academia;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessAcademia extends DaoGenerico<Academia> implements IBusinessAcademia {

    @Override
    public void salvar(Academia academia) {
        salvar_ou_atualizar(academia);
    }

    @Override
    public Academia buscaUltimoRegistro() {
       return new DaoAcademia().buscaUltimoRegistro();
    }

}
