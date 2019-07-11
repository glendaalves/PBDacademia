/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Tarefa;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessTarefa {
    
    public void salvar(Tarefa tarefa);
    public List<Tarefa> getAll();
    public void ativarDesativar(Tarefa tarefa);
    public List<Tarefa> busca(String nome);
    
}
