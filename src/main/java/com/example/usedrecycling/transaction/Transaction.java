package com.example.usedrecycling.transaction;

public class Transaction {
    private Integer productId;
    private Integer id;
    private Integer sellerId;
    private Integer custId;
    private String mailLocation;
    private Integer status;
    private Integer number;

    public Transaction(Integer productId, Integer id, Integer sellerId, Integer custId, String mailLocation, Integer status, Integer number) {
        this.productId = productId;
        this.id = id;
        this.sellerId = sellerId;
        this.custId = custId;
        this.mailLocation = mailLocation;
        this.status = status;
        this.number = number;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getMailLocation() {
        return mailLocation;
    }

    public void setMailLocation(String mailLocation) {
        this.mailLocation = mailLocation;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
