package com.pei.billinginquiry.auditinquiry.service.impl;

import com.pei.billinginquiry.auditinquiry.service.CertificateSignService;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;

@Service
public class CertificateSignServiceImpl implements CertificateSignService {


    public String signData(String dataToSign, String keyFile , String alias , String password ) {
        FileInputStream keyfis = null;
        try {
            keyfis = new FileInputStream(keyFile);
            KeyStore store = KeyStore.getInstance("PKCS12");
            store.load(keyfis, password.toCharArray());
            KeyStore.PrivateKeyEntry pvk = (KeyStore.PrivateKeyEntry)store.
                    getEntry(alias,
                            new KeyStore.PasswordProtection(password.toCharArray()));
            PrivateKey privateKey = (PrivateKey)pvk.getPrivateKey();
            byte[] data = dataToSign.getBytes();
            Signature rsa = Signature.getInstance("SHA1withRSA");
            rsa.initSign(privateKey);
            rsa.update(data);
            return new BASE64Encoder().encode(rsa.sign());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if ( keyfis != null ) {
                try {
                    keyfis.close();
                } catch (Exception ex) {

                }
            }
        }
        return null;
    }
}
