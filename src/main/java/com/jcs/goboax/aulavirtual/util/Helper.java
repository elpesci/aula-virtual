package com.jcs.goboax.aulavirtual.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class Helper
{
    public static String encodePassword(String aRawPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String myHashedPassword = passwordEncoder.encode(aRawPassword);

        return myHashedPassword;
    }
}
