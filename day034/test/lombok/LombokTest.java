package lombok;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import app.dto.Cust;

class LombokTest {

	Logger log = Logger.getLogger("LombokTest");
	
	@Test
	void test() {
		// given
		Cust cust = Cust.builder()
				.id("id01")
				.name("james")
				.pwd("pwd01")
				.build();
		
		log.info(cust.toString());
		
		// when
		assertEquals("Error", cust.getId(), "id01");
	}

}
