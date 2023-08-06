package cust;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.cust.CustServiceImpl;
import app.dto.Cust;
import app.frame.ServiceFrame;

class CustSelectTest {

	Logger log = Logger.getLogger("CustSelectTest");
	ServiceFrame<String, Cust> service;
	
	@BeforeEach
	void beforeEach() throws Exception {
		service = new CustServiceImpl();
		Cust inputCust = Cust.builder().id("id55").name("james55").pwd("pwd55").build();
		service.register(inputCust);
	}
	
	@AfterEach
	void afterEach() throws Exception {
		service.removeAll();
	}
	
	@DisplayName("Cust Select Test")
	@Test
	void insert() throws Exception {
		Cust cust = null;
		cust = service.get("id55");
		
		assertEquals("Test Error", cust.getId(), "id55");
	}

}
