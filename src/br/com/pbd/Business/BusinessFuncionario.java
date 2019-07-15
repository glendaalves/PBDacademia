/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoFuncionario;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.Daos.DaoTarefa;
import br.com.pbd.modelos.Funcionario;
import br.com.pbd.modelos.Tarefa;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessFuncionario extends DaoGenerico<Funcionario>implements IBusinessFuncionario {

    @Override
    public void salvar(Funcionario funcionario) {
      salvar_ou_atualizar(funcionario);
    }

    @Override
    public List<Funcionario> getAllFor() {
        return getAll(Funcionario.class);
    }

    @Override
    public void ativarDesativar(Funcionario funcionario) {
            remover(Funcionario.class,funcionario.getId());
    }

    @Override
    public List<Funcionario> BuscaFor(String nome) {
        return new DaoFuncionario().Busca(nome);
    }

}
