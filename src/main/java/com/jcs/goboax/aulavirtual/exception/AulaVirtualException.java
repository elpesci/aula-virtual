package com.jcs.goboax.aulavirtual.exception;

public class AulaVirtualException
        extends RuntimeException
{

    private static final long serialVersionUID = 3261435722552664673L;

    public AulaVirtualException()
    {
        super();
    }
    
    public AulaVirtualException(Throwable aThrowable)
    {
        super(aThrowable);
    }

    public AulaVirtualException(String aString)
    {
        super(aString);
    }

    public AulaVirtualException(String aString, Throwable aThrowable)
    {
        super(aString, aThrowable);
    }
}
