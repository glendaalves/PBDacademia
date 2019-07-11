
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.modelos;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Glenda Alves de Lima
 */

@Entity
@SequenceGenerator(name="academia_seq",sequenceName="academia_seq", initialValue=1,allocationSize=1)
@Table(name = "academia")
public class Academia implements EntidadeBase{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academia_seq")
    private Long id; 
    @Column (name="nome_fantasia",length=40,nullable=false)
    private String nome_fantasia;
    @Column (name="cnpj",length=18,nullable=false,unique = true)
    private String cnpj;
    @Column (name="razao_social",length=40,nullable=false)
    private String razao_social;

   
    @OneToOne(cascade=CascadeType.ALL) // um para um
    private Dados dados;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "academia")
    @JoinColumn(name = "academia_id")
    private List<ContaaPagar> contaaPagars;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "academia")
    @JoinColumn(name = "academia_id")
    private List<Exercicio> exercicios;

    
    @Override
    public Long getId() {
    return  id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return the contaaPagars
     */
    public List<ContaaPagar> getContaaPagars() {
        return contaaPagars;
    }

    /**
     * @param contaaPagars the contaaPagars to set
     */
    public void setContaaPagars(List<ContaaPagar> contaaPagars) {
        this.contaaPagars = contaaPagars;
    }

    /**
     * @return the exercicios
     */
    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    /**
     * @param exercicios the exercicios to set
     */
    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }
    

   

}
