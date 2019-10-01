/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Santiago Vivas
 */
public class BaseConnection {
        public BaseConnection() {

    }

    public Connection getConexion() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//crea una nueva instancia de la clase representada
            connection = DriverManager.getConnection("jdbc:mysql://localhost/database_transport", "root", "viv.viv1997");
            System.out.println("Ingreso Correcto a la base de datos");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return connection;
    }
}
