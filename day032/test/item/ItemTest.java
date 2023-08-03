package item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.dto.Item;
import app.frame.ServiceFrame;
import app.item.ItemService;

class ItemTest {

	Logger log = Logger.getLogger("ItemTest");
	ServiceFrame<Integer, Item> service;
	
	@BeforeEach
	void before() {
		service = new ItemService();
	}
	
	@DisplayName("Insert Test")
	@Test
	void insert() {
		Item inputItem = Item.builder().id(01).name("item01").price(1000).build();
		service.register(inputItem);
		Item item = service.get(01);
		assertEquals("Insert Error", inputItem.getId(), item.getId());
	}
	
	@DisplayName("SelectAll Test")
	@Test
	void selectAll() {
		List<Item> list = null;
		list = service.get();
		assertTrue("SelectAll Error", list.size() == 5);
	}

}
