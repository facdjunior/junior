package br.com.scesaude.DAOTest;

import br.com.scesaude.dao.BairroDAO;
import br.com.scesaude.dao.CidadeDAO;
import br.com.scesaude.dao.EntidadeDAO;
import br.com.scesaude.domain.Bairro;
import br.com.scesaude.domain.Cidade;
import br.com.scesaude.domain.Entidade;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Francisco Alves 2016-09-06
 */
public class BairroDAOTest {

    @Test
    @Ignore
    public void salvar() {

        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidade = cidadeDAO.buscar(2L);

        Bairro bairro = new Bairro();
        bairro.setDescricao("CENTRO");
        bairro.setSequencia(1);
        bairro.setCidade(cidade);

        BairroDAO bairroDAO = new BairroDAO();
        bairroDAO.merge(bairro);
    }

    @Test
    @Ignore
    public void listar() {

        BairroDAO bairroDAO = new BairroDAO();
        List<Bairro> resultado = bairroDAO.listar();

        for (Bairro bairro : resultado) {
            System.out.println("Código: " + bairro.getCodigo()
                    + " - " + bairro.getDescricao() + "-" + bairro.getCidade().getNome());

        }
    }

    @Test
    @Ignore
    public void buscar() {
        Long codigo = 1L;

        BairroDAO bairroDAO = new BairroDAO();
        Bairro bairro = bairroDAO.buscar(codigo);

        System.out.println("Código: " + bairro.getCodigo()
                + " Cidade: " + bairro.getCidade().getNome() + "-" + bairro.getDescricao());
    }

    @Test
    @Ignore
    public void excluir() {

        Long codigo = 1L;

        BairroDAO bairroDAO = new BairroDAO();
        Bairro bairro = bairroDAO.buscar(codigo);

        bairroDAO.excluir(bairro);
        System.out.println("Código: " + bairro.getCodigo()
                + " Cidade: " + bairro.getCidade().getNome() + "-" + bairro.getDescricao());
    }

    @Test
    @Ignore
    public void editar() {

        Long codigoBairro = 1L;
        Long codigoEntidade = 1L;

        EntidadeDAO entidadeDAO = new EntidadeDAO();
        Entidade entidade = entidadeDAO.buscar(codigoEntidade);

        System.out.println("Código: " + entidade.getCodigo());
        BairroDAO bairroDAO = new BairroDAO();
        Bairro bairro = bairroDAO.buscar(codigoBairro);

        bairro.setDataCadastro(new Date());
        bairro.setEntidade(entidade);
        bairroDAO.editar(bairro);
    }
}
