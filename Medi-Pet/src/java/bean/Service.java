package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Service{

    private int serviceNo;
    private String serviceType;
    private String petType;
    private String status;

    /*public Service(String serviceNo, String serviceType, double servicePrice) {
        this.SERVICENO = SERVICENO;
        this.serviceType = serviceType;
        this.servicePrice = servicePrice;
    }
    
    Service() {
    }*/

    public int getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(int serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
