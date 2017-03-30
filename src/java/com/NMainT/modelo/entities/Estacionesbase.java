/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NMainT.modelo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nico
 */
@Entity
@Table(name = "estacionesbase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estacionesbase.findAll", query = "SELECT e FROM Estacionesbase e"),
    @NamedQuery(name = "Estacionesbase.findByIdestacionBase", query = "SELECT e FROM Estacionesbase e WHERE e.idestacionBase = :idestacionBase"),
    @NamedQuery(name = "Estacionesbase.findByNombreEB", query = "SELECT e FROM Estacionesbase e WHERE e.nombreEB = :nombreEB"),
    @NamedQuery(name = "Estacionesbase.findByCiudad", query = "SELECT e FROM Estacionesbase e WHERE e.ciudad = :ciudad")})
public class Estacionesbase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestacionBase")
    private Integer idestacionBase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreEB")
    private String nombreEB;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEstacionBase")
    private List<Ordenesdetrabajo> ordenesdetrabajoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstacionBase")
    private List<Equipos> equiposList;

    public Estacionesbase() {
    }

    public Estacionesbase(Integer idestacionBase) {
        this.idestacionBase = idestacionBase;
    }

    public Estacionesbase(Integer idestacionBase, String nombreEB, String ciudad) {
        this.idestacionBase = idestacionBase;
        this.nombreEB = nombreEB;
        this.ciudad = ciudad;
    }

    public Integer getIdestacionBase() {
        return idestacionBase;
    }

    public void setIdestacionBase(Integer idestacionBase) {
        this.idestacionBase = idestacionBase;
    }

    public String getNombreEB() {
        return nombreEB;
    }

    public void setNombreEB(String nombreEB) {
        this.nombreEB = nombreEB;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public List<Ordenesdetrabajo> getOrdenesdetrabajoList() {
        return ordenesdetrabajoList;
    }

    public void setOrdenesdetrabajoList(List<Ordenesdetrabajo> ordenesdetrabajoList) {
        this.ordenesdetrabajoList = ordenesdetrabajoList;
    }

    @XmlTransient
    public List<Equipos> getEquiposList() {
        return equiposList;
    }

    public void setEquiposList(List<Equipos> equiposList) {
        this.equiposList = equiposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestacionBase != null ? idestacionBase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estacionesbase)) {
            return false;
        }
        Estacionesbase other = (Estacionesbase) object;
        if ((this.idestacionBase == null && other.idestacionBase != null) || (this.idestacionBase != null && !this.idestacionBase.equals(other.idestacionBase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.NMainT.modelo.entities.Estacionesbase[ idestacionBase=" + idestacionBase + " ]";
    }
    
}
