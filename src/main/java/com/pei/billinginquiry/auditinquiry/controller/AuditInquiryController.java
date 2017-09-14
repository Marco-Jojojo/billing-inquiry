package com.pei.billinginquiry.auditinquiry.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pei.billinginquiry.auditinquiry.model.AuditInquiry;
import com.pei.billinginquiry.auditinquiry.model.SignedUrlParams;
import com.pei.billinginquiry.auditinquiry.model.UserDetailParameters;
import com.pei.billinginquiry.auditinquiry.service.AuditInquiryService;
import com.pei.billinginquiry.auditinquiry.service.CertificateSignService;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@SuppressWarnings("restriction")
@Controller
@RequestMapping("/AuditInquiry")
public class AuditInquiryController {
	private static final String UTF8 = "utf-8";
	@Autowired
	private AuditInquiryService auditInquiryService;
	@Autowired
	private CertificateSignService certificateSignService;
	private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("MM/dd/yyyy H:mm:ss");

	/**
	 * Exposes web service in
	 * http://host:8080/AuditInquiry/interimAudit/{submissionNumber}
	 * submissionNumber is a path variable used in this web service.
	 *
	 * @param submissionNum
	 *            parameter for a submission number
	 * @return a list of interim audits contained in a submission number.
	 */
	@RequestMapping(value = "/interimAudit/{submissionNum}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public HttpEntity<List<AuditInquiry>> interimAudit(@PathVariable final int submissionNum) {
		final List<AuditInquiry> inquiries = auditInquiryService.findInterimAuditBySubmission(submissionNum);
		return new HttpEntity<List<AuditInquiry>>(inquiries);
	}

	/**
	 * Exposes web service in
	 * http://host:8080/AuditInquiry/interimAudit/{submissionNum}/{submissionNum2}
	 * submissionNum and submissionNum2 are path variables used in this web
	 * service.
	 *
	 * @param submissionNum
	 *            submission Number used for interim audit parameter
	 * @param submissionNum2
	 *            alternative submission Number used for interim audit parameter
	 * @return a list of interim audits contained in a submission numbers.
	 */
	@RequestMapping(value = "/interimAudit2/{submissionNum}/{submissionNum2}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public HttpEntity<List<AuditInquiry>> interimAudit2(@PathVariable final int submissionNum,
	        @PathVariable final int submissionNum2) {
		final List<AuditInquiry> inquiries = auditInquiryService.findInterimAuditBySubmissionNumbers(submissionNum,
		        submissionNum2);
		return new HttpEntity<List<AuditInquiry>>(inquiries);
	}

	/**
	 * generates a encoded encrypted url part. this method exposes web service
	 * as: http://host:8080/AuditInquiry/interimAudit/generateSignedUrl
	 *
	 * @param signedUrlParams
	 *            signed params is a json multipart value used for receiving key
	 *            value pairs used to generate signed url.
	 * @return
	 * @throws KeyStoreException
	 *             if key algorithm could not be generated.
	 * @throws IOException
	 *             if IO error occurs when reading/writing a file.
	 * @throws CertificateException
	 *             if a certificate operation could not be completed normally.
	 * @throws NoSuchAlgorithmException
	 *             if a key store algorithm does not exist when executing
	 *             operations on key stores.
	 */
	@RequestMapping(value = "/generateSignedUrl", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public java.lang.Object generateSignedURL(@RequestBody final SignedUrlParams signedUrlParams,
	        final HttpServletRequest request)
	        throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
		final String certificatePassword = "yosemite";
		final String signatureFile = "peiaudit.jks";
		final String alias = "yosemite";
		final String parameterUrl = this.generateParameterUrl(signedUrlParams);
		final String signedData = certificateSignService.signData(parameterUrl, signatureFile, alias,
		        certificatePassword);
		return request.getRequestURL().toString() + "?" + signedData;
	}

	/**
	 * no description yet.
	 *
	 * @param sUserId
	 * @param sEmail
	 * @param sPolicyToken
	 * @return
	 */
	public java.lang.Object generateSignedURLTrupay(@RequestBody final UserDetailParameters userParameters,
	        final HttpServletRequest request) throws UnsupportedEncodingException {
		final String dateCreated = AuditInquiryController.DATEFORMAT.format(new Date());
		final String certificatePassword = "yosemite";
		final String signatureFile = "peiaudit.jks";
		final String alias = "yosemite";
		final String urlParameters = "uid=" + URLEncoder.encode(userParameters.getUserId(), AuditInquiryController.UTF8)
		        + "&emailid=" + URLEncoder.encode(userParameters.getEmail(), AuditInquiryController.UTF8)
		        + "&policyHolderToken="
		        + URLEncoder.encode(userParameters.getPolicyToken(), AuditInquiryController.UTF8) + "&id=500";
		final String signedData = this.certificateSignService.signData(urlParameters, signatureFile, alias,
		        certificatePassword);
		return request.getRequestURL().toString() + "?" + signedData;
	}

	/**
	 * no description yet
	 *
	 * @param encryptedURL
	 * @return
	 */
	public java.lang.Object decryptURLTrupay(final java.lang.String encryptedURL) {
		throw new NotImplementedException();
	}

	/**
	 * no description yet
	 *
	 * @param encryptedURL
	 * @return
	 */
	public java.lang.Object decryptURLTrupay2(final java.lang.String encryptedURL) {
		throw new NotImplementedException();
	}

	/**
	 * no description yet
	 *
	 * @param signedUrlParams
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private String generateParameterUrl(final SignedUrlParams signedUrlParams) throws UnsupportedEncodingException {
		final StringBuilder queryString = new StringBuilder();
		queryString.append("c=");
		queryString.append(URLEncoder.encode(signedUrlParams.getInterface(), AuditInquiryController.UTF8));
		queryString.append("&p=");
		queryString.append(URLEncoder.encode(signedUrlParams.getPolicy(), AuditInquiryController.UTF8));
		queryString.append("&a=");
		queryString.append(URLEncoder.encode(signedUrlParams.getSolicitation(), AuditInquiryController.UTF8));
		queryString.append("&n=");
		queryString.append(
		        URLEncoder.encode(AuditInquiryController.DATEFORMAT.format(new Date()), AuditInquiryController.UTF8));
		queryString.append("&i=");
		queryString.append(URLEncoder.encode(signedUrlParams.getItem(), AuditInquiryController.UTF8));
		queryString.append("&m=");
		queryString.append(URLEncoder.encode(signedUrlParams.getMultiAudits(), AuditInquiryController.UTF8));
		queryString.append("&name=");
		queryString.append(URLEncoder.encode(signedUrlParams.getFirstName() + " " + signedUrlParams.getLastName(),
		        AuditInquiryController.UTF8));
		queryString.append("&email=");
		queryString.append(URLEncoder.encode(signedUrlParams.getEmail(), AuditInquiryController.UTF8));
		return queryString.toString();
	}
}
