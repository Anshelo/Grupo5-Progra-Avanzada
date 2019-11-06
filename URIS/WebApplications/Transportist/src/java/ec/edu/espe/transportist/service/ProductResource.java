/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportist.service;

import ec.edu.espe.school.model.ProductoDAO;
import ec.edu.espe.transportist.model.Producto;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Diego
 */
@Path("product")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transportist.service.ProductResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{weight}")    
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getJsonProductoPeso(@PathParam("weight") float peso) {
        ProductoDAO prod=new ProductoDAO();
        ArrayList<Producto> producto=new ArrayList<Producto>();
        producto=prod.mostrarProducto(peso);
        return producto;
    }

    /**
     * PUT method for updating or creating an instance of ProductResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    
    @PUT
    @Path("/modifify/product")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> modifyProduct(Producto data) {
        ProductoDAO response = new ProductoDAO();
        response.modificarProductoIdentificacion(data);
  /*      System.out.println(data.getCodigo());
        System.out.println(data.getNombre());
        System.out.println(data.getDescripcion());
        System.out.println(data.getPeso());
        System.out.println(data.getSensibilidad());
        System.out.println(data.getValorU());
*/        ProductoDAO prod=new ProductoDAO();
        
        ArrayList<Producto> producto=new ArrayList<Producto>();
        producto=prod.mostrarProductoCodigo(data.getCodigo());
        return producto;

    }

    
}
