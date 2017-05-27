package org.feedback.communication.service.email;

import org.feedback.communication.model.EMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("salesEmail")
@Qualifier("salesEmail")
public class SalesEMailServiceImpl extends EMailServiceImpl {

	private static final String DEPT_NAME="Sales";
	
	@Autowired
	@Qualifier("securityEmail")
	private EMailService nextDep;
	


	/*
	 * This method will look into the subject of the email 
	 *  if the subject contains "Sales" then this email is intended for Sales otherwise it will forward to the next in the chain.
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
