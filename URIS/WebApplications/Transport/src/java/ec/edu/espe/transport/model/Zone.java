/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.model;

/**
 *
 * @author DenniseSandoval
 */
public class Zone {
    private String zoneName;
    private float zonePrice;

    public Zone(String zoneName, float zonePrice) {
        this.zoneName = zoneName;
        this.zonePrice = zonePrice;
    }

    /**
     * @return the zoneName
     */
    public String getZoneName() {
        return zoneName;
    }

    /**
     * @param zoneName the zoneName to set
     */
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    /**
     * @return the zonePrice
     */
    public float getZonePrice() {
        return zonePrice;
    }

    /**
     * @param zonePrice the zonePrice to set
     */
    public void setZonePrice(float zonePrice) {
        this.zonePrice = zonePrice;
    }

    
}
