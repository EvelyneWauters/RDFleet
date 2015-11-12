package com.realdolmen.rdfleet.services.DTO;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.employee.Employee;

import java.io.Serializable;

/**
 * Created by EWTAX45 on 11/11/2015.
 */

public class NewCarAssignation implements Serializable {
//    private Order order;
    private Long orderId;
    private String numberPlate;
    private String vinNumber;
    private int leasingDurationYears;


    public NewCarAssignation() {
    }


    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getLeasingDurationYears() {
        return leasingDurationYears;
    }

    public void setLeasingDurationYears(int leasingDurationYears) {
        this.leasingDurationYears = leasingDurationYears;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    //    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
}
