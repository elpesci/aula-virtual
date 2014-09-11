package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Contenido;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.viewmodel.ContentModelForm;

import java.util.List;

public interface ContentService
{
    public void createContent(ContentModelForm aContentModelForm, Integer aModuleId);

    /**
     * @param aContentModelForm
     */
    void updateContent(ContentModelForm aContentModelForm);

    /**
     * @param aModulo
     * @return
     */
    List<Contenido> readContentsByModule(Modulo aModulo);

    /**
     * @param aModuleId
     * @return
     */
    List<Contenido> readContentsByModule(Integer aModuleId);

    /**
     * Read content by Id
     *
     * @param aContentId
     * @return
     */
    Contenido readContentById(Integer aContentId);

    /**
     * Remove Content given an Id
     *
     * @param aContent Content Id
     */
    void removeContent(Integer aContent);

}
