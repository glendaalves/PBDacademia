/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.Daos.DaoMensalidade;
import br.com.pbd.modelos.Aluno;
import br.com.pbd.modelos.Mensalidade;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessMensalidade implements IBusinessMensalidade {

    @Override
    public void salvar(Mensalidade mensalidade) {
        new DaoGenerico<Mensalidade>().salvar_ou_atualizar(mensalidade);
    }

    @Override
    public List<Mensalidade> getAll() {
        return (new DaoGenerico<Mensalidade>().getAll(Mensalidade.class));
    }

    @Override
    public List<Mensalidade> BuscaMensalidades(Aluno aluno, String status) {
        return new DaoMensalidade().BuscaMensalidades(aluno, status);
    }

    @Override
    public List<Mensalidade> usandoID(Aluno aluno) {
        return new DaoMensalidade().BuscarporAluno(aluno);
    }

}
