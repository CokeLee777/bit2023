package cust;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.cust.CustService;
import app.dto.Cust;
import app.frame.ServiceFrame;

class CustTest {

	Logger log = Logger.getLogger("CustTest");
	ServiceFrame<String, Cust> service;
	
	@BeforeEach
	void before() {
		service = new CustService();
	}
	
	@DisplayName("Insert Test")
	@Test
	void insert() {
		Cust inputCust = Cust.builder().id("id01").name("james1").pwd("pwd01").build();
		service.register(inputCust);
		Cust cust = service.get("id01");
		assertEquals("Insert Error", inputCust.getId(), cust.getId());
	}
	
	@DisplayName("SelectAll Test")
	@Test
	void selectAll() {
		List<Cust> list = null;
		list = service.get();
		assertTrue("SelectAll Error", list.size() == 5);
	}

}
