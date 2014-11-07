package com.jcs.goboax.aulavirtual.util;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public abstract class Utils
{
    private static final String PERIOD = ".";

    public static String encodePassword(String aRawPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String myHashedPassword = passwordEncoder.encode(aRawPassword);

        return myHashedPassword;
    }

    /**
     * Generates a random password with numbers and letters
     *
     * @return A random password
     */
    public static String generateRandomPassword()
    {
        return Long.toHexString(Double.doubleToLongBits(Math.random())).substring(8);
    }

    public static String generateVerificationKey(String aString, String aSalt) throws NoSuchAlgorithmException
    {
        return Base64.encode(computeVerificationHash(aString, aSalt));
    }

    public static byte[] computeVerificationHash(String aString, String aSalt) throws NoSuchAlgorithmException
    {
        MessageDigest myMessageDigest = null;
        String saltedKey = aString + "." + aSalt;
        myMessageDigest = MessageDigest.getInstance("SHA-256");
        myMessageDigest.update(saltedKey.getBytes(), 0, aString.length());
        return myMessageDigest.digest();
    }

    public static String convertListExtensionsToAcceptString(List<String> anExtensions)
    {
        return PERIOD + StringUtils.join(anExtensions, ",.");
    }
}
