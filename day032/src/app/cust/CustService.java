package app.cust;

import java.util.List;

import app.dto.Cust;
import app.frame.DaoFrame;
import app.frame.ServiceFrame;

public class CustService implements ServiceFrame<String, Cust>{
	
	DaoFrame<String, Cust> dao;
	
	public CustService() {
		dao = new CustDao();
	}

	@Override
	public void register(Cust v) {
		dao.insert(v);
	}

	@Override
	public void modifiy(Cust v) {
		dao.update(v);
	}

	@Override
	public void remove(String k) {
		dao.delete(k);
	}

	@Override
	public Cust get(String k) {
		return dao.select(k);
	}

	@Override
	public List<Cust> get() {
		return dao.select();
	}

}
