package br.com.scesaude.bean;

import br.com.scesaude.dao.BairroDAO;
import br.com.scesaude.dao.CidadeDAO;
import br.com.scesaude.dao.EstadoDAO;
import br.com.scesaude.dao.TipoEntidadeDAO;
import br.com.scesaude.domain.Bairro;
import br.com.scesaude.domain.Cidade;
import br.com.scesaude.domain.Estado;
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
 * @author Francisco Alves
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BairroBean implements Serializable {

    private Bairro bairro;
    private List<Bairro> bairros;
    private Cidade cidade;
    private List<Cidade> cidades;
    private List<Estado> estados;

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

    @PostConstruct
    public void listar() {
        try {
            BairroDAO bairroDAO = new BairroDAO();
            bairros = bairroDAO.listar("descricao");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar Bairros");
            erro.printStackTrace();
        }
    }

    public void novo() {
        try {
            bairro = new Bairro();

            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar("nome");


        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao carregar cadastro de estado!");
            erro.printStackTrace();
        }
    }

    public void salvar() {
        try {
            BairroDAO bairroDAO = new BairroDAO();
            bairroDAO.merge(bairro);

            bairro = new Bairro();
            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();

            bairros = bairroDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao tentar gravar registro!");
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidadeDAO.excluir(cidade);

            cidades = cidadeDAO.listar();

            Messages.addGlobalInfo("Cidade removida com Sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar remover a cidade");
            erro.printStackTrace();
        }
    }

    public void Editar(ActionEvent evento) {
        try {
            cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");

            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao editar registro");
            erro.printStackTrace();
        }

    }
}
