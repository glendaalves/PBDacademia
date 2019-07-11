/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Mensalidade;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessMensalidade {

    public void salvar(Mensalidade mensalidade);
    public List<Mensalidade> getAll();
    public List<Mensalidade> BuscaMensalidades(Aluno aluno, String status);
    public List<Mensalidade> usandoID(Aluno aluno);

}
