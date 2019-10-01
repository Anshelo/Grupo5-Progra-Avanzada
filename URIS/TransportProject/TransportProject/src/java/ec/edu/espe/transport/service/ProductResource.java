/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.service;

import ec.edu.espe.transport.control.BaseConnection;
import ec.edu.espe.transport.control.SearchData;
import ec.edu.espe.transport.model.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@Path("productweight")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.transport.service.ProductResource
     *
     * @return an instance of ec.edu.espe.transport.model.Product
     */
    @GET
    @Path("{weight}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getJson(@PathParam("weight") String weight) {
        
        ArrayList<Product> arrayProduct = new ArrayList<Product>();
        arrayProduct = SearchData.searchAProduct(weight);
        return arrayProduct;
    }



    /**
     * PUT method for updating or creating an instance of ProductResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Product content) {
    }
}
