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

@Entity
@SequenceGenerator(name = "imagem_seq", sequenceName = "imagem_seq", initialValue = 1, allocationSize = 1)
@Table(name = "imagem")
public class Imagem implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagem_seq")
    private Long id;
    @Column(name = "imagem", nullable = false)
    private byte[] imagem;

    @ManyToOne // muitos para um
    private Acompanhamento acompanhamento;

    @Override
    public Long getId() {
        return id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    /**
     * @return the acompanhamento
     */
    public Acompanhamento getAcompanhamento() {
        return acompanhamento;
    }

    /**
     * @param acompanhamento the acompanhamento to set
     */
    public void setAcompanhamento(Acompanhamento acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

}
