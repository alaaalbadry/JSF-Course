/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ALaa
 */
@FacesConverter("ccConverter")
public class CreditCardConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        CreditCard c = null;
        String [] str = value.split("-");
        if(str.length == 4){
            int [] parts = new int[4];
            for(int i=0;i<4;i++){
                parts[i] = Integer.parseInt(str[i]);
            }
            c = new CreditCard(parts[0],parts[1],parts[2],parts[3]); 
        }else{
            FacesMessage message = new FacesMessage("Conversion error occurred","Invalid Card Number.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        
        CreditCard c = (CreditCard)value;
        int [] parts = c.getParts();
        String s = parts[0]+"-"+parts[1]+"-"+parts[2]+"-"+parts[3];
        System.out.println("ana fe getAs String");
        return s;
    }
    
}
