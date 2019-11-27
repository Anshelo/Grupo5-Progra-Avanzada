/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mateo
 */
@Entity
@Table(name = "guia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guia.findAll", query = "SELECT g FROM Guia g")
    , @NamedQuery(name = "Guia.findByIdguia", query = "SELECT g FROM Guia g WHERE g.idguia = :idguia")
    , @NamedQuery(name = "Guia.findByFechaenvio", query = "SELECT g FROM Guia g WHERE g.fechaenvio = :fechaenvio")
    , @NamedQuery(name = "Guia.findByFechaEntrega", query = "SELECT g FROM Guia g WHERE g.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Guia.findByCantidad", query = "SELECT g FROM Guia g WHERE g.cantidad = :cantidad")
    , @NamedQuery(name = "Guia.findByTotal", query = "SELECT g FROM Guia g WHERE g.total = :total")})
public class Guia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idguia")
    private String idguia;
    @Basic(optional = false)
    @Column(name = "fechaenvio")
    @Temporal(TemporalType.DATE)
    private Date fechaenvio;
    @Basic(optional = false)
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "total")
    private double total;
    @JoinColumn(name = "ci_cliente", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Cliente ciCliente;
    @JoinColumn(name = "cod_producto", referencedColumnName = "codigoprod")
    @ManyToOne(optional = false)
    private Producto codProducto;
    @JoinColumn(name = "ci_transportista", referencedColumnName = "ci")
    @ManyToOne(optional = false)
    private Transportista ciTransportista;
    @JoinColumn(name = "cod_zona", referencedColumnName = "codigozona")
    @ManyToOne(optional = false)
    private Zona codZona;

    public Guia() {
    }

    public Guia(String idguia) {
        this.idguia = idguia;
    }

    public Guia(String idguia, Date fechaenvio, Date fechaEntrega, int cantidad, double total) {
        this.idguia = idguia;
        this.fechaenvio = fechaenvio;
        this.fechaEntrega = fechaEntrega;
        this.cantidad = cantidad;
        this.total = total;
    }

    public String getIdguia() {
        return idguia;
    }

    public void setIdguia(String idguia) {
        this.idguia = idguia;
    }

    public Date getFechaenvio() {
        return fechaenvio;
    }

    public void setFechaenvio(Date fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCiCliente() {
        return ciCliente;
    }

    public void setCiCliente(Cliente ciCliente) {
        this.ciCliente = ciCliente;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public Transportista getCiTransportista() {
        return ciTransportista;
    }

    public void setCiTransportista(Transportista ciTransportista) {
        this.ciTransportista = ciTransportista;
    }

    public Zona getCodZona() {
        return codZona;
    }

    public void setCodZona(Zona codZona) {
        this.codZona = codZona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idguia != null ? idguia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guia)) {
            return false;
        }
        Guia other = (Guia) object;
        if ((this.idguia == null && other.idguia != null) || (this.idguia != null && !this.idguia.equals(other.idguia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Guia[ idguia=" + idguia + " ]";
    }
    
}
