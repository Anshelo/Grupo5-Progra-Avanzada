/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.model;

/**
 *
 * @author Santiago Vivas
 */
public class Product {

    private String productCode;
    private String productName;
    private String productDescription;
    private float productWeigth;
    private String productSensitivy;
    private String productUnitValue;

    public Product() {
    }

    public Product(String productCode, String productName, String productDescription, float productWeigth, String productSensitivy, String productUnitValue) {
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productWeigth = productWeigth;
        this.productSensitivy = productSensitivy;
        this.productUnitValue = productUnitValue;
    }


    @Override
    public String toString() {
        return "Product{" + "productCode=" + getProductCode() + ", productName=" + getProductName() + ", productDescription=" + getProductDescription() + ", productWeigth=" + getProductWeigth() + ", productSensitivy=" + getProductSensitivy() + ", productUnitValue=" + getProductUnitValue() + '}';
    }

    /**
     * @return the productCode
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * @param productCode the productCode to set
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * @param productDescription the productDescription to set
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * @return the productWeigth
     */
    public float getProductWeigth() {
        return productWeigth;
    }

    /**
     * @param productWeigth the productWeigth to set
     */
    public void setProductWeigth(float productWeigth) {
        this.productWeigth = productWeigth;
    }

    /**
     * @return the productSensitivy
     */
    public String getProductSensitivy() {
        return productSensitivy;
    }

    /**
     * @param productSensitivy the productSensitivy to set
     */
    public void setProductSensitivy(String productSensitivy) {
        this.productSensitivy = productSensitivy;
    }

    /**
     * @return the productUnitValue
     */
    public String getProductUnitValue() {
        return productUnitValue;
    }

    /**
     * @param productUnitValue the productUnitValue to set
     */
    public void setProductUnitValue(String productUnitValue) {
        this.productUnitValue = productUnitValue;
    }

}
