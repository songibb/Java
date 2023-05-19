package com.yedam.store;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class StoreDAO extends DAO{
	
	private static StoreDAO storeDao = null;
	
	private StoreDAO() {
		
	}
	
	public static StoreDAO getInstance() {
		if(storeDao == null) {
			storeDao = new StoreDAO();
		}
		return storeDao;
	}
	
	
	//모든 가게 정보 조회
	public List<Store> getStoreList(){
		List<Store> list = new ArrayList<>();
		Store st = null;
		try {
			conn();
			String sql = "SELECT * FROM store";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				st = new Store();
				st.setStoreId(rs.getInt("store_id"));
				st.setStoreName(rs.getString("store_name"));
				st.setStoreTel(rs.getString("store_tel"));
				st.setStoreAddr(rs.getString("store_addr"));
				st.setStoreSales(rs.getInt("store_sales"));
				list.add(st);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	
	//지역구별 매출 합계 조회
	//JAVA로 처리할 수 도 있지만 DB로 처리하는 것이 편함
	public List<Store> getStoreSales(){
		List<Store> list = new ArrayList<>();
		Store store = null;
		try {
			conn();
			String sql = "SELECT SUBSTR(store_addr, 4, 3) AS location, SUM(store_sales) \"loc_Sales\"\r\n"
					+ "FROM store\r\n"
					+ "GROUP BY SUBSTR(store_addr, 4, 3)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				store = new Store();
				//	private String storeAddr;
				//private int storeSales;   필드의 변수를 잠깐 빌려서 사용
				
				store.setStoreAddr(rs.getString("location"));
				store.setStoreSales(rs.getInt("loc_Sales"));
				list.add(store);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		
		return list;
	}
	
	
	
	
	//가게 정보 입력
	//[1]데이터 입력
//	public int insertStore(Store st) {
//		int result = 0;
//		try {
//			conn();
//			String sql = "INSERT INTO store VALUES(?,?,?,?,?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, st.getStoreId());
//			pstmt.setString(2, st.getStoreName());
//			pstmt.setString(3, st.getStoreTel());
//			pstmt.setString(4, st.getStoreAddr());
//			pstmt.setInt(5, st.getStoreSales());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			disconn();
//		}
//		
//		return result;
//	}

	//[2]서브쿼리를 활용해서 자동 부여
	public int insertStore(Store store) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO store VALUES(\r\n"
					+ "(SELECT COUNT(*)+1 FROM store),"
					+ " ?, ?, ?, ?)";    //서브쿼리를 활용해서 id 값을 자동 부여
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, store.getStoreName());
			pstmt.setString(2, store.getStoreTel());
			pstmt.setString(3, store.getStoreAddr());
			pstmt.setInt(4, store.getStoreSales());
			
			result = pstmt.executeUpdate();
					
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return result;
	}
	
	//[3]시퀀스를 활용해서 자동 부여
	
	
	
	//매출 수정
	public int updateSales(Store st) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE Store SET store_sales = ? WHERE store_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, st.getStoreSales());
			pstmt.setInt(2, st.getStoreId());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	

}
