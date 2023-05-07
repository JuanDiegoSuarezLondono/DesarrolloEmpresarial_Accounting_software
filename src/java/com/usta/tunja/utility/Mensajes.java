/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usta.tunja.utility;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario
 */
public class Mensajes {
    public static void error (String text, String detail){
        FacesMessage mensaje= new FacesMessage(FacesMessage.SEVERITY_FATAL, text,detail);
        FacesContext.getCurrentInstance().addMessage(null,mensaje);
    }
    
    public static void exito (String text, String detail){
        FacesMessage mensaje= new FacesMessage(FacesMessage.SEVERITY_INFO, text,detail);
        FacesContext.getCurrentInstance().addMessage("successInfo",mensaje);
    }
    
}
