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
@Table(name = "mantenimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimientos.findAll", query = "SELECT m FROM Mantenimientos m"),
    @NamedQuery(name = "Mantenimientos.findByIdMtto", query = "SELECT m FROM Mantenimientos m WHERE m.idMtto = :idMtto"),
    @NamedQuery(name = "Mantenimientos.findByTipoMtto", query = "SELECT m FROM Mantenimientos m WHERE m.tipoMtto = :tipoMtto"),
    @NamedQuery(name = "Mantenimientos.findByEstadoMtto", query = "SELECT m FROM Mantenimientos m WHERE m.estadoMtto = :estadoMtto"),
    @NamedQuery(name = "Mantenimientos.findByNovedad", query = "SELECT m FROM Mantenimientos m WHERE m.novedad = :novedad")})
public class Mantenimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMtto")
    private Integer idMtto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "tipoMtto")
    private String tipoMtto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "estadoMtto")
    private String estadoMtto;
    @Size(max = 200)
    @Column(name = "novedad")
    private String novedad;
    @JoinColumn(name = "idAsignacion", referencedColumnName = "idcronograma")
    @ManyToOne(optional = false)
    private Asignaciones idAsignacion;
    @JoinColumn(name = "idOT", referencedColumnName = "idOT")
    @ManyToOne(optional = false)
    private Ordenesdetrabajo idOT;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mantenimientos")
    private List<Detallemttos> detallemttosList;

    public Mantenimientos() {
    }

    public Mantenimientos(Integer idMtto) {
        this.idMtto = idMtto;
    }

    public Mantenimientos(Integer idMtto, String tipoMtto, String estadoMtto) {
        this.idMtto = idMtto;
        this.tipoMtto = tipoMtto;
        this.estadoMtto = estadoMtto;
    }

    public Integer getIdMtto() {
        return idMtto;
    }

    public void setIdMtto(Integer idMtto) {
        this.idMtto = idMtto;
    }

    public String getTipoMtto() {
        return tipoMtto;
    }

    public void setTipoMtto(String tipoMtto) {
        this.tipoMtto = tipoMtto;
    }

    public String getEstadoMtto() {
        return estadoMtto;
    }

    public void setEstadoMtto(String estadoMtto) {
        this.estadoMtto = estadoMtto;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public Asignaciones getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Asignaciones idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Ordenesdetrabajo getIdOT() {
        return idOT;
    }

    public void setIdOT(Ordenesdetrabajo idOT) {
        this.idOT = idOT;
    }

    @XmlTransient
    public List<Detallemttos> getDetallemttosList() {
        return detallemttosList;
    }

    public void setDetallemttosList(List<Detallemttos> detallemttosList) {
        this.detallemttosList = detallemttosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMtto != null ? idMtto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimientos)) {
            return false;
        }
        Mantenimientos other = (Mantenimientos) object;
        if ((this.idMtto == null && other.idMtto != null) || (this.idMtto != null && !this.idMtto.equals(other.idMtto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.NMainT.modelo.entities.Mantenimientos[ idMtto=" + idMtto + " ]";
    }
    
}
