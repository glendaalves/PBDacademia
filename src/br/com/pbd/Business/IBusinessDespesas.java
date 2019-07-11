/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.ContaaPagar;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessDespesas {
    
    public void salvar(ContaaPagar contaaPagar);
    public List<ContaaPagar> getAll();
    public void ativarDesativar(ContaaPagar contaaPagar);
    public List<ContaaPagar> busca(String nome);
    
}
