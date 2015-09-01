package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Valoracion;
import com.jcs.goboax.aulavirtual.viewmodel.AppraisalModel;

import java.util.List;

public interface ValoracionService
{
    Valoracion reviewTest(AppraisalModel anAppraisalModel);

    List<Valoracion> retrieveAnsweredExams(int usuarioId);
}
