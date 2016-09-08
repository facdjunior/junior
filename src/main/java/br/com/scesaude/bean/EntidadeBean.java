package br.com.scesaude.bean;

import br.com.scesaude.dao.BairroDAO;
import br.com.scesaude.dao.CidadeDAO;
import br.com.scesaude.dao.EnderecoDAO;
import br.com.scesaude.dao.EntidadeDAO;
import br.com.scesaude.dao.EstadoDAO;
import br.com.scesaude.dao.TipoEntidadeDAO;
import br.com.scesaude.domain.Bairro;
import br.com.scesaude.domain.Cidade;
import br.com.scesaude.domain.Contato;
import br.com.scesaude.domain.Endereco;
import br.com.scesaude.domain.Entidade;
import br.com.scesaude.domain.Estado;
import br.com.scesaude.domain.Pessoa;
import br.com.scesaude.domain.PessoaJuridica;
import br.com.scesaude.domain.TipoEntidade;
import java.io.Serializable;
import java.util.ArrayList;
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
    private Estado estado;
    private List<Estado> estados;
    private List<TipoEntidade> tpentidade;
    private List<Cidade> cidades;
    private Cidade cidade;
    private Contato contato;

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

    public List<TipoEntidade> getTpentidade() {
        return tpentidade;
    }

    public void setTpentidade(List<TipoEntidade> tpentidade) {
        this.tpentidade = tpentidade;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    
    

    @PostConstruct
    public void listar() {
        try {
            EntidadeDAO entidadeDAO = new EntidadeDAO();
            entidades = entidadeDAO.listar("codigo");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar Cidades");
            erro.printStackTrace();
        }
    }

    public void novo() {
        try {
            entidade = new Entidade();
            pessoa = new Pessoa();
            endereco = new Endereco();
            pessoaJuridica = new PessoaJuridica();
            contato = new Contato();

            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar("nome");

            TipoEntidadeDAO tedao = new TipoEntidadeDAO();
            tpentidade = tedao.listar("codigo");
            
            BairroDAO bdao = new BairroDAO();
            bairros = bdao.listar("descricao");
            
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            enderecos = enderecoDAO.listar("logradouro");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao carregar cadastro de estado!"+erro);
            erro.printStackTrace();
        }
    }

    public void salvar() {
        try {
            EntidadeDAO entidadeDAO = new EntidadeDAO();
            // Inicia nova Pessoa
            
            //Grava nova Pessoa
            entidade.setPessoa(pessoa);
            pessoa.setEntidade(entidade);
            // Inicia novo Cadastro Endereço
            
            // Grava Novo Endereço
            entidade.setEndereco(endereco);
            endereco.setBairro(bairro);
            endereco.setPessoa(pessoa);
            endereco.setEntidade(entidade);
            //Inicia Novo Cadastro Pessoa Juridica
            entidade.setContato(contato);
            contato.setPessoa(pessoa);
            
            //Grava Novo Pessoa Juridica
            entidade.setPessoaJuridica(pessoaJuridica);
            pessoaJuridica.setPessoa(pessoa);
            pessoaJuridica.setEntidade(entidade);
            //Receber Codigo Entidade e popula nos novos Registros "Pessoa", "Endereço", "Pessoa Juridica"
            entidadeDAO.merge(entidade);
            novo();
            entidade = new Entidade();
            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();

            entidades = entidadeDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao tentar gravar registro!"+erro);
            System.out.println(erro);
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

    public void popular() {
        try {
            if (estado != null) {
                CidadeDAO cidadeDAO = new CidadeDAO();
                cidades = cidadeDAO.buscaPorEstado(estado.getCodigo());

            } else {
                cidades = new ArrayList<>();
            }
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar cidades");
        }
    }
    public void popularBairro() {
        try {
            if (bairro != null) {
                CidadeDAO cidadeDAO = new CidadeDAO();
                cidades = cidadeDAO.buscaPorBairro(bairro.getCidade().getCodigo());
                EstadoDAO estadoDAO = new EstadoDAO();
                

            } else {
                cidades = new ArrayList<>();
            }
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar cidades");
        }
    }
}
