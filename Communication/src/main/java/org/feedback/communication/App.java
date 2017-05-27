package org.feedback.communication;

import org.feedback.communication.handler.EMailHandler;
import org.feedback.communication.handler.ResourceHandler;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Communication application.
 * 
 * This application intended to handle the message based on the content of the subject
 * 
 * Sample input for the application is as below.
 * 
 *  Enter Subject: Sales
 *  Enter Message: Sales information that is to be circulated.
 * 
 * Expected O/p : Sales department has received the message.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome..." );
        try(ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");){
        	ResourceHandler resourceHandler = appContext.getBean("eMailHandler", EMailHandler.class);
            resourceHandler.prepareResource();
            resourceHandler.handleResource();
        }
        
    }
}
