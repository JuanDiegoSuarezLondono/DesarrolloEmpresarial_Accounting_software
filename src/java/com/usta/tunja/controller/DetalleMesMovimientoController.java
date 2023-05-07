/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usta.tunja.controller;

import com.usta.tunja.ejb.DetalleMesMovimientoFacade;
import com.usta.tunja.entity.Cargo;
import com.usta.tunja.entity.CargoPersona;
import com.usta.tunja.entity.Cuenta;
import com.usta.tunja.entity.DetalleMesMovimiento;
import com.usta.tunja.entity.DetalleMesMovimiento_;
import com.usta.tunja.entity.Factura;
import com.usta.tunja.entity.PersonaTipoPersona;
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


@ManagedBean(name = "detallemesmovimientoController")
@SessionScoped

public class DetalleMesMovimientoController implements Serializable{
    
    @EJB
    private DetalleMesMovimientoFacade _ejbFacade;
    private DetalleMesMovimiento objActual;

    public DetalleMesMovimientoController() {
    }

    public DetalleMesMovimiento getField() {
        if (this.objActual == null) {
            this.objActual = new DetalleMesMovimiento();
        }
        return this.objActual;
    }

    public DetalleMesMovimientoFacade getFacade() {
        return this._ejbFacade;
    }

    public String saveDetalleMesMovimiento() {

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("/com/usta/tunja/utility/txtaccount").getString("MsgGrabarExito");
            getFacade().grabar(objActual);
            Mensajes.exito(text, detail);
            return "ListDetalleMesMovimiento";
        } catch (Exception e) {
            text = "error";
            detail = ResourceBundle.getBundle("/com/usta/tunja/utility/txtaccount").getString("MsgGrabarError");
            Mensajes.error(text, detail);
            return "CreateDetalleMesMovimiento";
        }
    }

    public String deleteDetalleMesMovimiento(DetalleMesMovimiento detalleMesMovimiento) {

        objActual = detalleMesMovimiento;

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("/com/usta/tunja/utility/txtaccount").getString("MsgExitoEliminar");
            getFacade().borrar(objActual);
            Mensajes.exito(text, detail);
            return "ListDetalleMesMovimiento";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateDetalleMesMovimiento";
        }
    }
    
     public String updateDetalleMesMovimiento(DetalleMesMovimiento detalleMesMovimiento) {

        objActual = detalleMesMovimiento;

        String text, detail;
        try {
            text = "Exito";
            detail = ResourceBundle.getBundle("/com/usta/tunja/utility/txtaccount").getString("MsgActualizar");
            getFacade().actualizar(objActual);
            Mensajes.exito(text, detail);
            return "ListDetalleMesMovimiento";
        } catch (Exception e) {
            text = "error";
            detail = e.getMessage();
            Mensajes.error(text, detail);
            return "CreateDetalleMesMovimiento";
        }
    }
     
     public String LoadDetalleMesMovimiento(DetalleMesMovimiento detalleMesMovimiento){
         objActual = detalleMesMovimiento;
         return "updateDetalleMesMovimiento";
     }
    
    public List<DetalleMesMovimiento> getDetalleMesMovimientoList() {
        return getFacade().listar();
    }
    
    public SelectItem[] getListadoCombo (String value){
        return Forms.addObject(getFacade().listar(), value);
    }

    @FacesConverter(forClass = Cargo.class, value = "detallemesmovimientoController")
    public static class detalleMesMovimientoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            try {

                int id = Integer.parseInt(value);
                DetalleMesMovimientoController controlador;
                ELContext contextoExterno = context.getELContext();
                Application contextoAplicacion = context.getApplication();
                String nombreDecoracionControlador = "detallemesmovimientoController";

                controlador = (DetalleMesMovimientoController) contextoAplicacion.getELResolver().getValue(contextoExterno, null, nombreDecoracionControlador);
                return controlador.getFacade().buscar(id);
            } catch (NumberFormatException error) {
                return null;
            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            if (value instanceof DetalleMesMovimiento) {
                DetalleMesMovimiento obj = (DetalleMesMovimiento) value;
                return String.valueOf(obj.getIdDetalleMovimiento());
            }
            return null;
        }
    }
}
