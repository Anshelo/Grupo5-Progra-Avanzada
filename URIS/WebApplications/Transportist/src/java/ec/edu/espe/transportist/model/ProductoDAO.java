/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.school.model;

import ec.edu.espe.transportist.model.Conexion;
import ec.edu.espe.transportist.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */

public class ProductoDAO {
    Conexion con;

    public ProductoDAO() {
        con=new Conexion();
    }

    public ArrayList<Producto> mostrarProducto(float peso){
        ArrayList <Producto> listaB=new ArrayList <Producto>();
        Producto Producto;
        try{
            Connection acceso = con.getConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM producto WHERE peso='"+peso+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Producto=new Producto();
                Producto.setCodigo(rs.getString(1));
                Producto.setNombre(rs.getString(2));
                Producto.setDescripcion(rs.getString(3));
                Producto.setPeso(rs.getFloat(4));
                Producto.setSensibilidad(rs.getString(5));
                Producto.setValorU(rs.getFloat(6));
                listaB.add(Producto);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }

        public ArrayList<Producto> mostrarProductoCodigo(String cod){
        ArrayList <Producto> listaB=new ArrayList <Producto>();
        Producto Producto;
        try{
            Connection acceso = con.getConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM producto WHERE codigoprod='"+cod+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Producto=new Producto();
                Producto.setCodigo(rs.getString(1));
                Producto.setNombre(rs.getString(2));
                Producto.setDescripcion(rs.getString(3));
                Producto.setPeso(rs.getFloat(4));
                Producto.setSensibilidad(rs.getString(5));
                Producto.setValorU(rs.getFloat(6));
                listaB.add(Producto);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
        
        
           public void modificarProductoIdentificacion(Producto pro){
        try{
            Connection acceso = con.getConexion();
            PreparedStatement ps= acceso.prepareStatement("UPDATE producto SET nombreprod='" +pro.getNombre()+"', descripcion='"+pro.getDescripcion()
                    +"', peso='"+pro.getPeso()+"', sensibilidad='"+pro.getSensibilidad()+"', valorunit='"+pro.getValorU()
                    +"'WHERE codigoprod='"+pro.getCodigo()+"'" );
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }



    
}
