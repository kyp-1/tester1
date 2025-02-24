package p0220;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import p0219.DBcon;

public class UserInfoRepository {
	public UserInfoVO selectUserInfo(int uiNum) {
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD FROM USER_INFO WHERE UI_NUM=?";
		try(Connection con = DBcon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, uiNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				UserInfoVO user = new UserInfoVO();
				user.setUiNum(rs.getInt("UI_NUM"));
				user.setUiName(rs.getString("UI_NAME"));
				user.setUiId(rs.getString("UI_ID"));
				user.setUiPwd(rs.getString("UI_PWD"));
				return user;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo){
		List<UserInfoVO> userInfoList = new ArrayList<>();
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD FROM USER_INFO WHERE 1=1 ";
		if(userInfo!=null) {
			if(userInfo.getUiName()!=null && userInfo.getUiName().length()!=0) {
				sql += " AND UI_NAME LIKE CONCAT('%',?,'%')";
			}
			if(userInfo.getUiId()!=null && userInfo.getUiId().length()!=0) {
				sql += " AND UI_ID LIKE CONCAT('%',?,'%')";
			}
		}
		try (Connection con = DBcon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			if(userInfo!=null) {
				if(userInfo.getUiName()!=null && userInfo.getUiName().length()!=0) {
					ps.setString(1, userInfo.getUiName());
				}
				if(userInfo.getUiId()!=null && userInfo.getUiId().length()!=0) {
					if(userInfo.getUiName()!=null && userInfo.getUiName().length()!=0) {
						ps.setString(2, userInfo.getUiId());
					}else{
						ps.setString(1, userInfo.getUiId());
					}
				}
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserInfoVO user = new UserInfoVO();
				user.setUiNum(rs.getInt("UI_NUM"));
				user.setUiName(rs.getString("UI_NAME"));
				user.setUiId(rs.getString("UI_ID"));
				user.setUiPwd(rs.getString("UI_PWD"));
				userInfoList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoList;
	}
	
	public static void main(String[] args) {
		UserInfoRepository uiRepo = new UserInfoRepository();
		UserInfoVO user = uiRepo.selectUserInfo(2);
		System.out.println(user);
		
		user = new UserInfoVO();
		List<UserInfoVO> userInfoList = uiRepo.selectUserInfoList(user);
		for(UserInfoVO userInfo : userInfoList) {
			System.out.println(userInfo);
		}
		
		
	}
}
