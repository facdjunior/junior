package br.com.scesaude.bean;

import br.com.scesaude.dao.EstadoDAO;
import br.com.scesaude.domain.Estado;
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
@ManagedBean
@ViewScoped
@SuppressWarnings("serial")
public class EstadoBean implements Serializable {

    private Estado estado;
    private List<Estado> estados;

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

    @PostConstruct
    public void listar() {
        try {

            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar estados");
        }
    }

    public void novo() {
        estado = new Estado();
    }

    public void salvar() {
        try {
            EstadoDAO estadoDAO = new EstadoDAO();
            estadoDAO.merge(estado);

            novo();
            estados = estadoDAO.listar();
            Messages.addGlobalInfo("Registro salvo com sucesso!");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {

            estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");

            EstadoDAO estadoDAO = new EstadoDAO();
            estadoDAO.excluir(estado);

            estados = estadoDAO.listar();

            Messages.addGlobalInfo("Estado removido com Sucesso!");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao tentar remover registro");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {

        estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
    }
}
