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

public class ListMap5 {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/ezen";
		String user = "root";
		String password = "r1r2r3";
		Connection con = null;
		List<Map<String,String>> users = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD FROM USER_INFO";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String uiNum = rs.getString("UI_NUM");
				String uiName = rs.getString("UI_NAME");
				String uiId = rs.getString("UI_ID");
				String uiPwd = rs.getString("UI_PWD");
				Map<String,String> userInfo = new HashMap<>();
				userInfo.put("UI_NUM", uiNum);
				userInfo.put("UI_NAME", uiName);
				userInfo.put("UI_ID", uiId);
				userInfo.put("UI_PWD", uiPwd);
				users.add(userInfo);
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
		for(Map<String,String> userInfo : users) {
			System.out.println(userInfo);
		}
		}
	}
