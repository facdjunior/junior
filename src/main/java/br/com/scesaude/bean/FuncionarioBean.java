package br.com.scesaude.bean;

import br.com.scesaude.dao.BairroDAO;
import br.com.scesaude.dao.CidadeDAO;
import br.com.scesaude.dao.ContatoDAO;
import br.com.scesaude.dao.EnderecoDAO;
import br.com.scesaude.dao.EntidadeDAO;
import br.com.scesaude.dao.EstadoDAO;
import br.com.scesaude.dao.FuncionarioDAO;
import br.com.scesaude.dao.PessoaDAO;

import br.com.scesaude.dao.TipoFuncionarioDAO;
import br.com.scesaude.domain.Bairro;
import br.com.scesaude.domain.Cidade;
import br.com.scesaude.domain.Contato;
import br.com.scesaude.domain.Endereco;
import br.com.scesaude.domain.Entidade;
import br.com.scesaude.domain.Estado;
import br.com.scesaude.domain.Funcionario;
import br.com.scesaude.domain.Pessoa;
import br.com.scesaude.domain.PessoaFisica;
import br.com.scesaude.domain.TipoFuncionario;
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
public class FuncionarioBean implements Serializable {

    private Entidade entidade;
    private List<Entidade> entidades;
    private Funcionario funcionario;
    private List<Funcionario>funcionarios;
    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    private PessoaFisica pessoaFisica;
    private List<PessoaFisica> pessoaFisicas;
    private Endereco endereco;
    private List<Endereco> enderecos;
    private Bairro bairro;
    private List<Bairro> bairros;
    private Estado estado;
    private List<Estado> estados;
    private TipoFuncionario tipoFuncionario;
    private List<TipoFuncionario> tipoFuncionarios;
    private List<Cidade> cidades;
    private Cidade cidade;
    private Contato contato;
    private List<Contato> contatos;

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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public List<PessoaFisica> getPessoaFisicas() {
        return pessoaFisicas;
    }

    public void setPessoaFisicas(List<PessoaFisica> pessoaFisicas) {
        this.pessoaFisicas = pessoaFisicas;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public List<Bairro> getBairros() {
        return bairros;
    }

    public void setBairros(List<Bairro> bairros) {
        this.bairros = bairros;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public List<TipoFuncionario> getTipoFuncionarios() {
        return tipoFuncionarios;
    }

    public void setTipoFuncionarios(List<TipoFuncionario> tipoFuncionarios) {
        this.tipoFuncionarios = tipoFuncionarios;
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

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

   
    @PostConstruct
    public void listar() {
        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarios = funcionarioDAO.listar("codigo");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar Funcionarios");
            erro.printStackTrace();
        }
    }

    public void novo() {
        try {
            //entidade = new Entidade();
            pessoa = new Pessoa();
            endereco = new Endereco();
            pessoaFisica = new PessoaFisica();
            contato = new Contato();
            
            funcionario = new Funcionario();

            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar("nome");

            TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
            tipoFuncionarios = tipoFuncionarioDAO.listar("Descricao");

            BairroDAO bdao = new BairroDAO();
            bairros = bdao.listar("codigo");
            
            bairro = new Bairro();

            EnderecoDAO enderecoDAO = new EnderecoDAO();
            enderecos = enderecoDAO.listar("logradouro");

            cidades = new ArrayList<Cidade>();
           
            
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao carregar registros!");
            erro.printStackTrace();
        }
    }

    public void salvar() {
        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            // Inicia nova Pessoa

            //Grava nova Pessoa
            funcionario.setPessoa(pessoa);
            pessoa.setPessoaFisica(pessoaFisica);
           // pessoa.setPessoaFisica(pessoaFisica);
            //pessoa.setEntidade(entidade);

            // Grava Novo Endereço
            funcionario.setEndereco(endereco);
            endereco.setBairro(bairro);
            endereco.setPessoa(pessoa);
         //   endereco.setEntidade(entidade);

            //Inicia Novo Contato
            funcionario.setContato(contato);
            funcionario.setPessoaFisica(pessoaFisica);
            funcionario.setTipoFuncionario(tipoFuncionario);
            funcionario.setEndereco(endereco);
       //     funcionario.setEntidade(entidade);
            contato.setPessoa(pessoa);

            //Gravar Tipo Entidade
            funcionario.setTipoFuncionario(tipoFuncionario);
          //  tipoFuncionario.setEntidade(entidade);

            //Grava Novo Pessoa Juridica
           // entidade.setPessoa(pessoa);
            pessoaFisica.setPessoa(pessoa);
            pessoaFisica.setContato(contato);
            pessoaFisica.setEndereco(endereco);
            pessoaFisica.setTipoFuncionario(tipoFuncionario);
            
            //Receber Codigo Entidade e popula nos novos Registros "Pessoa", "Endereço", "Pessoa Juridica"
            
            funcionarioDAO.merge(funcionario);
             Messages.addGlobalInfo("Registro salvo com Sucesso!");
            novo();
            
            //funcionarios = funcionarioDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao tentar gravar registro!" + erro);
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
            funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionado");
            bairro = funcionario.getEndereco().getBairro();
            pessoa = funcionario.getPessoaFisica().getPessoa();
            pessoaFisica = funcionario.getPessoa().getPessoaFisica();
            endereco = funcionario.getPessoaFisica().getEndereco();
            tipoFuncionario = funcionario.getPessoaFisica().getTipoFuncionario();
            contato = funcionario.getPessoaFisica().getContato();

            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();

            CidadeDAO cidadeDAO = new CidadeDAO();
            cidades = cidadeDAO.listar();

            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoas = pessoaDAO.listar();

            BairroDAO bairroDAO = new BairroDAO();
            bairros = bairroDAO.listar();

            TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
            tipoFuncionarios = tipoFuncionarioDAO.listar();

            EnderecoDAO enderecoDAO = new EnderecoDAO();
            enderecos = enderecoDAO.listar();

            ContatoDAO contatoDAO = new ContatoDAO();
            contatos = contatoDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao editar registro"+erro);
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
