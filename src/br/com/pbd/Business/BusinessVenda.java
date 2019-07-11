/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.Venda;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessVenda implements IBusinessVenda{

    @Override
    public void salvar(Venda venda) {
   new DaoGenerico<Venda>().salvar_ou_atualizar(venda);
    }
    
}
