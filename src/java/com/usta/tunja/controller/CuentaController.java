/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usta.tunja.controller;

import com.usta.tunja.ejb.CuentaFacade;
import com.usta.tunja.entity.Cuenta;
import com.usta.tunja.utility.Forms;
import com.usta.tunja.utility.Mensajes;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "cuentaController")
@RequestScoped

public class CuentaController implements Serializable{
    
    @EJB

    private CuentaFacade _ejbFacade;
    private Cuenta _objActual;

    public CuentaController() {
    }

    public Cuenta getField() {
        if (this._objActual == null) {
            this._objActual = new Cuenta();
        }
        return this._objActual;
    }

    public CuentaFacade getFacade() {
        return this._ejbFacade;
    }

    public String saveCuenta() {

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("com/usta/tunja/utility/txtaccount").getString("MsgExitoCuenta");
            getFacade().grabar(_objActual);
            Mensajes.exito(text, detail);
            return "ListCuenta";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateCuenta";
        }
    }

    public String deleteCuenta(Cuenta cuenta) {

        _objActual = cuenta;

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("com/usta/tunja/utility/txtaccount").getString("MsgEliminarCuenta");
            getFacade().borrar(_objActual);
            Mensajes.exito(text, detail);
            return "ListCuenta";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateCuenta";
        }
    }
    
     public String updateCuenta(Cuenta cuenta) {

        _objActual = cuenta;

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("co/edu/usta/tunja/taller1/utility/txtaccount").getString("MsgActualizar");
            getFacade().actualizar(_objActual);
            Mensajes.exito(text, detail);
            return "ListCuenta";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateCuenta";
        }
    }
     
     public String LoadCuenta(Cuenta cuenta){
         _objActual = cuenta;
         return "updateCuenta";
     }
    
    
    

    public List<Cuenta> getCuentaList() {
        return getFacade().listar();
    }
    
    public SelectItem[] getListadoCombo (String value){
        return Forms.addObject(getFacade().listar(), value);
    }

    @FacesConverter(forClass = Cuenta.class, value = "cuentaController")
    public static class cuentaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            try {

                int id = Integer.parseInt(value);
                CuentaController controlador;
                ELContext contextoExterno = context.getELContext();
                Application contextoAplicacion = context.getApplication();
                String nombreDecoracionControlador = "cuentaController";

                controlador = (CuentaController) contextoAplicacion.getELResolver().getValue(contextoExterno, null, nombreDecoracionControlador);
                return controlador.getFacade().buscar(id);
            } catch (NumberFormatException error) {
                return null;
            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            if (value instanceof Cuenta) {
                Cuenta obj = (Cuenta) value;
                return String.valueOf(obj.getIdCuenta());
            }
            return null;
        }
    }
}

