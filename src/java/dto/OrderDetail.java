/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author L3oN
 */
public class OrderDetail {

    private int detailID;
    private int orderID;    //o
    private int plantID;
    private String plantName;   //o
    private double price;       //o
    private String imgPath;     //o
    private int quantity;       //o
    private int status;

    public OrderDetail() {
    }

    public OrderDetail(int detailID, int orderID, int plantID, String plantName, double price, String imgPath, int quantity, int status) {
        this.detailID = detailID;
        this.orderID = orderID;
        this.plantID = plantID;
        this.plantName = plantName;
        this.price = price;
        this.imgPath = imgPath;
        this.quantity = quantity;
        this.status = status;
    }

    public OrderDetail(int detailID, int orderID, int plantID, String plantName, double price, String imgPath, int quantity) {
        this.detailID = detailID;
        this.orderID = orderID;
        this.plantID = plantID;
        this.plantName = plantName;
        this.price = price;
        this.imgPath = imgPath;
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getPlantID() {
        return plantID;
    }

    public void setPlantID(int plantID) {
        this.plantID = plantID;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
