package p0219;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodInfoCRUD {

	public int insertFoodInfo(String fiName, String fiPrice) {
		String sql = "INSERT INTO FOOD_INFO(FI_NAME, FI_PRICE) VALUES('%s','%s')";
		sql = String.format(sql, fiName, fiPrice);
		try (Connection con = DBcon.getCon();
				Statement stmt = con.createStatement();){
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteFoodInfo(int fiNum) {
		String sql = "DELETE FROM FOOD_INFO WHERE FI_NUM="+fiNum;
		try(Connection con = DBcon.getCon();
				Statement stmt = con.createStatement();) {
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateFoodInfo(String fiName, String fiPrice, int fiNum) {
		String sql = "UPDATE FOOD_INFO SET FI_NAME='%s',FI_PRICE='%s' WHERE FI_NUM=%d";
		sql = String.format(sql, fiName, fiPrice, fiNum);
		try (Connection con = DBcon.getCon();
				Statement stmt = con.createStatement();){
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Map<String,String>> selectFoodInfo(){
		List<Map<String,String>> foods = new ArrayList<>();
		String sql = "SELECT FI_NUM, FI_NAME, FI_PRICE FROM FOOD_INFO";
		try (Connection con = DBcon.getCon();
				Statement stmt = con.createStatement();){
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Map<String,String> food = new HashMap<>();
				food.put("FI_NUM", rs.getString("FI_NUM"));
				food.put("FI_NAME", rs.getString("FI_NAME"));
				food.put("FI_PRICE", rs.getString("FI_PRICE"));
				foods.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foods;
	}
	public static void main(String[] args) {
		FoodInfoCRUD fi = new FoodInfoCRUD();
		List<Map<String, String>> foods = fi.selectFoodInfo();
		for(Map<String,String> food : foods) {
			System.out.println(food);
		}
	}
}
