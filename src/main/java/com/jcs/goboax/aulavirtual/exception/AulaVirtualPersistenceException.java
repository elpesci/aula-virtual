package com.jcs.goboax.aulavirtual.exception;

/**
 * Created by acardenas on 8/6/14.
 */
public class AulaVirtualPersistenceException
    extends AulaVirtualException
{
    public AulaVirtualPersistenceException()
    {
    }

    public AulaVirtualPersistenceException(String aString)
    {
        super(aString);
    }

    public AulaVirtualPersistenceException(String aString, Throwable aThrowable)
    {
        super(aString, aThrowable);
    }
}
