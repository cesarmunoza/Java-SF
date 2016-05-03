package com.cmunoz.beans;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PersonaController implements Serializable{

    public PersonaController() {
    }
public void salvarPersona(ActionEvent actionEvent){
    FacesMessage facesMessage = new FacesMessage("Datos guardados correctamente");
    facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
    
    FacesContext.getCurrentInstance().addMessage(null, facesMessage);
}
}
