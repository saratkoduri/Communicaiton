/**
 * 
 */
package org.feedback.communication.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Sarat Koduri
 *
 * EMail Resource
 */

@Component
@Qualifier("eMail")
public class EMail extends GenericResource {

	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
