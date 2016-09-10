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
 * @author Francisco Alves
 */
@SuppressWarnings("serial")
@Entity
public class Pessoa extends GenericDomain{
    
    @Column(length = 180, nullable = false)
    private String Nome;
    @Temporal(TemporalType.DATE)
    private Date DataNascimento;
    @Column(length = 1)
    private Character sexo;
    private Integer Sequencia;
    @ManyToOne
    private Entidade entidade;
    @Temporal(TemporalType.TIMESTAMP)
    private Date DataCadastro;
    
    private Byte[] ImagemPessoa;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
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

    public Byte[] getImagemPessoa() {
        return ImagemPessoa;
    }

    public void setImagemPessoa(Byte[] ImagemPessoa) {
        this.ImagemPessoa = ImagemPessoa;
    }

    
}
