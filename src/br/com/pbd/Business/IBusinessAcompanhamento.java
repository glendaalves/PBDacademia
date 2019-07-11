/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Acompanhamento;
import br.com.pbd.modelos.Aluno;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessAcompanhamento {
    
    public void salvar(Acompanhamento acompanhamento);
    public void ativarDesativar(Acompanhamento acompanhamento);
    public List<Acompanhamento> getAll();
    public List<Acompanhamento> usandoID(Aluno aluno);
    
}
