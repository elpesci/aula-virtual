package com.jcs.goboax.aulavirtual.viewmodel;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ContentModelForm
{
    private Integer id;
    private String name;
    private CommonsMultipartFile content;
    private String description;
    private Integer contentTypeId;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

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

    public Integer getContentTypeId()
    {
        return contentTypeId;
    }

    public void setContentTypeId(Integer contentTypeId)
    {
        this.contentTypeId = contentTypeId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
