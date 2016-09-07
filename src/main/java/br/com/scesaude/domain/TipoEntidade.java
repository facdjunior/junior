package br.com.scesaude.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Alves
 */
@SuppressWarnings("serial")
@Entity
public class TipoEntidade extends GenericDomain {

    @Column(length = 250, nullable = false)
    private String Descricao;
    @Column(length = 80)
    private String ChaveMaster;
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataCadastro;
    private Integer Sequencia;
    @ManyToOne
    private Entidade entidade;
  
    

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getChaveMaster() {
        return ChaveMaster;
    }

    public void setChaveMaster(String ChaveMaster) {
        this.ChaveMaster = ChaveMaster;
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
