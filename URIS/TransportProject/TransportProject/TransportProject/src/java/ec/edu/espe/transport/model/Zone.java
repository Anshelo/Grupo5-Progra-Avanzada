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
public class Zone {
    private String zoneCode;
    private String zoneName;
    
    public Zone(){}

    public Zone(String zoneCode, String zoneName) {
        this.zoneCode = zoneCode;
        this.zoneName = zoneName;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    @Override
    public String toString() {
        return "Zone{" + "zoneCode=" + zoneCode + ", zoneName=" + zoneName + '}';
    }
    
    
}
