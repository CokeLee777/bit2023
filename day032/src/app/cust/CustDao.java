package app.cust;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import app.dto.Cust;
import app.frame.DaoFrame;

public class CustDao implements DaoFrame<String, Cust>{
	
	Logger log = Logger.getLogger("CustDao");

	@Override
	public void insert(Cust v) {
		log.info("Inserted: " + v.toString());
	}

	@Override
	public void update(Cust v) {
		log.info("Updated: " + v.toString());
		
	}

	@Override
	public void delete(String k) {
		log.info("Deleted: " + k);
		
	}

	@Override
	public Cust select(String k) {
		Cust cust = Cust.builder()
				.id("id01")
				.name("james")
				.pwd("pwd01")
				.build();
		return cust;
	}

	@Override
	public List<Cust> select() {
		List<Cust> list = new ArrayList<>();
		list.add(Cust.builder().id("id01").name("james1").pwd("pwd01").build());
		list.add(Cust.builder().id("id02").name("james2").pwd("pwd02").build());
		list.add(Cust.builder().id("id03").name("james3").pwd("pwd03").build());
		list.add(Cust.builder().id("id04").name("james4").pwd("pwd04").build());
		list.add(Cust.builder().id("id05").name("james5").pwd("pwd05").build());
		return list;
	}

}
