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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Glenda Alves de Lima
 */
@Entity
@SequenceGenerator(name = "login_seq", sequenceName = "login_seq", initialValue = 1, allocationSize = 1)
@Table(name = "login")
public class Login implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login_seq")
    private Long id;
    @Column (name="usuario",length=20,nullable=false,unique = true)
    private String usuario;
    @Column (name="senha",length=100,nullable=false)
    private String senha;
    @Column (name="reset",insertable = false)
    private boolean reset;

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
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the reset
     */
    public boolean isReset() {
        return reset;
    }

    /**
     * @param reset the reset to set
     */
    public void setReset(boolean reset) {
        this.reset = reset;
    }

}
