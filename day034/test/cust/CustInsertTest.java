package cust;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.cust.CustServiceImpl;
import app.dto.Cust;
import app.frame.ServiceFrame;

class CustInsertTest {

	Logger log = Logger.getLogger("CustInsertTest");
	ServiceFrame<String, Cust> service;
	
	@BeforeEach
	void beforeEach() throws Exception {
		service = new CustServiceImpl();
	}
	
	@AfterEach
	void afterEach() throws Exception {
		service.removeAll();
	}
	
	@DisplayName("Cust Insert Test")
	@Test
	void insert() throws Exception {
		Cust inputCust = Cust.builder().id("id88").name("james88").pwd("pwd88").build();
		int result = service.register(inputCust);
		assertEquals("Insert Error", result, 1);
	}

}
