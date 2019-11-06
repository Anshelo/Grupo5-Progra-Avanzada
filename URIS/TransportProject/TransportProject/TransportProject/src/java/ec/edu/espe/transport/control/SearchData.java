/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.control;

import ec.edu.espe.transport.model.Carrier;
import ec.edu.espe.transport.model.Product;
import ec.edu.espe.transport.model.Zone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Santiago Vivas
 */
public class SearchData {

    public static Carrier searchCarrier() {
        Carrier carrier = new Carrier();
        // Conexion a la base
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        //Sacar datos

        String sql = "SELECT * FROM transportista";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            //rs.next();
            carrier.setCarrierCode(rs.getString(1));
            carrier.setCarrierCI(rs.getString(2));
            carrier.setCarrierBirthday(rs.getString(3));
            carrier.setCarrierName(rs.getString(4));
            carrier.setCarrierAddress(rs.getString(5));
            carrier.setCarrierPhone(rs.getString(6));
            carrier.setCarrierCellPhone(rs.getString(7));
            carrier.setCarrierEmail(rs.getString(8));
            carrier.setLicensePlate(rs.getString(9));
            carrier.setVehiculeType(rs.getString(10));

        } catch (SQLException ex) {

        }
        return carrier;

    }

    public static Carrier searchCarrier(String vehicleType) {
        Carrier carrier = new Carrier();
        // Conexion a la base
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        //Sacar datos
        String sql = "SELECT * FROM transportista";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                if (vehicleType.equals(rs.getString(10))) {
                    carrier.setCarrierCode(rs.getString(1));
                    carrier.setCarrierCI(rs.getString(2));
                    carrier.setCarrierBirthday(rs.getString(3));
                    carrier.setCarrierName(rs.getString(4));
                    carrier.setCarrierAddress(rs.getString(5));
                    carrier.setCarrierPhone(rs.getString(6));
                    carrier.setCarrierCellPhone(rs.getString(7));
                    carrier.setCarrierEmail(rs.getString(8));
                    carrier.setLicensePlate(rs.getString(9));
                    carrier.setVehiculeType(rs.getString(10));
                }

            }
        } catch (SQLException ex) {

        }
        return carrier;

    }

    public static Carrier changeCarrier(String phone, String cellphone, String code) {
        Carrier carrier = new Carrier();
        // Conexion a la base
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        //Sacar datos
        String sql = "UPDATE transportista SET telfconvencional=?,telfcelular=? WHERE codigotransp = " + code;

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, phone);
            pst.setString(2, cellphone);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

        carrier = searchCarrierByCode(code);

        return carrier;

    }

    public static void changeIVA(String newIVA) {
        // Conexion a la base
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        //Sacar datos
        String sql = "update producto set valorunit = valorunit + valorunit*?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, newIVA);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
    public static void deleteZONE(String codeZone) {
        // Conexion a la base
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        //Sacar datos
        String sql = "DELETE FROM zona WHERE codigozona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, codeZone);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static Carrier searchCarrierByCode(String carrierCode) {
        Carrier carrier = new Carrier();
        //carrier.setCarrierEmail("0");
        // Conexion a la base
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        //Sacar datos

        String sql = "SELECT * FROM transportista";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                if (carrierCode.equals(rs.getString(1))) {

                    carrier.setCarrierCode(rs.getString(1));
                    carrier.setCarrierCI(rs.getString(2));
                    carrier.setCarrierBirthday(rs.getString(3));
                    carrier.setCarrierName(rs.getString(4));
                    carrier.setCarrierAddress(rs.getString(5));
                    carrier.setCarrierPhone(rs.getString(6));
                    carrier.setCarrierCellPhone(rs.getString(7));
                    carrier.setCarrierEmail(rs.getString(8));
                    carrier.setLicensePlate(rs.getString(9));
                    carrier.setVehiculeType(rs.getString(10));
                }

            }
        } catch (SQLException ex) {

        }
        return carrier;
    }

    public static ArrayList<Product> searchAProduct(String weight) {
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        Product product = new Product();
        ArrayList<Product> arrayProduct = new ArrayList<Product>();
        //Sacar datos
        String sql = "SELECT * FROM producto";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                product = new Product(rs.getString(1), rs.getString(2), rs.getString(3), Float.parseFloat(rs.getString(4)), rs.getString(5), rs.getString(6));
                if (Float.parseFloat(rs.getString(4)) > Float.parseFloat(weight)) {
                    arrayProduct.add(product);
                }

            }

        } catch (SQLException ex) {

        }

        return arrayProduct;

    }

    public static ArrayList<Product> searchAllProduct() {
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        Product product = new Product();
        ArrayList<Product> arrayProduct = new ArrayList<Product>();
        //Sacar datos
        String sql = "SELECT * FROM producto";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                product = new Product(rs.getString(1), rs.getString(2), rs.getString(3), Float.parseFloat(rs.getString(4)), rs.getString(5), rs.getString(6));

                arrayProduct.add(product);

            }

        } catch (SQLException ex) {

        }

        return arrayProduct;

    }
    
    public static ArrayList<Zone> searchAllZone() {
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        Zone zone = new Zone();
        ArrayList<Zone> arrayZone = new ArrayList<Zone>();
        //Sacar datos
        String sql = "SELECT * FROM zona";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                zone = new Zone(rs.getString(1), rs.getString(2));

                arrayZone.add(zone);

            }

        } catch (SQLException ex) {

        }

        return arrayZone;

    }

    public static Product searchProduct(String code) {
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        Product product = new Product();
        //Sacar datos
        String sql = "SELECT * FROM producto";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(1).equals(code)) {
                    product = new Product(rs.getString(1), rs.getString(2), rs.getString(3), Float.parseFloat(rs.getString(4)), rs.getString(5), rs.getString(6));
                }

            }

        } catch (SQLException ex) {

        }

        return product;

    }

}
