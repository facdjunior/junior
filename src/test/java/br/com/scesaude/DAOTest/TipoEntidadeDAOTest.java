package br.com.scesaude.DAOTest;

import br.com.scesaude.dao.EstadoCivilDAO;
import br.com.scesaude.dao.TipoEntidadeDAO;
import br.com.scesaude.domain.EstadoCivil;
import br.com.scesaude.domain.TipoEntidade;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Francisco Alves
 */
public class TipoEntidadeDAOTest {

    @Test
    @Ignore
    public void salvar() {

        TipoEntidade tipoEntidade = new TipoEntidade();

        tipoEntidade.setDescricao("GERAL");
        //tipoEntidade.setEntidade(1L);
        //tipoEntidade.setChaveMaster("testechave");
        tipoEntidade.setDataCadastro(new Date());
        tipoEntidade.setSequencia(1);

        TipoEntidadeDAO tipoEntidadeDAO = new TipoEntidadeDAO();
        tipoEntidadeDAO.merge(tipoEntidade);

    }

    @Test
    @Ignore
    public void listar() {

        TipoEntidadeDAO tipoEntidadeDAO = new TipoEntidadeDAO();
        List<TipoEntidade> resultado = tipoEntidadeDAO.listar();

        System.err.println("Total de Registros Encontrados: " + resultado.size());

        for (TipoEntidade tipoEntidade : resultado) {
            System.out.println(tipoEntidade.getCodigo() + " - " + tipoEntidade.getDescricao());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        Long codigo = 2L;

        TipoEntidadeDAO tipoEntidadeDAO = new TipoEntidadeDAO();
        TipoEntidade tipoEntidade = tipoEntidadeDAO.buscar(codigo);

        if (tipoEntidade == null) {
            System.out.println("Nenhum registro Encontrado");
        } else {
            System.out.println(tipoEntidade.getCodigo() + " - " + tipoEntidade.getDescricao());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Long codigo = 1L;
        TipoEntidadeDAO tipoEntidadeDAO = new TipoEntidadeDAO();
        TipoEntidade tipoEntidade = tipoEntidadeDAO.buscar(codigo);

        if (tipoEntidade == null) {
            System.out.println("Nenhum registro encontrado");
        } else {

            //  fabricanteDAO.excluir(fabricante);
            System.out.println("Registro editado com Sucesso");
            System.out.println(tipoEntidade.getCodigo() + "-" + tipoEntidade.getDescricao());
            tipoEntidade.setDataCadastro(new Date());
            //tipoEntidade.setEntidade(1L);
            //estadoCivil.setSequencia(2);

            tipoEntidadeDAO.editar(tipoEntidade);

        }

    }

    @Test
    @Ignore
    public void excluir() {
        Long codigo = 8L;
        TipoEntidadeDAO tipoEntidadeDAO = new TipoEntidadeDAO();
        TipoEntidade tipoEntidade = tipoEntidadeDAO.buscar(codigo);

        if (tipoEntidade == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            tipoEntidadeDAO.excluir(tipoEntidade);
            System.out.println("Registro removido");
            System.out.println(tipoEntidade.getCodigo() + "-" + tipoEntidade.getDescricao());
        }
    }

}
