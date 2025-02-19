package p0219;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameInfoCRUD {
	public int insertGameInfo(String giName, String giPrice, String giGenre, String giDesc) {
		String sql = "INSERT INTO GAME_INFO(GI_NAME, GI_PRICE, GI_GENRE, GI_DESC)";
		sql += " VALUES('%s','%s','%s','%s')";
		sql = String.format(sql, giName, giPrice, giGenre, giDesc);
		try(Connection con = DBcon.getCon();
				Statement stmt = con.createStatement();) {
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteGameInfo(int giNum) {
		String sql = "DELETE FROM GAME_INFO WHERE GI_NUM="+giNum;
		try(Connection con = DBcon.getCon();
				Statement stmt = con.createStatement();) {
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateGameInfo(String giName, String giPrice, String giGenre, String giDesc, int giNum) {
		String sql = "UPDATE GAME_INFO SET GI_NAME='%s',GI_PRICE='%s',GI_GENRE='%s',GI_DESC='%s' WHERE GI_NUM=%d";
		sql = String.format(sql, giName, giPrice, giGenre, giDesc, giNum);
		try(Connection con = DBcon.getCon();
				Statement stmt = con.createStatement();) {
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Map<String,String>> selectGameInfo(){
		List<Map<String,String>> games = new ArrayList<>();
		String sql = "SELECT GI_NUM, GI_NAME, GI_PRICE, GI_GENRE, GI_DESC FROM GAME_INFO";
		try (Connection con = DBcon.getCon();
				Statement stmt = con.createStatement();){
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Map<String,String> game = new HashMap<>();
				game.put("GI_NUM", rs.getString("GI_NUM"));
				game.put("GI_NAME", rs.getString("GI_NAME"));
				game.put("GI_PRICE", rs.getString("GI_PRICE"));
				game.put("GI_GENRE", rs.getString("GI_GENRE"));
				game.put("GI_DESC", rs.getString("GI_DESC"));
				games.add(game);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return games;
	}
	public static void main(String[] args) {
		GameInfoCRUD gi = new GameInfoCRUD();
		List<Map<String,String>> games = gi.selectGameInfo();
		for(Map<String,String> game : games) {
			System.out.println(game);
		}
	}
}
