/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmunoz.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent uIComponent, Object value) throws ValidatorException {        
        Pattern patron = Pattern.compile("\\w+@\\w+\\.\\w+");
        Matcher matcher = patron.matcher((CharSequence)value);
        HtmlInputText htmlInputText = (HtmlInputText) uIComponent;
        String label;
        if(htmlInputText.getLabel() == null || htmlInputText.getLabel().trim().equals("")){
            label = htmlInputText.getId();
        }else{
            label = htmlInputText.getLabel();
        }
        
        if(!matcher.matches()){
            FacesMessage facesMessage = new FacesMessage(label+": No es una dirección email válida");
            throw new ValidatorException(facesMessage);
        }
    }
    
}
