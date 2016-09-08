package br.com.scesaude.bean;

import br.com.scesaude.dao.ContatoDAO;
import br.com.scesaude.dao.EstadoDAO;
import br.com.scesaude.dao.PessoaDAO;
import br.com.scesaude.domain.Contato;
import br.com.scesaude.domain.Estado;
import br.com.scesaude.domain.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

/**
 *
 * @author Francisco Alves 2016-09-08
 */
@ManagedBean
@ViewScoped
@SuppressWarnings("serial")
public class PessoaBean implements Serializable {

    private Pessoa pessoa;
    private List<Pessoa> pessoas;

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

   

    @PostConstruct
    public void listar() {
        try {

            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoas = pessoaDAO.listar();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao listar pessoas");
        }
    }

    public void novo() {
        pessoa = new Pessoa();
    }

    public void salvar() {
        try {
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.merge(pessoa);

            novo();
            pessoas = pessoaDAO.listar();
            Messages.addGlobalInfo("Registro salvo com sucesso!");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar registro");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {

            pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionado");

            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.excluir(pessoa);

            pessoas = pessoaDAO.listar();

            Messages.addGlobalInfo("Estado removido com Sucesso!");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Erro ao tentar remover registro");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {

        pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionado");
    }
}
