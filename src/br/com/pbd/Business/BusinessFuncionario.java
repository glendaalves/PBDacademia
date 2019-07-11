/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoFuncionario;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.Funcionario;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessFuncionario implements IBusinessFuncionario {

    @Override
    public void salvar(Funcionario funcionario) {
        new DaoGenerico<Funcionario>().salvar_ou_atualizar(funcionario);
    }

    @Override
    public List<Funcionario> getAllFor() {
        return new DaoGenerico<Funcionario>().getAll(Funcionario.class);
    }

    @Override
    public void ativarDesativar(Funcionario funcionario) {
        new DaoGenerico<Funcionario>().salvar_ou_atualizar(funcionario);
    }

    @Override
    public List<Funcionario> BuscaFor(String nome) {
        return new DaoFuncionario().Busca(nome);
    }

}
