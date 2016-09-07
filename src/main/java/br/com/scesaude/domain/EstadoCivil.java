package br.com.scesaude.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Alves 2016-09-02
 */
@Entity
@SuppressWarnings("serial")
public class EstadoCivil extends GenericDomain {

    @Column(length = 80, nullable = false)
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date DataCadastro;
    
    private Integer Sequencia;
    @ManyToOne
    private Entidade entidade;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
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