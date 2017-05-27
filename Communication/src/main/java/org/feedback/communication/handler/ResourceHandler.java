/**
 * 
 */
package org.feedback.communication.handler;

import org.feedback.communication.model.Resource;

/**
 * @author Sarat Koduri
 *
 * Generic Resource Handler.
 */
public interface ResourceHandler {

	public void handleResource();
	
	public Resource prepareResource();
}
