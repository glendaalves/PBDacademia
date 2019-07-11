/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.Estoque;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessEstoque implements IBusinessEstoque{

    @Override
    public void salvar(Estoque estoque) {
   new DaoGenerico<Estoque>().salvar_ou_atualizar(estoque); }

    @Override
    public List<Estoque> getAll() {
  return new DaoGenerico<Estoque>().getAll(Estoque.class);
    }
    
}
