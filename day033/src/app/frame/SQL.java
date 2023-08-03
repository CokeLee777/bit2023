package app.frame;

public class SQL {
	
	public static String custInsert = 
			"INSERT INTO cust VALUES (?, ?, ?)";
	public static String custUpdate = 
			"UPDATE cust SET pwd = ?, name = ? WHERE id = ?";
	public static String custDelete = 
			"DELETE FROM cust WHERE id = ?";
	public static String custDeleteAll = 
			"DELETE FROM cust";
	public static String custSelect = 
			"SELECT * FROM cust WHERE id = ?";
	public static String custSelectAll = 
			"SELECT * FROM cust";
	
	public static String itemInsert = 
			"INSERT INTO item (name, price, regdate) VALUES (?, ?, ?)";
	public static String itemUpdate = 
			"UPDATE item SET name = ?, price = ? WHERE id = ?";
	public static String itemDelete = 
			"DELETE FROM item WHERE id = ?";
	public static String itemDeleteAll = 
			"DELETE FROM item";
	public static String itemSelect = 
			"SELECT * FROM item WHERE id = ?";
	public static String itemSelectAll = 
			"SELECT * FROM item";
}
