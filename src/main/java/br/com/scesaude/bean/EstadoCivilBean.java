package br.com.scesaude.bean;

import br.com.scesaude.dao.EstadoCivilDAO;
import br.com.scesaude.domain.Entidade;
import br.com.scesaude.domain.EstadoCivil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

/**
 *
 * @author FRANCISCO ALVES 2016-09-02
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoCivilBean implements Serializable {

    private EstadoCivil estadoCivil;
    private List<EstadoCivil> estadoCivils;
    private Entidade entidade;

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<EstadoCivil> getEstadoCivils() {
        return estadoCivils;
    }

    public void setEstadoCivils(List<EstadoCivil> estadoCivils) {
        this.estadoCivils = estadoCivils;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    @PostConstruct
    public void listar() {
        try {

            EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
            estadoCivils = estadoCivilDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar Estado Civis cadastrados");
        }
    }

    public void novo() {

        estadoCivil = new EstadoCivil();

    }

    public void salvar() {
        try {
            EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
            estadoCivilDAO.merge(estadoCivil);

            novo();
            estadoCivils = estadoCivilDAO.listar();
            Messages.addGlobalInfo("Estado Civil salvo com sucesso!");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }

    }

    public void excluir(ActionEvent evento) {
        try {

            estadoCivil = (EstadoCivil) evento.getComponent().getAttributes().get("estadoCivilSelecionado");

            EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
            estadoCivilDAO.excluir(estadoCivil);

            estadoCivils = estadoCivilDAO.listar();

            Messages.addGlobalInfo("Estado civil removido com Sucesso!");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao tentar remover registro");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {

        estadoCivil = (EstadoCivil) evento.getComponent().getAttributes().get("estadoCivilSelecionado");
    }

}
