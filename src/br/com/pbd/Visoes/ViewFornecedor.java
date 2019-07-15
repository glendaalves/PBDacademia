/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Visoes;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 *
 * @author Glenda Alves de Lima
 */
@Immutable
@Entity
public class ViewFornecedor {

    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "nome_fantasia", nullable = false)
    private String nome_fantasia;
    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;
    @Column(name = "razao_social", nullable = false)
    private String razao_social;
    @Column(name = "linha_produto", nullable = false)
    private String linha_produto;
    @Column(name = "data_cadastro", nullable = false)
    private Date data_cadastro;
    @Column(name = "Celular", nullable = false)
    private String Celular;

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
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
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
     * @return the Celular
     */
    public String getCelular() {
        return Celular;
    }

    /**
     * @param Celular the Celular to set
     */
    public void setCelular(String Celular) {
        this.Celular = Celular;
    }


}
