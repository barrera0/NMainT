/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NMainT.modelo.facades;

import com.NMainT.modelo.entities.Ordenesdetrabajo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nico
 */
@Stateless
public class OrdenesdetrabajoFacade extends AbstractFacade<Ordenesdetrabajo> {

    @PersistenceContext(unitName = "crudPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenesdetrabajoFacade() {
        super(Ordenesdetrabajo.class);
    }
    
}
