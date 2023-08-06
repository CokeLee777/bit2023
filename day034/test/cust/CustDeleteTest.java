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

class CustDeleteTest {

	Logger log = Logger.getLogger("CustDeleteTest");
	ServiceFrame<String, Cust> service;
	
	@BeforeEach
	void beforeEach() throws Exception {
		service = new CustServiceImpl();
	}
	
	@DisplayName("Cust Delete Test")
	@Test
	void delete() throws Exception {
		
		Exception exception = assertThrows(Exception.class, () -> {
			service.remove("id66");
		});
		
		assertEquals("Test Error", exception.getMessage(), "삭제내용이 없습니다");
	}

}
