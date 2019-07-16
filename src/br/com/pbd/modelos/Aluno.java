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
@SequenceGenerator(name = "aluno_seq", sequenceName = "aluno_seq", initialValue = 1, allocationSize = 1)
@Table(name = "aluno")

public class Aluno implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
    private Long id;
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    @Column(name = "situacao", length = 15, nullable = false)
    private String situacao;
    @Column(name = "estado_civil", length = 15, nullable = false)
    private String estado_civil;
    @Column(name = "cpf", length = 14, nullable = false, unique = false)
    private String cpf;
    @Column(name = "rg", length = 9, nullable = false, unique = false)
    private String rg;
    @Column(name = "sexo", length = 10, nullable = false)
    private String sexo;
    @Column(name = "data_matricula", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
    private Date data_matricula;
    @Column(name = "data_nascimento", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
    private Date data_nascimento;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dados_id")
    private Dados dados;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    @JoinColumn(name = "aluno_id")
    private List<Acompanhamento> acompanhamentos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    @JoinColumn(name = "aluno_id")
    private List<Agenda> agendas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    @JoinColumn(name = "aluno_id")
    private List<Mensalidade> mensalidades;

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
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the estado_civil
     */
    public String getEstado_civil() {
        return estado_civil;
    }

    /**
     * @param estado_civil the estado_civil to set
     */
    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }


    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the data_matricula
     */
    public Date getData_matricula() {
        return data_matricula;
    }

    /**
     * @param data_matricula the data_matricula to set
     */
    public void setData_matricula(Date data_matricula) {
        this.data_matricula = data_matricula;
    }

    /**
     * @return the data_nascimento
     */
    public Date getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
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
     * @return the acompanhamentos
     */
    public List<Acompanhamento> getAcompanhamentos() {
        return acompanhamentos;
    }

    /**
     * @param acompanhamentos the acompanhamentos to set
     */
    public void setAcompanhamentos(List<Acompanhamento> acompanhamentos) {
        this.acompanhamentos = acompanhamentos;
    }

    /**
     * @return the agendas
     */
    public List<Agenda> getAgendas() {
        return agendas;
    }

    /**
     * @param agendas the agendas to set
     */
    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    /**
     * @return the mensalidades
     */
    public List<Mensalidade> getMensalidades() {
        return mensalidades;
    }

    /**
     * @param mensalidades the mensalidades to set
     */
    public void setMensalidades(List<Mensalidade> mensalidades) {
        this.mensalidades = mensalidades;
    }

    

}
