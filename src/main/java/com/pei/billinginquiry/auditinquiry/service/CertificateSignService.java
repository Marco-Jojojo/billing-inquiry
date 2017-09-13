package com.pei.billinginquiry.auditinquiry.service;

import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;


public interface CertificateSignService {



    String signData(String dataToSign, String keyFile , String alias , String password ) ;



}
