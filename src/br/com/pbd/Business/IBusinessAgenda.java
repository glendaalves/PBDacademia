/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Agenda;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Professor;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessAgenda {
    
    public void salvar(Agenda agenda);
    public void ativarDesativar(Agenda agenda);
    public List<Agenda> getAll();
    public List<Agenda> usandoID(Aluno aluno);
    public List<Agenda> usandoID(Professor professor, String dia);
    public List<Agenda> usandoID(Professor professor);
    
}
