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
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e"),
    @NamedQuery(name = "Equipos.findByIdEquipo", query = "SELECT e FROM Equipos e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "Equipos.findByDescripcion", query = "SELECT e FROM Equipos e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Equipos.findByMarca", query = "SELECT e FROM Equipos e WHERE e.marca = :marca"),
    @NamedQuery(name = "Equipos.findBySerie", query = "SELECT e FROM Equipos e WHERE e.serie = :serie"),
    @NamedQuery(name = "Equipos.findByEstadoEquipo", query = "SELECT e FROM Equipos e WHERE e.estadoEquipo = :estadoEquipo")})
public class Equipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEquipo")
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estadoEquipo")
    private String estadoEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipos")
    private List<Detallemttos> detallemttosList;
    @JoinColumn(name = "idEstacionBase", referencedColumnName = "idestacionBase")
    @ManyToOne(optional = false)
    private Estacionesbase idEstacionBase;

    public Equipos() {
    }

    public Equipos(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipos(Integer idEquipo, String descripcion, String marca, String serie, String estadoEquipo) {
        this.idEquipo = idEquipo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.serie = serie;
        this.estadoEquipo = estadoEquipo;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(String estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }

    @XmlTransient
    public List<Detallemttos> getDetallemttosList() {
        return detallemttosList;
    }

    public void setDetallemttosList(List<Detallemttos> detallemttosList) {
        this.detallemttosList = detallemttosList;
    }

    public Estacionesbase getIdEstacionBase() {
        return idEstacionBase;
    }

    public void setIdEstacionBase(Estacionesbase idEstacionBase) {
        this.idEstacionBase = idEstacionBase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.NMainT.modelo.entities.Equipos[ idEquipo=" + idEquipo + " ]";
    }
    
}
