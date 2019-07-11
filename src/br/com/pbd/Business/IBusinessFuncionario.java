/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Funcionario;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessFuncionario {
    
    public void salvar(Funcionario funcionario);
    public List<Funcionario> getAllFor();
    public void ativarDesativar(Funcionario funcionario);
    public List<Funcionario> BuscaFor(String nome);
    
}
