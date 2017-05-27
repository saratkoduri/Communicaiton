/**
 * 
 */
package org.feedback.communication.handler;

import java.util.Scanner;

import org.feedback.communication.model.EMail;
import org.feedback.communication.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Sarat Koduri
 *
 *         EMail Resource Handler
 */
@Service("eMailHandler")
@Qualifier("eMailHandler")
public class EMailHandler implements ResourceHandler {

	@Autowired
	private EMail eMail;
	
	@Autowired
	@Qualifier("adminEMail")
 	private CommunicationService emailService;
	

	/*
	 * EMail resource will be handled here.
	 */
	@Override
	public void handleResource() {
		emailService.receiveMessage(eMail);

	}

	/*
	 * Method to Prepare the EMail 
	 * Reads the Subject and the Message
	 * eMail data is prepared. 
	 */
	@Override
	public EMail prepareResource() {
		try (Scanner scanner = new Scanner(System.in);) {
			System.out.println("Enter Subject:");
			eMail.setSubject(scanner.nextLine());
			System.out.println("Enter Message:");
			eMail.setMessage(scanner.nextLine());
		}

		return eMail;

	}

}
