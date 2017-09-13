package com.pei.billinginquiry.auditinquiry.service;

/**
 * this service contains the method to generate a certificate sign.
 * 
 * @author carlos.acosta
 *
 */
public interface CertificateSignService {
	/**
	 * Generate encrypted parameter url part.
	 * 
	 * @param dataToSign
	 *            query string used to query an url
	 * @param keyFile
	 *            key file location
	 * @param alias
	 *            alias for key
	 * @param password
	 *            key file password
	 * @return an base64 encrypted url part
	 */
	String signData(String dataToSign, String keyFile, String alias, String password);
}
