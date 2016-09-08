package br.com.scesaude.bean;

import br.com.scesaude.dao.ContatoDAO;
import br.com.scesaude.dao.EstadoDAO;
import br.com.scesaude.domain.Contato;
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
public class ContatoBean implements Serializable {

    private Contato contato;
    private List<Contato> contatos;

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

    @PostConstruct
    public void listar() {
        try {

            ContatoDAO contatoDAO = new ContatoDAO();
            contatos = contatoDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar estados");
        }
    }

    public void novo() {
        contato = new Contato();
    }

    public void salvar() {
        try {
            ContatoDAO contatoDAO = new ContatoDAO();
            contatoDAO.merge(contato);

            novo();
            contatos = contatoDAO.listar();
            Messages.addGlobalInfo("Registro salvo com sucesso!");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {

            contato = (Contato) evento.getComponent().getAttributes().get("contatoSelecionado");

            ContatoDAO contatoDAO = new ContatoDAO();
            contatoDAO.excluir(contato);

            contatos = contatoDAO.listar();

            Messages.addGlobalInfo("Estado removido com Sucesso!");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao tentar remover registro");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {

        contato = (Contato) evento.getComponent().getAttributes().get("contatoSelecionado");
    }
}
