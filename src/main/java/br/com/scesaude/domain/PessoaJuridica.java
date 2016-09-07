package br.com.scesaude.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Alves
 */
@SuppressWarnings("serial")
@Entity
public class PessoaJuridica extends GenericDomain{
    @ManyToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;
    @Column(length = 180)
    private String RazaoSocial;
    @Column(length = 45)
    private String InsEstadual;
    @Column(length = 18)
    private String CNPJ;
    @Column(length = 45)
    private String InscMunicipal;
    @Column(length = 45)
    private String RegistroANS;
    @Column(length = 45)
    private String RegistroCNES;
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataCadastro;
    @ManyToOne
    private Entidade entidade;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }

    public String getInsEstadual() {
        return InsEstadual;
    }

    public void setInsEstadual(String InsEstadual) {
        this.InsEstadual = InsEstadual;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getInscMunicipal() {
        return InscMunicipal;
    }

    public void setInscMunicipal(String InscMunicipal) {
        this.InscMunicipal = InscMunicipal;
    }

    public String getRegistroANS() {
        return RegistroANS;
    }

    public void setRegistroANS(String RegistroANS) {
        this.RegistroANS = RegistroANS;
    }

    public String getRegistroCNES() {
        return RegistroCNES;
    }

    public void setRegistroCNES(String RegistroCNES) {
        this.RegistroCNES = RegistroCNES;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }
    
    
    
            
}
