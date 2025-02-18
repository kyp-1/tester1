package p0218;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodInfoCRUD {

	static List<Map<String,String>> getFoods(){
		List<Map<String,String>> foods = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/ezen";
		String user = "root";
		String password = "r1r2r3";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			Statement stmt = con.createStatement();
			String sql = "SELECT FI_NUM, FI_NAME, FI_PRICE FROM FOOD_INFO";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String fiNum = rs.getString("FI_NUM");
				String fiName = rs.getString("FI_NAME");
				String fiPrice = rs.getString("FI_PRICE");
				Map<String,String> food = new HashMap<>();
				food.put("fiNum", fiNum);
				food.put("fiName", fiName);
				food.put("fiPrice", fiPrice);
				foods.add(food);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return foods;
	}
	
		public static int insertFoodInfo(String fiName,String fiPrice) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String url = "jdbc:mysql://localhost:3306/ezen";
			String user = "root";
			String password = "r1r2r3";
			
			Connection con = null;
			try {
				con = DriverManager.getConnection(url,user,password);
				Statement stmt = con.createStatement();
				String sql = "INSERT INTO FOOD_INFO(FI_NAME,FI_PRICE)";
				sql += " VALUES('" + fiName +  "','" + fiPrice +"')";
				return stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return 0;
		}
	
		public static int deleteFoodInfo(String fiNum) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String url = "jdbc:mysql://localhost:3306/ezen";
			String user = "root";
			String password = "r1r2r3";
			
			Connection con = null;
			try {
				con = DriverManager.getConnection(url,user,password);
				Statement stmt = con.createStatement();
				String sql = "DELETE FROM FOOD_INFO WHERE FI_NUM=" + fiNum;
				return stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return 0;
		}
		
		public static int updateFoodInfo(String fiName,String fiName2) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String url = "jdbc:mysql://localhost:3306/ezen";
			String user = "root";
			String password = "r1r2r3";
			
			Connection con = null;
			try {
				con = DriverManager.getConnection(url,user,password);
				Statement stmt = con.createStatement();
				String sql = "UPDATE FOOD_INFO SET FI_NAME='"+fiName+"' "+"WHERE FI_NAME='"+fiName2+"'";
				return stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return 0;
		}
		
		
	public static void main(String[] args) {
		
		int result = insertFoodInfo("제육","8500");
		System.out.println("입력한 갯수: " + result);
		result = deleteFoodInfo("16");
		System.out.println("삭제한 갯수 :" + result);
		result = updateFoodInfo("공기밥","제육");
		System.out.println("업데이트한 갯수 :" + result);
		
		List<Map<String,String>> foods = getFoods();
		for(Map<String,String> food : foods) {
			System.out.println(food);
		}
		
		
	}
}
