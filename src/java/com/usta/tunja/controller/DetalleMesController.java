/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usta.tunja.controller;

import com.usta.tunja.ejb.DetalleMesFacade;
import com.usta.tunja.entity.CargoPersona;
import com.usta.tunja.entity.DetalleMes;
import com.usta.tunja.utility.Forms;
import com.usta.tunja.utility.Mensajes;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;


@ManagedBean(name = "detallemesController")
@SessionScoped

public class DetalleMesController implements Serializable{
    
    @EJB
    private DetalleMesFacade _ejbFacade;
    private DetalleMes objActual;
    private CargoPersona objForaneo;

    public DetalleMesController() {
    } 

    public DetalleMes getField() {
        if (this.objActual == null) {
            this.objActual = new DetalleMes();
        }
        return this.objActual;
    }
    
    public CargoPersona getFieldForaneo() {
        if (this.objForaneo == null) {
            this.objForaneo = new CargoPersona();
        }
        objActual.setCargoPersona(objForaneo);
        return this.objForaneo;
    }

    public DetalleMesFacade getFacade() {
        return this._ejbFacade;
    }

    public String saveDetalleMes() {
    String text, detail;
    try{
            text = "Exito";
            detail = ResourceBundle.getBundle("/com/usta/tunja/utility/txtaccount").getString("MsgGrabarExito");
            getFacade().grabar(objActual);
            Mensajes.exito(text, detail);
            return "ListDetalleMes";
        }catch(Exception e){
            text = "Error";
            detail = ResourceBundle.getBundle("/com/usta/tunja/utility/txtaccount").getString("MsgGrabarError");
            Mensajes.error(text, detail);
            return "CreateDetalleMes";
        }
    }

    public String deleteDetalleMes(DetalleMes detalleMes) {

        objActual = detalleMes;

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("/com/usta/tunja/utility/txtaccount").getString("MsgExitoEliminar");
            getFacade().borrar(objActual);
            Mensajes.exito(text, detail);
            return "ListDetalleMes";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateDetalleMes";
        }
    }
    
     public String updateDetalleMes(DetalleMes detalleMes) {

        objActual = detalleMes;

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("/com/usta/tunja/utility/txtaccount").getString("MsgActualizar");
            getFacade().actualizar(objActual);
            Mensajes.exito(text, detail);
            return "ListDetalleMes";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateDetalleMes";
        }
    }
     
     public String LoadDetalleMes(DetalleMes detalleMes){
         objActual = detalleMes;
         return "updateDetalleMes";
     }
    
    
    

    public List<DetalleMes> getDetalleMesList() {
        return getFacade().listar();
    }
    
    public SelectItem[] getListadoCombo (String value){
        return Forms.addObject(getFacade().listar(), value);
    }

    @FacesConverter(forClass = DetalleMes.class, value = "detallemesController")
    public static class detalleMesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            try {

                int id = Integer.parseInt(value);
                DetalleMesController controlador;
                ELContext contextoExterno = context.getELContext();
                Application contextoAplicacion = context.getApplication();
                String nombreDecoracionControlador = "detallemesController";

                controlador = (DetalleMesController) contextoAplicacion.getELResolver().getValue(contextoExterno, null, nombreDecoracionControlador);
                return controlador.getFacade().buscar(id);
            } catch (NumberFormatException error) {
                return null;
            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            if (value instanceof DetalleMes) {
                DetalleMes obj = (DetalleMes) value;
                return String.valueOf(obj.getIdDetalleMes());
            }
            return null;
        }
    }
}