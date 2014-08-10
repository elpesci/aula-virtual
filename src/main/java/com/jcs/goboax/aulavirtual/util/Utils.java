package com.jcs.goboax.aulavirtual.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class Utils
{
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
}
