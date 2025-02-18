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

public class GameInfoCRUD {
	
	private final static String URL = "jdbc:mysql://localhost:3306/ezen";
	private final static String USER = "root";
	private final static String PASSWORD = "r1r2r3";
	private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static Connection con = null;
	
	
	static List<Map<String,String>> selectGameInfo(){
		List<Map<String,String>> games = new ArrayList<>();
		
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			Statement stmt = con.createStatement();
			String sql = "SELECT GI_NUM, GI_NAME, GI_PRICE, GI_GENRE, GI_DESC FROM GAME_INFO";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String giNum = rs.getString("GI_NUM");
				String giName = rs.getString("GI_NAME");
				String giPrice = rs.getString("GI_PRICE");
				String giGenre = rs.getString("GI_GENRE");
				String giDesc = rs.getString("GI_DESC");
				Map<String,String> game = new HashMap<>();
				game.put("giNum",giNum);
				game.put("giName",giName);
				game.put("giPrice",giPrice);
				game.put("giGenre",giGenre);
				game.put("giDesc",giDesc);
				games.add(game);
				
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
		return games;
	}
	
	public static int insertGameInfo(String giName, String giPrice, String giGenre, String giDesc) {
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO GAME_INFO(GI_NAME, GI_PRICE, GI_GENRE, GI_DESC)";
			sql += "VALUES('"+giName+"','"+giPrice+"','"+giGenre+"','"+giDesc+"')";
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
	
	public static int deleteGameInfo(String giNum) {
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			Statement stmt = con.createStatement();
			String sql = "DELETE FROM GAME_INFO WHERE GI_NUM="+giNum;
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
	
	public static int updateGameInfo(String giName, String giPrice, String giGenre, String giDesc,int giNum) {
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			Statement stmt = con.createStatement();
			String sql = "UPDATE GAME_INFO SET GI_NAME='"+giName+"',GI_PRICE='"+giPrice+"',GI_GENRE='"+giGenre+"',GI_DESC='"+giDesc+"'WHERE GI_NUM="+giNum;
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
		
		int result = insertGameInfo("배틀그라운드","0","슈팅","뭐.. 재밌지");
		System.out.println("입력한 갯수 : " + result);
		result = deleteGameInfo("2");
		System.out.println("삭제한 갯수 : " + result);
		result = updateGameInfo("배틀그라운드2","0","슈팅","역시 1만한 게임은 없군",3);
		System.out.println("업데이트한 갯수 : " + result);
		List<Map<String,String>> games = selectGameInfo();
		for(Map<String,String> game : games) {
			System.out.println(game);
		}
		
	}
}
