package br.com.scesaude.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author Francisco Alves
 */
@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericDomain{
    
    private Integer Sequencia;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;
    @Temporal(TemporalType.DATE)
    private Date DataAdmissao;
    @Temporal(TemporalType.DATE)
    private Date Demissao;
    @Column(length = 45)
    private String CarteiraTrabalho;
    @ManyToOne
    private TipoFuncionario tipoFuncionario;
    @Column(length = 45)
    private String usuario;
    @Column(length = 32)
    private String senha;
    private Boolean Ativo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataCadastro;
    @Column(length = 6)
    private String NumeroANS;

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

    public Date getDataAdmissao() {
        return DataAdmissao;
    }

    public void setDataAdmissao(Date DataAdmissao) {
        this.DataAdmissao = DataAdmissao;
    }

    public Date getDemissao() {
        return Demissao;
    }

    public void setDemissao(Date Demissao) {
        this.Demissao = Demissao;
    }

    public String getCarteiraTrabalho() {
        return CarteiraTrabalho;
    }

    public void setCarteiraTrabalho(String CarteiraTrabalho) {
        this.CarteiraTrabalho = CarteiraTrabalho;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return Ativo;
    }

    public void setAtivo(Boolean Ativo) {
        this.Ativo = Ativo;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public String getNumeroANS() {
        return NumeroANS;
    }

    public void setNumeroANS(String NumeroANS) {
        this.NumeroANS = NumeroANS;
    }
    
    

}
