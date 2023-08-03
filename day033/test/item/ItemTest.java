package item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.dto.Item;
import app.frame.ServiceFrame;
import app.item.ItemServiceImpl;

class ItemTest {

	Logger log = Logger.getLogger("ItemTest");
	ServiceFrame<Integer, Item> service;
	
	@BeforeEach
	void before() {
		service = new ItemServiceImpl();
	}
	
	@AfterEach
	void afterEach() {
		try {
			service.removeAll();
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@DisplayName("Item Insert Test")
	@Test
	void insert() {
		Item inputItem = Item.builder()
				.name("shirts")
				.price(10000)
				.regDate(new Date())
				.build();
		try {
			service.register(inputItem);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@DisplayName("Item Update Test")
	@Test
	void update() {
		// given
		Item inputItem = Item.builder()
				.name("shirts")
				.price(10000)
				.regDate(new Date())
				.build();
		try {
			service.register(inputItem);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		
		// when
		Item updateItem = Item.builder()
				.name("shirts")
				.price(10000)
				.regDate(new Date())
				.build();
		try {
			service.modifiy(updateItem);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@DisplayName("Item Delete Test")
	@Test
	void delete() {
		// given
		Item inputItem = Item.builder()
				.name("shirts")
				.price(10000)
				.regDate(new Date())
				.build();
		try {
			service.register(inputItem);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		
		// when
		int id = 1;
		try {
			service.remove(id);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@DisplayName("Item Select Test")
	@Test
	void select() {
		// given
		Item inputItem = Item.builder()
				.name("shirts")
				.price(10000)
				.regDate(new Date())
				.build();
		try {
			service.register(inputItem);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		
		// when
		try {
			assertThrows(Exception.class, () -> {
				service.get(10);
			});
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@DisplayName("Item SelectAll Test")
	@Test
	void selectAll() {
		List<Item> list = null;
		try {
			list = service.get();
			
			assertTrue("SelectAll Error", list.size() == 0);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}	
	}

}
