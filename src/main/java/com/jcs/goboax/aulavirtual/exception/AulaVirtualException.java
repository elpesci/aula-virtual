package com.jcs.goboax.aulavirtual.exception;

public class AulaVirtualException 
    extends RuntimeException {

    private static final long serialVersionUID = 3261435722552664673L;
    
    public AulaVirtualException(String aString, Throwable aThrowable) {
       super(aString, aThrowable);
    }
}
