/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.Zone;
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
 * @author DenniseSandoval
 */
@Path("getzoneprice")
public class ZoneResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ZoneResource
     */
    public ZoneResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transport.services.ZoneResource
     * @return an instance of ec.edu.espe.transport.model.Zone
     */
    @Path("{totalproducts}/{zonename}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Zone getZonePrice(@PathParam("totalproducts") float totalproducts,@PathParam("zonename") String zonename) {
        float totalProducts;
        if(zonename.equals("Quito")||zonename.equals(("Quito").toLowerCase())||zonename.equals(("Quito").toUpperCase())){
            totalProducts=totalproducts+1.50f;
        }else{
            totalProducts=5.00f+totalproducts;
        }
        Zone zone=new Zone(zonename, totalProducts);
        return zone;
    }

    /**
     * PUT method for updating or creating an instance of ZoneResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Zone content) {
    }
}
