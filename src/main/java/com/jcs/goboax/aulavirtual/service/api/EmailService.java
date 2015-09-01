package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Usuario;

public interface EmailService
{
    void sendTemporaryPasswordEmail(Usuario aUsuario, String Password);

    void sendActivationComplete(Usuario aUsuario);

    void sendWelcomeEmail(Usuario aUsuario);

    void sendScoreMail(Usuario aUsuario, Double anScore, String aModuleName, String aCourseName, Integer anCorrectAnswersCount, Integer anTotalExamQuestions);
}
