package ec.edu.espe.transportist.control;

import ec.edu.espe.transport.model.DBConnect;
import ec.edu.espe.transport.model.Zone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mateo
 */
public class ZoneDAO {

    DBConnect con;

    public ZoneDAO() {
        con = new DBConnect();
    }

    public ArrayList<Zone> mostrarZonaCodigo(String codigozona) {
        ArrayList<Zone> listaZ = new ArrayList<Zone>();
        Zone zone;
        try {
            Connection acceso = con.connect();
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM zona WHERE codigozona='" + codigozona + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                zone = new Zone();
                zone.setCodigozona(rs.getString(1));
                zone.setNombrezona(rs.getString(2));
                listaZ.add(zone);
            }
        } catch (SQLException e) {
            System.out.println("error" + e);
        }
        return listaZ;
    }

    public Zone aniadirZona(Zone zone) {
        Connection acceso = con.connect();
        String sql = "INSERT INTO zona (codigozona,nombrezona)VALUES(?,?)";
        try {
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.setString(1, zone.getCodigozona());
            ps.setString(2, zone.getNombrezona());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error" + e);
        }
        zone = new Zone(zone.getCodigozona(), zone.getNombrezona());
        return zone;
    }

    public void borrarZona(String codigozona) {
        try {
            Connection acceso = con.connect();
            PreparedStatement ps = acceso.prepareStatement("DELETE FROM zona where codigozona='" +codigozona+ "'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
