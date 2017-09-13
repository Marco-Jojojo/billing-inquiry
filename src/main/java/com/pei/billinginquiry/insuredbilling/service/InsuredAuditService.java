package com.pei.billinginquiry.insuredbilling.service;

import com.pei.billinginquiry.insuredbilling.model.InsuredAudit;
import java.util.List;

/**
 * Service Layer for Insured Audit.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 12, 2017
 */
public interface InsuredAuditService
{
    /**
     * Gets Insured Audit information given a client ID.
     * @param clientId Client identifier.
     * @return A list of Insured Audit.
     */
    List<InsuredAudit> getInsuredAudit(int clientId);
}
