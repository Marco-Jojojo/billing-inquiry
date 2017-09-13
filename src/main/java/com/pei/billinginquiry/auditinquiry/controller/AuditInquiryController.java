package com.pei.billinginquiry.auditinquiry.controller;

import com.pei.billinginquiry.auditinquiry.model.AuditInquiry;
import com.pei.billinginquiry.auditinquiry.service.CertificateSignService;
import com.pei.billinginquiry.auditinquiry.model.SignedUrlParams;
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

import java.io.IOException;
import java.net.URLEncoder;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/AuditInquiry")
public class AuditInquiryController {

    @Autowired
    private AuditInquiryService auditInquiryService;

    @Autowired
    private CertificateSignService certificateSignService;

    @RequestMapping(value="/interimAudit/{submissionNum}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET )
    public HttpEntity<List<AuditInquiry>> interimAudit(@PathVariable int submissionNum) {
        List<AuditInquiry> inquiries = auditInquiryService.findInterimAuditBySubmission(submissionNum);
        return new HttpEntity<List<AuditInquiry>>( inquiries  );
    }

    @RequestMapping(value = "/interimAudit2/{submissionNum}/{submissionNum2}" ,
            produces = MediaType.APPLICATION_JSON_VALUE ,
            method = RequestMethod.GET)
    public HttpEntity<List<AuditInquiry>> interimAudit2(@PathVariable int submissionNum,@PathVariable int submissionNum2) {
        List<AuditInquiry> inquiries = auditInquiryService.findInterimAuditBySubmissionNumbers(submissionNum,submissionNum2);
        return new HttpEntity<List<AuditInquiry>>(inquiries);
    }

    @RequestMapping( value="/generateSignedUrl" , consumes=MediaType.APPLICATION_JSON_VALUE ,
            produces=MediaType.APPLICATION_JSON_VALUE , method = RequestMethod.POST)
    public java.lang.Object generateSignedURL(@RequestBody SignedUrlParams signedUrlParams) throws KeyStoreException,
            IOException, CertificateException, NoSuchAlgorithmException {
        String certificatePassword = "yosemite";
        String signatureFile = "peiaudit.jks";
        String alias = "yosemite";
        String parameterUrl = this.generateParameterUrl(signedUrlParams);
        String signedData = certificateSignService.signData( parameterUrl , signatureFile , alias , certificatePassword  );
        return signedData;
    }
    public java.lang.Object generateSignedURLTrupay(java.lang.String sUserId,
                                                    java.lang.String sEmail,
                                                    java.lang.String sPolicyToken) {
        throw new NotImplementedException();
    }
    public java.lang.Object decryptURLTrupay(java.lang.String encryptedURL) {
        throw new NotImplementedException();
    }
    public java.lang.Object decryptURLTrupay2(java.lang.String encryptedURL) {
        throw new NotImplementedException();
    }


    private String generateParameterUrl(SignedUrlParams signedUrlParams){
        StringBuilder queryString = new StringBuilder();
        queryString.append("c=");
        queryString.append(URLEncoder.encode( signedUrlParams.getInterface() ));
        queryString.append("p=");
        queryString.append(URLEncoder.encode( signedUrlParams.getPolicy() ));
        queryString.append("a=");
        queryString.append(URLEncoder.encode( signedUrlParams.getSolicitation() ));
        queryString.append("n=");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy H:mm:ss");
        queryString.append(URLEncoder.encode( simpleDateFormat.format( new Date()  )));
        queryString.append("i=");
        queryString.append(URLEncoder.encode(signedUrlParams.getItem()));
        queryString.append("m=");
        queryString.append(URLEncoder.encode( signedUrlParams.getMultiAudits() ));
        queryString.append("name=");
        queryString.append(URLEncoder.encode(signedUrlParams.getFirstName()+" "+signedUrlParams.getLastName()));
        queryString.append("email=");
        queryString.append(URLEncoder.encode(signedUrlParams.getEmail()));
        return queryString.toString();
    }


}
