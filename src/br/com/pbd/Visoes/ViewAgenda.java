/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.Visoes;

import br.com.pbd.modelos.Aluno;
import java.sql.Time;
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
public class ViewAgenda {

    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "dia_semana", nullable = false)
    private String dia_semana;
    @Column(name = "turno", nullable = true)
    private String turno;
    @Column(name = "horario", nullable = true)
    private Time horario;
    @Column(name = "aluno_id", nullable = true)
    private int aluno_id;
    @Column(name = "professor_id", nullable = true)
    private int professor_id;
    @Column(name = "nome", nullable = true)
    private String nome;
    @Column(name = "situacao", nullable = true)
    private String situacao;

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
     * @return the dia_semana
     */
    public String getDia_semana() {
        return dia_semana;
    }

    /**
     * @param dia_semana the dia_semana to set
     */
    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * @return the horario
     */
    public Time getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(Time horario) {
        this.horario = horario;
    }

    /**
     * @return the aluno_id
     */
    public int getAluno_id() {
        return aluno_id;
    }

    /**
     * @param aluno_id the aluno_id to set
     */
    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    /**
     * @return the professor_id
     */
    public int getProfessor_id() {
        return professor_id;
    }

    /**
     * @param professor_id the professor_id to set
     */
    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
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

}
