package br.com.scesaude.DAOTest;

import br.com.scesaude.dao.CidadeDAO;
import br.com.scesaude.dao.EstadoDAO;
import br.com.scesaude.domain.Cidade;
import br.com.scesaude.domain.Estado;
import java.util.List;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Francisco Alves 2016-09-02
 */
public class CidadeDAOTest {

    @Test
    @Ignore
    public void salvar() {

        EstadoDAO estadoDAO = new EstadoDAO();
        Estado estado = estadoDAO.buscar(2L);

        Cidade cidade = new Cidade();
        cidade.setNome("Teste para exclusão");
        cidade.setCodIBGE(120001L);
        cidade.setEstado(estado);

        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.salvar(cidade);
    }

    @Test
    @Ignore
    public void listar() {

        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> resultado = cidadeDAO.listar();

        for (Cidade cidade : resultado) {
            System.out.println("Código: " + cidade.getCodigo()
                    + " - " + cidade.getCodIBGE() + "-" + cidade.getNome() + " - " + cidade.getEstado().getSigla());

        }
    }

    @Test
    @Ignore
    public void buscar() {
        Long codigo = 1L;

        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidade = cidadeDAO.buscar(codigo);

        System.out.println("Código: " + cidade.getCodigo()
                + " Cidade: " + cidade.getCodIBGE() + "-" + cidade.getNome() + " - " + cidade.getEstado().getSigla());
    }

    @Test
    @Ignore
    public void excluir() {

        Long codigo = 2L;

        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidade = cidadeDAO.buscar(codigo);

        cidadeDAO.excluir(cidade);
        System.out.println("Código: " + cidade.getCodigo()
                + " Cidade: " + cidade.getCodIBGE() + "-" + cidade.getNome() + " - " + cidade.getEstado().getSigla());
    }

    @Test
    @Ignore
    public void editar() {

        Long codigoCidade = 1L;
        Long codigoEstado = 2L;

        EstadoDAO estadoDAO = new EstadoDAO();
        Estado estado = estadoDAO.buscar(codigoEstado);

        System.out.println("Código: " + estado.getCodigo() + estado.getNome());

        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidade = cidadeDAO.buscar(codigoCidade);

        System.out.println("Código: " + cidade.getCodigo()
                + " Cidade: " + cidade.getCodIBGE() + "-" + cidade.getNome() + " - " + cidade.getEstado().getSigla());

        cidade.setNome("ACRELÂNDIA");
        cidade.setEstado(estado);

        cidadeDAO.editar(cidade);
    }

    @Test
    @Ignore
    public void puscarPorEstado() {
        Long estadoCodigo = 1L;

        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> resultado = cidadeDAO.buscaPorEstado(estadoCodigo);

        for (Cidade cidade : resultado) {
            System.out.println(cidade.getCodigo() + "-" + cidade.getNome() + " - " + cidade.getEstado());
        }
    }
}
