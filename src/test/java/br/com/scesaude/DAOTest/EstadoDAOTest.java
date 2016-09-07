package br.com.scesaude.DAOTest;

import br.com.scesaude.dao.EstadoCivilDAO;
import br.com.scesaude.dao.EstadoDAO;
import br.com.scesaude.domain.Estado;
import br.com.scesaude.domain.EstadoCivil;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Francisco Alves 2016-09-02
 */
public class EstadoDAOTest {

    @Test
    @Ignore
    public void salvar() {

        Estado estado = new Estado();

        estado.setNome("Distrito Federal");
        estado.setSigla("DF");
        estado.setCodIBGE(53);
        estado.setSequencia(27);

        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.merge(estado);

    }

    @Test
    @Ignore
    public void listar() {

        EstadoDAO estadoDAO = new EstadoDAO();
        List<Estado> resultado = estadoDAO.listar();

        System.err.println("Total de Registros Encontrados: " + resultado.size());

        for (Estado estado : resultado) {
            System.out.println(estado.getCodigo() + " - " + estado.getNome());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        Long codigo = 1L;

        EstadoDAO estadoDAO = new EstadoDAO();
        Estado estado = estadoDAO.buscar(codigo);

        if (estado == null) {
            System.out.println("Nenhum registro Encontrado");
        } else {
            System.out.println(estado.getCodigo() + " - " + estado.getNome());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        EstadoDAO estadoDAO = new EstadoDAO();
        Estado estado = estadoDAO.buscar(codigo);

        if (estado == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            //  fabricanteDAO.excluir(fabricante);
            System.out.println("Registro editado com Sucesso");
            System.out.println(estado.getCodigo() + "-" + estado.getNome());

            estado.setSigla("RO");
            
            estadoDAO.editar(estado);
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 8L;
        EstadoDAO estadoDAO = new EstadoDAO();
        Estado estado = estadoDAO.buscar(codigo);

        if (estado == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            estadoDAO.excluir(estado);
            System.out.println("Registro removido");
            System.out.println(estado.getCodigo() + "-" + estado.getNome());
        }
    }
}
