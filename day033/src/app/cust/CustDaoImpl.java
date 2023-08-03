package app.cust;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import app.dto.Cust;
import app.frame.ConnectionPool;
import app.frame.DaoFrame;
import app.frame.SQL;

public class CustDaoImpl implements DaoFrame<String, Cust>{
	
	Logger log = Logger.getLogger("CustDaoImpl");
	ConnectionPool cp;
	
	public CustDaoImpl() {
		try {
			cp = ConnectionPool.create();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Cust v) throws Exception {
		int result = 0;
		// get db connection
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.custInsert);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
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
	public int update(Cust v) throws Exception {
		int result = 0;
		// get db connection
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.custUpdate);
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getId());
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
	public int delete(String k) throws Exception {
		int result = 0;
		// get db connection
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.custDelete);
			pstmt.setString(1, k);
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
			pstmt = con.prepareStatement(SQL.custDeleteAll);
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
	public Cust select(String k) throws Exception {
		Cust cust = null;
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = con.prepareStatement(SQL.custSelect);
			pstmt.setString(1, k);
			
			rset = pstmt.executeQuery();
			rset.next();
			cust = Cust.builder()
					.id(rset.getString("id"))
					.pwd(rset.getString("pwd"))
					.name(rset.getString("name"))
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
		
		return cust;
	}

	@Override
	public List<Cust> select() throws Exception {
		List<Cust> custs = new ArrayList<>();
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = con.prepareStatement(SQL.custSelectAll);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				custs.add(Cust.builder()
					.id(rset.getString("id"))
					.pwd(rset.getString("pwd"))
					.name(rset.getString("name"))
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
		
		return custs;
	}

}
