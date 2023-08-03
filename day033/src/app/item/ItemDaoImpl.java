package app.item;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import app.dto.Item;
import app.frame.ConnectionPool;
import app.frame.DaoFrame;
import app.frame.SQL;

public class ItemDaoImpl implements DaoFrame<Integer, Item>{

	Logger log = Logger.getLogger("ItemDaoImpl");
	ConnectionPool cp;
	
	public ItemDaoImpl() {
		try {
			cp = ConnectionPool.create();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Item v) throws Exception {
		int result = 0;
		// get db connection
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.itemInsert);
			pstmt.setString(1, v.getName());
			pstmt.setLong(2, v.getPrice());
			pstmt.setDate(3, new Date(v.getRegDate().getTime()));
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			log.info(e.getMessage());
			throw new Exception("아이디 중복 에러");
		} finally {
			// close db resources
			DaoFrame.closePstmt(pstmt);
			cp.releaseConnection(con);
		}
		
		return result;
	}

	@Override
	public int update(Item v) throws Exception {
		int result = 0;
		// get db connection
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.itemUpdate);
			pstmt.setString(1, v.getName());
			pstmt.setLong(2, v.getPrice());
			pstmt.setInt(3, v.getId());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			log.info(e.getMessage());
			throw new Exception("업데이트 에러");
		} finally {
			// close db resources
			DaoFrame.closePstmt(pstmt);
			cp.releaseConnection(con);
		}
		
		return result;
	}

	@Override
	public int delete(Integer k) throws Exception {
		int result = 0;
		// get db connection
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.itemDelete);
			pstmt.setInt(1, k);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			log.info(e.getMessage());
			throw new Exception("삭제 에러");
		} finally {
			// close db resources
			DaoFrame.closePstmt(pstmt);
			cp.releaseConnection(con);
		}
		
		return result;
	}
	
	@Override
	public int deleteAll() throws Exception {
		int result = 0;
		// get db connection
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.itemDeleteAll);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			log.info(e.getMessage());
			throw new Exception("모두 삭제 에러");
		} finally {
			// close db resources
			DaoFrame.closePstmt(pstmt);
			cp.releaseConnection(con);
		}
		
		return result;
	}

	@Override
	public Item select(Integer k) throws Exception {
		Item item = null;
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = con.prepareStatement(SQL.itemSelect);
			pstmt.setInt(1, k);
			
			rset = pstmt.executeQuery();
			rset.next();
			item = Item.builder()
					.id(rset.getInt("id"))
					.name(rset.getString("name"))
					.price(rset.getInt("price"))
					.build();
		} catch(Exception e) {
			log.info(e.getMessage());
			throw new Exception("조회 에러");
		} finally {
			// close db resources
			DaoFrame.closeRset(rset);
			DaoFrame.closePstmt(pstmt);
			cp.releaseConnection(con);
		}
		
		return item;
	}

	@Override
	public List<Item> select() throws Exception {
		List<Item> items = new ArrayList<>();
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = con.prepareStatement(SQL.itemSelectAll);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				items.add(Item.builder()
					.id(rset.getInt("id"))
					.name(rset.getString("name"))
					.price(rset.getInt("price"))
					.build());
			}
		} catch(Exception e) {
			log.info(e.getMessage());
			throw new Exception("전체 조회 에러");
		} finally {
			// close db resources
			DaoFrame.closeRset(rset);
			DaoFrame.closePstmt(pstmt);
			cp.releaseConnection(con);
		}
		
		return items;
	}

}
