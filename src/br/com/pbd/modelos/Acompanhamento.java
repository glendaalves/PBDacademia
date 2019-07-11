/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.modelos;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Glenda Alves de Lima
 */
@Entity
@SequenceGenerator(name = "acompanhamento_seq", sequenceName = "acompanhamento_seq", initialValue = 1, allocationSize = 1)
@Table(name = "acompanhamento")
public class Acompanhamento implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acompanhamento_seq")
    private Long id;
    @Column(name = "data", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
    private Date data;
    @Column(name = "peito", precision = 2, scale = 3, nullable = false)
    private Double peito;
    @Column(name = "ombro", precision = 2, scale = 3, nullable = false)
    private Double ombro;
    @Column(name = "cintura", precision = 2, scale = 3, nullable = false)
    private Double cintura;
    @Column(name = "quadril", precision = 2, scale = 3, nullable = false)
    private Double quadril;
    @Column(name = "coxa", precision = 2, scale = 3, nullable = false)
    private Double coxa;
    @Column(name = "panturrilha", precision = 2, scale = 3, nullable = false)
    private Double panturrilha;
    @Column(name = "braco", precision = 2, scale = 3, nullable = false)
    private Double braco;
    @Column(name = "antebraco", precision = 2, scale = 3, nullable = false)
    private Double antebraco;
    

    @ManyToOne // muitos para um
    private Aluno aluno;

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
     * @return the peito
     */
    public Double getPeito() {
        return peito;
    }

    /**
     * @param peito the peito to set
     */
    public void setPeito(Double peito) {
        this.peito = peito;
    }

    /**
     * @return the ombro
     */
    public Double getOmbro() {
        return ombro;
    }

    /**
     * @param ombro the ombro to set
     */
    public void setOmbro(Double ombro) {
        this.ombro = ombro;
    }

    /**
     * @return the cintura
     */
    public Double getCintura() {
        return cintura;
    }

    /**
     * @param cintura the cintura to set
     */
    public void setCintura(Double cintura) {
        this.cintura = cintura;
    }

    /**
     * @return the quadril
     */
    public Double getQuadril() {
        return quadril;
    }

    /**
     * @param quadril the quadril to set
     */
    public void setQuadril(Double quadril) {
        this.quadril = quadril;
    }

    /**
     * @return the coxa
     */
    public Double getCoxa() {
        return coxa;
    }

    /**
     * @param coxa the coxa to set
     */
    public void setCoxa(Double coxa) {
        this.coxa = coxa;
    }

    /**
     * @return the panturriha
     */
    public Double getPanturrilha() {
        return panturrilha;
    }

    /**
     * @param panturriha the panturriha to set
     */
    public void setPanturrilha(Double panturrilha) {
        this.panturrilha = panturrilha;
    }

    /**
     * @return the braco
     */
    public Double getBraco() {
        return braco;
    }

    /**
     * @param braco the braco to set
     */
    public void setBraco(Double braco) {
        this.braco = braco;
    }

    /**
     * @return the antebraco
     */
    public Double getAntebraco() {
        return antebraco;
    }

    /**
     * @param antebraco the antebraco to set
     */
    public void setAntebraco(Double antebraco) {
        this.antebraco = antebraco;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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

}
