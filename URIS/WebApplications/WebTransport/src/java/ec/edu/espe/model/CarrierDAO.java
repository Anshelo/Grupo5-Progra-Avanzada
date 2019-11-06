/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

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
    private int idCarrier;
   private String ci;
   private String birthDate;
   private String name;
   private String address;
   private String phone;
   private String mobile;
   private String email;
   private String truckPlate;
   private String truckType;

    public CarrierDAO(int idCarrier, String ci, String birthDate, String name, String address, String phone, String mobile, String email, String truckPlate, String truckType) {
        this.idCarrier = idCarrier;
        this.ci = ci;
        this.birthDate = birthDate;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.truckPlate = truckPlate;
        this.truckType = truckType;
    }

    public CarrierDAO() {
    }
    public static void main(String[] args){
        Conexion c=new Conexion();
        c.obtenerConexion();
    }
    private Conexion conexion = new Conexion();
    public ArrayList<CarrierVO> SearchTruckCarrier(String truck) {
        ArrayList <CarrierVO> listaB=new ArrayList <CarrierVO>();
        CarrierVO carrier;
        Conexion con = new Conexion();
        try{
            Connection acceso = con.obtenerConexion();
            
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM transportista where tipoCamion='"+truck+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                carrier=new CarrierVO();
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
    public CarrierDAO adicionarCliente(CarrierVO carrier)throws SQLException{
        Conexion con = new Conexion();
         CarrierDAO carrierDAO;
        ArrayList<CarrierDAO> listCarrier = new ArrayList<CarrierDAO>();
        
            Statement orden = con.obtenerConexion().createStatement();           
            orden.executeUpdate("INSERT INTO transportista VALUES('" + carrier.getIdCarrier()+ "','" + carrier.getCi() + "','" + carrier.getBirthDate() + "','" +carrier.getName()+"','" + carrier.getAddress()+"','"+ carrier.getPhone()+"','" + carrier.getMobile()+"','" + carrier.getEmail() +"','" + carrier.getTruckPlate()+"','" + carrier.getTruckType()+"')");
            
            carrierDAO = new CarrierDAO(carrier.getIdCarrier(),carrier.getCi() ,carrier.getBirthDate(),carrier.getName(),carrier.getAddress(),carrier.getPhone(),carrier.getMobile(), carrier.getEmail(), carrier.getTruckPlate(), carrier.getTruckType());
            
            listCarrier.add(carrierDAO);
            System.out.println("Registro exitoso");
            orden.close();
        
        return carrierDAO;
    }
   
}
