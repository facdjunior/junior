package br.com.scesaude.DAOTest;

import br.com.scesaude.dao.EstadoCivilDAO;
import br.com.scesaude.domain.EstadoCivil;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Francisco Alves 2016-09-02
 */
public class EstadoCivilDAOTest {

    @Test
    @Ignore
    public void salvar() {

        EstadoCivil estadoCivil = new EstadoCivil();

        estadoCivil.setDescricao("OUTROS");
        estadoCivil.setDataCadastro(new Date());
        estadoCivil.setSequencia(1);

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        estadoCivilDAO.merge(estadoCivil);

    }

    @Test
    @Ignore
    public void listar() {

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        List<EstadoCivil> resultado = estadoCivilDAO.listar();

        System.err.println("Total de Registros Encontrados: " + resultado.size());

        for (EstadoCivil estadoCivil : resultado) {
            System.out.println(estadoCivil.getCodigo() + " - " + estadoCivil.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        Long codigo = 1L;

        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(codigo);

        if (estadoCivil == null) {
            System.out.println("Nenhum registro Encontrado");
        } else {
            System.out.println(estadoCivil.getCodigo() + " - " + estadoCivil.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(codigo);

        if (estadoCivil == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            //  fabricanteDAO.excluir(fabricante);
            System.out.println("Registro editado com Sucesso");
            System.out.println(estadoCivil.getCodigo() + "-" + estadoCivil.getDescricao());

            estadoCivil.setDataCadastro(new Date());
            estadoCivil.setDescricao("OUTROS");
            estadoCivil.setSequencia(1);

            estadoCivilDAO.editar(estadoCivil);
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 8L;
        EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(codigo);

        if (estadoCivil == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            estadoCivilDAO.excluir(estadoCivil);
            System.out.println("Registro removido");
            System.out.println(estadoCivil.getCodigo() + "-" + estadoCivil.getDescricao());
        }
    }
}
