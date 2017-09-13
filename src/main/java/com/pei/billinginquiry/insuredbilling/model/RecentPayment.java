package com.pei.billinginquiry.insuredbilling.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 12, 2017
 */
public class RecentPayment implements Serializable
{
    private static final long serialVersionUID = 3656663293974553900L;
    
    private String policyNumber;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
    private Timestamp entryDate;
    private double amount;
    private String checkNumber;

    @JsonProperty("PolicyNumber")
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    @JsonProperty("EntryDate")
    public Timestamp getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Timestamp entryDate) {
        this.entryDate = entryDate;
    }

    @JsonProperty("Amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @JsonProperty("CheckNumber")
    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public String toString() {
        return "RecentPayment{" + "policyNumber=" + policyNumber + ", entryDate=" + entryDate + ", amount=" + amount + ", checkNumber=" + checkNumber + '}';
    }
    
}
