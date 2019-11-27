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
@Table(name = "zona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zona.findAll", query = "SELECT z FROM Zona z")
    , @NamedQuery(name = "Zona.findByCodigozona", query = "SELECT z FROM Zona z WHERE z.codigozona = :codigozona")
    , @NamedQuery(name = "Zona.findByNombrezona", query = "SELECT z FROM Zona z WHERE z.nombrezona = :nombrezona")})
public class Zona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigozona")
    private String codigozona;
    @Basic(optional = false)
    @Column(name = "nombrezona")
    private String nombrezona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codZona")
    private Collection<Guia> guiaCollection;

    public Zona() {
    }

    public Zona(String codigozona) {
        this.codigozona = codigozona;
    }

    public Zona(String codigozona, String nombrezona) {
        this.codigozona = codigozona;
        this.nombrezona = nombrezona;
    }

    public String getCodigozona() {
        return codigozona;
    }

    public void setCodigozona(String codigozona) {
        this.codigozona = codigozona;
    }

    public String getNombrezona() {
        return nombrezona;
    }

    public void setNombrezona(String nombrezona) {
        this.nombrezona = nombrezona;
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
        hash += (codigozona != null ? codigozona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zona)) {
            return false;
        }
        Zona other = (Zona) object;
        if ((this.codigozona == null && other.codigozona != null) || (this.codigozona != null && !this.codigozona.equals(other.codigozona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Zona[ codigozona=" + codigozona + " ]";
    }
    
}
