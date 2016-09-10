package br.com.scesaude.DAOTest;

import br.com.scesaude.dao.EstadoCivilDAO;
import br.com.scesaude.dao.TipoFuncionarioDAO;
import br.com.scesaude.domain.EstadoCivil;
import br.com.scesaude.domain.TipoFuncionario;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Francisco Alves 2016-09-09
 */
public class TipoFuncionarioDAOTest {

    @Test
    @Ignore
    public void salvar() {

        TipoFuncionario tipoFuncionario = new TipoFuncionario();

        tipoFuncionario.setDescricao("Administrador");
        tipoFuncionario.setDataCadastro(new Date());
        tipoFuncionario.setSequencia(1);

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        tipoFuncionarioDAO.merge(tipoFuncionario);

    }

    @Test
    @Ignore
    public void listar() {

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        List<TipoFuncionario> resultado = tipoFuncionarioDAO.listar();

        System.err.println("Total de Registros Encontrados: " + resultado.size());

        for (TipoFuncionario tipoFuncionario : resultado) {
            System.out.println(tipoFuncionario.getCodigo() + " - " + tipoFuncionario.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        Long codigo = 1L;

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        TipoFuncionario tipoFuncionario = tipoFuncionarioDAO.buscar(codigo);

        if (tipoFuncionario == null) {
            System.out.println("Nenhum registro Encontrado");
        } else {
            System.out.println(tipoFuncionario.getCodigo() + " - " + tipoFuncionario.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        TipoFuncionario tipoFuncionario = tipoFuncionarioDAO.buscar(codigo);

        if (tipoFuncionario == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            //  fabricanteDAO.excluir(fabricante);
            System.out.println("Registro editado com Sucesso");
            System.out.println(tipoFuncionario.getCodigo() + "-" + tipoFuncionario.getDescricao());

            tipoFuncionario.setDataCadastro(new Date());

            tipoFuncionarioDAO.editar(tipoFuncionario);
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 1L;
        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        TipoFuncionario tipoFuncionario = tipoFuncionarioDAO.buscar(codigo);

        if (tipoFuncionario == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            tipoFuncionarioDAO.excluir(tipoFuncionario);
            System.out.println("Registro removido");
            System.out.println(tipoFuncionario.getCodigo() + "-" + tipoFuncionario.getDescricao());
        }
    }
}
