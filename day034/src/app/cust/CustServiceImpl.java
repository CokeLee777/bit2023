package app.cust;

import java.util.List;
import java.util.Optional;

import app.dto.Cust;
import app.frame.DaoFrame;
import app.frame.ServiceFrame;

public class CustServiceImpl implements ServiceFrame<String, Cust>{
	
	DaoFrame<String, Cust> dao;
	
	public CustServiceImpl() {
		this.dao = new CustDaoImpl();
	}

	@Override
	public int register(Cust v) throws Exception {
		return dao.insert(v);
	}

	@Override
	public int modifiy(Cust v) throws Exception {
		return dao.update(v);
	}

	@Override
	public int remove(String k) throws Exception {
		int result = dao.delete(k);
		if(result != 1) {
			throw new Exception("삭제내용이 없습니다");
		}
		return result;
	}
	
	@Override
	public int removeAll() throws Exception {
		return dao.deleteAll();
	}

	@Override
	public Cust get(String k) throws Exception {
		Optional<Cust> result = dao.select(k);
		if(result.isEmpty()) {
			throw new Exception("조회 내용이 없습니다");
		}
		return result.get();
	}

	@Override
	public List<Cust> get() throws Exception {
		return dao.select();
	}
	
}
