/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Fornecedor;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessFornecedor {
    
    public void salvar(Fornecedor fornecedor);
    public List<Fornecedor> getAll();
    public void ativarDesativar(Fornecedor fornecedor);
    public List<Fornecedor> Busca(String nome);
    
}
