/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NMainT.modelo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nico
 */
@Entity
@Table(name = "detallemttos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallemttos.findAll", query = "SELECT d FROM Detallemttos d"),
    @NamedQuery(name = "Detallemttos.findByIdEquipo", query = "SELECT d FROM Detallemttos d WHERE d.detallemttosPK.idEquipo = :idEquipo"),
    @NamedQuery(name = "Detallemttos.findByIdMtto", query = "SELECT d FROM Detallemttos d WHERE d.detallemttosPK.idMtto = :idMtto"),
    @NamedQuery(name = "Detallemttos.findByEstadoEquipo", query = "SELECT d FROM Detallemttos d WHERE d.estadoEquipo = :estadoEquipo"),
    @NamedQuery(name = "Detallemttos.findByFechaEstadoEquipo", query = "SELECT d FROM Detallemttos d WHERE d.fechaEstadoEquipo = :fechaEstadoEquipo")})
public class Detallemttos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallemttosPK detallemttosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estadoEquipo")
    private String estadoEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEstadoEquipo")
    @Temporal(TemporalType.DATE)
    private Date fechaEstadoEquipo;
    @JoinColumn(name = "idEquipo", referencedColumnName = "idEquipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipos equipos;
    @JoinColumn(name = "idMtto", referencedColumnName = "idMtto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Mantenimientos mantenimientos;

    public Detallemttos() {
    }

    public Detallemttos(DetallemttosPK detallemttosPK) {
        this.detallemttosPK = detallemttosPK;
    }

    public Detallemttos(DetallemttosPK detallemttosPK, String estadoEquipo, Date fechaEstadoEquipo) {
        this.detallemttosPK = detallemttosPK;
        this.estadoEquipo = estadoEquipo;
        this.fechaEstadoEquipo = fechaEstadoEquipo;
    }

    public Detallemttos(int idEquipo, int idMtto) {
        this.detallemttosPK = new DetallemttosPK(idEquipo, idMtto);
    }

    public DetallemttosPK getDetallemttosPK() {
        return detallemttosPK;
    }

    public void setDetallemttosPK(DetallemttosPK detallemttosPK) {
        this.detallemttosPK = detallemttosPK;
    }

    public String getEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(String estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }

    public Date getFechaEstadoEquipo() {
        return fechaEstadoEquipo;
    }

    public void setFechaEstadoEquipo(Date fechaEstadoEquipo) {
        this.fechaEstadoEquipo = fechaEstadoEquipo;
    }

    public Equipos getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipos equipos) {
        this.equipos = equipos;
    }

    public Mantenimientos getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(Mantenimientos mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallemttosPK != null ? detallemttosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallemttos)) {
            return false;
        }
        Detallemttos other = (Detallemttos) object;
        if ((this.detallemttosPK == null && other.detallemttosPK != null) || (this.detallemttosPK != null && !this.detallemttosPK.equals(other.detallemttosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.NMainT.modelo.entities.Detallemttos[ detallemttosPK=" + detallemttosPK + " ]";
    }
    
}
