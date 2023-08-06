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

class CustInsertTest2 {

	Logger log = Logger.getLogger("CustInsertTest2");
	ServiceFrame<String, Cust> service;
	
	@BeforeEach
	void beforeEach() throws Exception {
		service = new CustServiceImpl();
		Cust inputCust = Cust.builder().id("id88").name("james88").pwd("pwd88").build();
		service.register(inputCust);
	}
	
	@AfterEach
	void afterEach() throws Exception {
		service.removeAll();
	}
	
	@DisplayName("Cust Delete Test")
	@Test
	void insert() throws Exception {
		
		Exception exception = assertThrows(Exception.class, () -> {
			Cust inputCust = Cust.builder().id("id88").name("james88").pwd("pwd88").build();
			service.register(inputCust);
		});
		
		assertEquals("Test Error", exception.getMessage(), "아이디 중복 에러");
	}

}
