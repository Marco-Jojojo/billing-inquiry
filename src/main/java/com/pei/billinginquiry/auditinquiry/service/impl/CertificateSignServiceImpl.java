package com.pei.billinginquiry.auditinquiry.service.impl;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.pei.billinginquiry.auditinquiry.service.CertificateSignService;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author carlos.acosta
 *
 */
@SuppressWarnings("restriction")
@Service
public class CertificateSignServiceImpl implements CertificateSignService {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String signData(final String dataToSign, final String keyFile, final String alias, final String password) {
		FileInputStream keyfis = null;
		try {
			keyfis = new FileInputStream(keyFile);
			final KeyStore store = KeyStore.getInstance("PKCS12");
			store.load(keyfis, password.toCharArray());
			final KeyStore.PrivateKeyEntry pvk = (KeyStore.PrivateKeyEntry) store.getEntry(alias,
			        new KeyStore.PasswordProtection(password.toCharArray()));
			final PrivateKey privateKey = pvk.getPrivateKey();
			final byte[] data = dataToSign.getBytes();
			final Signature rsa = Signature.getInstance("SHA1withRSA");
			rsa.initSign(privateKey);
			rsa.update(data);
			return new String(new Base64().encode(rsa.sign()));
		} catch (final Exception ex) {
			ex.printStackTrace();
		} finally {
			if (keyfis != null) {
				try {
					keyfis.close();
				} catch (final Exception ex) {
				}
			}
		}
		return null;
	}

	public String decryptData(final String dataToDecrypt, final String keyFile, final String alias,
	        final String password) {
		throw new NotImplementedException();
	}
}
