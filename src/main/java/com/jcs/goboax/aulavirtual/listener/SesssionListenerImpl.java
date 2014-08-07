package com.jcs.goboax.aulavirtual.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.security.core.context.SecurityContextHolder;

public class SesssionListenerImpl implements HttpSessionListener 
{
 @Override
 public void sessionCreated(HttpSessionEvent httpSessionEvent) 
 {
    System.out.println("getAuthentication" + SecurityContextHolder.getContext().getAuthentication());
    String uniqueName =     SecurityContextHolder.getContext().getAuthentication().getName();
    String sessionId = httpSessionEvent.getSession().getId();
    long beginTimeInSeconds = System.currentTimeMillis()/1000;
//create a record and persist to data base with sessionId, uniquename, sessionBeginTime
    System.out.println(uniqueName);
    System.out.println(sessionId);
    System.out.println(beginTimeInSeconds);

}

@Override
public void sessionDestroyed(HttpSessionEvent httpSessionEvent) 
{
   httpSessionEvent.getSession().getId();
   System.out.println("session END" + httpSessionEvent);
   long endTime = System.currentTimeMillis()/1000;
   //load the record based on sessionId
   //update the record with sessionEndTime
   System.out.println("END" + httpSessionEvent);
   System.out.println("END" + endTime);
}
}