/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.modelos;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Glenda Alves de Lima
 */
@Entity
@SequenceGenerator(name = "venda_seq", sequenceName = "venda_seq", initialValue = 1, allocationSize = 1)
@Table(name = "venda")
public class Venda implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
    private Long id;
    @Column (name = "forma_pagamento", length = 25, nullable = false)
    private String forma_pagamento;
    @Column (name = "subtotal", precision = 3, scale = 2, nullable = false)
    private Double subtotal;
    @Column (name = "total", precision = 3, scale = 2, nullable = false)
    private Double total;
    @Column (name = "desconto", precision = 3, scale = 2, nullable = false)
    private Double desconto;
    @Column(name = "data_venda", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
    private Date data_venda;

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Caixa caixa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    @JoinColumn(name = "venda_id")
    private List<ItemVenda> itemVendas;

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
     * @return the forma_pagamento
     */
    public String getForma_pagamento() {
        return forma_pagamento;
    }

    /**
     * @param forma_pagamento the forma_pagamento to set
     */
    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    /**
     * @return the subtotal
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }



    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the caixa
     */
    public Caixa getCaixa() {
        return caixa;
    }

    /**
     * @param caixa the caixa to set
     */
    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }


    /**
     * @return the itemVendas
     */
    public List<ItemVenda> getItemVendas() {
        return itemVendas;
    }

    /**
     * @param itemVendas the itemVendas to set
     */
    public void setItemVendas(List<ItemVenda> itemVendas) {
        this.itemVendas = itemVendas;
    }

    /**
     * @return the desconto
     */
    public Double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the data_venda
     */
    public Date getData_venda() {
        return data_venda;
    }

    /**
     * @param data_venda the data_venda to set
     */
    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }


}
