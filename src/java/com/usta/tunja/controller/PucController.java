/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usta.tunja.controller;

import com.usta.tunja.ejb.PucFacade;
import com.usta.tunja.entity.Puc;
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


@ManagedBean(name = "pucController")
@RequestScoped

public class PucController implements Serializable{
    
    @EJB

    private PucFacade _ejbFacade;
    private Puc _objActual;

    public PucController() {
    }

    public Puc getField() {
        if (this._objActual == null) {
            this._objActual = new Puc();
        }
        return this._objActual;
    }

    public PucFacade getFacade() {
        return this._ejbFacade;
    }

    public String savePuc() {

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("com/usta/tunja/utility/txtaccount").getString("MsgGrabarExito");
            getFacade().grabar(_objActual);
            Mensajes.exito(text, detail);
            return "ListPuc";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreatePuc";
        }
    }

    public String deletePuc(Puc puc) {

        _objActual = puc;

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("com/usta/tunja/utility/txtaccount").getString("MsgExitoEliminar");
            getFacade().borrar(_objActual);
            Mensajes.exito(text, detail);
            return "ListPuc";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreatePuc";
        }
    }
    
     public String updatePuc(Puc puc) {

        _objActual = puc;

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("co/edu/usta/tunja/taller1/utility/txtaccount").getString("MsgActualizar");
            getFacade().actualizar(_objActual);
            Mensajes.exito(text, detail);
            return "ListPuc";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreatePuc";
        }
    }
     
     public String LoadPuc(Puc puc){
         _objActual = puc;
         return "updatePuc";
     }
    
    
    

    public List<Puc> getPucList() {
        return getFacade().listar();
    }
    
    public SelectItem[] getListadoCombo (String value){
        return Forms.addObject(getFacade().listar(), value);
    }

    @FacesConverter(forClass = Puc.class, value = "pucController")
    public static class pucControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            try {

                int id = Integer.parseInt(value);
                PucController controlador;
                ELContext contextoExterno = context.getELContext();
                Application contextoAplicacion = context.getApplication();
                String nombreDecoracionControlador = "pucController";

                controlador = (PucController) contextoAplicacion.getELResolver().getValue(contextoExterno, null, nombreDecoracionControlador);
                return controlador.getFacade().buscar(id);
            } catch (NumberFormatException error) {
                return null;
            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            if (value instanceof Puc) {
                Puc obj = (Puc) value;
                return String.valueOf(obj.getIdPuc());
            }
            return null;
        }
    }
}
