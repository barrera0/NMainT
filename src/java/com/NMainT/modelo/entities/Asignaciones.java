/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NMainT.modelo.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nico
 */
@Entity
@Table(name = "asignaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignaciones.findAll", query = "SELECT a FROM Asignaciones a"),
    @NamedQuery(name = "Asignaciones.findByIdcronograma", query = "SELECT a FROM Asignaciones a WHERE a.idcronograma = :idcronograma"),
    @NamedQuery(name = "Asignaciones.findByFechaSolicitudOT", query = "SELECT a FROM Asignaciones a WHERE a.fechaSolicitudOT = :fechaSolicitudOT"),
    @NamedQuery(name = "Asignaciones.findByEstadoSolicitudOT", query = "SELECT a FROM Asignaciones a WHERE a.estadoSolicitudOT = :estadoSolicitudOT"),
    @NamedQuery(name = "Asignaciones.findByFechaAsignacion", query = "SELECT a FROM Asignaciones a WHERE a.fechaAsignacion = :fechaAsignacion"),
    @NamedQuery(name = "Asignaciones.findByEstadoAsignacion", query = "SELECT a FROM Asignaciones a WHERE a.estadoAsignacion = :estadoAsignacion"),
    @NamedQuery(name = "Asignaciones.findByFechaInicio", query = "SELECT a FROM Asignaciones a WHERE a.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Asignaciones.findByFechaFin", query = "SELECT a FROM Asignaciones a WHERE a.fechaFin = :fechaFin"),
    @NamedQuery(name = "Asignaciones.findByDisponibilidad", query = "SELECT a FROM Asignaciones a WHERE a.disponibilidad = :disponibilidad"),
    @NamedQuery(name = "Asignaciones.findByEjecutadoPor", query = "SELECT a FROM Asignaciones a WHERE a.ejecutadoPor = :ejecutadoPor"),
    @NamedQuery(name = "Asignaciones.findByTecnico", query = "SELECT a FROM Asignaciones a WHERE a.tecnico = :tecnico")})
public class Asignaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcronograma")
    private Integer idcronograma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSolicitudOT")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitudOT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estadoSolicitudOT")
    private String estadoSolicitudOT;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaAsignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "estadoAsignacion")
    private String estadoAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "disponibilidad")
    private String disponibilidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ejecutadoPor")
    private String ejecutadoPor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tecnico")
    private String tecnico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsignacion")
    private List<Mantenimientos> mantenimientosList;

    public Asignaciones() {
    }

    public Asignaciones(Integer idcronograma) {
        this.idcronograma = idcronograma;
    }

    public Asignaciones(Integer idcronograma, Date fechaSolicitudOT, String estadoSolicitudOT, Date fechaAsignacion, String estadoAsignacion, Date fechaInicio, Date fechaFin, String disponibilidad, String ejecutadoPor, String tecnico) {
        this.idcronograma = idcronograma;
        this.fechaSolicitudOT = fechaSolicitudOT;
        this.estadoSolicitudOT = estadoSolicitudOT;
        this.fechaAsignacion = fechaAsignacion;
        this.estadoAsignacion = estadoAsignacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.disponibilidad = disponibilidad;
        this.ejecutadoPor = ejecutadoPor;
        this.tecnico = tecnico;
    }

    public Integer getIdcronograma() {
        return idcronograma;
    }

    public void setIdcronograma(Integer idcronograma) {
        this.idcronograma = idcronograma;
    }

    public Date getFechaSolicitudOT() {
        return fechaSolicitudOT;
    }

    public void setFechaSolicitudOT(Date fechaSolicitudOT) {
        this.fechaSolicitudOT = fechaSolicitudOT;
    }

    public String getEstadoSolicitudOT() {
        return estadoSolicitudOT;
    }

    public void setEstadoSolicitudOT(String estadoSolicitudOT) {
        this.estadoSolicitudOT = estadoSolicitudOT;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getEstadoAsignacion() {
        return estadoAsignacion;
    }

    public void setEstadoAsignacion(String estadoAsignacion) {
        this.estadoAsignacion = estadoAsignacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getEjecutadoPor() {
        return ejecutadoPor;
    }

    public void setEjecutadoPor(String ejecutadoPor) {
        this.ejecutadoPor = ejecutadoPor;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    @XmlTransient
    public List<Mantenimientos> getMantenimientosList() {
        return mantenimientosList;
    }

    public void setMantenimientosList(List<Mantenimientos> mantenimientosList) {
        this.mantenimientosList = mantenimientosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcronograma != null ? idcronograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaciones)) {
            return false;
        }
        Asignaciones other = (Asignaciones) object;
        if ((this.idcronograma == null && other.idcronograma != null) || (this.idcronograma != null && !this.idcronograma.equals(other.idcronograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.NMainT.modelo.entities.Asignaciones[ idcronograma=" + idcronograma + " ]";
    }
    
}
