package com.pei.billinginquiry.auditinquiry.controller;

import com.pei.billinginquiry.auditinquiry.model.AuditInquiry;
import com.pei.billinginquiry.billinginquiry.model.SignedUrlParams;
import com.pei.billinginquiry.auditinquiry.service.AuditInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/AuditInquiry")
public class AuditInquiryController {

    @Autowired
    private AuditInquiryService auditInquiryService;

    @RequestMapping(value="/interimAudit/{submissionNum}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET )
    public HttpEntity<List<AuditInquiry>> interimAudit(@PathVariable int submissionNum) {
        List<AuditInquiry> inquiries = auditInquiryService.findInterimAuditBySubmission(submissionNum);
        return new HttpEntity<List<AuditInquiry>>( inquiries  );
    }

    @RequestMapping(value = "/interimAudit2/{submissionNum}/{submissionNum2}" , produces = MediaType.APPLICATION_JSON_VALUE , method = RequestMethod.GET)
    public HttpEntity<List<AuditInquiry>> interimAudit2(@PathVariable int submissionNum,@PathVariable int submissionNum2) {
        List<AuditInquiry> inquiries = auditInquiryService.findInterimAuditBySubmissionNumbers(submissionNum,submissionNum2);
        return new HttpEntity<List<AuditInquiry>>(inquiries);
    }

    @RequestMapping( value="/generateSignedUrl" , consumes=MediaType.APPLICATION_JSON_VALUE ,
            produces=MediaType.APPLICATION_JSON_VALUE , method = RequestMethod.POST)
    public java.lang.Object generateSignedURL(@RequestBody SignedUrlParams signedUrlParams){
        String certificatePassword = "yosemite";
        String signatureFile = "peiaudit.jks";
        StringBuilder parameterUrl = new StringBuilder();
        parameterUrl.append("c=");
        parameterUrl.append(URLEncoder.encode(signedUrlParams.getInterface()));



        throw new NotImplementedException();
    }
    public java.lang.Object generateSignedURLTrupay(java.lang.String sUserId, java.lang.String sEmail, java.lang.String sPolicyToken) {
        throw new NotImplementedException();
    }
    public java.lang.Object decryptURLTrupay(java.lang.String encryptedURL) {
        throw new NotImplementedException();
    }
    public java.lang.Object decryptURLTrupay2(java.lang.String encryptedURL) {
        throw new NotImplementedException();
    }


}
