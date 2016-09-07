package br.com.scesaude.bean;

import br.com.scesaude.dao.BairroDAO;
import br.com.scesaude.dao.EntidadeDAO;
import br.com.scesaude.dao.EstadoDAO;
import br.com.scesaude.dao.TipoEntidadeDAO;
import br.com.scesaude.domain.Bairro;
import br.com.scesaude.domain.Endereco;
import br.com.scesaude.domain.Entidade;
import br.com.scesaude.domain.Estado;
import br.com.scesaude.domain.Pessoa;
import br.com.scesaude.domain.PessoaJuridica;
import br.com.scesaude.domain.TipoEntidade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

/**
 *
 * @author Francisco Alves 2016-09-07
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EntidadeBean implements Serializable {

    private Entidade entidade;
    private List<Entidade> entidades;
    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    private PessoaJuridica pessoaJuridica;
    private List<PessoaJuridica> pessoaJuridicas;
    private Endereco endereco;
    private List<Endereco> enderecos;
    private Bairro bairro;
    private List<Bairro> bairros;
    private List<Estado> estados;
    private List<TipoEntidade> tipoEntidades;

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public List<Entidade> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidade> entidades) {
        this.entidades = entidades;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<PessoaJuridica> getPessoaJuridicas() {
        return pessoaJuridicas;
    }

    public void setPessoaJuridicas(List<PessoaJuridica> pessoaJuridicas) {
        this.pessoaJuridicas = pessoaJuridicas;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Bairro> getBairros() {
        return bairros;
    }

    public void setBairros(List<Bairro> bairros) {
        this.bairros = bairros;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public List<TipoEntidade> getTipoEntidades() {
        return tipoEntidades;
    }

    public void setTipoEntidades(List<TipoEntidade> tipoEntidades) {
        this.tipoEntidades = tipoEntidades;
    }

    @PostConstruct
    public void listar() {
        try {
            EntidadeDAO entidadeDAO = new EntidadeDAO();
            entidades = entidadeDAO.listar("codigo");

            TipoEntidadeDAO tipoEntidadeDAO = new TipoEntidadeDAO();
            tipoEntidades = tipoEntidadeDAO.listar("descricao");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar Cidades");
            erro.printStackTrace();
        }
    }

    public void novo() {
        try {
            entidade = new Entidade();

       

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao carregar cadastro de estado!");
            erro.printStackTrace();
        }
    }

    public void salvar() {
        try {
            EntidadeDAO entidadeDAO = new EntidadeDAO();
            // Inicia nova Pessoa
            pessoa = new Pessoa();
            //Grava nova Pessoa
            entidade.setPessoa(pessoa);
            // Inicia novo Cadastro Endereço
            endereco = new Endereco();
            // Grava Novo Endereço
            entidade.setEndereco(endereco);
            //Inicia Novo Cadastro Pessoa Juridica
            pessoaJuridica = new PessoaJuridica();
            //Grava Novo Pessoa Juridica
            entidade.setPessoaJuridica(pessoaJuridica);
            //Receber Codigo Entidade e popula nos novos Registros "Pessoa", "Endereço", "Pessoa Juridica"
            entidadeDAO.merge(entidade);

            entidade = new Entidade();
            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();

            entidades = entidadeDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao tentar gravar registro!");
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            entidade = (Entidade) evento.getComponent().getAttributes().get("entidadeSelecionada");
            EntidadeDAO entidadeDAO = new EntidadeDAO();
            entidadeDAO.excluir(entidade);

            entidades = entidadeDAO.listar();

            Messages.addGlobalInfo("Entidade removida com Sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar remover a Entidade");
            erro.printStackTrace();
        }
    }

    public void Editar(ActionEvent evento) {
        try {
            entidade = (Entidade) evento.getComponent().getAttributes().get("entidadeSelecionada");

            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();

            BairroDAO bairroDAO = new BairroDAO();
            bairros = bairroDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao editar registro");
            erro.printStackTrace();
        }

    }
}
