/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.service;

import ec.edu.espe.transport.control.BaseConnection;
import ec.edu.espe.transport.control.SearchData;
import ec.edu.espe.transport.model.Carrier;
import ec.edu.espe.transport.model.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Santiago Vivas
 */
@Path("CarriersTypeVehicle")
public class CarrierResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarrierResource
     */
    public CarrierResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.transport.service.CarrierResource
     *
     * @return an instance of ec.edu.espe.transport.model.Carrier
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Carrier getJson() {
        //TODO return proper representation object
        Carrier carrier = new Carrier();

        carrier = SearchData.searchCarrier();

        return carrier;
    }

    @GET
    @Path("{searchVehiculeType}")
    @Produces(MediaType.APPLICATION_JSON)
    public Carrier getJsonCarriersTypeVehicle(@PathParam("searchVehiculeType") String vehicleType) {

        Carrier carrier = new Carrier();
        carrier = SearchData.searchCarrier(vehicleType);
        return carrier;
    }

    /**
     * PUT method for updating or creating an instance of CarrierResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Carrier content) {
    }
}
