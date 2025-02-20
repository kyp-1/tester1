package p0219;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public int insertUserInfo2(String uiName, String uiId, String uiPwd) {
		String sql = "INSERT INTO USER_INFO(UI_NAME, UI_ID, UI_PWD) VALUES(?,?,?)";
		try(Connection con = DBcon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
				ps.setString(1, uiName);
				ps.setString(2, uiId);
				ps.setString(3, uiPwd);
			return ps.executeUpdate();
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
	
	public int deleteUserInfo2(String uiNum) {
		String sql = "DELETE FROM USER_INFO WHERE UI_NUM=?";
		try (Connection con = DBcon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
				ps.setString(1, uiNum);
				return ps.executeUpdate();
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
	
	public int updateUserInfo2(String uiName,int uiNum) {
		String sql = "UPDATE USER_INFO SET UI_NAME=? WHERE UI_NUM=?";
		try(Connection con = DBcon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setString(1, uiName);
				ps.setInt(2, uiNum);
				return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<Map<String,String>> selectUserInfo(String type, String str){
		List<Map<String,String>> users = new ArrayList<>();
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD FROM USER_INFO";
		//"1" -> name "2" -> id "3" -> pwd
		if("1".equals(type)) {
			sql += " WHERE UI_NAME LIKE '%" + str+"%'";
		}else if("2".equals(type)) {
			sql += " WHERE UI_ID '%" + str+"%'";
		}else if("3".equals(type)) {
			sql += " WHERE UI_PWD '%" + str+"%'";
		}
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
	
	public List<Map<String,String>> selectUserInfos2(String type, String str){
		List<Map<String,String>> userInfos = new ArrayList<>();
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD FROM USER_INFO";
		if("1".equals(type)) {
			sql += " WHERE UI_NAME LIKE CONCAT('%',?,'%')";
		}else if("2".equals(type)) {
			sql += " WHERE UI_ID LIKE CONCAT('%',?,'%')";
		}else if("3".equals(type)) {
			sql += " WHERE UI_PWD LIKE CONCAT('%',?,'%')";
		}
		try(Connection con = DBcon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, str);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> userInfo = new HashMap<>();
				userInfo.put("UI_NUM", rs.getString("UI_NUM"));
				userInfo.put("UI_NAME", rs.getString("UI_NAME"));
				userInfo.put("UI_ID", rs.getString("UI_ID"));
				userInfo.put("UI_PWD", rs.getString("UI_PWD"));
				userInfos.add(userInfo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userInfos;
	}
	public static void main(String[] args) {
		UserInfoCRUD us = new UserInfoCRUD();
		int result = us.updateUserInfo2("고길동", 3);
		System.out.println(result);
		
		
	}
}
