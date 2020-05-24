/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author ALaa
 */
@Named("user")
@SessionScoped
public class UserBean implements Serializable {

    private String name;
    private String password;
    private String greeting;
    private String login;
    private String outCome;

    public String getOutCome() {
        return outCome;
    }

    public void setOutCome(String outCome) {
        this.outCome = outCome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        if (name == null || password == null) {
            return "Please enter values ";
        } else {
            if (name.equals("alaa") && password.equals("1234")) {
//                this.outCome = "welcome";
                ExternalContext ec = FacesContext.getCurrentInstance()
                        .getExternalContext();
                try {
                    ec.redirect(ec.getRequestContextPath()
                            + "/faces/welcome.xhtml");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return "";
            } else {
                return "invalid username or password ,Please try again";
            }
        }
    }
    
    public void validateName(FacesContext fc, UIComponent uic, Object value){
        
            String v = (String) value;
      
        if (v.contains("_")) {

            FacesMessage msg = new FacesMessage("Name validation failed.",
                    "No Underscores.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        
    }

    public String getGreeting() {
        if (name == null || name.length() == 0) {
            return "";
        } else {
            return "welcome ya " + name;
        }
    }
}
