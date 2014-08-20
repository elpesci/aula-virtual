package com.jcs.goboax.aulavirtual.viewmodel;

import java.io.Serializable;
import java.util.List;

public class ObjectToJsonObject<T>
    implements Serializable
{

    private static final long serialVersionUID = -4354551450460679243L;
    
    int iTotalRecords;
    int iTotalDisplayRecords;
    String sEcho;
    String sColumns;
    List<T> aaData;

    public int getiTotalRecords()
    {
        return iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords)
    {
        this.iTotalRecords = iTotalRecords;
    }

    public int getiTotalDisplayRecords()
    {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords)
    {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public String getsEcho()
    {
        return sEcho;
    }

    public void setsEcho(String sEcho)
    {
        this.sEcho = sEcho;
    }

    public String getsColumns()
    {
        return sColumns;
    }

    public void setsColumns(String sColumns)
    {
        this.sColumns = sColumns;
    }

    public List<T> getAaData()
    {
        return aaData;
    }

    public void setAaData(List<T> aaData)
    {
        this.aaData = aaData;
    }
}
