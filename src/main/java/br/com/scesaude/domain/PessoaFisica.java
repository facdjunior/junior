package br.com.scesaude.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Alves 2016-09-10
 */
@SuppressWarnings("serial")
@Entity
public class PessoaFisica extends GenericDomain{
    
    @Column(length = 14, nullable = true)
    private String CPF;
    @Column(length = 25)
    private String rg;
    @Column(length = 10)
    private String orgaoEmissor;
    @Temporal(TemporalType.DATE)
    private Date dataEmissaoRg;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(length = 180, nullable = true)
    private String mae;
    @Column(length = 180)
    private String pai;
    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @ManyToOne
    private TipoFuncionario tipoFuncionario;
    @Column(length = 2)
    private String tipoSaguineo;
    @Column(length = 35)
    private String raca;
    @ManyToOne(cascade = CascadeType.ALL)
    private Contato contato;
    @Column(length = 1)
    private Character sexo;
    @Column(length = 40)
    private String estadoCivil;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = true)
    private Pessoa pessoa;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public Date getDataEmissaoRg() {
        return dataEmissaoRg;
    }

    public void setDataEmissaoRg(Date dataEmissaoRg) {
        this.dataEmissaoRg = dataEmissaoRg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getTipoSaguineo() {
        return tipoSaguineo;
    }

    public void setTipoSaguineo(String tipoSaguineo) {
        this.tipoSaguineo = tipoSaguineo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
