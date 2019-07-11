/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.modelos;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Glenda Alves de Lima
 */
@Entity
@SequenceGenerator(name = "agenda_seq", sequenceName = "agenda_seq", initialValue = 1, allocationSize = 1)
@Table(name = "agenda")
public class Agenda implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agenda_seq")
    private Long id; 
    @Column (name="dia_semana",length=15,nullable=false)
    private String dia_semana;
    @Column (name="turno",length=10,nullable=true)
    private String turno;
    @Column (name="horario",nullable=true)
    private Time horario;

    @ManyToOne
    private Professor professor;
    
    @ManyToOne
    private Aluno aluno;
    
    
    @OneToMany// ( orphanRemoval = true)
    private List<Exercicio> exercicios;
    
  


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
     * @return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * @return the aluno1
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno1 the aluno1 to set
     */
    public void setAluno(Aluno aluno1) {
        this.aluno = aluno1;
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
