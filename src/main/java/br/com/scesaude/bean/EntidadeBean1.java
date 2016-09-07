package br.com.scesaude.bean;

import br.com.scesaude.dao.EntidadeDAO;
import br.com.scesaude.dao.EstadoDAO;
import br.com.scesaude.domain.Entidade;
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
public class EntidadeBean1 implements Serializable {

    private Entidade entidade;
    private List<Entidade> entidades;
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

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
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
            entidades = entidadeDAO.listar("nome");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar Cidades");
            erro.printStackTrace();
        }
    }

    public void novo() {
        try {
            entidade = new Entidade();

            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar("nome");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao carregar cadastro de estado!");
            erro.printStackTrace();
        }
    }

}
