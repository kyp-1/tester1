package p0219;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoCRUD {

	public int insertUserInfo(String uiName, String uiId, String uiPwd) {
		String sql = "INSERT INTO USER_INFO(UI_NAME, UI_ID, UI_PWD) VALUES('%s','%s','%s')";
		sql = String.format(sql, uiName, uiId, uiPwd);
		try(Connection con = DBcon.getCon();
				Statement stmt = con.createStatement();){
			return stmt.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return 0;
	}
	
	public int deleteUserInfo(String uiNum) {
		String sql = "DELETE FROM USER_INFO WHERE UI_NUM="+uiNum;
		try(Connection con = DBcon.getCon();
				Statement stmt = con.createStatement();){
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateUserInfo(String uiName,int uiNum) {
		String sql = "UPDATE USER_INFO SET UI_NAME=' "+uiName+"' WHERE UI_NUM="+uiNum;
		try(Connection con = DBcon.getCon();
				Statement stmt = con.createStatement();) {
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Map<String,String>> selectUserInfo(){
		List<Map<String,String>> users = new ArrayList<>();
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD FROM USER_INFO";
		try(Connection con = DBcon.getCon();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);){
			while(rs.next()) {
				Map<String,String> user = new HashMap<>();
				user.put("UI_NUM", rs.getString("UI_NUM"));
				user.put("UI_NAME", rs.getString("UI_NAME"));
				user.put("UI_ID", rs.getString("UI_ID"));
				user.put("UI_PWD", rs.getString("UI_PWD"));
				users.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public static void main(String[] args) {
		UserInfoCRUD us = new UserInfoCRUD();
		List<Map<String,String>> users = us.selectUserInfo();
		for(Map<String,String> user : users) { 
			System.out.println(user);
		}
		
	}
}
