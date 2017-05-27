package org.feedback.communication.service.email;

import org.feedback.communication.model.EMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("securityEmail")
@Qualifier("securityEmail")
public class SecurityEMailServiceImpl extends EMailServiceImpl {

	private static final String DEPT_NAME="Security";
	
	@Autowired
	@Qualifier("defaultEmail")
	private EMailService nextDep;
	
	/*
	 * This method will look into the subject of the email 
	 *  if the subject contains "Securty" then this email is intended for Security otherwise it will forward to the next in the chain.
	 */
	@Override
	String processMessage(EMail eMail) {
		String subject = eMail.getSubject();
		if(subject != null && subject.toLowerCase().contains(DEPT_NAME.toLowerCase())){
			notifySucccess(DEPT_NAME);
			return DEPT_NAME;
		}
		return nextDep.receiveMessage(eMail);
	}


}
