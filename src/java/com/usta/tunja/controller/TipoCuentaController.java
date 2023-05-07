/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usta.tunja.controller;


import com.usta.tunja.ejb.TipoCuentaFacade;
import com.usta.tunja.entity.TipoCuenta;
import com.usta.tunja.utility.Forms;
import com.usta.tunja.utility.Mensajes;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;


@ManagedBean(name = "tipocuentaController")
@RequestScoped

public class TipoCuentaController implements Serializable{
    
    @EJB

    private TipoCuentaFacade _ejbFacade;
    private TipoCuenta _objActual;

    public TipoCuentaController() {
    }

    public TipoCuenta getField() {
        if (this._objActual == null) {
            this._objActual = new TipoCuenta();
        }
        return this._objActual;
    }

    public TipoCuentaFacade getFacade() {
        return this._ejbFacade;
    }

    public String saveTipoCuenta() {

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("/com/usta/tunja/utility/txtaccount").getString("MsgExitoTipoCuenta");
            getFacade().grabar(_objActual);
            Mensajes.exito(text, detail);
            return "ListTipoCuenta";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateTipoCuenta";
        }
    }

    public String deleteTipoCuenta(TipoCuenta tipo) {

        _objActual = tipo;

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("/com/usta/tunja/utility/txtaccount").getString("MsgEliminarTipoCuenta");
            getFacade().borrar(_objActual);
            Mensajes.exito(text, detail);
            return "ListTipoCuenta";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateTipoCuenta";
        }
    }
    
     public String updateTipoCuenta(TipoCuenta tipo) {

        _objActual = tipo;

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("/co/edu/usta/tunja/taller1/utility/txtaccount").getString("MsgActualizar");
            getFacade().actualizar(_objActual);
            Mensajes.exito(text, detail);
            return "ListTipoCuenta";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateTipoCuenta";
        }
    }
     
     public String LoadTipoCuenta(TipoCuenta tipo){
         _objActual = tipo;
         return "updateTipoCuenta";
     }
    
    
    

    public List<TipoCuenta> getTipoCuentaList() {
        return getFacade().listar();
    }
    
    public SelectItem[] getListadoCombo (String value){
        return Forms.addObject(getFacade().listar(), value);
    }

    @FacesConverter(forClass = TipoCuenta.class, value = "tipocuentaController")
    public static class tipocuentaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            try {

                int id = Integer.parseInt(value);
                TipoCuentaController controlador;
                ELContext contextoExterno = context.getELContext();
                Application contextoAplicacion = context.getApplication();
                String nombreDecoracionControlador = "tipocuentaController";

                controlador = (TipoCuentaController) contextoAplicacion.getELResolver().getValue(contextoExterno, null, nombreDecoracionControlador);
                return controlador.getFacade().buscar(id);
            } catch (NumberFormatException error) {
                return null;
            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            if (value instanceof TipoCuenta) {
                TipoCuenta obj = (TipoCuenta) value;
                return String.valueOf(obj.getIdTipoCuenta());
            }
            return null;
        }
    }
}
