package br.com.scesaude.DAOTest;

import br.com.scesaude.dao.BairroDAO;
import br.com.scesaude.dao.EntidadeDAO;
import br.com.scesaude.dao.TipoEntidadeDAO;
import br.com.scesaude.domain.Bairro;
import br.com.scesaude.domain.Endereco;
import br.com.scesaude.domain.Entidade;
import br.com.scesaude.domain.Pessoa;
import br.com.scesaude.domain.PessoaJuridica;
import br.com.scesaude.domain.TipoEntidade;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Francisco Alves 2016-09-03
 */
public class EntidadeDAOTest {

    @Test
    @Ignore
    public void salvar() {

        Long codigoBairro = 1L;
        Long codigoEntidade = 1L;

        BairroDAO bairroDAO = new BairroDAO();
        Bairro bairro = bairroDAO.buscar(codigoBairro);

        TipoEntidadeDAO tipoEntidadeDAO = new TipoEntidadeDAO();
        TipoEntidade tipoEntidade = tipoEntidadeDAO.buscar(codigoEntidade);
//Pesquisa tipo de entidade e Bairro para preenchimento dos demais dados//

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Nome Pessoa Juridica3");
        pessoa.setDataCadastro(new Date());
        pessoa.setSequencia(1);

        Endereco endereco = new Endereco();
        endereco.setBairro(bairro);
        endereco.setCep("77.807-290");
        endereco.setComplemento("complemento");
        endereco.setLogradouro("Rua Falcao Coelho");
        endereco.setNumero(1044);
        endereco.setPessoa(pessoa);

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCNPJ("00.000.000/0001-00");
        pessoaJuridica.setDataCadastro(new Date());
        pessoaJuridica.setPessoa(pessoa);

        EntidadeDAO entidadeDAO = new EntidadeDAO();
        Entidade entidade = new Entidade();
        entidade.setCodigoCNES("123456");
        entidade.setPessoa(pessoa);
        entidade.setEndereco(endereco);
        entidade.setPessoaJuridica(pessoaJuridica);
        entidade.setDataCadastro(new Date());
        entidade.setTipoEntidade(tipoEntidade);
        pessoa.setEntidade(entidade);
        endereco.setEntidade(entidade);
        pessoaJuridica.setEntidade(entidade);
        entidadeDAO.merge(entidade);

    }

    // Criado 2016-09-07 - Francisco Alves
    @Test
    @Ignore
    public void listar() {

        EntidadeDAO entidadeDAO = new EntidadeDAO();
        List<Entidade> resultado = entidadeDAO.listar();

        System.err.println("Total de Registros Encontrados: " + resultado.size());

        for (Entidade entidade : resultado) {
            System.out.println(entidade.getPessoa().getNome() + "-" + entidade.getTipoEntidade());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        Long codigo = 10L;

        EntidadeDAO entidadeDAO = new EntidadeDAO();
        Entidade entidade = entidadeDAO.buscar(codigo);

        System.out.println("Código: " + entidade.getCodigo()
                + " Nome: " + entidade.getPessoa().getNome() + "Razão Social: " + entidade.getTipoEntidade().getDescricao());
    }

    @Test
    @Ignore
    public void excluir() {

        Long codigo = 1L;

        EntidadeDAO entidadeDAO = new EntidadeDAO();
        Entidade entidade = entidadeDAO.buscar(codigo);

        entidadeDAO.excluir(entidade);
        System.out.println("Código: " + entidade.getCodigo());
    }
    
    @Test
    @Ignore
    public void editar(){
        
        Long codigoEntidade = 1L;
        Long codigoBairro = 1L;
        Long codigoTpEntidade = 1L;
        
        BairroDAO bairroDAO = new BairroDAO();
        Bairro bairro = bairroDAO.buscar(codigoBairro);
        
        TipoEntidadeDAO tipoEntidadeDAO = new TipoEntidadeDAO();
        TipoEntidade tipoEntidade = tipoEntidadeDAO.buscar(codigoTpEntidade);
        
        EntidadeDAO entidadeDAO = new EntidadeDAO();
        Entidade entidade = entidadeDAO.buscar(codigoEntidade);
        
        System.out.println("Código: " + entidade.getCodigo());
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Nome Pessoa Juridica3");
        pessoa.setDataCadastro(new Date());
        pessoa.setSequencia(1);

        Endereco endereco = new Endereco();
        endereco.setBairro(bairro);
        endereco.setCep("77.807-290");
        endereco.setComplemento("complemento");
        endereco.setLogradouro("Rua Falcao Coelho");
        endereco.setNumero(1044);
        endereco.setPessoa(pessoa);

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCNPJ("00.000.000/0001-00");
        pessoaJuridica.setDataCadastro(new Date());
        pessoaJuridica.setPessoa(pessoa);
        
        entidade.setCodigoCNES("123456");
        entidade.setPessoa(pessoa);
        entidade.setEndereco(endereco);
        entidade.setPessoaJuridica(pessoaJuridica);
        entidade.setDataCadastro(new Date());
        entidade.setTipoEntidade(tipoEntidade);
        pessoa.setEntidade(entidade);
        endereco.setEntidade(entidade);
        pessoaJuridica.setEntidade(entidade);
        
        entidadeDAO.editar(entidade);
    }

}
