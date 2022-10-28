package com.se.onlinemoviebooking.application.services;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Base64;


public class EncryptionService implements AttributeConverter<String, String> {

    private static final String AES = "AES";
    private static final String SECRET = "secret-key-74829"; //16, 24 or 32 bytes

    private final Key key;
    private final Cipher cipher;
    
    
    private static EncryptionService encryptionService = null;
    
    //let this be singleton for now
    public static EncryptionService getInstance()
    {
        if (encryptionService == null) {
        	try {
				encryptionService = new EncryptionService();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
  
        return encryptionService;
    }

    public EncryptionService() throws Exception {
        key = new SecretKeySpec(SECRET.getBytes(), AES);
        cipher = Cipher.getInstance("AES");
    }
    
    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(attribute.getBytes("UTF-8")));
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(dbData)));
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new IllegalStateException(e);
        }
    }
}
