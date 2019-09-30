/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import ec.edu.espe.transport.model.Customer;
import ec.edu.espe.transport.model.DBConnect;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
@Path("customervalidateidcard")
public class CustomerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource() {
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        try {
            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }

    @Path("{idCard}/{ruc}/{name}/{address}/{telephone}/{phone}/{email}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object validateId(@PathParam("idCard") String idCard, @PathParam("ruc") String ruc, @PathParam("name") String name, @PathParam("address") String address, @PathParam("telephone") String telephone, @PathParam("phone") String phone, @PathParam("email") String email) throws SQLException {
        DBConnect connect = new DBConnect();
        boolean validatorIdCard = false;
        String query;
        PreparedStatement state;
        validatorIdCard = validadorDeCedula(idCard);
        if (validatorIdCard == true) {
            query = "INSERT INTO cliente" + " (ci,ruc,nombre,direccion,telfconvencional,telfcelular,correo) values (?,?,?,?,?,?,?)";
            state = connect.connect().prepareStatement(query);
            state.setString(1, idCard);
            state.setString(2, ruc);
            state.setString(3, name);
            state.setString(4, address);
            state.setString(5, telephone);
            state.setString(6, phone);
            state.setString(7, email);
            state.executeUpdate();
            Customer customer = new Customer(idCard, ruc, name, address, telephone, phone, email);
            return customer;
        }else{
            return validatorIdCard;
        }

    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Customer content) {
    }
}
