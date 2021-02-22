package app.model.entity;

import java.time.LocalDate;

public class Order {
    private int id;
    private String clientName;
    private String orderName;
    private String masterName;
    private String masterStatus;
    private String mgrStatus;
    private double price;
    private LocalDate date;
    private String review;

    public Order(int id, String clientName, String orderName, String masterName, String masterStatus, String mgrStatus, double price, LocalDate date, String review) {
        this.id = id;
        this.clientName = clientName;
        this.orderName = orderName;
        this.masterName = masterName;
        this.masterStatus = masterStatus;
        this.mgrStatus = mgrStatus;
        this.price = price;
        this.date = date;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterStatus() {
        return masterStatus;
    }

    public void setMasterStatus(String masterStatus) {
        this.masterStatus = masterStatus;
    }

    public String getMgrStatus() {
        return mgrStatus;
    }

    public void setMgrStatus(String mgrStatus) {
        this.mgrStatus = mgrStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

