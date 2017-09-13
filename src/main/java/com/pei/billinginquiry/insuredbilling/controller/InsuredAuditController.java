package com.pei.billinginquiry.insuredbilling.controller;

import com.pei.billinginquiry.insuredbilling.model.InsuredAudit;
import com.pei.billinginquiry.insuredbilling.service.InsuredAuditService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller layer for Insured Audit information.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 12, 2017
 */
@RestController
@RequestMapping("/InsuredBilling")
public class InsuredAuditController
{
    @Autowired
    private InsuredAuditService insuredAuditService;
    
    /**
     * Exposes Web Service in http://host:8080/InsuredBilling/InsuredAuditQuery/{clientId} which receives the Client ID.
     * @param clientId Client ID.
     * @return JSON list of  Insured Audit information.
     */
    @RequestMapping(value = {"/InsuredAuditQuery/{clientId}"}, method = RequestMethod.GET)
    public List<InsuredAudit> getInsuredAudit(@PathVariable int clientId) {
        return insuredAuditService.getInsuredAudit(clientId);
    }
}
