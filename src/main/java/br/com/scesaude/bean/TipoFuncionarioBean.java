package br.com.scesaude.bean;

import br.com.scesaude.dao.TipoFuncionarioDAO;
import br.com.scesaude.domain.Entidade;
import br.com.scesaude.domain.TipoFuncionario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

/**
 *
 * @author Francisco Alves 2016-09-09
 */
@ManagedBean
@ViewScoped
@SuppressWarnings("serial")
public class TipoFuncionarioBean implements Serializable {

    private  Entidade entidade;
    private TipoFuncionario tipoFuncionario;
    private List<TipoFuncionario> tipoFuncionarios;
    

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
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
    

       

    @PostConstruct
    public void listar() {
        try {

            TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
            tipoFuncionarios = tipoFuncionarioDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar Tipo de funcionários");
        }
    }

    public void novo() {
        tipoFuncionario = new TipoFuncionario();
        tipoFuncionario.setDataCadastro(new Date());
       // DataCadastro = new Date();
    }

    public void salvar() {
        try {
             TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
             tipoFuncionario.setDataCadastro(new Date());
            tipoFuncionarioDAO.merge(tipoFuncionario);

            novo();
            tipoFuncionarios = tipoFuncionarioDAO.listar();
            Messages.addGlobalInfo("Tipo de funcionário salvo com sucesso!");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar Tipo de funcionário");
            erro.printStackTrace();
        }
    }
    
    public void excluir(ActionEvent evento) {
        try {
            
            tipoFuncionario = (TipoFuncionario) evento.getComponent().getAttributes().get("tipoFuncionarioSelecionado");
            
             TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
            tipoFuncionarioDAO.excluir(tipoFuncionario);
            
            tipoFuncionarios = tipoFuncionarioDAO.listar();
            
            Messages.addGlobalInfo("Registro removida com Sucesso!");
            
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao tentar remover registro");
            erro.printStackTrace();
        }
    }
    
    public void editar(ActionEvent evento){
        
        tipoFuncionario = (TipoFuncionario) evento.getComponent().getAttributes().get("tipoFuncionarioSelecionadozzzxzxzxz");
    }

}
