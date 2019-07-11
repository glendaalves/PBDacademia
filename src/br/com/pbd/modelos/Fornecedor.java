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
@SequenceGenerator(name = "fornecedor_seq", sequenceName = "fornecedor_seq", initialValue = 1, allocationSize = 1)
@Table(name = "fornecedor")
public class Fornecedor implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor_seq")
    private Long id;
    @Column (name="nome_fantasia",length=40,nullable=false)
    private String nome_fantasia;
    @Column (name="cnpj",length=18,nullable=false,unique = true)
    private String cnpj;
    @Column (name="razao_social",length=40,nullable=false)
    private String razao_social;
    @Column (name="linha_produto",length=30,nullable=false)
    private String linha_produto;
    @Column (name = "data_cadastro", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
    private Date data_cadastro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dados_id")
    private Dados dados;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedor")
    @JoinColumn(name = "fornecedor_id")
    private List<Produto> produtos;

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
     * @return the nome_fantasia
     */
    public String getNome_fantasia() {
        return nome_fantasia;
    }

    /**
     * @param nome_fantasia the nome_fantasia to set
     */
    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    /**
     * @return the cnpf
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpf the cnpf to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the razao_social
     */
    public String getRazao_social() {
        return razao_social;
    }

    /**
     * @param razao_social the razao_social to set
     */
    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    /**
     * @return the linha_produto
     */
    public String getLinha_produto() {
        return linha_produto;
    }

    /**
     * @param linha_produto the linha_produto to set
     */
    public void setLinha_produto(String linha_produto) {
        this.linha_produto = linha_produto;
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
     * @return the dados
     */
    public Dados getDados() {
        return dados;
    }

    /**
     * @param dados the dados to set
     */
    public void setDados(Dados dados) {
        this.dados = dados;
    }

    /**
     * @return the produtos
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    
}
