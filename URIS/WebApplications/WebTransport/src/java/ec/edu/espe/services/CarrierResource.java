/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.services;

import ec.edu.espe.model.CarrierDAO;
import ec.edu.espe.model.CarrierVO;
import ec.edu.espe.model.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Anshelo
 */
@Path("Carries")
public class CarrierResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarrierResource
     */
    public CarrierResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.services.CarrierResource
     * @return an instance of ec.edu.espe.model.CarrierVO
     */
    @Path("carrier/{trucktype}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<CarrierVO> getCarrierTruck(@PathParam("trucktype")String truckType) {
        CarrierDAO carrierList = new CarrierDAO();
         ArrayList<CarrierVO> carrierVO=new ArrayList<CarrierVO>();
         carrierVO = carrierList.SearchTruckCarrier(truckType);
         return carrierVO;
    }
    
    @Path("insertcarrier")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CarrierDAO addCarrier(CarrierVO carrier) throws SQLException{
        CarrierDAO carriermet = new CarrierDAO();
        return carriermet.adicionarCliente(carrier);
    }
    
    
    
    
    

    /**
     * PUT method for updating or creating an instance of CarrierResource
     * @param content representation for the resource
     */
    
}
