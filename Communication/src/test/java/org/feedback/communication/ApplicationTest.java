package org.feedback.communication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.feedback.communication.model.EMail;
import org.feedback.communication.service.CommunicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class ApplicationTest {

	@Autowired
	EMail eMail;
	
	@Autowired
	@Qualifier("adminEMail")
	CommunicationService emailService;
	
	
	@Test
	public void testAdminEMail(){
		eMail.setSubject("Admin Intimation");
		eMail.setMessage("Informaton for the Administrator");
		String dept = emailService.receiveMessage(eMail);
		assertEquals("Admin", dept);
	}
	
	@Test
	public void testSalesEMail(){
		eMail.setSubject("Sales Intimation");
		eMail.setMessage("Informaton for the Sales Team");
		String dept = emailService.receiveMessage(eMail);
		assertEquals("Sales", dept);
	}
	
	@Test
	public void testDefaultEMail(){
		eMail.setSubject("No Existing Department Intimation");
		eMail.setMessage("This dept is not existing.");
		String dept = emailService.receiveMessage(eMail);
		assertEquals("Default", dept);
	}
	
	@Test
	public void testNot(){
		eMail.setSubject("Sales Intimation");
		eMail.setMessage("Informaton for the Sales Team");
		String dept = emailService.receiveMessage(eMail);
		assertNotEquals("Admin",dept );
	}
	
}
