package br.com.scesaude.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Francisco Alves
 */
@SuppressWarnings("serial")
@Entity
public class Cidade extends GenericDomain{
    
    @Column(length = 90, nullable = false)
    private String nome;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Estado estado;
    
    @Column(length = 6)
    private Long CodIBGE;
    @ManyToOne
    private Entidade entidade;
    
    private Integer sequencia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getCodIBGE() {
        return CodIBGE;
    }

    public void setCodIBGE(Long CodIBGE) {
        this.CodIBGE = CodIBGE;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }
}
