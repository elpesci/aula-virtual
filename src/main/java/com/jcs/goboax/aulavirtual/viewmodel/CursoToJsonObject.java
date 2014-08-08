package com.jcs.goboax.aulavirtual.viewmodel;

import java.util.List;

/**
 * Created by acardenas on 8/5/14.
 */
public class CursoToJsonObject
{
    int iTotalRecords;
    int iTotalDisplayRecords;
    String sEcho;
    String sColumns;
    List<CourseModel> aaData;

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

    public List<CourseModel> getAaData()
    {
        return aaData;
    }

    public void setAaData(List<CourseModel> aaData)
    {
        this.aaData = aaData;
    }
}
