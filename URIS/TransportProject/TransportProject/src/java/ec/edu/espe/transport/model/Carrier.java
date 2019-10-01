/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.model;

import java.util.Date;

/**
 *
 * @author Santiago Vivas
 */
public class Carrier {

    private String carrierCode;
    private String carrierCI;
    private String carrierBirthday;
    private String carrierName;
    private String carrierAddress;
    private String carrierPhone;
    private String carrierCellPhone;
    private String carrierEmail;
    private String licensePlate;
    private String vehiculeType;

    public Carrier() {
        
    }

    

    public Carrier(String carrierCode, String carrierCI, String carrierBirthday, String carrierName, String carrierAddress, String carrierPhone, String carrierCellPhone, String carrierEmail, String licensePlate, String vehiculeType) {
        this.carrierCode = carrierCode;
        this.carrierCI = carrierCI;
        this.carrierBirthday = carrierBirthday;
        this.carrierName = carrierName;
        this.carrierAddress = carrierAddress;
        this.carrierPhone = carrierPhone;
        this.carrierCellPhone = carrierCellPhone;
        this.carrierEmail = carrierEmail;
        this.licensePlate = licensePlate;
        this.vehiculeType = vehiculeType;
    }
    
    


    @Override
    public String toString() {
        return "Carrier{" + "carrierCode=" + getCarrierCode() + ", carrierCI=" + getCarrierCI() + ", carrierBirthday=" + getCarrierBirthday() + ", carrierName=" + getCarrierName() + ", carrierAddress=" + getCarrierAddress() + ", carrierPhone=" + getCarrierPhone() + ", carrierCellPhone=" + getCarrierCellPhone() + ", carrierEmail=" + getCarrierEmail() + ", licensePlate=" + getLicensePlate() + ", vehiculeType=" + getVehiculeType() + '}';
    }

    /**
     * @return the carrierCode
     */
    public String getCarrierCode() {
        return carrierCode;
    }

    /**
     * @param carrierCode the carrierCode to set
     */
    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    /**
     * @return the carrierCI
     */
    public String getCarrierCI() {
        return carrierCI;
    }

    /**
     * @param carrierCI the carrierCI to set
     */
    public void setCarrierCI(String carrierCI) {
        this.carrierCI = carrierCI;
    }

    /**
     * @return the carrierBirthday
     */
    public String getCarrierBirthday() {
        return carrierBirthday;
    }

    /**
     * @param carrierBirthday the carrierBirthday to set
     */
    public void setCarrierBirthday(String carrierBirthday) {
        this.carrierBirthday = carrierBirthday;
    }

    /**
     * @return the carrierName
     */
    public String getCarrierName() {
        return carrierName;
    }

    /**
     * @param carrierName the carrierName to set
     */
    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    /**
     * @return the carrierAddress
     */
    public String getCarrierAddress() {
        return carrierAddress;
    }

    /**
     * @param carrierAddress the carrierAddress to set
     */
    public void setCarrierAddress(String carrierAddress) {
        this.carrierAddress = carrierAddress;
    }

    /**
     * @return the carrierPhone
     */
    public String getCarrierPhone() {
        return carrierPhone;
    }

    /**
     * @param carrierPhone the carrierPhone to set
     */
    public void setCarrierPhone(String carrierPhone) {
        this.carrierPhone = carrierPhone;
    }

    /**
     * @return the carrierCellPhone
     */
    public String getCarrierCellPhone() {
        return carrierCellPhone;
    }

    /**
     * @param carrierCellPhone the carrierCellPhone to set
     */
    public void setCarrierCellPhone(String carrierCellPhone) {
        this.carrierCellPhone = carrierCellPhone;
    }

    /**
     * @return the carrierEmail
     */
    public String getCarrierEmail() {
        return carrierEmail;
    }

    /**
     * @param carrierEmail the carrierEmail to set
     */
    public void setCarrierEmail(String carrierEmail) {
        this.carrierEmail = carrierEmail;
    }

    /**
     * @return the licensePlate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * @param licensePlate the licensePlate to set
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * @return the vehiculeType
     */
    public String getVehiculeType() {
        return vehiculeType;
    }

    /**
     * @param vehiculeType the vehiculeType to set
     */
    public void setVehiculeType(String vehiculeType) {
        this.vehiculeType = vehiculeType;
    }

}
