package br.com.scesaude.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Alves 2016-09-06
 */
@SuppressWarnings("serial")
@Entity
public class Entidade extends GenericDomain {

    private Integer Sequencia;
    @ManyToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;
    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @ManyToOne(cascade = CascadeType.ALL)
    private PessoaJuridica pessoaJuridica;
    @Column(length = 80)
    private String ChaveMaster;
    @ManyToOne
    private TipoEntidade tipoEntidade;
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataCadastro;
    private String CodigoCNES;

    public Integer getSequencia() {
        return Sequencia;
    }

    public void setSequencia(Integer Sequencia) {
        this.Sequencia = Sequencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    public TipoEntidade getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(TipoEntidade tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    public String getCodigoCNES() {
        return CodigoCNES;
    }

    public void setCodigoCNES(String CodigoCNES) {
        this.CodigoCNES = CodigoCNES;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

}
