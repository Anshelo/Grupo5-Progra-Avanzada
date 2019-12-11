/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.DBConnect;
import ec.edu.espe.transport.model.Product;
import ec.edu.espe.transport.model.Zone;
import ec.edu.espe.transportist.control.ZoneDAO;
import ec.edu.espe.transportist.control.ProductDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Mateo
 */
@Path("zone")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ZoneResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ZoneResource() {
    }

    @GET
    @Path("{zonecode}")
    public ArrayList<Zone> getJsonZonaCodigo(@PathParam("zonecode") String codigozona) {
        ZoneDAO zdao = new ZoneDAO();
        ArrayList<Zone> zone = new ArrayList<Zone>();
        zone = zdao.mostrarZonaCodigo(codigozona);
        return zone;
    }

    @POST
    @Path("insertzone")
    public Zone insertZone(Zone zone) {
        ZoneDAO zoneObj = new ZoneDAO();
        return zoneObj.aniadirZona(zone);
    }

    @DELETE
    @Path("/deleteZone/{codigozona}")
    public void deleteZone(@PathParam("codigozona") String codigozona){
        ZoneDAO zdao = new ZoneDAO();
        zdao.borrarZona(codigozona);
    }

    @Path("searchProduct/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product getCarrierTruck(@PathParam("id") String id) {
        ProductDAO searchedProduct = new ProductDAO();
        return searchedProduct.searchproductByCi(id);
    }

    @PUT
    @Path("/modify/product")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Product> modifyProduct(Product data) {
        ProductDAO response = new ProductDAO();
        response.modificarProductoIdentificacion(data);
        /*      System.out.println(data.getCodigo());
        System.out.println(data.getNombre());
        System.out.println(data.getDescripcion());
        System.out.println(data.getPeso());
        System.out.println(data.getSensibilidad());
        System.out.println(data.getValorU());
         */ ProductDAO prod = new ProductDAO();

        ArrayList<Product> producto = new ArrayList<Product>();
        producto = prod.mostrarProductoCodigo(data.getProductCode());
        return producto;

    }

    @DELETE
    @Path("/deleteProduct/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteClient(@PathParam("code") String code) throws SQLException {
        ProductDAO deletedProduct = new ProductDAO();
        deletedProduct.eliminarProductoIdentificacion(code);
    }

    @Path("getproducts")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getProduct() {
        ProductDAO productList = new ProductDAO();
        ArrayList<Product> productVO = new ArrayList<Product>();
        productVO = productList.printProducto();
        return productVO;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Product content) {
    }
}
