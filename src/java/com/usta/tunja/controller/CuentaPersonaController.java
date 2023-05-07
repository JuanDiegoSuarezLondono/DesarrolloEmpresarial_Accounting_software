/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usta.tunja.controller;

import com.usta.tunja.ejb.CuentaPersonaFacade;
import com.usta.tunja.entity.CuentaPersona;
import com.usta.tunja.utility.Forms;
import com.usta.tunja.utility.Mensajes;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named(value = "cuentapersonaController")
@RequestScoped

public class CuentaPersonaController implements Serializable{
    
    @EJB

    private CuentaPersonaFacade _ejbFacade;
    private CuentaPersona _objActual;

    public CuentaPersonaController() {
    }

    public CuentaPersona getField() {
        if (this._objActual == null) {
            this._objActual = new CuentaPersona();
        }
        return this._objActual;
    }

    public CuentaPersonaFacade getFacade() {
        return this._ejbFacade;
    }

    public String saveCuentaPersona() {

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("com/usta/tunja/utility/txtaccount").getString("MsgExitoCuenta");
            getFacade().grabar(_objActual);
            Mensajes.exito(text, detail);
            return "ListCuentaPersona";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateCuentaPersona";
        }
    }

    public String deleteCuentaPersona(CuentaPersona cp) {

        _objActual = cp;

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("com/usta/tunja/utility/txtaccount").getString("MsgEliminarCuenta");
            getFacade().borrar(_objActual);
            Mensajes.exito(text, detail);
            return "ListCuentaPersona";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateCuentaPersona";
        }
    }
    
     public String updateCuentaPersona(CuentaPersona cp) {

        _objActual = cp;

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("co/edu/usta/tunja/taller1/utility/txtaccount").getString("MsgActualizar");
            getFacade().actualizar(_objActual);
            Mensajes.exito(text, detail);
            return "ListCuentaPersona";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateCuentaPersona";
        }
    }
     
     public String LoadCuentaPersona(CuentaPersona cp){
         _objActual = cp;
         return "updateCuentaPersona";
     }
    
    
    

    public List<CuentaPersona> getCuentaPersonaList() {
        return getFacade().listar();
    }
    
    public SelectItem[] getListadoCombo (String value){
        return Forms.addObject(getFacade().listar(), value);
    }

    @FacesConverter(forClass = CuentaPersona.class, value = "cuentapersonaController")
    public static class cuentapersonaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            try {

                int id = Integer.parseInt(value);
                CuentaPersonaController controlador;
                ELContext contextoExterno = context.getELContext();
                Application contextoAplicacion = context.getApplication();
                String nombreDecoracionControlador = "cuentapersonaController";

                controlador = (CuentaPersonaController) contextoAplicacion.getELResolver().getValue(contextoExterno, null, nombreDecoracionControlador);
                return controlador.getFacade().buscar(id);
            } catch (NumberFormatException error) {
                return null;
            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            if (value instanceof CuentaPersona) {
                CuentaPersona obj = (CuentaPersona) value;
                return String.valueOf(obj.getIdCuentaPersona());
            }
            return null;
        }
    }
}
