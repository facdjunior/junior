package br.com.scesaude.dao;

import br.com.scesaude.domain.Bairro;
import br.com.scesaude.domain.Cidade;
import br.com.scesaude.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Francisco Alves 2016-09-08
 */
public class BairroDAO extends GenericDAO<Bairro>{
    
      @SuppressWarnings("unchecked")
    public List<Bairro> buscaPorCidade(Long cidadeCodigo){
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        
        try {
            Criteria consulta = sessao.createCriteria(Bairro.class);
            consulta.add(Restrictions.eq("cidade.codigo", cidadeCodigo));
            
            consulta.addOrder(Order.asc("descricao"));
            List<Bairro> resultado = consulta.list();
            return resultado;
            
        } catch (RuntimeException erro) {
            throw erro;
        }finally{
            sessao.close();
        }
    }
}
