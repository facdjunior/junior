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
import java.util.ArrayList;
import java.util.Date;
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
    private Estado estado;

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
            
            bairro.setDataCadastro(new Date());
            bairroDAO.merge(bairro);

            bairro = new Bairro();
            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();

            bairros = bairroDAO.listar();
            
            Messages.addGlobalInfo("Registro salvo com Sucesso!");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao tentar gravar registro!");
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            bairro = (Bairro) evento.getComponent().getAttributes().get("bairroSelecionado");
            BairroDAO bairroDAO = new BairroDAO();
            bairroDAO.excluir(bairro);

            bairros = bairroDAO.listar();

            Messages.addGlobalInfo("Bairro removido com Sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar remover Bairro");
            erro.printStackTrace();
        }
    }

    public void Editar(ActionEvent evento) {
        try {
            bairro = (Bairro) evento.getComponent().getAttributes().get("bairroSelecionado");

            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();

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
    
    public void popularCidade() {
        try {
            if (bairro != null) {
                CidadeDAO cidadeDAO = new CidadeDAO();
                cidades = cidadeDAO.buscaPorEstado(bairro.getCidade().getCodigo());

            } else {
                cidades = new ArrayList<>();
            }
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar cidades");
        }
    }
}
