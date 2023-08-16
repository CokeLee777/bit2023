package cust;

import app.cust.CustServiceImpl;
import app.dto.Cust;
import org.junit.jupiter.api.Test;

public class CustSelect {

	
	
	@Test
	public void test() {
		CustServiceImpl service;
		service = new CustServiceImpl();
		
		Cust data = new Cust("id16","pwd16","james");
		
		try {
			service.register(data);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		Cust cust = null;
		
		try {
			cust = service.get("id16");
			System.out.println(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}







