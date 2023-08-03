package app.dao;

import java.util.logging.Logger;

import app.dto.Cust;

public class CustMySQLDao {
	
	Logger log = Logger.getLogger("MySQLDao");
	
	public void insert(Cust cust) {
		log.info(cust.toString() + " INSERTED ....");
	}
	
	public Cust select(String id) {
		log.info(id + " SELECTED ....");
		Cust cust = Cust.builder()
				.id("id01")
				.name("james")
				.pwd("pwd01")
				.build();
		return cust;
	}
}
