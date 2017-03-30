/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NMainT.modelo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nico
 */
@Embeddable
public class DetallemttosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idEquipo")
    private int idEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMtto")
    private int idMtto;

    public DetallemttosPK() {
    }

    public DetallemttosPK(int idEquipo, int idMtto) {
        this.idEquipo = idEquipo;
        this.idMtto = idMtto;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdMtto() {
        return idMtto;
    }

    public void setIdMtto(int idMtto) {
        this.idMtto = idMtto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEquipo;
        hash += (int) idMtto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallemttosPK)) {
            return false;
        }
        DetallemttosPK other = (DetallemttosPK) object;
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        if (this.idMtto != other.idMtto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.NMainT.modelo.entities.DetallemttosPK[ idEquipo=" + idEquipo + ", idMtto=" + idMtto + " ]";
    }
    
}
