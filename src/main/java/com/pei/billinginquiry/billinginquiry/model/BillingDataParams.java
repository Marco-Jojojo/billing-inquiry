package com.pei.billinginquiry.billinginquiry.model;

import java.io.Serializable;

/**
 * Parameters to call Billing Data's web service.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 8, 2017
 */
public class BillingDataParams implements Serializable
{
    private static final long serialVersionUID = 3656663293974553899L;
    
    private String agencyCode;
    private int policyKey;

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public int getPolicyKey() {
        return policyKey;
    }

    public void setPolicyKey(int policyKey) {
        this.policyKey = policyKey;
    }

    @Override
    public String toString() {
        return "BillingDataParams{" + "agencyCode=" + agencyCode + ", policyKey=" + policyKey + '}';
    }
    
}
