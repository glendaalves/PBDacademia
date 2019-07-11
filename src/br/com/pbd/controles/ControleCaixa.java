/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Caixa;
import br.com.pbd.view.Principal;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import javax.persistence.NoResultException;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleCaixa implements ActionListener {

    private Principal principal;
    private Caixa caixa;
    private Fachada fachada;

    public ControleCaixa(Principal principal,Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;

        caixa = new Caixa();
        abrirCaixa();
        principal.getBotaoCaixa().addActionListener(this);
        principal.getCaixa().getBotaofechar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.getBotaoCaixa()) {
           principal.Desativar();
        }
        if(e.getSource() == principal.getCaixa().getBotaofechar()){
              principal.Ativar();
        }

    }

    public void abrirCaixa() {
        Date data = new Date(System.currentTimeMillis());
        Caixa caixaAnterior = null;
        try {
            caixaAnterior = fachada.buscaUltimoRegistroC();
        } catch (NoResultException n) {
            System.out.println("Caixa anterior nao encontrado");
        }
        try {
            caixa = fachada.BuscarCaixa(data);
        } catch (NoResultException n) {
            System.out.println("Caixa do dia nao encontrado");
        }

        if (caixa == null) {
            caixa = new Caixa();
            caixa.setData(data);
            caixa.setStatus(Boolean.TRUE);
            caixa.setLucro(0.0);
            if (caixaAnterior != null) {
                caixa.setValor_abertura(caixaAnterior.getValor_fechamento());
                caixa.setValor_fechamento(caixaAnterior.getValor_fechamento());
            } else {
                caixa.setValor_abertura(0.0);
                caixa.setValor_fechamento(0.0);
            }
           fachada.salvar(caixa);

        } else {
            caixa.setStatus(Boolean.TRUE);
            fachada.salvar(caixa);
        }

    }

}
