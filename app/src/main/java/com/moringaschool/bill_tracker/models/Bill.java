package com.moringaschool.bill_tracker.models;

import java.io.Serializable;

public class Bill implements Serializable {
    private String billName;
    private String amount ;
    private String dueDate;
    private String description;

    public Bill(String billName, String amount, String dueDate, String description) {
        this.billName = billName;
        this.amount = amount;
        this.dueDate = dueDate;
        this.description = description;
    }

    public Bill() {
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
