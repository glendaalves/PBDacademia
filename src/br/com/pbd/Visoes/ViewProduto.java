/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Visoes;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import jdk.nashorn.internal.ir.annotations.Immutable;


@Immutable
@Entity
public class ViewProduto {
    
    @Id
    @Column(name = "id",nullable=false)
    private int id;
    
    @Column(name = "descricao",nullable=false)
     private String descricao;
    
    @Column(name = "tamanho_peso",nullable=false)
    private String tamanho_peso;
    
    @Column(name = "estoque_atual",nullable=false)
    private int estoque_atual;
    
    @Column(name = "valor_venda",nullable=false)
    private Double valor_venda;
    
    @Column(name = "data_cadastro",nullable=false)
    private Date data_cadastro;

    public ViewProduto() {
    }

    public ViewProduto(String descricao, String tamanho_peso, int estoque_atual, Double valor_venda, Date data_cadastro) {
        this.descricao = descricao;
        this.tamanho_peso = tamanho_peso;
        this.estoque_atual = estoque_atual;
        this.valor_venda = valor_venda;
        this.data_cadastro = data_cadastro;
    }
    

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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

  



}
