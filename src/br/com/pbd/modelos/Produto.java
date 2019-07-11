/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.modelos;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Glenda Alves de Lima
 */
@Entity
@SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", initialValue = 1, allocationSize = 1)
@Table(name = "produto")
public class Produto implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    private Long id;
    @Column(name = "descricao", length = 25, nullable = false, unique = true)
    private String descricao;
    @Column(name = "tamanho_peso", length = 25, nullable = false)
    private String tamanho_peso;
    @Column(name = "estoque_atual", precision = 4, scale = 0, nullable = false)
    private int estoque_atual;
    @Column(name = "valor_venda", precision = 3, scale = 2, nullable = false)
    private Double valor_venda;
    @Column(name = "data_cadastro", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
    private Date data_cadastro;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @OneToOne
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;

    @Override
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the estoque
     */
    public Estoque getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
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

}
