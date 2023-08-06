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

class CustTest {

	Logger log = Logger.getLogger("CustTest");
	ServiceFrame<String, Cust> service;
	
	@BeforeEach
	void before() {
		service = new CustServiceImpl();
	}
	
	@AfterEach
	void afterEach() {
		try {
			service.removeAll();
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@DisplayName("Cust Insert Test")
	@Test
	void insert() {
		Cust inputCust = Cust.builder().id("id06").name("james6").pwd("pwd06").build();
		try {
			service.register(inputCust);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@DisplayName("Cust Update Test")
	@Test
	void update() {
		// given
		Cust inputCust = Cust.builder().id("id01").name("james1").pwd("pwd01").build();
		try {
			service.register(inputCust);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		
		// when
		Cust updateCust = Cust.builder().id("id01").name("jamesEdit").pwd("pwd01").build();
		try {
			service.modifiy(updateCust);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@DisplayName("Cust Delete Test")
	@Test
	void delete() {
		// given
		Cust inputCust = Cust.builder().id("id01").name("james1").pwd("pwd01").build();
		try {
			service.register(inputCust);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		
		// when
		String id = "id01";
		try {
			service.remove(id);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@DisplayName("Cust Select Test")
	@Test
	void select() {
		// given
		Cust inputCust = Cust.builder().id("id01").name("james1").pwd("pwd01").build();
		try {
			service.register(inputCust);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		
		// when
		Cust cust = null;
		try {
			cust = service.get("id01");
			
			// then
			assertEquals("Select Error", cust.getId(), "id01");
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@DisplayName("Cust SelectAll Test")
	@Test
	void selectAll() {
		List<Cust> list = null;
		try {
			list = service.get();
			
			assertTrue("SelectAll Error", list.size() == 0);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}	
	}

}
