package br.com.scesaude.DAOTest;

import br.com.scesaude.dao.BairroDAO;
import br.com.scesaude.dao.FuncionarioDAO;
import br.com.scesaude.dao.PessoaFisicaDAO;
import br.com.scesaude.dao.TipoFuncionarioDAO;
import br.com.scesaude.domain.Bairro;
import br.com.scesaude.domain.Contato;
import br.com.scesaude.domain.Endereco;
import br.com.scesaude.domain.Entidade;
import br.com.scesaude.domain.Funcionario;
import br.com.scesaude.domain.Pessoa;
import br.com.scesaude.domain.PessoaFisica;
import br.com.scesaude.domain.TipoFuncionario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Alves 2016-09-09
 */
public class FuncionarioDAOTest {

    @Test
    @Ignore
    public void salvar() throws ParseException {

        Long codigoBairro = 1L;
        Long codigoEntidade = 2L;

        BairroDAO bairroDAO = new BairroDAO();
        Bairro bairro = bairroDAO.buscar(codigoBairro);

        TipoFuncionarioDAO tipoFuncionarioDAO = new TipoFuncionarioDAO();
        TipoFuncionario tipoFuncionario = tipoFuncionarioDAO.buscar(codigoEntidade);
//Pesquisa tipo de entidade e Bairro para preenchimento dos demais dados//

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Francisco Alves Cabral de Oliveira Junior");
        pessoa.setDataCadastro(new Date());
        pessoa.setSequencia(1);

        Endereco endereco = new Endereco();
        endereco.setBairro(bairro);
        endereco.setCep("77.807-290");
        endereco.setComplemento("complemento");
        endereco.setLogradouro("Rua Falcao Coelho");
        endereco.setNumero(1044);
        endereco.setPessoa(pessoa);

        Contato contato = new Contato();
        contato.setPessoa(pessoa);
        contato.setCelular("(63)9230-6498");
        contato.setEmail("facdjunior@gmail.com");
        contato.setFax("(63)3413-7100");
        contato.setSite("www.scesaude.com.br");
        contato.setSkype("facdjunior");
        contato.setTelefone("(63)3415-4201");

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica pessoaFisica = new PessoaFisica();

        pessoaFisica.setCPF("959.905.501-20");
        pessoaFisica.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("22/02/1982"));
        pessoaFisica.setContato(contato);
        pessoaFisica.setDataEmissaoRg(new SimpleDateFormat("dd/MM/yyyy").parse("10/09/2000"));
        pessoaFisica.setEndereco(endereco);
        pessoaFisica.setEstadoCivil("S");
        pessoaFisica.setMae("Maria do Socorro Soares Oliveira");
        pessoaFisica.setOrgaoEmissor("SSP-TO");
        pessoaFisica.setPai("Francisco Alves Cabral de Oliveira Junior");
        pessoaFisica.setRaca("P");
        pessoaFisica.setRg("294.512");
        pessoaFisica.setSexo(new Character('M'));
        pessoaFisica.setTipoFuncionario(tipoFuncionario);
        pessoaFisica.setTipoSaguineo("AB");
        pessoaFisica.setPessoa(pessoa);

        // Entidade entidade = new Entidade();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario();

        funcionario.setCarteiraTrabalho("123456");
        funcionario.setPessoa(pessoa);
        funcionario.setContato(contato);
        funcionario.setTipoFuncionario(tipoFuncionario);
        funcionario.setEndereco(endereco);
        funcionario.setPessoaFisica(pessoaFisica);
        funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("01/08/2016"));
        funcionario.setNumeroANS("2536");
        funcionario.setDataCadastro(new Date());
        funcionario.setSequencia(1);

        funcionarioDAO.merge(funcionario);
    }

    @Test
    @Ignore
    public void listar() {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        List<Funcionario> resultado = funcionarioDAO.listar();

        System.err.println("Total de Registros Encontrados: " + resultado.size());

        for (Funcionario funcionario : resultado) {
            System.out.println(funcionario.getPessoa().getNome() + "-" + funcionario.getEndereco());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        Long codigo = 9L;

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = funcionarioDAO.buscar(codigo);

        System.out.println("Código: " + funcionario.getCodigo()
                + " Nome: " + funcionario.getPessoa().getNome() + "Razão Social: " + funcionario.getTipoFuncionario());
    }
    
    @Test
    @Ignore
    public void excluir() {

        Long codigo = 1L;

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = funcionarioDAO.buscar(codigo);

        funcionarioDAO.excluir(funcionario);
        System.out.println("Código: " + funcionario.getCodigo());
    }
}
