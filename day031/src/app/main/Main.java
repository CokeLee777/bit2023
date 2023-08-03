package app.main;

import app.dto.Cust;
import app.service.CustService;

public class Main {

	public static void main(String[] args) {
		CustService service = new CustService();
		Cust cust = Cust.builder()
				.id("id01")
				.name("james")
				.pwd("pwd01")
				.build();
		service.register(cust);
	}

}
