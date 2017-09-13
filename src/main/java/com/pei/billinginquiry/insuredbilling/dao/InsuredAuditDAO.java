package com.pei.billinginquiry.insuredbilling.dao;

import com.pei.billinginquiry.insuredbilling.model.InsuredAudit;
import java.util.List;

/**
 * DAO layer for Insured Audit.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 12, 2017
 */
public interface InsuredAuditDAO
{
    /**
     * Execution of the existing stored procedure dbo.InsuredAuditQuery.
     * @param clientId Client identifier.
     * @return A list of Insured Audit objects of the client.
     */
    List<InsuredAudit> getInsuredAudit(int clientId);
}
