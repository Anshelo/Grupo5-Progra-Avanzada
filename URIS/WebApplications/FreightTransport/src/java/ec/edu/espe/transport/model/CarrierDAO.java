/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Anshelo
 */
public class CarrierDAO {
   DBConnect con;
   

    public CarrierDAO() {
        con=new DBConnect();
    }
  
    
    public ArrayList<Carrier> SearchTruckCarrier(String truck) {
        ArrayList <Carrier> listaB=new ArrayList <Carrier>();
        Carrier carrier;
        try{
            Connection acceso = con.connect();
            
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM transportista where tipoCamion='"+truck+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                carrier=new Carrier();
                carrier.setIdCarrier(rs.getInt(1));
                carrier.setCi(rs.getString(2));
                carrier.setBirthDate(rs.getString(3));
                carrier.setName(rs.getString(4));
                carrier.setAddress(rs.getString(5));
                carrier.setPhone(rs.getString(6));
                carrier.setMobile(rs.getString(7));
                carrier.setEmail(rs.getString(8));
                carrier.setTruckPlate(rs.getString(9));
                carrier.setTruckType(rs.getString(10));
                
      
                listaB.add(carrier);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
         
  }
    public Carrier addCarrier(Carrier carrier)throws SQLException{
        Connection acceso = con.connect();
        String sql = "INSERT INTO transportista (codigotransp,ci,birthdate,nombre,direccion,telfconvencional,telfcelular,correo,placaCamion,tipoCamion) VALUES(?,?,?,?,?,?,?,?,?,?)";
         try {
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.setInt(1, carrier.getIdCarrier());
            ps.setString(2, carrier.getCi());
            ps.setString(3, carrier.getBirthDate());
            ps.setString(4, carrier.getName());
            ps.setString(5, carrier.getAddress());
            ps.setString(6, carrier.getPhone());
            ps.setString(7, carrier.getMobile());
            ps.setString(8, carrier.getEmail());
            ps.setString(9, carrier.getTruckPlate());
            ps.setString(10, carrier.getTruckType());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        carrier = new Carrier(carrier.getIdCarrier(),carrier.getCi(),carrier.getBirthDate(),carrier.getName(),carrier.getAddress(),carrier.getPhone(),carrier.getMobile(),carrier.getEmail(),carrier.getTruckPlate(),carrier.getTruckType());
        return carrier;
    }
    public ArrayList<Carrier> searchTruckCarrier(String truck) {
        ArrayList <Carrier> listaB=new ArrayList <Carrier>();
        Carrier carrier;
        Connection acceso = con.connect();
        try{
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM transportista where tipoCamion='"+truck+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                carrier=new Carrier();
                carrier.setIdCarrier(rs.getInt(1));
                carrier.setCi(rs.getString(2));
                carrier.setBirthDate(rs.getString(3));
                carrier.setName(rs.getString(4));
                carrier.setAddress(rs.getString(5));
                carrier.setPhone(rs.getString(6));
                carrier.setMobile(rs.getString(7));
                carrier.setEmail(rs.getString(8));
                carrier.setTruckPlate(rs.getString(9));
                carrier.setTruckType(rs.getString(10));
                listaB.add(carrier);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    public ArrayList<Carrier> printCarrierById(int id) {
        ArrayList <Carrier> listaB=new ArrayList <Carrier>();
        Carrier carrier;
        Connection acceso = con.connect();
        try{
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM transportista where codigotransp='"+id+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                carrier=new Carrier();
                carrier.setIdCarrier(rs.getInt(1));
                carrier.setCi(rs.getString(2));
                carrier.setBirthDate(rs.getString(3));
                carrier.setName(rs.getString(4));
                carrier.setAddress(rs.getString(5));
                carrier.setPhone(rs.getString(6));
                carrier.setMobile(rs.getString(7));
                carrier.setEmail(rs.getString(8));
                carrier.setTruckPlate(rs.getString(9));
                carrier.setTruckType(rs.getString(10));
                listaB.add(carrier);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    public ArrayList<Carrier> printCarrier() {
        ArrayList <Carrier> listaB=new ArrayList <Carrier>();
        Carrier carrier;
        Connection acceso = con.connect();
        try{
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM transportista");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                carrier=new Carrier();
                carrier.setIdCarrier(rs.getInt(1));
                carrier.setCi(rs.getString(2));
                carrier.setBirthDate(rs.getString(3));
                carrier.setName(rs.getString(4));
                carrier.setAddress(rs.getString(5));
                carrier.setPhone(rs.getString(6));
                carrier.setMobile(rs.getString(7));
                carrier.setEmail(rs.getString(8));
                carrier.setTruckPlate(rs.getString(9));
                carrier.setTruckType(rs.getString(10));
                listaB.add(carrier);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    public void updateCarrier(Carrier carrier){
        try{
            Connection acceso = con.connect();
            PreparedStatement ps= acceso.prepareStatement("UPDATE transportista SET ci='" +carrier.getCi()+"', birthdate='"+carrier.getBirthDate()
                    +"', nombre='"+carrier.getName()+"', direccion='"+carrier.getAddress()+"', telfconvencional='"+carrier.getPhone()
                    +"', telfcelular='"+carrier.getMobile()+"', correo='"+carrier.getEmail()+"', placaCamion='"+carrier.getTruckPlate()+"', tipoCamion='"+carrier.getTruckType()
                    +"'WHERE codigotransp='"+carrier.getIdCarrier()+"'" );
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    public void deleteCarrier(int id){
        try {
            Connection accesoDB = con.connect();
            PreparedStatement ps= accesoDB.prepareStatement("DELETE FROM transportista where codigotransp='"+id+"'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
   
}
