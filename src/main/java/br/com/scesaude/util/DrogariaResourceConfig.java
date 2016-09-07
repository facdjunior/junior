package br.com.scesaude.util;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
/**
 *
 * @author Francisco Alves
 */
//http://localhost:8084/Drogarias/rest/drogaria

@ApplicationPath("rests")
public class DrogariaResourceConfig extends ResourceConfig{
    
    public DrogariaResourceConfig(){
        packages("br.com.facdjunior.drogarias.service");
    }
}
