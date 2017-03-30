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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ordenesdetrabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenesdetrabajo.findAll", query = "SELECT o FROM Ordenesdetrabajo o"),
    @NamedQuery(name = "Ordenesdetrabajo.findByIdOT", query = "SELECT o FROM Ordenesdetrabajo o WHERE o.idOT = :idOT"),
    @NamedQuery(name = "Ordenesdetrabajo.findByEstadoOT", query = "SELECT o FROM Ordenesdetrabajo o WHERE o.estadoOT = :estadoOT"),
    @NamedQuery(name = "Ordenesdetrabajo.findByDescripcionOT", query = "SELECT o FROM Ordenesdetrabajo o WHERE o.descripcionOT = :descripcionOT")})
public class Ordenesdetrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOT")
    private Integer idOT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estadoOT")
    private String estadoOT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "descripcionOT")
    private String descripcionOT;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOT")
    private List<Mantenimientos> mantenimientosList;
    @JoinColumn(name = "fkIdEstacionBase", referencedColumnName = "idestacionBase")
    @ManyToOne(optional = false)
    private Estacionesbase fkIdEstacionBase;
    @JoinColumn(name = "fkIdUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios fkIdUsuario;

    public Ordenesdetrabajo() {
    }

    public Ordenesdetrabajo(Integer idOT) {
        this.idOT = idOT;
    }

    public Ordenesdetrabajo(Integer idOT, String estadoOT, String descripcionOT) {
        this.idOT = idOT;
        this.estadoOT = estadoOT;
        this.descripcionOT = descripcionOT;
    }

    public Integer getIdOT() {
        return idOT;
    }

    public void setIdOT(Integer idOT) {
        this.idOT = idOT;
    }

    public String getEstadoOT() {
        return estadoOT;
    }

    public void setEstadoOT(String estadoOT) {
        this.estadoOT = estadoOT;
    }

    public String getDescripcionOT() {
        return descripcionOT;
    }

    public void setDescripcionOT(String descripcionOT) {
        this.descripcionOT = descripcionOT;
    }

    @XmlTransient
    public List<Mantenimientos> getMantenimientosList() {
        return mantenimientosList;
    }

    public void setMantenimientosList(List<Mantenimientos> mantenimientosList) {
        this.mantenimientosList = mantenimientosList;
    }

    public Estacionesbase getFkIdEstacionBase() {
        return fkIdEstacionBase;
    }

    public void setFkIdEstacionBase(Estacionesbase fkIdEstacionBase) {
        this.fkIdEstacionBase = fkIdEstacionBase;
    }

    public Usuarios getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Usuarios fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOT != null ? idOT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenesdetrabajo)) {
            return false;
        }
        Ordenesdetrabajo other = (Ordenesdetrabajo) object;
        if ((this.idOT == null && other.idOT != null) || (this.idOT != null && !this.idOT.equals(other.idOT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.NMainT.modelo.entities.Ordenesdetrabajo[ idOT=" + idOT + " ]";
    }
    
}
