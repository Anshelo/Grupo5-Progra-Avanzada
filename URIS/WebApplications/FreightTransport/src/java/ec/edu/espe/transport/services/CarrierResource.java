/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.Carrier;
import ec.edu.espe.transport.model.CarrierDAO;
import ec.edu.espe.transport.model.DBConnect;
import ec.edu.espe.transport.model.Product;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DenniseSandoval
 */
@Path("carrier")
public class CarrierResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarrierResource
     */
    public CarrierResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transport.services.CarrierResource
     * @return an instance of ec.edu.espe.transport.model.Carrier
     */
    @Path("getage/{day}/{month}/{year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAge(@PathParam("day") String day, @PathParam("month") String month, @PathParam("year") String year) {
        String age;
        Calendar fecha = new GregorianCalendar();
        int yearNow = fecha.get(Calendar.YEAR);
        int monthNow = fecha.get(Calendar.MONTH) + 1;
        int dayNow = fecha.get(Calendar.DAY_OF_MONTH);
        int operationYear = yearNow - Integer.parseInt(year);//sin el 0
        if (Integer.parseInt(day) == dayNow && Integer.parseInt(month) == monthNow) {
            age= Integer.toString(operationYear);  
        } else if (Integer.parseInt(day) < dayNow && Integer.parseInt(month) == monthNow) {// Birthday passed
            age= Integer.toString(operationYear); 
        } else if (Integer.parseInt(month) < monthNow) {
            age= Integer.toString(operationYear); 
        } else if (Integer.parseInt(day) > dayNow && Integer.parseInt(month) == monthNow) {// Birthday passed
            age= Integer.toString(operationYear-1);
        } else if (Integer.parseInt(month) > monthNow) {
            age= Integer.toString(operationYear-1); 
        } else {
            age="Incorrect date";
        }
        return age;
    }
    @Path("insertcarrier")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Carrier insertCarrier(Carrier carrier) throws SQLException{
        CarrierDAO carrierObj = new CarrierDAO();
       return carrierObj.addCarrier(carrier);
    }
    
    @Path("getcarrierbytruck/{trucktype}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Carrier> getCarrierTruck(@PathParam("trucktype")String truckType) {
        CarrierDAO carrierList = new CarrierDAO();
         ArrayList<Carrier> carrierVO=new ArrayList<Carrier>();
         carrierVO = carrierList.SearchTruckCarrier(truckType);
         return carrierVO;
    }
    @Path("getcarrierbyid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Carrier> getCarrierTruck(@PathParam("id")int id) {
        CarrierDAO carrierList = new CarrierDAO();
         ArrayList<Carrier> carrierVO=new ArrayList<Carrier>();
         carrierVO = carrierList.printCarrierById(id);
         return carrierVO;
    }
    @Path("getcarriers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Carrier> getCarrier() {
        CarrierDAO carrierList = new CarrierDAO();
         ArrayList<Carrier> carrierVO=new ArrayList<Carrier>();
         carrierVO = carrierList.printCarrier();
         return carrierVO;
    }
    @PUT
    @Path("/updatecarrier/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Carrier> updateCarrier(Carrier data) {
        CarrierDAO response = new CarrierDAO();
        response.updateCarrier(data);
  
        CarrierDAO carrier=new CarrierDAO();
        
        ArrayList<Carrier> listCarrier=new ArrayList<Carrier>();
        listCarrier=carrier.printCarrierById(data.getIdCarrier());
        return listCarrier;
    }
    @DELETE
    @Path("deletecarrier/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Carrier> deleteCarrier(@PathParam("id")int id) {
        CarrierDAO response = new CarrierDAO();
        response.deleteCarrier(id);
        CarrierDAO carrier=new CarrierDAO();
        ArrayList<Carrier> listCarrier=new ArrayList<Carrier>();
        listCarrier=carrier.printCarrierById(id);
        return listCarrier;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Carrier content) {
    }
}
