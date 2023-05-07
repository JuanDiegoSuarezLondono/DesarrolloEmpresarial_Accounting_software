/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usta.tunja.ejb;

import com.usta.tunja.entity.Puc;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */

@Stateless
public class PucFacade extends Abstract<Puc> {
    @PersistenceContext (unitName="proyecto1PU")
    private EntityManager _em;

   

    @Override
    protected EntityManager getAdmEntidad() {
        return this. _em;
    }
    
     public PucFacade() {
        super(Puc.class);
    }
    

    
    
}
