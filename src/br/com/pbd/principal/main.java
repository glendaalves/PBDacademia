
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.principal;

import br.com.pbd.DaoView.DaoViewProduto;
import br.com.pbd.Fachada.Fachada;
import br.com.pbd.controles.ControleAcademia;
import br.com.pbd.controles.ControleAgenda;
import br.com.pbd.controles.ControleAlunos;
import br.com.pbd.controles.ControleCaixa;
import br.com.pbd.controles.ControleDespesas;
import br.com.pbd.controles.ControleExercicio;
import br.com.pbd.controles.ControleFornecedor;
import br.com.pbd.controles.ControleFuncionario;
import br.com.pbd.controles.ControleLogin;
import br.com.pbd.controles.ControleProduto;
import br.com.pbd.controles.ControleProfessor;
import br.com.pbd.controles.ControleRelatorios;
import br.com.pbd.controles.ControleTarefa;
import br.com.pbd.controles.ControleVendas;
import br.com.pbd.view.TelaAdministrador;
import br.com.pbd.view.Principal;
import br.com.pbd.view.TelaLogin;
import br.com.pbd.modelos.ViewProduto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class main {

    public static void main(String[] a) {
        
        Fachada fachada = Fachada.getInstance();
        
        Principal principal = new Principal();

        TelaLogin telaLogin = new TelaLogin();
        
        TelaAdministrador administrador = new TelaAdministrador();

        ControleCaixa controleCaixa = new ControleCaixa(principal, fachada);

        ControleAcademia controleAcademia = new ControleAcademia(principal, fachada);
        
        ControleFuncionario controleFuncionario = new ControleFuncionario(principal, fachada);

        ControleFornecedor controleFornecedor = new ControleFornecedor(principal, fachada);

        ControleProduto controleProduto = new ControleProduto(principal, fachada);

        ControleProfessor controleProfessor = new ControleProfessor(principal, fachada);

        ControleAlunos controleAluno = new ControleAlunos(principal, fachada);

        ControleExercicio controleExercicio = new ControleExercicio(principal, fachada);

        ControleAgenda controleAgenda = new ControleAgenda(principal, fachada);

        ControleDespesas controleDespesas = new ControleDespesas(principal, fachada);

        ControleLogin controleLogin = new ControleLogin(principal, telaLogin, administrador, fachada);
        ControleRelatorios  controleRelatorios = new ControleRelatorios(principal);

        ControleVendas controleVendas = new ControleVendas(principal, fachada);


   


    }
}
