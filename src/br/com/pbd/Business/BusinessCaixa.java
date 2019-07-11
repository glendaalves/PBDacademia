/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.Daos.DaoCaixa;
import br.com.pbd.Daos.DaoGenerico;
import br.com.pbd.modelos.Caixa;
import java.sql.Date;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessCaixa implements IBusinessCaixa {

    @Override
    public Caixa BuscarCaixa(Date date) {
        return new DaoCaixa().BuscarCaixa(date);
    }

    @Override
    public Caixa buscaUltimoRegistro() {
        return new DaoCaixa().buscaUltimoRegistro();
    }

    @Override
    public void salvar(Caixa caixa) {
        new DaoGenerico<Caixa>().salvar_ou_atualizar(caixa);
    }

}
