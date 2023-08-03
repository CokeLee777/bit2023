package app.item;

import java.util.List;

import app.dto.Item;
import app.frame.DaoFrame;
import app.frame.ServiceFrame;

public class ItemServiceImpl implements ServiceFrame<Integer, Item>{
	
	DaoFrame<Integer, Item> dao;
	
	public ItemServiceImpl() {
		dao = new ItemDaoImpl();
	}

	@Override
	public void register(Item v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modifiy(Item v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}
	
	@Override
	public void removeAll() throws Exception {
		dao.deleteAll();
	}

	@Override
	public Item get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<Item> get() throws Exception {
		return dao.select();
	}

	

}
