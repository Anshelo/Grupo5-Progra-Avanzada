/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.Carrier;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
 * @author DenniseSandoval
 */
@Path("getcarrierage")
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
    @Path("{day}/{month}/{year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Carrier getAge(@PathParam("day") String day, @PathParam("month") String month, @PathParam("year") String year) {
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
        Carrier carrier=new Carrier(age);
        return carrier;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Carrier content) {
    }
}
