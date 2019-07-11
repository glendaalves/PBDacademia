/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Business;

import br.com.pbd.modelos.Caixa;
import java.sql.Date;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessCaixa {

    public Caixa BuscarCaixa(Date date);
    public Caixa buscaUltimoRegistro();
    public void salvar(Caixa caixa);

}
