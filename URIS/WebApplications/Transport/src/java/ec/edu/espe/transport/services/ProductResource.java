/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.Customer;
import ec.edu.espe.transport.model.DBConnect;
import ec.edu.espe.transport.model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

@Path("calculatevalueproduct")
public class ProductResource {

    @Context
    private UriInfo context;

    public ProductResource() {
    }

    @Path("{productCode}/{productName}/{description}/{weight}/{sensibility}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product addProduct(@PathParam("productCode") String productCode, @PathParam("productName") String productName, @PathParam("description") String description, @PathParam("weight") float weight, @PathParam("sensibility") String sensibility) throws SQLException {
        DBConnect connect = new DBConnect();
        float valueProduct, priceKg = 2, priceFragile = 4.50f;
        String query;
        PreparedStatement state;
        if (sensibility.equals("Fragil")) {
            valueProduct = (weight * priceKg) + priceFragile;
        } else {
            valueProduct = weight * priceKg;
        }
        query = "INSERT INTO producto" + " (codigoprod,nombreprod,descripcion,peso,sensibilidad,valorunit) values (?,?,?,?,?,?)";
        state = connect.connect().prepareStatement(query);
        state.setString(1, productCode);
        state.setString(2, productName);
        state.setString(3, description);
        state.setFloat(4, weight);
        state.setString(5, sensibility);
        state.setFloat(6, valueProduct);
        state.executeUpdate();
        Product product = new Product(productCode, productName, description, weight, sensibility, valueProduct);
        return product;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Product content) {
    }
}
