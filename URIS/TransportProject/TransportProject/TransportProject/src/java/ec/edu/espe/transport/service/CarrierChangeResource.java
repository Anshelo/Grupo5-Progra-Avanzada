/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.service;

import ec.edu.espe.transport.control.SearchData;
import ec.edu.espe.transport.model.Carrier;
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
    @Path("CarrierChange")
public class CarrierChangeResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarrierChangeResource
     */
    public CarrierChangeResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transport.service.CarrierChangeResource
     * @return an instance of ec.edu.espe.transport.model.Carrier
     */
    @GET
    @Path("{carrierCode}/{phone}/{cellphone}")
    @Produces(MediaType.APPLICATION_JSON)
    public Carrier getJson(@PathParam("carrierCode") String carrierCode, @PathParam("phone") String phone,@PathParam("cellphone") String cellphone ) {
        Carrier carrier = new Carrier();
        carrier = SearchData.changeCarrier(phone,cellphone,carrierCode);
        return carrier;
    }

    /**
     * PUT method for updating or creating an instance of CarrierChangeResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Carrier content) {
        
    }
}
