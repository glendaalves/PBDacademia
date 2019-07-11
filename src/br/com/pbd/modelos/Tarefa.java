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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Glenda Alves de Lima
 */
@Entity
@SequenceGenerator(name = "tarefa_seq", sequenceName = "tarefa_seq", initialValue = 1, allocationSize = 1)
@Table(name = "tarefa")
public class Tarefa implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarefa_seq")
    private Long id;

    @Column (name = "descricao", length = 25, nullable = false)
    private String descricao;
    @Column (name = "prioridade", length = 10, nullable = false)
    private String prioridade;
    @Column (name = "status", length = 10, nullable = false)
    private String status;
    @Column (name = "data_inicial", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
    private Date datainicial;
    @Column (name = "data_final", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
    private Date datafinal;

    @ManyToOne
    private Funcionario funcionario;

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
     * @return the prioridade
     */
    public String getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the data_inicial
     */
    public Date getData_inicial() {
        return datainicial;
    }

    /**
     * @param data_inicial the data_inicial to set
     */
    public void setData_inicial(Date data_inicial) {
        this.datainicial = data_inicial;
    }

    /**
     * @return the date_final
     */
    public Date getDate_final() {
        return datafinal;
    }

    /**
     * @param date_final the date_final to set
     */
    public void setDate_final(Date date_final) {
        this.datafinal = date_final;
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

}
