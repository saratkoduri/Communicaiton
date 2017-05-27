package org.feedback.communication.service.email;

import org.feedback.communication.model.EMail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("defaultEmail")
@Qualifier("defaultEmail")
public class DefaultEMailServiceImpl  extends EMailServiceImpl {

	@Override
	String processMessage(EMail eMail) {
		System.out.println("Default Email processing....");
		return "Default";
		
	}
}
