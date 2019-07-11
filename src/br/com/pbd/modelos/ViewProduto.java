/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.modelos;


/**
 *
 * @author Glenda Alves de Lima
 *
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Table;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 *
 * @author Glenda Alves de Lima
 */

@Immutable
@Table(name = "viewprodutos")
public class ViewProduto {

    
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "tamanho_peso")
    private String tamanho_peso;
    @Column(name = "estoque_atual")
    private int estoque_atual;
    @Column(name = "valor_venda" )
    private Double valor_venda;
    @Column(name = "data_cadastro")
    private Date data_cadastro;

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the tamanho_peso
     */
    public String getTamanho_peso() {
        return tamanho_peso;
    }

    /**
     * @param tamanho_peso the tamanho_peso to set
     */
    public void setTamanho_peso(String tamanho_peso) {
        this.tamanho_peso = tamanho_peso;
    }

    /**
     * @return the estoque_atual
     */
    public int getEstoque_atual() {
        return estoque_atual;
    }

    /**
     * @param estoque_atual the estoque_atual to set
     */
    public void setEstoque_atual(int estoque_atual) {
        this.estoque_atual = estoque_atual;
    }

    /**
     * @return the valor_venda
     */
    public Double getValor_venda() {
        return valor_venda;
    }

    /**
     * @param valor_venda the valor_venda to set
     */
    public void setValor_venda(Double valor_venda) {
        this.valor_venda = valor_venda;
    }

    /**
     * @return the data_cadastro
     */
    public Date getData_cadastro() {
        return data_cadastro;
    }

    /**
     * @param data_cadastro the data_cadastro to set
     */
    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    
}
