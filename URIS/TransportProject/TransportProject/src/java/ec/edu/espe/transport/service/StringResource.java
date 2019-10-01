/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.service;

import ec.edu.espe.transport.control.BaseConnection;
import ec.edu.espe.transport.control.SearchData;
import ec.edu.espe.transport.model.Carrier;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
@Path("ZodiacSign")
public class StringResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StringResource
     */
    public StringResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transport.service.StringResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{carrierCode}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@PathParam("carrierCode") String carrierCode) throws ParseException, ParseException {

        
        return "";
    }

    /**
     * PUT method for updating or creating an instance of StringResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
