
package br.com.scesaude.utilTest;

import br.com.scesaude.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Ignore;

/**
 *
 * @author Francisco Alves
 */
public class HibernateUtilTest {
    
    @Test
   // @Ignore
    public void conectar(){
        Session teste = HibernateUtil.getFabricaDeSessoes().openSession();
        teste.close();
        HibernateUtil.getFabricaDeSessoes().close();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
}
