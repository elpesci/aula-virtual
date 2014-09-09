package com.jcs.goboax.aulavirtual.listener;

import com.jcs.goboax.aulavirtual.model.RegistroAcceso;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.RegistroAccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ApplicationSecurityListener
        implements ApplicationListener<ApplicationEvent>
{
    @Autowired
    private RegistroAccesoService registroAccesoService;

    @Override
    public void onApplicationEvent(ApplicationEvent event)
    {

        if (event instanceof AuthorizationFailureEvent)
        {
            AuthorizationFailureEvent authorizationFailureEvent = (AuthorizationFailureEvent) event;
            System.out.println("not authorized:" + authorizationFailureEvent);
        }
        else if (event instanceof AuthenticationFailureBadCredentialsEvent)
        {
            AuthenticationFailureBadCredentialsEvent badCredentialsEvent = (AuthenticationFailureBadCredentialsEvent) event;
            System.out.println("badCredentials:" + badCredentialsEvent);
        }
        //login success event
        else
        {
            if (event instanceof AuthenticationSuccessEvent)
            {
                AuthenticationSuccessEvent authenticationSuccessEvent = (AuthenticationSuccessEvent) event;
                //this will provide user id and password but no session, get source has all the user information in security context
                System.out.println("AuthenticationSuccessEvent:" + authenticationSuccessEvent.getSource());
                WebAuthenticationDetails myDetails = (WebAuthenticationDetails)
                        authenticationSuccessEvent.getAuthentication().getDetails();
                Usuario myUsuario = (Usuario) authenticationSuccessEvent.getAuthentication().getPrincipal();

                RegistroAcceso myRegistroAcceso = new RegistroAcceso();
                myRegistroAcceso.setSessionId(myDetails.getSessionId());
                myRegistroAcceso.setUsuario(myUsuario);
                myRegistroAcceso.setInicioAcceso(new Date());

                registroAccesoService.createRecord(myRegistroAcceso);

            }
            //this event will published if you add the HttpSessionEventPublisher to web.xml
            else if (event instanceof SessionDestroyedEvent)
            {
                SessionDestroyedEvent sessinEvent = (SessionDestroyedEvent) event;
                System.out.println("SessionDestroyedEvent:" + sessinEvent.getId());
                //load session if it is not empty
                WebAuthenticationDetails myDetails = null;
                for (SecurityContext mySecurityContext : sessinEvent.getSecurityContexts() )
                {
                    myDetails = (WebAuthenticationDetails) mySecurityContext.getAuthentication().getDetails();
                    RegistroAcceso myRegistroAcceso =
                            registroAccesoService.readRegistroAccesoBySessionId(myDetails.getSessionId());
                    if (myRegistroAcceso != null)
                    {
                        myRegistroAcceso.setFinAcceso(new Date());
                        registroAccesoService.updateRegistroAcceso(myRegistroAcceso);
                    }
                }
                if (sessinEvent.getSecurityContexts() != null)
                {
                    System.out.println("SessionDestroyedEvent:" + sessinEvent.getSecurityContexts());
                    //update the session with endTime
                }
            }
            else
            {
                //System.out.println("undefined: " + event.getClass().getName());
            }
        }


    }

}