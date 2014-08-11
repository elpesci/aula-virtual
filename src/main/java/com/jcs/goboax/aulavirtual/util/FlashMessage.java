package com.jcs.goboax.aulavirtual.util;

import java.io.Serializable;

public class FlashMessage
        implements Serializable
{

    private static final long serialVersionUID = 1L;

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private static final String NOTICE = "notice";

    private String message = null;
    private String type = null;
    private String arguments = null;
    private Boolean alternateLocation = false;

    public void message(String type, String message)
    {
        this.type = type;
        this.message = message;
    }

    public void notice(String message)
    {
        this.message(NOTICE, message);
    }

    public void success(String message)
    {
        this.message(SUCCESS, message);
    }

    public void error(String message)
    {
        this.message(ERROR, message);
    }

    public boolean isNotEmpty()
    {
        return message != null && !message.isEmpty();
    }

    public void clear()
    {
        this.message = null;
        this.type = null;
        this.alternateLocation = false;
    }

    public String getMessage()
    {
        String msg = message;
        this.clear();
        return msg;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getArguments()
    {
        return arguments;
    }

    public void setArguments(String arguments)
    {
        this.arguments = arguments;
    }

    public Boolean getAlternateLocation()
    {
        return alternateLocation;
    }

    public void setAlternateLocation(Boolean alternateLocation)
    {
        this.alternateLocation = alternateLocation;
    }
}
