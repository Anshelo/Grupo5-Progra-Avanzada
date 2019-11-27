/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mateo
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByCodigoprod", query = "SELECT p FROM Producto p WHERE p.codigoprod = :codigoprod")
    , @NamedQuery(name = "Producto.findByNombreprod", query = "SELECT p FROM Producto p WHERE p.nombreprod = :nombreprod")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByPeso", query = "SELECT p FROM Producto p WHERE p.peso = :peso")
    , @NamedQuery(name = "Producto.findBySensibilidad", query = "SELECT p FROM Producto p WHERE p.sensibilidad = :sensibilidad")
    , @NamedQuery(name = "Producto.findByValorunit", query = "SELECT p FROM Producto p WHERE p.valorunit = :valorunit")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoprod")
    private String codigoprod;
    @Basic(optional = false)
    @Column(name = "nombreprod")
    private String nombreprod;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @Basic(optional = false)
    @Column(name = "sensibilidad")
    private String sensibilidad;
    @Column(name = "valorunit")
    private Double valorunit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProducto")
    private Collection<Guia> guiaCollection;

    public Producto() {
    }

    public Producto(String codigoprod) {
        this.codigoprod = codigoprod;
    }

    public Producto(String codigoprod, String nombreprod, String descripcion, String sensibilidad) {
        this.codigoprod = codigoprod;
        this.nombreprod = nombreprod;
        this.descripcion = descripcion;
        this.sensibilidad = sensibilidad;
    }

    public String getCodigoprod() {
        return codigoprod;
    }

    public void setCodigoprod(String codigoprod) {
        this.codigoprod = codigoprod;
    }

    public String getNombreprod() {
        return nombreprod;
    }

    public void setNombreprod(String nombreprod) {
        this.nombreprod = nombreprod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getSensibilidad() {
        return sensibilidad;
    }

    public void setSensibilidad(String sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    public Double getValorunit() {
        return valorunit;
    }

    public void setValorunit(Double valorunit) {
        this.valorunit = valorunit;
    }

    @XmlTransient
    public Collection<Guia> getGuiaCollection() {
        return guiaCollection;
    }

    public void setGuiaCollection(Collection<Guia> guiaCollection) {
        this.guiaCollection = guiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoprod != null ? codigoprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigoprod == null && other.codigoprod != null) || (this.codigoprod != null && !this.codigoprod.equals(other.codigoprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Producto[ codigoprod=" + codigoprod + " ]";
    }
    
}
