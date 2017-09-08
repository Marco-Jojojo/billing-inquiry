package com.pei.billinginquiry.billinginquiry.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Model for Billing Data.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 8, 2017
 */
public class BillingData implements Serializable
{
    private static final long serialVersionUID = 3656663293974553898L;
    
    private int billingKey;
    private String description;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
    private Timestamp fromDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
    private Timestamp toDate;
    private double amount;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
    private Timestamp dueDate;

    @JsonProperty("BillingKey")
    public int getBillingKey() {
        return billingKey;
    }

    public void setBillingKey(int billingKey) {
        this.billingKey = billingKey;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("FromDate")
    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    @JsonProperty("ToDate")
    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    @JsonProperty("Amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @JsonProperty("DueDate")
    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "BillingData{" + "billingKey=" + billingKey + ", description=" + description + ", fromDate=" + fromDate + ", toDate=" + toDate + ", amount=" + amount + ", dueDate=" + dueDate + '}';
    }
    
}
