/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author L3oN
 */
public class Order {

    private int orderID;
    private Date ordDate;
    private Date shipdate;
    private int status;
    private int accID;

    public Order() {
    }

    public Order(int orderID, Date ordDate, Date shipdate, int status, int accID) {
        this.orderID = orderID;
        this.ordDate = ordDate;
        this.shipdate = shipdate;
        this.status = status;
        this.accID = accID;
    }

    public Date getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
 
}
