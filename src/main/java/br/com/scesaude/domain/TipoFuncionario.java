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
@SuppressWarnings("serial")
@Entity
public class TipoFuncionario extends GenericDomain{
    
    @Column(length = 120, nullable = false)
    private String Descricao;
    @Column(length = 5)
    private Integer Sequencia;
    @ManyToOne
    private Entidade entidade;
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataCadastro;

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
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

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }
}
