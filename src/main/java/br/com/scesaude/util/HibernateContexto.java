/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scesaude.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Francisco Alves
 */
public class HibernateContexto implements ServletContextListener{
    
    @Override
    public void contextDestroyed(ServletContextEvent event){
        HibernateUtil.getFabricaDeSessoes().close();
    }
    
    @Override
    public void contextInitialized(ServletContextEvent event){
        HibernateUtil.getFabricaDeSessoes();
    }
    
}
