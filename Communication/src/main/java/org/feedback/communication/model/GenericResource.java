/**
 * 
 */
package org.feedback.communication.model;

/**
 * @author Sarat Koduri
 *
 * Basic Resource class
 */
abstract class GenericResource implements Resource {

	private String communicationType;
	private String message;
	
	public String getCommunicationType() {
		return communicationType;
	}
	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
