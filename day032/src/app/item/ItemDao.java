package app.item;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import app.dto.Item;
import app.frame.DaoFrame;

public class ItemDao implements DaoFrame<Integer, Item>{

	Logger log = Logger.getLogger("CustDao");

	@Override
	public void insert(Item v) {
		log.info("Inserted: " + v.toString());
	}

	@Override
	public void update(Item v) {
		log.info("Updated: " + v.toString());
	}

	@Override
	public void delete(Integer k) {
		log.info("Deleted: " + k);	
	}

	@Override
	public Item select(Integer k) {
		Item item = Item.builder()
				.id(01)
				.name("item01")
				.price(1000)
				.build();
		return item;
	}

	@Override
	public List<Item> select() {
		List<Item> list = new ArrayList<>();
		list.add(Item.builder().id(01).name("item01").price(1000).build());
		list.add(Item.builder().id(02).name("item02").price(2000).build());
		list.add(Item.builder().id(03).name("item03").price(3000).build());
		list.add(Item.builder().id(04).name("item04").price(4000).build());
		list.add(Item.builder().id(05).name("item05").price(5000).build());
		return list;
	}
}
