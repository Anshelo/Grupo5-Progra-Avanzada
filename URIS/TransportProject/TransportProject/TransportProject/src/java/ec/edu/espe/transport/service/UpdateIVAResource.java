/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.service;

import ec.edu.espe.transport.control.SearchData;
import ec.edu.espe.transport.model.Carrier;
import ec.edu.espe.transport.model.Product;
import java.util.ArrayList;
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
@Path("updateIVA")
public class UpdateIVAResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UpdateIVAResource
     */
    public UpdateIVAResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.transport.service.UpdateIVAResource
     *
     * @return an instance of ec.edu.espe.transport.model.Product
     */
    @GET
    @Path("All")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getJson(@PathParam("weight") String weight) {
        
        ArrayList<Product> arrayProduct = new ArrayList<Product>();
        arrayProduct = SearchData.searchAProduct(weight);
        return arrayProduct;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getJson() {
        //TODO return proper representation object
        return SearchData.searchAllProduct();
    }

    /**
     * PUT method for updating or creating an instance of UpdateIVAResource
     *
     * @param content representation for the resource
     */
    /*
    @PUT
    @Path("{newIva}")
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> updateNewIva(@PathParam("newIva") String code) {
        
        SearchData.changeIVA(code);
        
        return SearchData.searchAllProduct();
    }*/
    
    @GET
    @Path("{newIva}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> updateNewIva(@PathParam("newIva") String code) {
        SearchData.changeIVA(code);
        return SearchData.searchAllProduct();
    }
    
}
