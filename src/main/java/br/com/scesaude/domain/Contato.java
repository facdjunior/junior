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
    private Character telefone;
    @Column(length = 14)
    private Character celular;
    @Column(length = 14)
    private Character fax;
    @Column(length = 120)
    private String site;
    @Column(length = 60)
    private String skype;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getTelefone() {
        return telefone;
    }

    public void setTelefone(Character telefone) {
        this.telefone = telefone;
    }

    public Character getCelular() {
        return celular;
    }

    public void setCelular(Character celular) {
        this.celular = celular;
    }

    public Character getFax() {
        return fax;
    }

    public void setFax(Character fax) {
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
