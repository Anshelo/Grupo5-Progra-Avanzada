/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

/**
 *
 * @author Anshelo
 */
public class CarrierVO {
   private int idCarrier;
   private String ci;
   private String birthDate;
   private String name;
   private String address;
   private String phone;
   private String mobile;
   private String email;
   private String truckPlate;
   private String truckType;

    public CarrierVO() {
    }

    public CarrierVO(int idCarrier, String ci, String birthDate, String name, String address, String phone, String mobile, String email, String truckPlate, String truckType) {
        this.idCarrier = idCarrier;
        this.ci = ci;
        this.birthDate = birthDate;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.truckPlate = truckPlate;
        this.truckType = truckType;
    }

   
   
    /**
     * @return the idCarrier
     */
    public int getIdCarrier() {
        return idCarrier;
    }

    /**
     * @param idCarrier the idCarrier to set
     */
    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    /**
     * @return the ci
     */
    public String getCi() {
        return ci;
    }

    /**
     * @param ci the ci to set
     */
    public void setCi(String ci) {
        this.ci = ci;
    }

    /**
     * @return the birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the truckPlate
     */
    public String getTruckPlate() {
        return truckPlate;
    }

    /**
     * @param truckPlate the truckPlate to set
     */
    public void setTruckPlate(String truckPlate) {
        this.truckPlate = truckPlate;
    }

    /**
     * @return the truckType
     */
    public String getTruckType() {
        return truckType;
    }

    /**
     * @param truckType the truckType to set
     */
    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }
   
   
}
