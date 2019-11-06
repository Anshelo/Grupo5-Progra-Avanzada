/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.service;

import ec.edu.espe.transport.control.SearchData;
import ec.edu.espe.transport.model.Product;
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
@Path("IVAProduct")
public class ProductIvaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductIvaResource
     */
    public ProductIvaResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transport.service.ProductIvaResource
     * @return an instance of ec.edu.espe.transport.model.Product
     */
    @GET
    @Path("{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getJson(@PathParam("code") String code) {
        float newValue=0.0f;
        Product product = new Product();
        product = SearchData.searchProduct(code);
        newValue = Float.parseFloat(product.getProductUnitValue());
        newValue = newValue*0.12f;
        product.setProductUnitValue( Float.toString(newValue) );
        
        return product;
    }

    /**
     * PUT method for updating or creating an instance of ProductIvaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Product content) {
    }
}
