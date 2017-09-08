package com.pei.billinginquiry.billinginquiry.model;

import java.io.Serializable;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
public class FilenetDocParams implements Serializable
{
    private static final long serialVersionUID = 3656663293974553897L;
    
    private String fromDate;
    private String toDate;
    private String agencyCode;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    @Override
    public String toString() {
        return "FilenetDocParams{" + "fromDate=" + fromDate + ", toDate=" + toDate + ", agencyCode=" + agencyCode + '}';
    }
    
}
