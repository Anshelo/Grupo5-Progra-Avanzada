/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.DBConnect;
import ec.edu.espe.transport.model.Guide;
import ec.edu.espe.transport.model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DenniseSandoval
 */
@Path("guide")
public class GuideResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GuideResource
     */
    public GuideResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transport.services.GuideResource
     * @return an instance of ec.edu.espe.transport.model.Guide
     * @throws java.sql.SQLException
     */
    @Path("/showallguides")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList showAllGuides() throws SQLException {
        DBConnect connect = new DBConnect();
        String query;
        query = "SELECT * from guia";
        PreparedStatement state = connect.connect().prepareStatement(query);
        ResultSet rs = state.executeQuery();
        Guide tempGuide;
        ArrayList<Guide> guide = new ArrayList();
        while (rs.next()) {
            tempGuide = new Guide(rs.getString("idguia"), rs.getString("fechaenvio"), rs.getString("fecha_entrega"), rs.getInt("cantidad"), rs.getDouble("total"), rs.getString("ci_cliente"), rs.getString("ci_transportista"), rs.getString("cod_zona"), rs.getString("cod_producto"));
            guide.add(tempGuide);
        }
        return guide;
    }
    @Path("/insertguide")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Object addGuide(Guide objGuide) throws SQLException {
        DBConnect connect = new DBConnect();
        String query;
        PreparedStatement state;
        query = "INSERT INTO guia" + 
                " (idguia,fechaenvio,fecha_entrega,cantidad,total,ci_cliente,ci_transportista,cod_zona,cod_producto) values (?,?,?,?,?,?,?,?,?)";
        state = connect.connect().prepareStatement(query);
        state.setString(1, objGuide.getGuideId());
        state.setString(2, objGuide.getSendDate());
        state.setString(3, objGuide.getDeliverDate());
        state.setInt(4, objGuide.getQuantity());
        state.setDouble(5, objGuide.getTotal());
        state.setString(6, objGuide.getCarrierCard());
        state.setString(7, objGuide.getCustomerId());
        state.setString(8, objGuide.getZoneCode());
        state.setString(9, objGuide.getProductCode());
        state.executeUpdate();
        Guide guide=new Guide(objGuide.getGuideId(), objGuide.getSendDate(), objGuide.getDeliverDate(), objGuide.getQuantity(), objGuide.getTotal(), objGuide.getCustomerId(), objGuide.getCarrierCard(), objGuide.getZoneCode(), objGuide.getProductCode());
        return guide;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Guide content) {
    }
}
