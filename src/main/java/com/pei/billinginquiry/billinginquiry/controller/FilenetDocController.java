package com.pei.billinginquiry.billinginquiry.controller;

import com.pei.billinginquiry.billinginquiry.model.FilenetDoc;
import com.pei.billinginquiry.billinginquiry.model.FilenetDocParams;
import com.pei.billinginquiry.billinginquiry.service.FilenetDocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller layer for Filenet Documents.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
@RestController
@RequestMapping("/BillingInquiry")
public class FilenetDocController
{
    @Autowired
    private FilenetDocService filenetDocService;
    
    /**
     * Exposes Web Service in http://host:8080/BillingInquiry/GetFilenetDocByDateRange which receives the FilenetDocParams parameters: fromDate, toDate, and agencyCode.
     * @param filenetDocParams FilenetDocParams parameters: fromDate, toDate, and agencyCode.
     * @return JSON list of FilenetDoc.
     */
    @RequestMapping(value = {"/GetFilenetDocByDateRange**"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<FilenetDoc> getFilenetDocByDateRange(@RequestBody FilenetDocParams filenetDocParams) {
        return filenetDocService.getFilenetDocByDateRange(filenetDocParams);
    }
}
