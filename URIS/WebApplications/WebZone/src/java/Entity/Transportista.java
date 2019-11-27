/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mateo
 */
@Entity
@Table(name = "transportista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportista.findAll", query = "SELECT t FROM Transportista t")
    , @NamedQuery(name = "Transportista.findByCodigotransp", query = "SELECT t FROM Transportista t WHERE t.codigotransp = :codigotransp")
    , @NamedQuery(name = "Transportista.findByCi", query = "SELECT t FROM Transportista t WHERE t.ci = :ci")
    , @NamedQuery(name = "Transportista.findByBirthdate", query = "SELECT t FROM Transportista t WHERE t.birthdate = :birthdate")
    , @NamedQuery(name = "Transportista.findByNombre", query = "SELECT t FROM Transportista t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Transportista.findByDireccion", query = "SELECT t FROM Transportista t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "Transportista.findByTelfconvencional", query = "SELECT t FROM Transportista t WHERE t.telfconvencional = :telfconvencional")
    , @NamedQuery(name = "Transportista.findByTelfcelular", query = "SELECT t FROM Transportista t WHERE t.telfcelular = :telfcelular")
    , @NamedQuery(name = "Transportista.findByCorreo", query = "SELECT t FROM Transportista t WHERE t.correo = :correo")
    , @NamedQuery(name = "Transportista.findByPlacaCamion", query = "SELECT t FROM Transportista t WHERE t.placaCamion = :placaCamion")
    , @NamedQuery(name = "Transportista.findByTipoCamion", query = "SELECT t FROM Transportista t WHERE t.tipoCamion = :tipoCamion")})
public class Transportista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "codigotransp")
    private int codigotransp;
    @Id
    @Basic(optional = false)
    @Column(name = "ci")
    private String ci;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telfconvencional")
    private String telfconvencional;
    @Column(name = "telfcelular")
    private String telfcelular;
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "placaCamion")
    private String placaCamion;
    @Basic(optional = false)
    @Column(name = "tipoCamion")
    private String tipoCamion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciTransportista")
    private Collection<Guia> guiaCollection;

    public Transportista() {
    }

    public Transportista(String ci) {
        this.ci = ci;
    }

    public Transportista(String ci, int codigotransp, String nombre, String direccion, String placaCamion, String tipoCamion) {
        this.ci = ci;
        this.codigotransp = codigotransp;
        this.nombre = nombre;
        this.direccion = direccion;
        this.placaCamion = placaCamion;
        this.tipoCamion = tipoCamion;
    }

    public int getCodigotransp() {
        return codigotransp;
    }

    public void setCodigotransp(int codigotransp) {
        this.codigotransp = codigotransp;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelfconvencional() {
        return telfconvencional;
    }

    public void setTelfconvencional(String telfconvencional) {
        this.telfconvencional = telfconvencional;
    }

    public String getTelfcelular() {
        return telfcelular;
    }

    public void setTelfcelular(String telfcelular) {
        this.telfcelular = telfcelular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPlacaCamion() {
        return placaCamion;
    }

    public void setPlacaCamion(String placaCamion) {
        this.placaCamion = placaCamion;
    }

    public String getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(String tipoCamion) {
        this.tipoCamion = tipoCamion;
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
        hash += (ci != null ? ci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportista)) {
            return false;
        }
        Transportista other = (Transportista) object;
        if ((this.ci == null && other.ci != null) || (this.ci != null && !this.ci.equals(other.ci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Transportista[ ci=" + ci + " ]";
    }
    
}
