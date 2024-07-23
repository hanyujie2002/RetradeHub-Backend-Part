package com.example.usedrecycling.transaction;

public class TransactionPostRequest {
    private String mailLocation;
    private Integer number;

    public TransactionPostRequest(String mailLocation, Integer number) {
        this.mailLocation = mailLocation;
        this.number = number;
    }

    public String getMailLocation() {
        return mailLocation;
    }

    public void setMailLocation(String mailLocation) {
        this.mailLocation = mailLocation;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
