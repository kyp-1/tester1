package p0214;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDB1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/ezen";
		String username = "root";
		String password = "r1r2r3";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			String sql = " INSERT INTO USER_INFO(UI_NAME,UI_ID,UI_PWD)";
			sql += " VALUES('홍길동','qwer','1234')";
			int result = stmt.executeUpdate(sql);
			if(result>=1) {
				System.out.println("업데이트 성공했어요");
			}else { 
				System.out.println("업데이트 실패했어요");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
