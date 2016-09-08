package br.com.scesaude.bean;

import br.com.scesaude.dao.BairroDAO;
import br.com.scesaude.dao.CidadeDAO;
import br.com.scesaude.dao.EnderecoDAO;
import br.com.scesaude.dao.EstadoDAO;
import br.com.scesaude.dao.TipoEntidadeDAO;
import br.com.scesaude.domain.Bairro;
import br.com.scesaude.domain.Cidade;
import br.com.scesaude.domain.Endereco;
import br.com.scesaude.domain.Estado;
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
 * @author Francisco Alves
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EnderecoBean implements Serializable {

    private Endereco endereco;
    private List<Endereco> enderecos;
    private Bairro bairro;
    private List<Bairro> bairros;
    private Cidade cidade;
    private List<Cidade> cidades;
    private List<Estado> estados;
    private Estado estado;

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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @PostConstruct
    public void listar() {
        try {
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            enderecos = enderecoDAO.listar("logradouro");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar Enderecos");
            erro.printStackTrace();
        }
    }

    public void novo() {
        try {
            endereco = new Endereco();

            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar("nome");
            
            BairroDAO bairroDAO = new BairroDAO();
            bairros = bairroDAO.listar("descricao");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao carregar cadastro de estado!");
            erro.printStackTrace();
        }
    }

    public void salvar() {
        try {
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            enderecoDAO.merge(endereco);

            novo();
            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();

            enderecos = enderecoDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao tentar gravar registro!");
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            endereco = (Endereco) evento.getComponent().getAttributes().get("enderecoSelecionado");
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            enderecoDAO.excluir(endereco);

            enderecos = enderecoDAO.listar();

            Messages.addGlobalInfo("Endereço removido com Sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar remover Endereço");
            erro.printStackTrace();
        }
    }

    public void Editar(ActionEvent evento) {
        try {
            endereco = (Endereco) evento.getComponent().getAttributes().get("enderecoSelecionado");

            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao editar registro");
            erro.printStackTrace();
        }
    }
}
