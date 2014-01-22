package com.usavich.common.cryptoservice.impl;

import com.usavich.common.cryptoservice.CryptoService;
import com.usavich.common.lib.CommonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.codec.binary.Base64;
import org.springframework.util.Assert;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/5/13
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class CryptoServiceImpl implements CryptoService {

    private static final Log log = LogFactory.getLog(CryptoServiceImpl.class);

    private static final int SECRET_KEY_LENGTH = 24;
    private static final InputStream SECRET_KEY_NOT_FOUND = null;
    private static final String ALGORITHM = "TripleDES";
    private static final String CHARSET = "UTF-8";

    //will config later
    private String secretKey = "gLadFzYcmiMbDuuVsTBsbzUQ";

    private SecretKey key;

    public CryptoServiceImpl() {
        initialize();
    }

    @Override
    public String encrypt(String value) {
        Assert.state(key != null);
        CommonUtils.checkString(value, "value");

        try {
            Cipher cipherEncrypt = Cipher.getInstance(ALGORITHM);
            cipherEncrypt.init(Cipher.ENCRYPT_MODE, key);
            return new String(Base64.encodeBase64(cipherEncrypt.doFinal(value.getBytes(CHARSET))), CHARSET);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String decrypt(String value) {
        Assert.state(key != null);
        CommonUtils.checkString(value, "value");

        try {
            Cipher cipherDecrypt = Cipher.getInstance(ALGORITHM);
            cipherDecrypt.init(Cipher.DECRYPT_MODE, key);
            return new String(cipherDecrypt.doFinal(Base64.decodeBase64(value.getBytes(CHARSET))), CHARSET);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void initialize() {
        InputStream keyStream = SECRET_KEY_NOT_FOUND;
        try {
            // try to get available key stream
            keyStream = getSecretKeyStream();
            Assert.state(keyStream != SECRET_KEY_NOT_FOUND, "Secret key file can't be found.");

            // initialize secret key
            byte[] keyBytes = new byte[SECRET_KEY_LENGTH];
            keyStream.read(keyBytes);
            key = new SecretKeySpec(keyBytes, ALGORITHM);
            Assert.state(key != null, "Failed to create secret key with algorithm [" + ALGORITHM + "]");
        } catch (Exception e) {
            // log and ignore the exception silently
            log.error("Error occurred during initializing cipher.", e);
        } finally {
            try {
                if (keyStream != null) {
                    keyStream.close();
                }
            } catch (IOException e) {
                // silently ignore
                log.warn("Error occurred during closing key file stream.", e);
            }
        }
    }

    private InputStream getSecretKeyStream() {
        return new ByteArrayInputStream(secretKey.getBytes());
    }
}
