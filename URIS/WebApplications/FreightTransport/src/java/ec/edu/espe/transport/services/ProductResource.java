/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.DBConnect;
import ec.edu.espe.transport.model.Product;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DenniseSandoval
 */
@Path("getproductprice")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Object addProduct(Product objProduct) throws SQLException {
        DBConnect connect = new DBConnect();
        double valueProduct, priceKg = 2, priceFragile = 4.50;
        String query;
        PreparedStatement state;
        String sensibility;
        sensibility= objProduct.getSensibility().toLowerCase();
        if (sensibility.equals("fragil")) {
            valueProduct = (objProduct.getWeight() * priceKg) + priceFragile;
        } else {
            valueProduct = objProduct.getWeight() * priceKg;
        }
        query = "INSERT INTO producto" + " (codigoprod,nombreprod,descripcion,peso,sensibilidad,valorunit) values (?,?,?,?,?,?)";
        state = connect.connect().prepareStatement(query);
        state.setString(1, objProduct.getProductCode());
        state.setString(2, objProduct.getProductName());
        state.setString(3, objProduct.getDescription());
        state.setDouble(4, objProduct.getWeight());
        state.setString(5, objProduct.getSensibility());
        state.setDouble(6, valueProduct);
        state.executeUpdate();
        Product product = new Product(objProduct.getProductCode(), objProduct.getProductName(), objProduct.getDescription(), 
                objProduct.getWeight(), objProduct.getSensibility(), valueProduct);
        return product;
    }
}
