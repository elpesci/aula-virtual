package com.jcs.goboax.aulavirtual.viewmodel;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ContentModelForm
{
    private String name;
    private CommonsMultipartFile content;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public CommonsMultipartFile getContent()
    {
        return content;
    }
    
    public void setContent(CommonsMultipartFile content)
    {
        this.content = content;
    }
}
