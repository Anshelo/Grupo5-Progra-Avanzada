/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.Zone;
import ec.edu.espe.transportist.control.ZoneDAO;
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

    @GET
    @Path("zones")
    public ArrayList<Zone> getZones() {
        ZoneDAO zdao = new ZoneDAO();
        ArrayList<Zone> listaZ = new ArrayList<Zone>();
        listaZ = zdao.mostrarZonas();
        return listaZ;
    }

    @PUT
    @Path("/modify/zone")
    public ArrayList<Zone> modificarZona(Zone date) {
        ZoneDAO zdao = new ZoneDAO();
        zdao.modificarZonas(date);
        ZoneDAO dao = new ZoneDAO();
        ArrayList<Zone> listaZ = new ArrayList<Zone>();
        listaZ = dao.mostrarZonaCodigo(date.getCodigozona());
        return listaZ;

    }

    @Path("/removezone/{codigozona}")
    @DELETE
    public ArrayList<Zone> borrarZona(@PathParam("codigozona") String codigozona) {
        ZoneDAO zdao = new ZoneDAO();
        zdao.borrarZona(codigozona);
        ArrayList<Zone> listaZ = new ArrayList<>();
        listaZ = zdao.mostrarZonas();
        return listaZ;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Zone content) {
    }
}
