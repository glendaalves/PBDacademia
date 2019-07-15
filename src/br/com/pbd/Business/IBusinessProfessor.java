/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Professor;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessProfessor {
    
    public void salvar(Professor professor);
    public List<Professor> getAll();
    public boolean ativarDesativar(Professor professor);
    public List<Professor> busca(String nome);
    
}
