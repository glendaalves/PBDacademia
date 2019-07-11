/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.modelos;

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
@SequenceGenerator(name = "exercicio_seq", sequenceName = "exercicio_seq", initialValue = 1, allocationSize = 1)
@Table(name = "exercicio")
public class Exercicio implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercicio_seq")
    private Long id;
    @Column(name = "Descricao", length = 20, nullable = false)
    private String descricao;
    @Column(name = "repeticao", precision = 3, scale = 0, nullable = false)
    private int repeticao;
    @Column(name = "serie", precision = 3, scale = 0, nullable = false)
    private int serie;
    @Column(name = "intervalo", length = 15, nullable = false)
    private String intervalo;
    @Column(name = "peso", precision = 3, scale = 3, nullable = false)
    private Double peso;
    @Column(name = "Treino", length = 30, nullable = false)
    private String Treino;

    @ManyToOne
    private Academia academia;
    
    @Column(name = "nivel", length = 20, nullable = false)
    private String nivel;

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
     * @return the repeticao
     */
    public int getRepeticao() {
        return repeticao;
    }

    /**
     * @param repeticao the repeticao to set
     */
    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
    }

    /**
     * @return the serie
     */
    public int getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(int serie) {
        this.serie = serie;
    }

    /**
     * @return the intervalo
     */
    public String getIntervalo() {
        return intervalo;
    }

    /**
     * @param intervalo the intervalo to set
     */
    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    /**
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * @return the Treino
     */
    public String getTreino() {
        return Treino;
    }

    /**
     * @param Treino the Treino to set
     */
    public void setTreino(String Treino) {
        this.Treino = Treino;
    }

    /**
     * @return the academia
     */
    public Academia getAcademia() {
        return academia;
    }

    /**
     * @param academia the academia to set
     */
    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    

}
