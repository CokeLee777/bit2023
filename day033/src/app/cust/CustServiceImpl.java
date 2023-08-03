package app.cust;

import java.util.List;

import app.dto.Cust;
import app.frame.DaoFrame;
import app.frame.ServiceFrame;

public class CustServiceImpl implements ServiceFrame<String, Cust>{
	
	DaoFrame<String, Cust> dao;
	
	public CustServiceImpl() {
		this.dao = new CustDaoImpl();
	}

	@Override
	public void register(Cust v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modifiy(Cust v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}
	
	@Override
	public void removeAll() throws Exception {
		dao.deleteAll();
	}

	@Override
	public Cust get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<Cust> get() throws Exception {
		return dao.select();
	}
	
}
