package org.feedback.communication.service.email;

import org.feedback.communication.model.EMail;
import org.feedback.communication.model.Resource;


/**
 * @author Sarat Koduri
 *
 */
public abstract class EMailServiceImpl implements EMailService {

	
	@Override
	public String receiveMessage(Resource resource) {
		if(resource instanceof EMail){
			EMail eMailObj = (EMail)resource;
			return processMessage(eMailObj);
		}
		return "";
	}

	 abstract String processMessage(EMail eMail);
	
	 void notifySucccess(String deptName){
		 System.out.println(deptName+" department has received the message.");
	 }

}
