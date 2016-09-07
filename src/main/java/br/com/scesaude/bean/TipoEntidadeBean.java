package br.com.scesaude.bean;

import br.com.scesaude.dao.TipoEntidadeDAO;
import br.com.scesaude.domain.Entidade;
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
 * @author Francisco Alves 2016-09-02
 */
@ManagedBean
@ViewScoped
@SuppressWarnings("serial")
public class TipoEntidadeBean implements Serializable {

    public Entidade entidade;
    public TipoEntidade tipoEntidade;
    public List<TipoEntidade> tipoEntidades;

    public TipoEntidade getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(TipoEntidade tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
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

            TipoEntidadeDAO tipoEntidadeDAO = new TipoEntidadeDAO();
            tipoEntidades = tipoEntidadeDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar estados");
        }
    }

    public void novo() {
        tipoEntidade = new TipoEntidade();
    }

    public void salvar() {
        try {
            TipoEntidadeDAO tipoEntidadeDAO = new TipoEntidadeDAO();
            tipoEntidadeDAO.merge(tipoEntidade);

            novo();
            tipoEntidades = tipoEntidadeDAO.listar();
            Messages.addGlobalInfo("Tipo de Entidade salvo com sucesso!");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar Tipo de Entidade");
            erro.printStackTrace();
        }
    }
    
    public void excluir(ActionEvent evento) {
        try {
            
            tipoEntidade = (TipoEntidade) evento.getComponent().getAttributes().get("tipoEntidadeSelecionado");
            
            TipoEntidadeDAO tipoEntidadeDAO = new TipoEntidadeDAO();
            tipoEntidadeDAO.excluir(tipoEntidade);
            
            tipoEntidades = tipoEntidadeDAO.listar();
            
            Messages.addGlobalInfo("Tipo de Entidade removida com Sucesso!");
            
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao tentar remover Tipo de Entidade");
            erro.printStackTrace();
        }
    }
    
    public void editar(ActionEvent evento){
        
        tipoEntidade = (TipoEntidade) evento.getComponent().getAttributes().get("tipoEntidadeSelecionado");
    }

}
