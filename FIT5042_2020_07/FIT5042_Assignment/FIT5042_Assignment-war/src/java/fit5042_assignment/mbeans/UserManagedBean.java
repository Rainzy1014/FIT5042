/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042_assignment.mbeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.validation.ValidationException;

/**
 *
 * @author shaohangyu
 */
//@Named(value = "userManagedBean")
@ManagedBean(name = "userManaged", eager = true)
@SessionScoped
public class UserManagedBean implements Serializable {

    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
    }
    
    private String name;
    private String password;

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
    
    public String isLoginSuccess(){
        if("admin".equals("name-id") && ("admin").equals("password-id")){
            return "success";
        }else{
            return "error";
        }
    }
    
}
