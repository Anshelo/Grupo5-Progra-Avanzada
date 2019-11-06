/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.service;

import ec.edu.espe.transport.control.SearchData;
import ec.edu.espe.transport.model.Product;
import ec.edu.espe.transport.model.Zone;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("Zone")
public class ZoneResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ZoneResource
     */
    public ZoneResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.transport.service.ZoneResource
     *
     * @return an instance of ec.edu.espe.transport.model.Zone
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Zone getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ZoneResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Zone content) {
    }

    @DELETE
    @Path("DeleteZone/{idzone}")
    public void deleteZone(@PathParam("idzone") String idzone) {
        SearchData.deleteZONE(idzone);
    }
    
    /*
    @GET
    @Path("DeleteZone/{idzone}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Zone> updateNewIva(@PathParam("idzone") String idzone) {
        SearchData.deleteZONE(idzone);
        return SearchData.searchAllZone();
    }*/
}
