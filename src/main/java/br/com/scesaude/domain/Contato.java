package br.com.scesaude.domain;

import javax.persistence.CascadeType;
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
public class Contato extends GenericDomain{
    
    @Column(length = 120, nullable = false)
    private String email;
    @Column(length = 14)
    private String telefone;
    @Column(length = 14)
    private String celular;
    @Column(length = 14)
    private String fax;
    @Column(length = 120)
    private String site;
    @Column(length = 60)
    private String skype;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }


    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
