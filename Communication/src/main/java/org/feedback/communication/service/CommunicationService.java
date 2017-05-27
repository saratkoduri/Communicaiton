package org.feedback.communication.service;

import org.feedback.communication.model.Resource;

/**
 * @author Sarat Koduri
 *  
 *   Generic interface for all types of communication
 *
 */
public interface CommunicationService {

	String receiveMessage(Resource resource);
}
