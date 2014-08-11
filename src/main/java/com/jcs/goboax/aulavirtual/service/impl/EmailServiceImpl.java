package com.jcs.goboax.aulavirtual.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.common.base.Charsets;
import com.jcs.goboax.aulavirtual.exception.AulaVirtualException;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.EmailService;
import com.jcs.goboax.aulavirtual.util.PropertiesUtil;

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

    @Override
    public void sendTemporaryPasswordEmail(Usuario aUsuario, String aPassword)
    {
        Map<String, Object> model = new HashMap<String, Object>();
        String myUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/login/forgetPassword/" + aUsuario.getUsuarioId() + "/"
                        + aPassword).build().toUriString();
        model.put("serverUrl", myUrl);
        model.put("user", aUsuario);
        model.put("password", aPassword);
        LOG.debug("Sending Reset Password Link: {}", myUrl);
        sendEmail(aUsuario.getUsername(), "forgetpassword", model, false);

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
