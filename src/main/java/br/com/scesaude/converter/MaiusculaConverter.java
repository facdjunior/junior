package br.com.scesaude.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Francisco Alves 2016-09-03
 */
@FacesConverter("upperCaseConverter")
public class MaiusculaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null){
            return null;
        }else{
            return value.toUpperCase();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value == null){
           return "";
       }else {
           return value.toString();
       }
    }
    
}
