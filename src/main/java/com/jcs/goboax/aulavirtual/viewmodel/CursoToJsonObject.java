package com.jcs.goboax.aulavirtual.viewmodel;

import com.jcs.goboax.aulavirtual.model.Curso;

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
    List<Curso> aaData;

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

    public List<Curso> getAaData()
    {
        return aaData;
    }

    public void setAaData(List<Curso> aaData)
    {
        this.aaData = aaData;
    }
}
