package com.jcs.goboax.aulavirtual.service.impl;

import com.google.common.base.Charsets;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualException;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.EmailService;
import com.jcs.goboax.aulavirtual.util.PropertiesUtil;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class EmailServiceImpl
        implements EmailService
{
    MessageSource messageSource;
    private static final Logger LOG = LoggerFactory
            .getLogger(EmailServiceImpl.class);

    @Autowired
    private PropertiesUtil propertiesUtil;

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ServletContext servletContext;

    @Override
    public void sendTemporaryPasswordEmail(Usuario aUsuario, String aPassword)
    {
        Map<String, Object> model = new HashMap<String, Object>();
        String myUrl = propertiesUtil.getMessage("url.domain")
                + servletContext.getContextPath()
                + "/login/forgetPassword/reset/" + aUsuario.getUsuarioId() + "/"
                + aPassword;
        model.put("serverUrl", myUrl);
        model.put("user", aUsuario);
        model.put("password", aPassword);
        LOG.debug("Sending Reset Password Link: {}", myUrl);
        sendEmail(aUsuario.getUsername(), "forgetpassword", model, false);

    }

    @Override
    public void sendActivationComplete(Usuario aUsuario)
    {
        Map<String, Object> model = new HashMap<String, Object>();
        String myUrl = propertiesUtil.getMessage("url.domain") + servletContext.getContextPath();
        model.put("serverUrl", myUrl);
        model.put("user", aUsuario);
        LOG.debug("Sending Activation Mail: {}", myUrl);
        sendEmail(aUsuario.getUsername(), "activation", model, false);
    }

    @Override
    public void sendWelcomeEmail(Usuario aUsuario)
    {
        Map<String, Object> model = new HashMap<String, Object>();
        try
        {
            String myVerificationKeyEncode = URLEncoder.encode(aUsuario.getVerificationKey(), "UTF-8");
            String myUrl = propertiesUtil.getMessage("url.domain") + servletContext.getContextPath()
                    + "/login/registration/activate/" + aUsuario.getUsuarioId()
                    + "?k=" + myVerificationKeyEncode;

            model.put("serverUrl", myUrl);
            model.put("user", aUsuario);
            LOG.debug("Sending Activation Link: {}", myUrl);
            sendEmail(aUsuario.getUsername(), "welcome", model, false);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
    }

    private void sendEmail(String aTo, String aTemplate,
                           Map<String, Object> model, boolean aBlindCopy)
    {
        try
        {
            String myText = VelocityEngineUtils.mergeTemplateIntoString(
                    velocityEngine, aTemplate + "_plain.vm",
                    Charsets.UTF_8.name(), model);
            String myHtml = VelocityEngineUtils.mergeTemplateIntoString(
                    velocityEngine, aTemplate + ".vm", Charsets.UTF_8.name(),
                    model);

            MimeMessage myMessage = mailSender.createMimeMessage();
            MimeMessageHelper myHelper = new MimeMessageHelper(myMessage, true,
                    "UTF-8");
            myHelper.setTo(aTo);

            if (aBlindCopy)
            {
                myHelper.setBcc(propertiesUtil.getMessage("address.admin"));
            }
            myHelper.setFrom(propertiesUtil.getMessage("address.mailer"));
            myHelper.setSubject(propertiesUtil.getMessage("subject."
                    + aTemplate));
            myHelper.setText(myText, myHtml);
            LOG.debug("sending " + aTemplate + ".vm email to " + aTo);
            mailSender.send(myMessage);
        }
        catch (MailException e)
        {
            LOG.error("sendTemporaryPasswordEmail has ben failed", e);
            throw new AulaVirtualException(e);
        }
        catch (MessagingException e)
        {
            LOG.error("sendTemporaryPasswordEmail has ben failed", e);
            throw new AulaVirtualException(e);
        }

    }
}
