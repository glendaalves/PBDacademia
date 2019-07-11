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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Glenda Alves de Lima
 */
@Entity
@SequenceGenerator(name = "caixa_seq", sequenceName = "caixa_seq", initialValue = 1, allocationSize = 1)
@Table(name = "caixa")
public class Caixa implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caixa_seq")
    private Long id;
    @Column(name = "data", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
    private Date data;
    @Column(name = "lucro", precision = 6, scale = 2, nullable = false)
    private Double lucro;
    @Column(name = "valor_abertura", precision = 6, scale = 2, nullable = false)
    private Double valor_abertura;
    @Column(name = "valor_fechamento", precision = 6, scale = 2, nullable = false)
    private Double valor_fechamento;
    @Column(name = "status", insertable = true, nullable = false)
    private boolean status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caixa")
    @JoinColumn(name = "caixa_id")
    private List<Venda> vendas;

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
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the lucro
     */
    public Double getLucro() {
        return lucro;
    }

    /**
     * @param lucro the lucro to set
     */
    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    /**
     * @return the valor_abertura
     */
    public Double getValor_abertura() {
        return valor_abertura;
    }

    /**
     * @param valor_abertura the valor_abertura to set
     */
    public void setValor_abertura(Double valor_abertura) {
        this.valor_abertura = valor_abertura;
    }

    /**
     * @return the valor_fechamento
     */
    public Double getValor_fechamento() {
        return valor_fechamento;
    }

    /**
     * @param valor_fechamento the valor_fechamento to set
     */
    public void setValor_fechamento(Double valor_fechamento) {
        this.valor_fechamento = valor_fechamento;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the vendas
     */
    public List<Venda> getVendas() {
        return vendas;
    }

    /**
     * @param vendas the vendas to set
     */
    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

}
