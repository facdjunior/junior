package br.com.scesaude.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
@Entity
public class Estado extends GenericDomain{
    @Column(length = 2, nullable = false)
    private String sigla;
    @Column(length = 60, nullable = false)
    private String nome;
    @Column(length = 2, nullable = false)
    private int codIBGE;
    private Integer Sequencia;
    @ManyToOne
    private Entidade entidade;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodIBGE() {
        return codIBGE;
    }

    public void setCodIBGE(int codIBGE) {
        this.codIBGE = codIBGE;
    }

    public Integer getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Integer Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }
    
    
}
