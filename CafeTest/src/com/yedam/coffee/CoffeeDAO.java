package com.yedam.coffee;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class CoffeeDAO extends DAO {

	private static CoffeeDAO cDao = new CoffeeDAO();
	
	private CoffeeDAO(){
	}
	
	public static CoffeeDAO getInstance() {
		return cDao;
	}
	
	//메뉴 조회
	public List<Coffee> getCoffeeList(){
		List<Coffee> list = new ArrayList<>();
		Coffee coffee = null;
		try {
			conn();
			String sql = "SELECT * FROM coffee";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeePrice(rs.getInt("coffee_price"));
				list.add(coffee);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	//상세 조회
	public Coffee getCoffeeMenu(String menu) {
		Coffee coffee = null;
		try {
			conn();
			String sql = "SELECT * FROM coffee WHERE coffee_menu = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeePrice(rs.getInt("coffee_price"));
				coffee.setCoffeeExplain(rs.getString("coffee_explain"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return coffee;
	}
	
	//메뉴 등록
	public int insertCoffee(Coffee coffee) {
		int result = 0;
		try {
			conn();
			//String sql = "INSERT INTO coffee(coffee_menu, coffee_price, coffee_explain) VALUES(?,?,?)";
			String sql = "INSERT INTO coffee VALUES(?,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffee.getCoffeeMenu());
			pstmt.setInt(2, coffee.getCoffeePrice());
			pstmt.setString(3, coffee.getCoffeeExplain());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
		
	}
	

	
	//판매
	public int sellCoffee(String menu) {
		int result = 0;
		try {
			conn();
			
			String sql = "UPDATE coffee \r\n"
						+ "SET coffee_sales = coffee_sales + 1"
						+ "WHERE coffee_menu = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu);
			
			result = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	
	
	//메뉴 삭제
	public int deleteCoffee(String menu) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM coffee WHERE coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu);
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//매출 
	public List<Coffee> salesCoffeeList(){
		List<Coffee> list = new ArrayList<>();
		Coffee coffee = null;
		try {
			conn();
			String sql = "SELECT coffee_menu, coffee_sales/coffee_price as \"판매갯수\", coffee_sales \r\n"
					+ "FROM coffee";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeePrice(rs.getInt(""));
				coffee.setCoffeeSales(rs.getInt("판매금액"));
				list.add(coffee);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
}
