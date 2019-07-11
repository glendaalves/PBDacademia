/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Estoque;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessEstoque {
    
    public void salvar(Estoque estoque);
    public List<Estoque> getAll();
    
}
