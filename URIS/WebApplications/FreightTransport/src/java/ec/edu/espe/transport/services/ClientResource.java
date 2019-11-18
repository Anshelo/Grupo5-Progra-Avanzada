/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.Client;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Santiago Vivas
 */
@Path("Client")
public class ClientResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientResource
     */
    public ClientResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transport.services.ClientResource
     * @return an instance of ec.edu.espe.transport.model.Client
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Client getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ClientResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Client content) {
    }
}
