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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "novedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedades.findAll", query = "SELECT n FROM Novedades n"),
    @NamedQuery(name = "Novedades.findByIdNovedad", query = "SELECT n FROM Novedades n WHERE n.idNovedad = :idNovedad"),
    @NamedQuery(name = "Novedades.findByDescripcionN", query = "SELECT n FROM Novedades n WHERE n.descripcionN = :descripcionN"),
    @NamedQuery(name = "Novedades.findByFechaN", query = "SELECT n FROM Novedades n WHERE n.fechaN = :fechaN")})
public class Novedades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNovedad")
    private Integer idNovedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcionN")
    private String descripcionN;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaN")
    @Temporal(TemporalType.DATE)
    private Date fechaN;
    @JoinColumn(name = "fkIdUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios fkIdUsuario;

    public Novedades() {
    }

    public Novedades(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public Novedades(Integer idNovedad, String descripcionN, Date fechaN) {
        this.idNovedad = idNovedad;
        this.descripcionN = descripcionN;
        this.fechaN = fechaN;
    }

    public Integer getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public String getDescripcionN() {
        return descripcionN;
    }

    public void setDescripcionN(String descripcionN) {
        this.descripcionN = descripcionN;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
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
        hash += (idNovedad != null ? idNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedades)) {
            return false;
        }
        Novedades other = (Novedades) object;
        if ((this.idNovedad == null && other.idNovedad != null) || (this.idNovedad != null && !this.idNovedad.equals(other.idNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.NMainT.modelo.entities.Novedades[ idNovedad=" + idNovedad + " ]";
    }
    
}
