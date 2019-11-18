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
import java.util.ArrayList;

/**
 *
 * @author Santiago Vivas
 */
public class ClientDAO {

    DBConnect con;

    public ClientDAO() {
        con = new DBConnect();
    }

    public Client addClient(Client client) throws SQLException {
        Connection acceso = con.connect();
        String sql = "INSERT INTO cliente VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.setString(1, client.getCiClient());
            ps.setString(2, client.getRucClient());
            ps.setString(3, client.getNameClient());
            ps.setString(4, client.getAddressClient());
            ps.setString(5, client.getPhoneClient());
            ps.setString(6, client.getMobileClient());
            ps.setString(7, client.getEmailClient());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return client;
    }

    public Client searchClientByCi(String ci) {
        Client client = new Client();
        Connection acceso = con.connect();
        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                if (ci.equals(rs.getString(1))) {
                    client = new Client();
                    client.setCiClient(rs.getString(1));
                    client.setRucClient(rs.getString(2));
                    client.setNameClient(rs.getString(3));
                    client.setAddressClient(rs.getString(4));
                    client.setPhoneClient(rs.getString(5));
                    client.setMobileClient(rs.getString(6));
                    client.setEmailClient(rs.getString(7));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return client;
    }

    public void updateClient(Client client) {
        try {
            Connection acceso = con.connect();
            PreparedStatement ps = acceso.prepareStatement("UPDATE cliente SET ruc='" + client.getRucClient()
                    + "', nombre='" + client.getNameClient() + "', direccion='" + client.getAddressClient() + "', telfconvencional='" + client.getPhoneClient()
                    + "', telfcelular='" + client.getMobileClient() + "', correo='" + client.getEmailClient()
                    + "'WHERE ci='" + client.getCiClient() + "'");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteClient(String ci) {
        try {
            Connection accesoDB = con.connect();
            PreparedStatement ps = accesoDB.prepareStatement("DELETE FROM cliente where codigotransp='" + ci + "'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
