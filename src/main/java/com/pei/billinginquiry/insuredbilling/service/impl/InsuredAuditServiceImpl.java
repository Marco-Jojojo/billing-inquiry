package com.pei.billinginquiry.insuredbilling.service.impl;

import com.pei.billinginquiry.insuredbilling.dao.InsuredAuditDAO;
import com.pei.billinginquiry.insuredbilling.model.InsuredAudit;
import com.pei.billinginquiry.insuredbilling.service.InsuredAuditService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 12, 2017
 */
@Service
public class InsuredAuditServiceImpl implements InsuredAuditService
{
    @Autowired
    private InsuredAuditDAO insuredAuditDAO;
    
    @Override
    public List<InsuredAudit> getInsuredAudit(int clientId) {
        return insuredAuditDAO.getInsuredAudit(clientId);
    }

}
